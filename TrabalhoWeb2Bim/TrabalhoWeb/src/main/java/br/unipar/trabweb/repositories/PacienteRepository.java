package br.unipar.trabweb.repositories;

import br.unipar.trabweb.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //Aqui você pode adicionar consultas customizadas se precisar
}
