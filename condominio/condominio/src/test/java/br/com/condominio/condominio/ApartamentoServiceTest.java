package br.com.condominio.condominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.condominio.condominio.model.Apartamento;
import br.com.condominio.condominio.repository.ApartamentoRepository;
import br.com.condominio.condominio.service.ApartamentoService;

@ExtendWith(MockitoExtension.class)
public class ApartamentoServiceTest {

	@InjectMocks
    private ApartamentoService apartamentoService;

    @Mock
    private ApartamentoRepository apartamentoRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Apartamento apartamento = new Apartamento();
        apartamento.setId(1L);
        apartamento.setBloco("A");
        apartamento.setAndar(1);
        apartamento.setNumero("101");

        when(apartamentoRepository.findAll()).thenReturn(Arrays.asList(apartamento));

        List<Apartamento> apartamentos = apartamentoService.findAll();

        assertNotNull(apartamentos);
        assertEquals(1, apartamentos.size());
        assertEquals("A", apartamentos.get(0).getBloco());
    }

    @Test
    void testFindById() {
        Apartamento apartamento = new Apartamento();
        apartamento.setId(1L);
        apartamento.setBloco("A");

        when(apartamentoRepository.findById(1L)).thenReturn(Optional.of(apartamento));

        Optional<Apartamento> found = apartamentoService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("A", found.get().getBloco());
    }

    @Test
    void testSave() {
        Apartamento apartamento = new Apartamento();
        apartamento.setBloco("A");
        apartamento.setAndar(1);
        apartamento.setNumero("101");

        when(apartamentoRepository.save(apartamento)).thenReturn(apartamento);

        Apartamento saved = apartamentoService.save(apartamento);

        assertNotNull(saved);
        assertEquals("A", saved.getBloco());
    }

    @Test
    void testDeleteById() {
        doNothing().when(apartamentoRepository).deleteById(1L);

        apartamentoService.deleteById(1L);

        verify(apartamentoRepository, times(1)).deleteById(1L);
    }
	
}
