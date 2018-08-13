package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class PlanoControleDTOTest {

    PlanoControleDTO respostaRisco;

    @Before
    public void setUp() throws Exception {
        respostaRisco = new PlanoControleDTO();
    }

    @Test
    public void getId() throws Exception {
        respostaRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), respostaRisco.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        respostaRisco.setExcluido(true);
        assertEquals(true, respostaRisco.isExcluido());
    }


    @Test
    public void getControle() throws Exception {
        ControleDTO controle = new ControleDTO();

        respostaRisco.setControle(controle);
        assertEquals(controle, respostaRisco.getControle());
    }

    @Test
    public void getTipoControle() throws Exception {
        TipoControleDTO tipoControle = new TipoControleDTO();

        respostaRisco.setTipoControle(tipoControle);
        assertEquals(tipoControle, respostaRisco.getTipoControle());
    }

    @Test
    public void getObjetivo() throws Exception {
        ObjetivoControleDTO objetivoControle = new ObjetivoControleDTO();

        respostaRisco.setObjetivo(objetivoControle);
        assertEquals(objetivoControle, respostaRisco.getObjetivo());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRiscoDTO eventoRisco = new EventoRiscoDTO();

        respostaRisco.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, respostaRisco.getEventoRisco());
    }

    @Test
    public void getCpf() throws Exception {
        respostaRisco.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, respostaRisco.getCpf());
    }
}