package br.unipar.trabweb.services;

import br.unipar.trabweb.model.dto.PacienteDTO;
import br.unipar.trabweb.models.Paciente;
import br.unipar.trabweb.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id){
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    //LISTA DE PACIENTES
    public List<PacienteDTO> listPacienteInfos() {
        List<Paciente> pacientes = pacienteRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        return pacientes.stream()
                .map(paciente -> {
                    PacienteDTO dto = new PacienteDTO();
                    dto.setNome(paciente.getNome());
                    dto.setEmail(paciente.getEmail());
                    dto.setCpf(paciente.getCpf());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    //ATUALIZAÇÃO DE PACIENTES (C/ RESTRIÇÕES)
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    //EXCLUSÃO DE PACIENTES
    public Paciente updateStatusPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }



}
