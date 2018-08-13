package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class AvaliacaoTest {

    private Avaliacao avaliacao;

    @Before
    public void setUp() throws Exception {
        avaliacao = new Avaliacao();
    }

    @Test
    public void constructoTest1() throws Exception {
        Processo processo = new Processo();

        Avaliacao avaliacao = new Avaliacao(processo);

        assertEquals(processo, avaliacao.getProcesso());
        assertEquals(false, avaliacao.getIgnorarRiscoInerente());
    }

    @Test
    public void getId() throws Exception {
        avaliacao.setId(1L);
        assertEquals(Long.valueOf(1), avaliacao.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        avaliacao.setExcluido(true);
        assertEquals(true, avaliacao.isExcluido());
    }

    @Test
    public void getIgnorarRiscoInerente() throws Exception {
        avaliacao.setIgnorarRiscoInerente(true);
        assertEquals(true, avaliacao.getIgnorarRiscoInerente());
    }

    @Test
    public void getProcesso() throws Exception {
        Processo processo = new Processo();

        avaliacao.setProcesso(processo);
        assertEquals(processo, avaliacao.getProcesso());
    }
}