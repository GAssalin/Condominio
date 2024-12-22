package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.Visitante;
import br.com.condominio.condominio.repository.VisitanteRepository;

@Service
public class VisitanteService {

    @Autowired
    private VisitanteRepository visitanteRepository;

    public List<Visitante> findAll() {
        return visitanteRepository.findAll();
    }

    public Optional<Visitante> findById(Long id) {
        return visitanteRepository.findById(id);
    }

    public Visitante save(Visitante visitante) {
        return visitanteRepository.save(visitante);
    }

    public void deleteById(Long id) {
        visitanteRepository.deleteById(id);
    }
    
}
