package br.unipar.trabweb.services;

import br.unipar.trabweb.exceptions.*;
import br.unipar.trabweb.models.Consulta;
import br.unipar.trabweb.models.Medico;
import br.unipar.trabweb.models.Paciente;
import br.unipar.trabweb.repositories.ConsultaRepository;
import br.unipar.trabweb.repositories.MedicoRepository;
import br.unipar.trabweb.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ConsultaService {

    //Importação para verificar se médico ou paciente já existem no sistema e para verificar se estão ativos.
    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }


    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> getConsultaById(Long id) {
        return consultaRepository.findById(id);
    }

    public Consulta saveConsulta(Consulta consulta) {
        // Se nenhum médico foi atribuído à consulta, busque um médico disponível
        if (consulta.getMedicoConsulta() == null) {
            List<Medico> medicosDisponiveis = medicoRepository.findAvailableMedicos(consulta.getHoraConsulta());

            if (medicosDisponiveis.isEmpty()) {
                throw new NoAvailableMedicosException("Não há médicos disponíveis no momento.");
            }

            // Escolha um médico aleatoriamente da lista de médicos disponíveis
            Random random = new Random();
            Medico medicoAleatorio = medicosDisponiveis.get(random.nextInt(medicosDisponiveis.size()));

            consulta.setMedicoConsulta(medicoAleatorio);
        }

        // Verifica se o médico e o paciente estão ativos
        Long doctorId = consulta.getMedicoConsulta().getId();
        Medico actualDoctor = medicoRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException("Médico não encontrado"));

        // Fetch the patient from the database
        Long patientId = consulta.getPacienteConsulta().getId();
        Paciente actualPatient = pacienteRepository.findById(patientId)
                .orElseThrow(() -> new NotFoundException("Paciente não encontrado"));

        // Verifica se o médico e o paciente estão ativos
        if (!actualDoctor.isAtivo() || !actualPatient.isAtivo()) {
            throw new InactiveDoctorException("Médico ou Paciente inativo, não é possível agendar a consulta");
        }

        // Verifica se a data e hora da consulta estão dentro dos limites permitidos
        LocalDateTime consultaHora = consulta.getHoraConsulta();
        DayOfWeek diaDaSemana = consultaHora.getDayOfWeek();
        int horaDoDia = consultaHora.getHour();

        // Consultas são permitidas de segunda a sábado (DayOfWeek de 1 a 6) e das 7:00 às 19:00
        if (diaDaSemana.getValue() == 7 || horaDoDia < 7 || horaDoDia >= 19) {
            throw new InvalidConsultaTimeException("Consultas só podem ser agendadas de segunda a sábado, das 07:00 até às 19:00");
        }

        // Check if the consulta is not too soon
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, consulta.getHoraConsulta());

        if (duration.toMinutes() < 30) {
            throw new ConsultationTooSoonException("A consulta não pode ser marcada com menos de 30 minutos de antecedência.");
        }

        // Check if the doctor is already booked at that time
        LocalDateTime consultaEnd = consulta.getHoraConsulta().plusHours(1);
        List<Consulta> overlappingConsultas = consultaRepository.findByMedicoConsultaAndHoraConsultaLessThanEqualAndHoraConsultaFimGreaterThanEqual(
                consulta.getMedicoConsulta(), consultaEnd, consulta.getHoraConsulta());

        if (!overlappingConsultas.isEmpty()) {
            throw new DoctorUnavailableException("O médico já tem uma consulta marcada nesse horário.");
        }

        // Verifica se o paciente já tem uma consulta no mesmo dia
        List<Consulta> consultasMesmoDia = consultaRepository.findByPacienteConsultaAndData(
                consulta.getPacienteConsulta(),
                consulta.getHoraConsulta()
        );

        if (!consultasMesmoDia.isEmpty()) {
            throw new ConsultaNoMesmoDiaException("O paciente já tem uma consulta marcada neste dia.");
        }

        return consultaRepository.save(consulta);
    }



    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
