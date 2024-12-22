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

import br.com.condominio.condominio.model.AnimaisEstimacao;
import br.com.condominio.condominio.service.AnimaisEstimacaoService;

@RestController
@RequestMapping("/animais-estimacao")
public class AnimaisEstimacaoController {

    @Autowired
    private AnimaisEstimacaoService animaisEstimacaoService;

    @GetMapping
    public List<AnimaisEstimacao> findAll() {
        return animaisEstimacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimaisEstimacao> findById(@PathVariable Long id) {
        Optional<AnimaisEstimacao> animal = animaisEstimacaoService.findById(id);
        return animal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AnimaisEstimacao save(@RequestBody AnimaisEstimacao animal) {
        return animaisEstimacaoService.save(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        animaisEstimacaoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
