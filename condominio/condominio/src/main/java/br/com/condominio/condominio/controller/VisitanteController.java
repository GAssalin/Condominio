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

import br.com.condominio.condominio.model.Visitante;
import br.com.condominio.condominio.service.VisitanteService;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping
    public List<Visitante> findAll() {
        return visitanteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitante> findById(@PathVariable Long id) {
        Optional<Visitante> visitante = visitanteService.findById(id);
        return visitante.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Visitante save(@RequestBody Visitante visitante) {
        return visitanteService.save(visitante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        visitanteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
