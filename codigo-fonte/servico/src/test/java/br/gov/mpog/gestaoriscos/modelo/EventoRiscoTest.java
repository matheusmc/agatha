package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class EventoRiscoTest {
    EventoRisco eventoRisco;

    @Before
    public void setUp() throws Exception {
        eventoRisco = new EventoRisco();
    }

    @Test
    public void getId() throws Exception {
        eventoRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), eventoRisco.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        eventoRisco.setExcluido(true);
        assertEquals(true, eventoRisco.isExcluido());
    }

    @Test
    public void getIdentificacao() throws Exception {
        Identificacao identificacao = new Identificacao();

        eventoRisco.setIdentificacao(identificacao);
        assertEquals(identificacao, eventoRisco.getIdentificacao());
    }

    @Test
    public void getEvento() throws Exception {
        Evento evento = new Evento();

        eventoRisco.setEvento(evento);
        assertEquals(evento, eventoRisco.getEvento());
    }

    @Test
    public void getCategoria() throws Exception {
        Categoria categoria = new Categoria();

        eventoRisco.setCategoria(categoria);
        assertEquals(categoria, eventoRisco.getCategoria());
    }

    @Test
    public void getCausas() throws Exception {
        EventoCausa causa = new EventoCausa();

        List<EventoCausa> causaList = new ArrayList<>();
        causaList.add(causa);

        eventoRisco.setCausas(causaList);
        assertEquals(causaList, eventoRisco.getCausas());
    }

    @Test
    public void getConsequencias() throws Exception {
        EventoConsequencia eventoConsequencia = new EventoConsequencia();

        List<EventoConsequencia> eventoConsequenciaList = new ArrayList<>();
        eventoConsequenciaList.add(eventoConsequencia);

        eventoRisco.setConsequencias(eventoConsequenciaList);
        assertEquals(eventoConsequenciaList, eventoRisco.getConsequencias());
    }

    @Test
    public void getCalculoRiscoInerente() throws Exception {
        CalculoRisco calculoRisco = new CalculoRisco();

        eventoRisco.setCalculoRiscoInerente(calculoRisco);
        assertEquals(calculoRisco, eventoRisco.getCalculoRiscoInerente());
    }

    @Test
    public void getCalculoRiscoResidual() throws Exception {
        CalculoRisco calculoRisco = new CalculoRisco();

        eventoRisco.setCalculoRiscoResidual(calculoRisco);
        assertEquals(calculoRisco, eventoRisco.getCalculoRiscoResidual());
    }

    @Test
    public void getControleEventos() throws Exception {
        ControleEvento controleEvento = new ControleEvento();

        List<ControleEvento> controleEventoList = new ArrayList<>();
        controleEventoList.add(controleEvento);

        eventoRisco.setControleEventos(controleEventoList);
        assertEquals(controleEventoList, eventoRisco.getControleEventos());
    }

    @Test
    public void getRespostas() throws Exception {
        PlanoControle planoControle = new PlanoControle();

        List<PlanoControle> planoControleList = new ArrayList<>();
        planoControleList.add(planoControle);

        eventoRisco.setControles(planoControleList);
        assertEquals(planoControleList, eventoRisco.getControles());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        EventoRisco eventoRisco1 = new EventoRisco();
        eventoRisco1.setId(Long.valueOf(1));
        eventoRisco1.setExcluido(true);

        EventoRisco eventoRisco2 = new EventoRisco();
        eventoRisco2.setId(Long.valueOf(2));
        eventoRisco2.setExcluido(true);

        assertNotEquals(eventoRisco1.hashCode(), eventoRisco2.hashCode());
    }

}