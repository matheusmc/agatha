package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.CausaDTO;
import br.gov.mpog.gestaoriscos.servico.CausaService;
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
public class CausaControllerTest {

    @InjectMocks
    private CausaController causaController;

    @Mock
    private CausaService causaService;

    @Mock
    private CausaDTO causaDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Before
    public void setUp() {
        when(causaService.save(any(CausaDTO.class))).thenReturn(new CausaDTO());
    }

    @Test
    public void createCausa() throws Exception {
        ResponseEntity<CausaDTO> naturezaSalvaDTO =
                causaController.createCausa(causaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateCausa() throws Exception {
        ResponseEntity<CausaDTO> naturezaSalvaDTO =
                causaController.updateCausa(causaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getCausa() throws Exception {
        when(causaService.findOne(anyLong())).thenReturn(causaDTO);
        ResponseEntity<CausaDTO> causaRetornoDTO =
                causaController.getCausa(1l);
        assertNotNull(causaRetornoDTO);
    }

    @Test
    public void getAllCausas() throws Exception {
        when(causaService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<CausaDTO>> causaRetornoDTO = causaController.getAllCausas(pageable, "", true);
        assertNotNull(causaRetornoDTO);
    }

    @Test
    public void deleteCausa() throws Exception {
        ResponseEntity responseEntity = causaController.deleteCausa(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(causaService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> causaRetornoDTO =
                causaController.searchByDescricao("AA");
        assertNotNull(causaRetornoDTO);
    }

}