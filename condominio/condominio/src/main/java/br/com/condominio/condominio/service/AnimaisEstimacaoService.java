package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.AnimaisEstimacao;
import br.com.condominio.condominio.repository.AnimaisEstimacaoRepository;

@Service
public class AnimaisEstimacaoService {

	@Autowired
    private AnimaisEstimacaoRepository animaisEstimacaoRepository;

    public List<AnimaisEstimacao> findAll() {
        return animaisEstimacaoRepository.findAll();
    }

    public Optional<AnimaisEstimacao> findById(Long id) {
        return animaisEstimacaoRepository.findById(id);
    }

    public AnimaisEstimacao save(AnimaisEstimacao animal) {
        return animaisEstimacaoRepository.save(animal);
    }

    public void deleteById(Long id) {
        animaisEstimacaoRepository.deleteById(id);
    }
	
}
