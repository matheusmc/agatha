package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
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
public class EventoCausaDTOIT {

    EventoCausaDTO eventoCausa;

    @Before
    public void setUp() throws Exception {
        eventoCausa = new EventoCausaDTO();
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
        EventoRiscoDTO eventoRisco = new EventoRiscoDTO();

        eventoCausa.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, eventoCausa.getEventoRisco());
    }

    @Test
    public void getCausa() throws Exception {
        CausaDTO causa = new CausaDTO();

        eventoCausa.setCausa(causa);
        assertEquals(causa, eventoCausa.getCausa());
    }

    @Test
    public void getCpf() throws Exception {
        eventoCausa.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, eventoCausa.getCpf());
    }
}