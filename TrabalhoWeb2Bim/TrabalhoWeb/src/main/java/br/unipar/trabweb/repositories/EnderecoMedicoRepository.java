package br.unipar.trabweb.repositories;

import br.unipar.trabweb.models.EnderecoMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoMedicoRepository extends JpaRepository<EnderecoMedico, Long> {
    //Aqui você pode adicionar consultas customizadas se precisar
}
