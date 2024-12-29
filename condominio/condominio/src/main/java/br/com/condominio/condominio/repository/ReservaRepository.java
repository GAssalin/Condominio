package br.com.condominio.condominio.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.condominio.condominio.model.Reserva;
import br.com.condominio.condominio.model.StatusReserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	Page<Reserva> findByStatus(StatusReserva status, Pageable pageable);
	Page<Reserva> findByDataReserva(LocalDate dataReserva, Pageable pageable);
	Page<Reserva> findByDataReservaBetween(LocalDate startLocalDate, LocalDate endLocalDate, Pageable pageable);
	Page<Reserva> findByAreaComumId(Long areaComumId, Pageable pageable);
	Page<Reserva> findByMoradorId(Long moradorId, Pageable pageable);
	Page<Reserva> findByAreaComumIdAndStatus(Long areaComumId, StatusReserva status, Pageable pageable);
	Page<Reserva> findByMoradorIdAndDataReserva(Long moradorId, LocalDate dataReserva, Pageable pageable);
	Page<Reserva> findByOrderByDataReservaAsc();
	Page<Reserva> findByMoradorIdOrderByDataReservaDesc(Long moradorId, Pageable pageable);

}
