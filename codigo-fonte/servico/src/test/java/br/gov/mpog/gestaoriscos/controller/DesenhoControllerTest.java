package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.DesenhoDTO;
import br.gov.mpog.gestaoriscos.servico.DesenhoService;
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
public class DesenhoControllerTest {

    @InjectMocks
    private DesenhoController desenhoController;

    @Mock
    private DesenhoService desenhoService;

    @Mock
    private DesenhoDTO desenhoDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Before
    public void setUp() {
        when(desenhoService.save(any(DesenhoDTO.class))).thenReturn(new DesenhoDTO());
    }

    @Test
    public void createDesenho() throws Exception {
        ResponseEntity<DesenhoDTO> naturezaSalvaDTO =
                desenhoController.createDesenho(desenhoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void updateDesenho() throws Exception {
        ResponseEntity<DesenhoDTO> naturezaSalvaDTO =
                desenhoController.updateDesenho(desenhoDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getDesenho() throws Exception {
        when(desenhoService.findOne(anyLong())).thenReturn(desenhoDTO);
        ResponseEntity<DesenhoDTO> desenhoRetornoDTO =
                desenhoController.getDesenho(1l);
        assertNotNull(desenhoRetornoDTO);
    }

    @Test
    public void getAllDesenhos() throws Exception {
        when(desenhoService.findAll(any(Pageable.class), anyString(), anyBoolean())).thenReturn(page);
        ResponseEntity<List<DesenhoDTO>> desenhoRetornoDTO = desenhoController.getAllDesenhos(pageable, "", true);
        assertNotNull(desenhoRetornoDTO);
    }

    @Test
    public void deleteDesenho() throws Exception {
        ResponseEntity responseEntity = desenhoController.deleteDesenho(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void searchByDescricaoComSucesso() throws Exception {
        when(desenhoService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> desenhoRetornoDTO =
                desenhoController.searchByDescricao("AA");
        assertNotNull(desenhoRetornoDTO);
    }

}