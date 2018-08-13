package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.EventoDTO;
import br.gov.mpog.gestaoriscos.servico.EventoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventoControllerTest {

    @InjectMocks
    private EventoController eventoController;

    @Mock
    private EventoService eventoService;

    @Mock
    private EventoDTO eventoDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Before
    public void setUp() {
        when(eventoService.save(any(EventoDTO.class))).thenReturn(new EventoDTO());
    }


    @Test
    public void createEvento() throws Exception {
        ResponseEntity<EventoDTO> naturezaSalvaDTO =
                eventoController.createEvento(eventoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateEvento() throws Exception {
        ResponseEntity<EventoDTO> naturezaSalvaDTO =
                eventoController.updateEvento(eventoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getEvento() throws Exception {
        when(eventoService.findOne(anyLong())).thenReturn(eventoDTO);
        ResponseEntity<EventoDTO> eventoRetornoDTO =
                eventoController.getEvento(1l);
        assertNotNull(eventoRetornoDTO);
    }

    @Test
    public void getAllEventos() throws Exception {
        when(eventoService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<EventoDTO>> eventoRetornoDTO = eventoController.getAllEventos(pageable, "", true);
        assertNotNull(eventoRetornoDTO);
    }

    @Test
    public void deleteEvento() throws Exception {
        ResponseEntity responseEntity = eventoController.deleteEvento(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(eventoService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> eventoRetornoDTO =
                eventoController.searchByDescricao("AA");
        assertNotNull(eventoRetornoDTO);
    }

}