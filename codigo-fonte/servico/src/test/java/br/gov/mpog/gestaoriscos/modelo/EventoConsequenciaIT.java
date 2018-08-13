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
public class EventoConsequenciaIT {

    EventoConsequencia eventoConsequencia;

    @Before
    public void setUp() throws Exception {
        eventoConsequencia = new EventoConsequencia();
    }

    @Test
    public void getId() throws Exception {
        eventoConsequencia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), eventoConsequencia.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        eventoConsequencia.setExcluido(true);
        assertEquals(true, eventoConsequencia.isExcluido());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRisco eventoRisco = new EventoRisco();

        eventoConsequencia.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, eventoConsequencia.getEventoRisco());
    }

    @Test
    public void getConsequencia() throws Exception {
        Consequencia consequencia = new Consequencia();

        eventoConsequencia.setConsequencia(consequencia);
        assertEquals(consequencia, eventoConsequencia.getConsequencia());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        EventoConsequencia eventoConsequencia1 = new EventoConsequencia();
        eventoConsequencia1.setId(Long.valueOf(1));
        eventoConsequencia1.setExcluido(true);

        EventoConsequencia eventoConsequencia2 = new EventoConsequencia();
        eventoConsequencia2.setId(Long.valueOf(2));
        eventoConsequencia2.setExcluido(true);

        assertNotEquals(eventoConsequencia1.hashCode(), eventoConsequencia2.hashCode());
    }

}