package br.unipar.trabweb.controllers;

import br.unipar.trabweb.model.dto.MedicoCadastroDTO;
import br.unipar.trabweb.model.dto.MedicoDTO;
import br.unipar.trabweb.models.Medico;
import br.unipar.trabweb.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.save(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //LISTA DE MÉDICOS
    @GetMapping("/info")
    public List<MedicoDTO> getMedicoInfos() {
        return medicoService.listMedicoInfos();
    }

    private MedicoDTO convertToDTO(Medico medico) {
        MedicoDTO medicoDTO = new MedicoDTO();
        medicoDTO.setNome(medico.getNome());
        medicoDTO.setEmail(medico.getEmail());
        medicoDTO.setCrm(medico.getCrm());
        medicoDTO.setEspecialidade(medico.getEspecialidade());
        return medicoDTO;
    }

    //ATUALIZAÇÃO DE MÉDICOS (C/ RESTRIÇÕES)
    @PutMapping("/medicos/{id}")
    public ResponseEntity<String> updateMedico(@PathVariable Long id, @RequestBody MedicoCadastroDTO medicoCadastroDTO) {
        Medico medico = medicoService.findById(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar se campos não alteráveis estão sendo modificados
        if (!medico.getEspecialidade().equals(medicoCadastroDTO.getEspecialidade()) ||
                !medico.getEmail().equals(medicoCadastroDTO.getEmail()) ||
                !medico.getCrm().equals(medicoCadastroDTO.getCrm())) {
            return ResponseEntity.badRequest().body("Não é permitido alterar a especialidade, email ou CRM.");
        }

        // Atualizar campos permitidos
        medico.setNome(medicoCadastroDTO.getNome());
        medico.setTelefone(medicoCadastroDTO.getTelefone());
        medico.setEndereco(medicoCadastroDTO.getEndereco());

        Medico updatedMedico = medicoService.save(medico);

        if (updatedMedico == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Cadastro do médico atualizado com sucesso.");
    }

    //EXCLUSÃO DE MÉDICOS
    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<String> desativarMedico(@PathVariable Long id) {
        Medico medico = medicoService.findById(id);
        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        medico.setAtivo(false); // Marcar o médico como inativo

        Medico updatedStatusMedico = medicoService.updateStatusMedico(medico);

        if (updatedStatusMedico == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Médico marcado como inativo.");
    }



}
