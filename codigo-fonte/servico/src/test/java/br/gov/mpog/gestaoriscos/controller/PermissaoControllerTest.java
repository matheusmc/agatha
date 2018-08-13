package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoContainerDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.UsuarioDTO;
import br.gov.mpog.gestaoriscos.servico.PermissaoService;
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
public class PermissaoControllerTest {

    @InjectMocks
    private PermissaoController permissaoController;

    @Mock
    private PermissaoService permissaoService;

    @Mock
    private PermissaoDTO permissaoDTO;

    @Mock
    private PermissaoContainerDTO permissaoContainerDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Test
    public void createPermissao() throws Exception {
        ResponseEntity<List<PermissaoDTO>> permissaoSalvaDTO =
                permissaoController.createPermissao(permissaoContainerDTO);
        assertNotNull(permissaoSalvaDTO);
    }

    @Test
    public void updatePermissao() throws Exception {
        ResponseEntity<PermissaoDTO> naturezaSalvaDTO =
                permissaoController.updatePermissao(permissaoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getPermissao() throws Exception {
        when(permissaoService.findOne(anyLong())).thenReturn(permissaoDTO);

        ResponseEntity<PermissaoDTO> permissaoRetornoDTO =
                permissaoController.getPermissao(1l);
        assertNotNull(permissaoRetornoDTO);
    }

    @Test
    public void getAllPermissaos() throws Exception {
        when(permissaoService.findAll(anyString(), anyLong(), anyLong(), any(Pageable.class))).thenReturn(page);
        ResponseEntity<List<UsuarioDTO>> permissaoRetornoDTO = permissaoController.getAllPermissao(pageable, "teste", 1L, 11L);
        assertNotNull(permissaoRetornoDTO);
    }

    @Test
    public void deletePermissao() throws Exception {
        ResponseEntity responseEntity = permissaoController.deletePermissao(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByNome() throws Exception {
        when(permissaoService.searchOrgaoByNome(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> permissaoRetornoDTO =
                permissaoController.searchByNome("AA");
        assertNotNull(permissaoRetornoDTO);
    }

    @Test
    public void searchUsuarioByNome() throws Exception {
        when(permissaoService.searchUsuarioByNome(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> permissaoRetornoDTO =
                permissaoController.searchUsuarioByNome("AA");
        assertNotNull(permissaoRetornoDTO);
    }

}