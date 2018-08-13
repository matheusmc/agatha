package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.OperacaoDTO;
import br.gov.mpog.gestaoriscos.servico.OperacaoService;
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
public class OperacaoControllerTest {

    @InjectMocks
    private OperacaoController operacaoController;

    @Mock
    private OperacaoService operacaoService;

    @Mock
    private OperacaoDTO operacaoDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;


    @Before
    public void setUp() {
        when(operacaoService.save(any(OperacaoDTO.class))).thenReturn(new OperacaoDTO());
    }


    @Test
    public void createOperacao() throws Exception {
        ResponseEntity<OperacaoDTO> naturezaSalvaDTO =
                operacaoController.createOperacao(operacaoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateOperacao() throws Exception {
        ResponseEntity<OperacaoDTO> naturezaSalvaDTO =
                operacaoController.updateOperacao(operacaoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getOperacao() throws Exception {
        when(operacaoService.findOne(anyLong())).thenReturn(operacaoDTO);

        ResponseEntity<OperacaoDTO> operacaoRetornoDTO =
                operacaoController.getOperacao(1l);
        assertNotNull(operacaoRetornoDTO);
    }

    @Test
    public void getAllOperacaos() throws Exception {
        when(operacaoService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<OperacaoDTO>> operacaoRetornoDTO = operacaoController.getAllOperacaos(pageable, "", true);
        assertNotNull(operacaoRetornoDTO);
    }

    @Test
    public void deleteOperacao() throws Exception {
        ResponseEntity responseEntity = operacaoController.deleteOperacao(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(operacaoService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> operacaoRetornoDTO =
                operacaoController.searchByDescricao("AA");
        assertNotNull(operacaoRetornoDTO);
    }

}