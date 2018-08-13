package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class PlanoControleIT {

    PlanoControle planoControle;

    @Before
    public void setUp() throws Exception {
        planoControle = new PlanoControle();
    }

    @Test
    public void getId() throws Exception {
        planoControle.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), planoControle.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        planoControle.setExcluido(true);
        assertEquals(true, planoControle.isExcluido());
    }

    @Test
    public void getControle() throws Exception {
        Controle controle = new Controle();

        planoControle.setControle(controle);
        assertEquals(controle, planoControle.getControle());
    }

    @Test
    public void getTipoControle() throws Exception {
        TipoControle tipoControle = new TipoControle();

        planoControle.setTipoControle(tipoControle);
        assertEquals(tipoControle, planoControle.getTipoControle());
    }

    @Test
    public void getObjetivo() throws Exception {
        ObjetivoControle objetivoControle = new ObjetivoControle();

        planoControle.setObjetivo(objetivoControle);
        assertEquals(objetivoControle, planoControle.getObjetivo());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRisco eventoRisco = new EventoRisco();

        planoControle.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, planoControle.getEventoRisco());
    }

}