package br.unipar.trabweb.services;

import br.unipar.trabweb.models.EnderecoPaciente;
import br.unipar.trabweb.repositories.EnderecoPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoPacienteService {

    private final EnderecoPacienteRepository enderecoPacienteRepository;

    @Autowired
    public EnderecoPacienteService(EnderecoPacienteRepository enderecoPacienteRepository) {
        this.enderecoPacienteRepository = enderecoPacienteRepository;
    }

    public List<EnderecoPaciente> getAllEnderecos() {
        return enderecoPacienteRepository.findAll();
    }

    public Optional<EnderecoPaciente> getEnderecoById(Long id) {
        return enderecoPacienteRepository.findById(id);
    }

    public EnderecoPaciente saveEndereco(EnderecoPaciente endereco) {
        return enderecoPacienteRepository.save(endereco);
    }

    public void deleteEndereco(Long id) {
        enderecoPacienteRepository.deleteById(id);
    }
}
