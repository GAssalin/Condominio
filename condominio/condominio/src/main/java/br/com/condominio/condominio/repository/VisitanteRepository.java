package br.com.condominio.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

}
