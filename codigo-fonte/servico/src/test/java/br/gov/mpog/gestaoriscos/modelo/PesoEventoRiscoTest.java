package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class PesoEventoRiscoTest {

    PesoEventoRisco pesoEventoRisco;

    @Before
    public void setUp() throws Exception {
        pesoEventoRisco = new PesoEventoRisco();
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
        CalculoRisco calculoRisco = new CalculoRisco();

        pesoEventoRisco.setCalculoRisco(calculoRisco);
        assertEquals(calculoRisco, pesoEventoRisco.getCalculoRisco());
    }

}