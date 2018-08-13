package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.*;
import br.gov.mpog.gestaoriscos.servico.AgrupamentoTaxonomiaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.convert.EntityConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AgrupamentoTaxonomiaControllerTest {

    @InjectMocks
    private AgrupamentoTaxonomiaController agrupamentoTaxonomiaController;

    @Mock
    private AgrupamentoTaxonomiaService agrupamentoTaxonomiaService;

    @Mock
    private EntityConverter entityConverter;

    @Mock
    private AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO;

    @Mock
    private Page<AgrupamentoTaxonomiaDTO> agrupamentoTaxonomiaDTOPage;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Before
    public void setUp() {
        when(agrupamentoTaxonomiaService.save(any(AgrupamentoTaxonomiaDTO.class))).thenReturn(new AgrupamentoTaxonomiaDTO());
    }

    @Test
    public void getAllTaxonomias() throws Exception {
        doReturn(agrupamentoTaxonomiaDTOPage).when(agrupamentoTaxonomiaService).findAll(pageable, "", 1L, 1L, 1L);
        ResponseEntity<List<AgrupamentoTaxonomiaDTO>> naturezaRetornoDTO = agrupamentoTaxonomiaController.getAllTaxonomias(pageable, "", 1L, 1L, 1L);
        assertNotNull(naturezaRetornoDTO);
    }

    @Test
    public void getCausasBySearch() throws Exception {
        when(agrupamentoTaxonomiaService.getCausasBySearch(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<CausaDTO>> causaDTO =
                agrupamentoTaxonomiaController.getCausasBySearch("AA");
        assertNotNull(causaDTO);
    }

    @Test
    public void getConsequenciasBySearch() throws Exception {
        when(agrupamentoTaxonomiaService.getConsequenciasBySearch(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<ConsequenciaDTO>> consequenciaDTO =
                agrupamentoTaxonomiaController.getConsequenciasBySearch("AA");
        assertNotNull(consequenciaDTO);
    }

    @Test
    public void getControlesBySearch() throws Exception {
        when(agrupamentoTaxonomiaService.getControlesBySearch(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<ControleDTO>> controleDTO =
                agrupamentoTaxonomiaController.getControlesBySearch("AA");
        assertNotNull(controleDTO);
    }

    @Test
    public void getEventosBySearch() throws Exception {
        when(agrupamentoTaxonomiaService.getEventosBySearch(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<EventoDTO>> eventoDTO =
                agrupamentoTaxonomiaController.getEventosBySearch("AA");
        assertNotNull(eventoDTO);
    }

    @Test
    public void getTaxonomiaBySearch() throws Exception {
        when(agrupamentoTaxonomiaService.getTaxonomiaBySearch(anyString(), anyLong())).thenReturn(new ArrayList<>());
        ResponseEntity<List<TaxonomiaDTO>> taxonomiaDTO =
                agrupamentoTaxonomiaController.getTaxonomiaBySearch("AA", 11L);
        assertNotNull(taxonomiaDTO);
    }

    @Test
    public void searchByDescricao() throws Exception {
        when(agrupamentoTaxonomiaService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> taxonomiaDTO =
                agrupamentoTaxonomiaController.searchByDescricao("AA");
        assertNotNull(taxonomiaDTO);
    }

}