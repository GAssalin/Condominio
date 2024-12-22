package br.com.condominio.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

}
