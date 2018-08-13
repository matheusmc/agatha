package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ControleEventoDTOTest {

    ControleEventoDTO controleEvento;

    @Before
    public void setUp() throws Exception {
        controleEvento = new ControleEventoDTO();
    }

    @Test
    public void getId() throws Exception {
        controleEvento.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), controleEvento.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        controleEvento.setExcluido(true);
        assertEquals(true, controleEvento.isExcluido());
    }

    @Test
    public void getControle() throws Exception {
        ControleDTO controle = new ControleDTO();

        controleEvento.setControle(controle);
        assertEquals(controle, controleEvento.getControle());
    }

    @Test
    public void getDesenho() throws Exception {
        DesenhoDTO desenho = new DesenhoDTO();

        controleEvento.setDesenho(desenho);
        assertEquals(desenho, controleEvento.getDesenho());
    }

    @Test
    public void getOperacao() throws Exception {
        OperacaoDTO operacao = new OperacaoDTO();

        controleEvento.setOperacao(operacao);
        assertEquals(operacao, controleEvento.getOperacao());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRiscoDTO eventoRisco = new EventoRiscoDTO();

        controleEvento.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, controleEvento.getEventoRisco());
    }

    @Test
    public void getCpf() throws Exception {
        controleEvento.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, controleEvento.getCpf());
    }

}