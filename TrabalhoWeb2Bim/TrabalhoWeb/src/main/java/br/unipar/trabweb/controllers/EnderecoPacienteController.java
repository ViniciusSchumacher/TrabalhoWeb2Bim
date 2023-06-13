package br.unipar.trabweb.controllers;

import br.unipar.trabweb.models.EnderecoPaciente;
import br.unipar.trabweb.services.EnderecoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoPacienteController {

    private final EnderecoPacienteService enderecoPacienteService;

    @Autowired
    public EnderecoPacienteController(EnderecoPacienteService enderecoPacienteService) {
        this.enderecoPacienteService = enderecoPacienteService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoPaciente>> getAllEnderecos() {
        List<EnderecoPaciente> enderecos = enderecoPacienteService.getAllEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoPaciente> getEnderecoById(@PathVariable Long id) {
        Optional<EnderecoPaciente> endereco = enderecoPacienteService.getEnderecoById(id);
        return endereco.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnderecoPaciente> saveEndereco(@RequestBody EnderecoPaciente endereco) {
        EnderecoPaciente savedEndereco = enderecoPacienteService.saveEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoPacienteService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }
}
