package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class AvaliacaoDTOTest {

    private AvaliacaoDTO avaliacao;

    @Before
    public void setUp() throws Exception {
        avaliacao = new AvaliacaoDTO();
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
        ProcessoDTO processo = new ProcessoDTO();

        avaliacao.setProcesso(processo);
        assertEquals(processo, avaliacao.getProcesso());
    }

}