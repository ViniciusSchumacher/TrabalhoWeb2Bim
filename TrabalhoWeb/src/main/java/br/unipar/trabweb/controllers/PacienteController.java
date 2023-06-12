package br.unipar.trabweb.controllers;

import br.unipar.trabweb.model.dto.PacienteCadastroDTO;
import br.unipar.trabweb.model.dto.PacienteDTO;
import br.unipar.trabweb.models.Paciente;
import br.unipar.trabweb.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.save(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        return ResponseEntity.ok(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.findById(id));
    }

    //LISTA DE PACIENTES
    @GetMapping("/info")
    public List<PacienteDTO> getPacienteInfos() {
        return pacienteService.listPacienteInfos();
    }

    //ATUALIZAÇÃO DE PACIENTES (C/ RESTRIÇÕES)
    @PutMapping("/pacientes/{id}")
    public ResponseEntity<String> updatePaciente(@PathVariable Long id, @RequestBody PacienteCadastroDTO pacienteCadastroDTO) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar se campos não alteráveis estão sendo modificados
        if (!paciente.getEmail().equals(pacienteCadastroDTO.getEmail()) ||
                !paciente.getCpf().equals(pacienteCadastroDTO.getCpf())) {
            return ResponseEntity.badRequest().body("Não é permitido alterar o email ou CPF.");
        }

        // Atualizar campos permitidos
        paciente.setNome(pacienteCadastroDTO.getNome());
        paciente.setTelefone(pacienteCadastroDTO.getTelefone());
        paciente.setEndereco(pacienteCadastroDTO.getEndereco());

        Paciente updatedPaciente = pacienteService.save(paciente);

        if (updatedPaciente == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Cadastro do paciente atualizado com sucesso.");
    }

    //EXCLUSÃO DE PACIENTES
    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<String> desativarPaciente(@PathVariable Long id) {
        Paciente paciente = pacienteService.findById(id);
        if (paciente == null) {
            return ResponseEntity.notFound().build();
        }

        paciente.setAtivo(false); // Marcar o paciente como inativo

        Paciente updatedStatusPaciente = pacienteService.updateStatusPaciente(paciente);

        if (updatedStatusPaciente == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok("Paciente marcado como inativo.");
    }



}
