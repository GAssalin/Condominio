package br.com.condominio.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

}
