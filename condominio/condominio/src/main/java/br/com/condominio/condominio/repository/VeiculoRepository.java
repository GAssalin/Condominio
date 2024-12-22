package br.com.condominio.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
}
