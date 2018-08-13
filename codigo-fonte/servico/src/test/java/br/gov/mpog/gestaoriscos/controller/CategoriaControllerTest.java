package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaDTO;
import br.gov.mpog.gestaoriscos.servico.CategoriaService;
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
public class CategoriaControllerTest {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaService;

    @Mock
    private CategoriaDTO categoriaDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Before
    public void setUp() {
        when(categoriaService.save(any(CategoriaDTO.class))).thenReturn(new CategoriaDTO());
    }


    @Test
    public void createCategoria() throws Exception {
        ResponseEntity<CategoriaDTO> naturezaSalvaDTO =
                categoriaController.createCategoria(categoriaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateCategoria() throws Exception {
        ResponseEntity<CategoriaDTO> naturezaSalvaDTO =
                categoriaController.updateCategoria(categoriaDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getCategoria() throws Exception {
        when(categoriaService.findOne(anyLong())).thenReturn(categoriaDTO);

        ResponseEntity<CategoriaDTO> categoriaRetornoDTO =
                categoriaController.getCategoria(1l);
        assertNotNull(categoriaRetornoDTO);
    }

    @Test
    public void getAllCategorias() throws Exception {
        when(categoriaService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<CategoriaDTO>> categoriaRetornoDTO = categoriaController.getAllCategorias(pageable, "", true);
        assertNotNull(categoriaRetornoDTO);
    }

    @Test
    public void deleteCategoria() throws Exception {
        ResponseEntity responseEntity = categoriaController.deleteCategoria(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(categoriaService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> categoriaRetornoDTO =
                categoriaController.searchByDescricao("AA");
        assertNotNull(categoriaRetornoDTO);
    }

}