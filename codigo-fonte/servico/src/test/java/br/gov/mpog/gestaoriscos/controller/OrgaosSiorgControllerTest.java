package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.OrgaoDTO;
import br.gov.mpog.gestaoriscos.servico.OrgaoServico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrgaosSiorgControllerTest {

    @InjectMocks
    private OrgaosSiorgController orgaosSiorgController;

    @Mock
    private OrgaoServico orgaosSiorgService;

    @Mock
    private OrgaoDTO orgaoDTO;

    @Test
    public void getAllOrgaosSiorgs() throws Exception {
        when(orgaosSiorgService.listarOrgaos(anyLong())).thenReturn(asList(orgaoDTO));
        ResponseEntity<List<OrgaoDTO>> orgaosSiorgRetornoDTO = orgaosSiorgController.getUnidadePeloId(1L);
        assertNotNull(orgaosSiorgRetornoDTO);
    }

    @Test
    public void filtrarOrgaos() throws Exception {
        when(orgaosSiorgService.filtrar(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<OrgaoDTO>> orgaosSiorgRetornoDTO =
                orgaosSiorgController.filtrarOrgaos("AA");
        assertNotNull(orgaosSiorgRetornoDTO);
    }

}