package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.CalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoCalculadoraDTO;
import br.gov.mpog.gestaoriscos.servico.CalculadoraService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CalculadoraControllerTest {

    @InjectMocks
    private CalculadoraController calculadoraController;

    @Mock
    private CalculadoraService calculadoraService;

    @Mock
    private CalculadoraDTO calculadoraDTO;

    @Mock
    private TipoCalculadoraDTO tipoCalculadoraDTO;


    @Before
    public void setUp() {
        when(calculadoraService.save(any(CalculadoraDTO.class))).thenReturn(new CalculadoraDTO());
    }

    @Test
    public void updateCalculadora() throws Exception {
        ResponseEntity<CalculadoraDTO> naturezaSalvaDTO =
                calculadoraController.updateCalculadora(calculadoraDTO);
        assertNotNull(naturezaSalvaDTO);
    }

    @Test
    public void getAllCalculadoras() throws Exception {
        when(calculadoraService.findAll()).thenReturn(Arrays.asList(calculadoraDTO));
        ResponseEntity<List<CalculadoraDTO>> calculadoraDTO = calculadoraController.getAllCalculadoras();
        assertNotNull(calculadoraDTO);
    }

    @Test
    public void getAllTiposCalculadora() throws Exception {
        when(calculadoraService.findAllTiposCalculadora()).thenReturn(Arrays.asList(tipoCalculadoraDTO));
        ResponseEntity<List<TipoCalculadoraDTO>> calculadoraDTO = calculadoraController.getAllTiposCalculadora();
        assertNotNull(calculadoraDTO);
    }

}