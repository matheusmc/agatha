package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class EventoCausaIT {

    EventoCausa eventoCausa;

    @Before
    public void setUp() throws Exception {
        eventoCausa = new EventoCausa();
    }

    @Test
    public void getId() throws Exception {
        eventoCausa.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), eventoCausa.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        eventoCausa.setExcluido(true);
        assertEquals(true, eventoCausa.isExcluido());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRisco eventoRisco = new EventoRisco();

        eventoCausa.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, eventoCausa.getEventoRisco());
    }

    @Test
    public void getCausa() throws Exception {
        Causa causa = new Causa();

        eventoCausa.setCausa(causa);
        assertEquals(causa, eventoCausa.getCausa());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        EventoCausa eventoCausa1 = new EventoCausa();
        eventoCausa1.setId(Long.valueOf(1));
        eventoCausa1.setExcluido(true);

        EventoCausa eventoCausa2 = new EventoCausa();
        eventoCausa2.setId(Long.valueOf(2));
        eventoCausa2.setExcluido(true);

        assertNotEquals(eventoCausa1.hashCode(), eventoCausa2.hashCode());
    }

}