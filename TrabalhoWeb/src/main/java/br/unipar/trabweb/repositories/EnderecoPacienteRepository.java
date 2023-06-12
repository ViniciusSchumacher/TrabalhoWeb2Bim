package br.unipar.trabweb.repositories;

import br.unipar.trabweb.models.EnderecoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoPacienteRepository extends JpaRepository<EnderecoPaciente, Long> {
}
