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
public class EntidadeBaseEventoTaxonomiaIT {

    EntidadeBaseEventoTaxonomia entidadeBaseEventoTaxonomia;

    @Before
    public void setUp() throws Exception {
        entidadeBaseEventoTaxonomia = new EntidadeBaseEventoTaxonomia();
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRisco risco = new EventoRisco();
        entidadeBaseEventoTaxonomia.setEventoRisco(risco);
        assertEquals(risco, entidadeBaseEventoTaxonomia.getEventoRisco());
    }

    @Test
    public void isExcluido() throws Exception {
        entidadeBaseEventoTaxonomia.setExcluido(true);
        assertEquals(true, entidadeBaseEventoTaxonomia.isExcluido());
    }

}