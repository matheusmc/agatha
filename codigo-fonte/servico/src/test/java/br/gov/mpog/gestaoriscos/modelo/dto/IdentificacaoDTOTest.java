package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class IdentificacaoDTOTest {

    private IdentificacaoDTO identificacao;

    @Before
    public void setUp() throws Exception {
        identificacao = new IdentificacaoDTO();
    }

    @Test
    public void getId() throws Exception {
        identificacao.setId(1L);
        assertEquals(Long.valueOf(1), identificacao.getId());
    }

    @Test
    public void getProcesso() throws Exception {
        ProcessoDTO processo = new ProcessoDTO();

        identificacao.setProcesso(processo);
        assertEquals(processo, identificacao.getProcesso());
    }

    @Test
    public void isExcluido() throws Exception {
        identificacao.setExcluido(true);
        assertEquals(true, identificacao.isExcluido());
    }

    @Test
    public void getEventos() throws Exception {
        EventoRiscoDTO eventoRisco = new EventoRiscoDTO();

        List<EventoRiscoDTO> eventoRiscoList = new ArrayList<>();
        eventoRiscoList.add(eventoRisco);

        identificacao.setEventos(eventoRiscoList);
        assertEquals(eventoRiscoList, identificacao.getEventos());
    }

}