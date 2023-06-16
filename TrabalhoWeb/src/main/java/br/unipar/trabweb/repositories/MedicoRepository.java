package br.unipar.trabweb.repositories;

import br.unipar.trabweb.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    //Criado para buscar um médico disponível caso nenhum seja atribuído na criação da consulta.
    @Query("SELECT m FROM Medico m WHERE m.ativo = true AND m NOT IN " +
            "(SELECT c.medicoConsulta FROM Consulta c WHERE c.horaConsulta = :data)")
    List<Medico> findAvailableMedicos(@Param("data") LocalDateTime data);

    //Criado para lançar exceção caso CRM seja repetido.
    Optional<Medico> findByCrm(String crm);
}

