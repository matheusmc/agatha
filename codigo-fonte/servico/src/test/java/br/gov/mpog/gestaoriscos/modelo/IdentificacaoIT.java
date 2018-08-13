package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class IdentificacaoIT {

    private Identificacao identificacao;

    @Test
    public void constructoTest1() throws Exception {
        Processo processo = new Processo();

        Identificacao identificacao = new Identificacao(processo);

        assertEquals(processo, identificacao.getProcesso());
    }

    @Before
    public void setUp() throws Exception {
        identificacao = new Identificacao();
    }

    @Test
    public void getId() throws Exception {
        identificacao.setId(1L);
        assertEquals(Long.valueOf(1), identificacao.getId());
    }

    @Test
    public void getProcesso() throws Exception {
        Processo processo = new Processo();

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
        EventoRisco eventoRisco = new EventoRisco();

        List<EventoRisco> eventoRiscoList = new ArrayList<>();
        eventoRiscoList.add(eventoRisco);

        identificacao.setEventos(eventoRiscoList);
        assertEquals(eventoRiscoList, identificacao.getEventos());
    }
}