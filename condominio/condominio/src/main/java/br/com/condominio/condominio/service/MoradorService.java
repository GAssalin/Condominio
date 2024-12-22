package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.Morador;
import br.com.condominio.condominio.repository.MoradorRepository;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    public List<Morador> findAll() {
        return moradorRepository.findAll();
    }

    public Optional<Morador> findById(Long id) {
        return moradorRepository.findById(id);
    }

    public Morador save(Morador morador) {
        return moradorRepository.save(morador);
    }

    public void deleteById(Long id) {
        moradorRepository.deleteById(id);
    }
    
}
