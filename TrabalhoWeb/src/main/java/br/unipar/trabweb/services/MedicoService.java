package br.unipar.trabweb.services;

import br.unipar.trabweb.model.dto.MedicoDTO;
import br.unipar.trabweb.models.Medico;
import br.unipar.trabweb.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    //LISTA DE MÉDICOS
    public List<MedicoDTO> listMedicoInfos() {
        List<Medico> medicos = medicoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        return medicos.stream()
                .map(medico -> {
                    MedicoDTO dto = new MedicoDTO();
                    dto.setNome(medico.getNome());
                    dto.setEmail(medico.getEmail());
                    dto.setCrm(medico.getCrm());
                    dto.setEspecialidade(medico.getEspecialidade());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    //ATUALIZAÇÃO DE MÉDICOS (C/ RESTRIÇÕES)
    public Medico updateMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    //EXCLUSÃO DE MÉDICOS
    public Medico updateStatusMedico(Medico medico) {
        return medicoRepository.save(medico);
    }


}
