package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.ConsequenciaDTO;
import br.gov.mpog.gestaoriscos.servico.ConsequenciaService;
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
public class ConsequenciaControllerTest {

    @InjectMocks
    private ConsequenciaController consequenciaController;

    @Mock
    private ConsequenciaService consequenciaService;

    @Mock
    private ConsequenciaDTO consequenciaDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Before
    public void setUp() {
        when(consequenciaService.save(any(ConsequenciaDTO.class))).thenReturn(new ConsequenciaDTO());
    }

    @Test
    public void createConsequencia() throws Exception {
        ResponseEntity<ConsequenciaDTO> naturezaSalvaDTO =
                consequenciaController.createConsequencia(consequenciaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateConsequencia() throws Exception {
        ResponseEntity<ConsequenciaDTO> naturezaSalvaDTO =
                consequenciaController.updateConsequencia(consequenciaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getConsequencia() throws Exception {
        when(consequenciaService.findOne(anyLong())).thenReturn(consequenciaDTO);
        ResponseEntity<ConsequenciaDTO> consequenciaRetornoDTO =
                consequenciaController.getConsequencia(1l);
        assertNotNull(consequenciaRetornoDTO);
    }

    @Test
    public void getAllConsequencias() throws Exception {
        when(consequenciaService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<ConsequenciaDTO>> consequenciaRetornoDTO = consequenciaController.getAllConsequencias(pageable, "", true);
        assertNotNull(consequenciaRetornoDTO);
    }

    @Test
    public void deleteConsequencia() throws Exception {
        ResponseEntity responseEntity = consequenciaController.deleteConsequencia(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(consequenciaService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> consequenciaRetornoDTO =
                consequenciaController.searchByDescricao("AA");
        assertNotNull(consequenciaRetornoDTO);
    }

}