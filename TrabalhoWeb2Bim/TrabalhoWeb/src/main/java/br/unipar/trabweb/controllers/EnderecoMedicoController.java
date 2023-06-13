package br.unipar.trabweb.controllers;

import br.unipar.trabweb.models.EnderecoMedico;
import br.unipar.trabweb.services.EnderecoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecosMedico")
public class EnderecoMedicoController {

    private final EnderecoMedicoService enderecoMedicoService;

    @Autowired
    public EnderecoMedicoController(EnderecoMedicoService enderecoMedicoService) {
        this.enderecoMedicoService = enderecoMedicoService;
    }

    @PostMapping
    public ResponseEntity<EnderecoMedico> save(@RequestBody EnderecoMedico enderecoMedico){
        return ResponseEntity.ok(enderecoMedicoService.save(enderecoMedico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        enderecoMedicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EnderecoMedico>> findAll(){
        return ResponseEntity.ok(enderecoMedicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoMedico> findById(@PathVariable Long id){
        return ResponseEntity.ok(enderecoMedicoService.findById(id));
    }
}
