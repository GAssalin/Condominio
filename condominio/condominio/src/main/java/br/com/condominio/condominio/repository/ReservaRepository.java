package br.com.condominio.condominio.repository;

import java.awt.print.Pageable;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Reserva;
import br.com.condominio.condominio.model.StatusReserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	Page<Reserva> findByStatus(StatusReserva status);
	Page<Reserva> findByDataReserva(Date dataReserva);
	Page<Reserva> findByDataReservaBetween(Date startDate, Date endDate);
	Page<Reserva> findByAreaComumId(Long areaComumId);
	Page<Reserva> findByMoradorId(Long moradorId);
	Page<Reserva> findByAreaComumIdAndStatus(Long areaComumId, StatusReserva status);
	Page<Reserva> findByMoradorIdAndDataReserva(Long moradorId, Date dataReserva);
	Page<Reserva> findByOrderByDataReservaAsc();
	Page<Reserva> findByMoradorIdOrderByDataReservaDesc(Long moradorId);
	Page<Reserva> findByStatus(StatusReserva status, Pageable pageable);

}
