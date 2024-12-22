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

import br.com.condominio.condominio.model.Morador;
import br.com.condominio.condominio.repository.MoradorRepository;
import br.com.condominio.condominio.service.MoradorService;

@ExtendWith(MockitoExtension.class)
public class MoradorServiceTest {

	@InjectMocks
	private MoradorService moradorService;

	@Mock
	private MoradorRepository moradorRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAll() {
		Morador morador = new Morador();
		morador.setId(1L);
		morador.setNome("João");

		when(moradorRepository.findAll()).thenReturn(Arrays.asList(morador));

		List<Morador> moradores = moradorService.findAll();

		assertNotNull(moradores);
		assertEquals(1, moradores.size());
		assertEquals("João", moradores.get(0).getNome());
	}

	@Test
	void testFindById() {
		Morador morador = new Morador();
		morador.setId(1L);
		morador.setNome("João");

		when(moradorRepository.findById(1L)).thenReturn(Optional.of(morador));

		Optional<Morador> found = moradorService.findById(1L);

		assertTrue(found.isPresent());
		assertEquals("João", found.get().getNome());
	}

	@Test
	void testSave() {
		Morador morador = new Morador();
		morador.setNome("João");

		when(moradorRepository.save(morador)).thenReturn(morador);

		Morador saved = moradorService.save(morador);

		assertNotNull(saved);
		assertEquals("João", saved.getNome());
	}

	@Test
	void testDeleteById() {
		doNothing().when(moradorRepository).deleteById(1L);

		moradorService.deleteById(1L);

		verify(moradorRepository, times(1)).deleteById(1L);
	}

}
