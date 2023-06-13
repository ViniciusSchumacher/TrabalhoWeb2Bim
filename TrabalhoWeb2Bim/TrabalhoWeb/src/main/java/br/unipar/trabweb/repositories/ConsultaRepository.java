package br.unipar.trabweb.repositories;

import br.unipar.trabweb.models.Consulta;
import br.unipar.trabweb.models.Medico;
import br.unipar.trabweb.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    //Criado para verificar se o médico está em consulta.
    List<Consulta> findByMedicoConsultaAndHoraConsultaLessThanEqualAndHoraConsultaFimGreaterThanEqual(
            Medico medico, LocalDateTime horaConsulta, LocalDateTime horaConsultaFim);

    //Criado para verificar se o cliente já tem consulta agendada no mesmo dia.
    @Query("SELECT c FROM Consulta c WHERE c.pacienteConsulta = :paciente AND " +
            "DATE(c.horaConsulta) = DATE(:data)")
    List<Consulta> findByPacienteConsultaAndData(
            @Param("paciente") Paciente paciente,
            @Param("data") LocalDateTime data);

}
