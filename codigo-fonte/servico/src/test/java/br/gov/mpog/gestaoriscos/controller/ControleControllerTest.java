package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.ControleDTO;
import br.gov.mpog.gestaoriscos.servico.ControleService;
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
public class ControleControllerTest {

    @InjectMocks
    private ControleController controleController;

    @Mock
    private ControleService controleService;

    @Mock
    private ControleDTO controleDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Before
    public void setUp() {
        when(controleService.save(any(ControleDTO.class))).thenReturn(new ControleDTO());
    }

    @Test
    public void createControle() throws Exception {
        ResponseEntity<ControleDTO> naturezaSalvaDTO =
                controleController.createControle(controleDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateControle() throws Exception {
        ResponseEntity<ControleDTO> naturezaSalvaDTO =
                controleController.updateControle(controleDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getControle() throws Exception {
        when(controleService.findOne(anyLong())).thenReturn(controleDTO);
        ResponseEntity<ControleDTO> controleRetornoDTO =
                controleController.getControle(1l);
        assertNotNull(controleRetornoDTO);
    }

    @Test
    public void getAllControles() throws Exception {
        when(controleService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<ControleDTO>> controleRetornoDTO = controleController.getAllControles(pageable, "", true);
        assertNotNull(controleRetornoDTO);
    }

    @Test
    public void deleteControle() throws Exception {
        ResponseEntity responseEntity = controleController.deleteControle(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(controleService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> controleRetornoDTO =
                controleController.searchByDescricao("AA");
        assertNotNull(controleRetornoDTO);
    }

}