package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
public class RespostaRiscoTest {

    RespostaRisco respostaRisco;

    @Before
    public void setUp() throws Exception {
        respostaRisco = new RespostaRisco();
    }

    @Test
    public void getId() throws Exception {
        respostaRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), respostaRisco.getId());
    }

    @Test
    public void getNome() throws Exception {
        respostaRisco.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, respostaRisco.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        respostaRisco.setExcluido(true);
        assertEquals(true, respostaRisco.isExcluido());
    }

    @Test
    public void getEventos() throws Exception {

        EventoRisco eventoRisco = new EventoRisco();

        List<EventoRisco> eventoRiscos = new ArrayList<>();
        eventoRiscos.add(eventoRisco);

        respostaRisco.setEventos(eventoRiscos);
        assertEquals(eventoRiscos, respostaRisco.getEventos());
    }

}