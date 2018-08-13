package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.GlossarioDTO;
import br.gov.mpog.gestaoriscos.servico.GlossarioService;
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
public class GlossarioControllerTest {

    @InjectMocks
    private GlossarioController glossarioController;

    @Mock
    private GlossarioService glossarioService;

    @Mock
    private GlossarioDTO glossarioDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Before
    public void setUp() {
        when(glossarioService.save(any(GlossarioDTO.class))).thenReturn(new GlossarioDTO());
    }


    @Test
    public void createGlossario() throws Exception {
        ResponseEntity<GlossarioDTO> naturezaSalvaDTO =
                glossarioController.createGlossario(glossarioDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateGlossario() throws Exception {
        ResponseEntity<GlossarioDTO> naturezaSalvaDTO =
                glossarioController.updateGlossario(glossarioDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getGlossario() throws Exception {
        when(glossarioService.findOne(anyLong())).thenReturn(glossarioDTO);
        ResponseEntity<GlossarioDTO> glossarioRetornoDTO =
                glossarioController.getGlossario(1l);
        assertNotNull(glossarioRetornoDTO);
    }

    @Test
    public void getAllGlossarios() throws Exception {
        when(glossarioService.findAll(any(Pageable.class), anyString(), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<GlossarioDTO>> glossarioRetornoDTO = glossarioController.getAllGlossarios(pageable, "", "", true);
        assertNotNull(glossarioRetornoDTO);
    }

    public void findAllGlossarios() throws Exception {
        when(glossarioService.findAll()).thenReturn(any());
        ResponseEntity<List<GlossarioDTO>> glossarioRetornoDTO = glossarioController.findAllGlossarios();
        assertNotNull(glossarioRetornoDTO);
    }

    @Test
    public void deleteGlossario() throws Exception {
        ResponseEntity responseEntity = glossarioController.deleteGlossario(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricao() throws Exception {
        when(glossarioService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> glossarioRetornoDTO =
                glossarioController.searchByDescricao("AA");
        assertNotNull(glossarioRetornoDTO);
    }

    @Test
    public void searchByTermo() throws Exception {
        when(glossarioService.searchByTermo(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> glossarioRetornoDTO =
                glossarioController.searchByTermo("AA");
        assertNotNull(glossarioRetornoDTO);
    }

}