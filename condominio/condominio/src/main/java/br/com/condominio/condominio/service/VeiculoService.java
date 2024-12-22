package br.com.condominio.condominio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.Veiculo;
import br.com.condominio.condominio.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }

}
