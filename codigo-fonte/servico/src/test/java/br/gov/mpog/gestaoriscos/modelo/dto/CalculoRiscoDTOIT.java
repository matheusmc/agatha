package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class CalculoRiscoDTOIT {

    CalculoRiscoDTO calculoRisco;

    @Before
    public void setUp() throws Exception {
        calculoRisco = new CalculoRiscoDTO();
    }

    @Test
    public void getId() throws Exception {
        calculoRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), calculoRisco.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        calculoRisco.setExcluido(true);
        assertEquals(true, calculoRisco.isExcluido());
    }

    @Test
    public void getMediaPeso() throws Exception {
        calculoRisco.setMediaPeso(BigDecimal.ONE);
        assertEquals(BigDecimal.ONE, calculoRisco.getMediaPeso());
    }

    @Test
    public void getFrequencia() throws Exception {
        calculoRisco.setFrequencia(1);
        assertEquals(Integer.valueOf(1), calculoRisco.getFrequencia());
    }

    @Test
    public void getNivel() throws Exception {
        calculoRisco.setNivel(BigDecimal.ONE);
        assertEquals(BigDecimal.ONE, calculoRisco.getNivel());
    }

    @Test
    public void getPesos() throws Exception {
        PesoEventoRiscoDTO pesoEventoRisco = new PesoEventoRiscoDTO();

        List<PesoEventoRiscoDTO> pesoEventoRiscoList = new ArrayList<>();
        pesoEventoRiscoList.add(pesoEventoRisco);

        calculoRisco.setPesos(pesoEventoRiscoList);
        assertEquals(pesoEventoRiscoList, calculoRisco.getPesos());
    }

}