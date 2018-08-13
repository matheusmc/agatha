package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class PesoEventoRiscoDTOIT {

    PesoEventoRiscoDTO pesoEventoRisco;

    @Before
    public void setUp() throws Exception {
        pesoEventoRisco = new PesoEventoRiscoDTO();
    }

    @Test
    public void getId() throws Exception {
        pesoEventoRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), pesoEventoRisco.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        pesoEventoRisco.setExcluido(true);
        assertEquals(true, pesoEventoRisco.isExcluido());
    }

    @Test
    public void getPeso() throws Exception {
        pesoEventoRisco.setPeso(1);
        assertEquals(Integer.valueOf(1), pesoEventoRisco.getPeso());
    }

    @Test
    public void getCalculoRisco() throws Exception {
        CalculoRiscoDTO calculoRisco = new CalculoRiscoDTO();

        pesoEventoRisco.setCalculoRisco(calculoRisco);
        assertEquals(calculoRisco, pesoEventoRisco.getCalculoRisco());
    }

}