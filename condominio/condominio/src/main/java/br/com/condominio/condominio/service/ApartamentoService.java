package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.Apartamento;
import br.com.condominio.condominio.repository.ApartamentoRepository;

@Service
public class ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public List<Apartamento> findAll() {
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamento> findById(Long id) {
        return apartamentoRepository.findById(id);
    }

    public Apartamento save(Apartamento apartamento) {
        return apartamentoRepository.save(apartamento);
    }

    public void deleteById(Long id) {
        apartamentoRepository.deleteById(id);
    }
    
}

