package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.AreaComum;
import br.com.condominio.condominio.repository.AreaComumRepository;

@Service
public class AreaComumService {

    @Autowired
    private AreaComumRepository areaComumRepository;

    public List<AreaComum> findAll() {
        return areaComumRepository.findAll();
    }

    public Optional<AreaComum> findById(Long id) {
        return areaComumRepository.findById(id);
    }

    public AreaComum save(AreaComum areaComum) {
        return areaComumRepository.save(areaComum);
    }

    public void deleteById(Long id) {
        areaComumRepository.deleteById(id);
    }

}
