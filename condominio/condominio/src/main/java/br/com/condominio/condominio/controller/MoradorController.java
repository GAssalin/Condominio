package br.com.condominio.condominio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condominio.condominio.model.Morador;
import br.com.condominio.condominio.service.MoradorService;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

    @Autowired
    private MoradorService moradorService;

    @GetMapping
    public List<Morador> findAll() {
        return moradorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Morador> findById(@PathVariable Long id) {
        Optional<Morador> morador = moradorService.findById(id);
        return morador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Morador save(@RequestBody Morador morador) {
        return moradorService.save(morador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        moradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
