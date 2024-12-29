package br.com.condominio.condominio.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.condominio.condominio.model.Reserva;
import br.com.condominio.condominio.model.StatusReserva;
import br.com.condominio.condominio.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }
    
    public Reserva criarReserva(Reserva reserva) {
    	//Regra para informar a administracao de uma nova reserva para ser avaliada
    	reserva.setStatus(StatusReserva.PENDENTE);
    	return save(reserva);
    }
    
    public Reserva confirmarReserva(Reserva reserva) {
    	//Regra para informar o morador
    	reserva.setStatus(StatusReserva.CONFIRMADA);
    	return save(reserva);
    }
    
    public Reserva cancelarReserva(Reserva reserva) throws Exception {
    	if(reserva.getMotivo().isEmpty())
    		throw new Exception("Motivo deve ser preenchido");
    	
    	//Regra para informar o morador e a administracao
    	reserva.setStatus(StatusReserva.CANCELADA);
    	return save(reserva);
    }
    
    public Page<Reserva> findReservasPendentes(Pageable pageable) {
    	return reservaRepository.findByStatus(StatusReserva.PENDENTE, pageable);
    }
    
    public Page<Reserva> findReservasHoje(Pageable pageable) {
    	return reservaRepository.findByDataReserva(LocalDate.now(), pageable);
    }
    
    public Page<Reserva> findReservasMes(LocalDate startDate, LocalDate endDate, Pageable pageable) {
    	return reservaRepository.findByDataReservaBetween(startDate, endDate, pageable);
    }
    
    public Page<Reserva> findReservasDoMorador(Long idMorador, Pageable pageable) {
    	return reservaRepository.findByMoradorId(idMorador, pageable);
    }
    
    public Page<Reserva> findReservasDoMoradorHoje(Long idMorador, Date dataReserva, Pageable pageable) {
    	return reservaRepository.findByMoradorIdAndDataReserva(idMorador, LocalDate.now(), pageable);
    }
    
    public Page<Reserva> findReservasOrdenadas() {
    	return reservaRepository.findByOrderByDataReservaAsc();
    }
    
    public Page<Reserva> findReservasRecentesDoMorador(Long idMorador) {
    	return reservaRepository.findByMoradorIdOrderByDataReservaDesc(idMorador, PageRequest.of(0, 10));
    }
    
    public Page<Reserva> findByStatus(StatusReserva status, Pageable pageable) {
    	return reservaRepository.findByStatus(status, pageable);
    }

}
