package br.com.condominio.condominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
