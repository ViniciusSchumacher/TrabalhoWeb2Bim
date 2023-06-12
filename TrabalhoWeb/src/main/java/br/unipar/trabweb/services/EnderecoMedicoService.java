package br.unipar.trabweb.services;

import br.unipar.trabweb.models.EnderecoMedico;
import br.unipar.trabweb.repositories.EnderecoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoMedicoService {

    private final EnderecoMedicoRepository enderecoMedicoRepository;

    @Autowired
    public EnderecoMedicoService(EnderecoMedicoRepository enderecoMedicoRepository) {
        this.enderecoMedicoRepository = enderecoMedicoRepository;
    }

    public EnderecoMedico save(EnderecoMedico enderecoMedico){
        return enderecoMedicoRepository.save(enderecoMedico);
    }

    public void delete(Long id){
        enderecoMedicoRepository.deleteById(id);
    }

    public List<EnderecoMedico> findAll(){
        return enderecoMedicoRepository.findAll();
    }

    public EnderecoMedico findById(Long id){
        return enderecoMedicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }
}
