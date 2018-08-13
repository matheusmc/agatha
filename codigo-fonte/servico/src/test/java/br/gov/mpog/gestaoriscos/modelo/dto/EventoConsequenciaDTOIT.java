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
public class EventoConsequenciaDTOIT {

    EventoConsequenciaDTO eventoConsequencia;

    @Before
    public void setUp() throws Exception {
        eventoConsequencia = new EventoConsequenciaDTO();
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
        EventoRiscoDTO eventoRisco = new EventoRiscoDTO();

        eventoConsequencia.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, eventoConsequencia.getEventoRisco());
    }

    @Test
    public void getConsequencia() throws Exception {
        ConsequenciaDTO consequencia = new ConsequenciaDTO();

        eventoConsequencia.setConsequencia(consequencia);
        assertEquals(consequencia, eventoConsequencia.getConsequencia());
    }

    @Test
    public void getCpf() throws Exception {
        eventoConsequencia.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, eventoConsequencia.getCpf());
    }
}