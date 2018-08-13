package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ControleEventoTest {

    ControleEvento controleEvento;

    @Before
    public void setUp() throws Exception {
        controleEvento = new ControleEvento();
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
        Controle controle = new Controle();

        controleEvento.setControle(controle);
        assertEquals(controle, controleEvento.getControle());
    }

    @Test
    public void getDesenho() throws Exception {
        Desenho desenho = new Desenho();

        controleEvento.setDesenho(desenho);
        assertEquals(desenho, controleEvento.getDesenho());
    }

    @Test
    public void getOperacao() throws Exception {
        Operacao operacao = new Operacao();

        controleEvento.setOperacao(operacao);
        assertEquals(operacao, controleEvento.getOperacao());
    }

    @Test
    public void getEventoRisco() throws Exception {
        EventoRisco eventoRisco = new EventoRisco();

        controleEvento.setEventoRisco(eventoRisco);
        assertEquals(eventoRisco, controleEvento.getEventoRisco());
    }

}