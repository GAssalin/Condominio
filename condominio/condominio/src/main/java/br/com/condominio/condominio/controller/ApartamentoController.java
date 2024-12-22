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

import br.com.condominio.condominio.model.Apartamento;
import br.com.condominio.condominio.service.ApartamentoService;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<Apartamento> findAll() {
        return apartamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartamento> findById(@PathVariable Long id) {
        Optional<Apartamento> apartamento = apartamentoService.findById(id);
        return apartamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Apartamento save(@RequestBody Apartamento apartamento) {
        return apartamentoService.save(apartamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        apartamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
