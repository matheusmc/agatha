package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.TaxonomiaContainerDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TaxonomiaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoTaxonomiaDTO;
import br.gov.mpog.gestaoriscos.servico.TaxonomiaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TaxonomiaControllerTest {

    @InjectMocks
    private TaxonomiaController taxonomiaController;

    @Mock
    private TaxonomiaService taxonomiaService;

    @Mock
    private TaxonomiaContainerDTO taxonomiaContainerDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Test
    public void aprovarTaxonomia() throws Exception {
        ResponseEntity<TaxonomiaDTO> naturezaSalvaDTO =
                taxonomiaController.aprovarTaxonomia(taxonomiaContainerDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void reprovarTaxonomia() throws Exception {
        ResponseEntity<TaxonomiaDTO> naturezaSalvaDTO =
                taxonomiaController.reprovarTaxonomia(taxonomiaContainerDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getAllTaxonomias() throws Exception {
        when(taxonomiaService.findAll(any(Pageable.class), anyString(), anyString(), anyLong(), anyLong(), anyLong())).thenReturn(page);
        ResponseEntity<List<TaxonomiaDTO>> taxonomiaRetornoDTO = taxonomiaController.getAllTaxonomias(pageable, "", "", 11L, 1L, 1L);
        assertNotNull(taxonomiaRetornoDTO);
    }

    public void getTiposTaxonomia() throws Exception {
        when(taxonomiaService.findAllTiposTaxonomia()).thenReturn(any());
        ResponseEntity<List<TipoTaxonomiaDTO>> taxonomiaRetornoDTO = taxonomiaController.getTiposTaxonomia();
        assertNotNull(taxonomiaRetornoDTO);
    }

    @Test
    public void searchByDescricao() throws Exception {
        when(taxonomiaService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> taxonomiaRetornoDTO =
                taxonomiaController.searchByDescricao("AA");
        assertNotNull(taxonomiaRetornoDTO);
    }

    @Test
    public void searchByTermo() throws Exception {
        when(taxonomiaService.searchOrgaoByNome(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> taxonomiaRetornoDTO =
                taxonomiaController.searchByNome("AA");
        assertNotNull(taxonomiaRetornoDTO);
    }

}