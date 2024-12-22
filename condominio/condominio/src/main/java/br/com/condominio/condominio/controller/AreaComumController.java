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

import br.com.condominio.condominio.model.AreaComum;
import br.com.condominio.condominio.service.AreaComumService;

@RestController
@RequestMapping("/areas-comuns")
public class AreaComumController {

    @Autowired
    private AreaComumService areaComumService;

    @GetMapping
    public List<AreaComum> findAll() {
        return areaComumService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaComum> findById(@PathVariable Long id) {
        Optional<AreaComum> areaComum = areaComumService.findById(id);
        return areaComum.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AreaComum save(@RequestBody AreaComum areaComum) {
        return areaComumService.save(areaComum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        areaComumService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
