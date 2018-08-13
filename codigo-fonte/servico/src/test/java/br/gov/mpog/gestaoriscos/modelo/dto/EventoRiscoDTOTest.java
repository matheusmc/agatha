package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class EventoRiscoDTOTest     {

    EventoRiscoDTO eventoRisco;

    @Before
    public void setUp() throws Exception {
        eventoRisco = new EventoRiscoDTO();
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
        IdentificacaoDTO identificacao = new IdentificacaoDTO();

        eventoRisco.setIdentificacao(identificacao);
        assertEquals(identificacao, eventoRisco.getIdentificacao());
    }

    @Test
    public void getEvento() throws Exception {
        EventoDTO evento = new EventoDTO();

        eventoRisco.setEvento(evento);
        assertEquals(evento, eventoRisco.getEvento());
    }

    @Test
    public void getCategoria() throws Exception {
        CategoriaDTO categoria = new CategoriaDTO();

        eventoRisco.setCategoria(categoria);
        assertEquals(categoria, eventoRisco.getCategoria());
    }

    @Test
    public void getCausas() throws Exception {
        EventoCausaDTO causa = new EventoCausaDTO();

        List<EventoCausaDTO> causaList = new ArrayList<>();
        causaList.add(causa);

        eventoRisco.setCausas(causaList);
        assertEquals(causaList, eventoRisco.getCausas());
    }

    @Test
    public void getConsequencias() throws Exception {
        EventoConsequenciaDTO eventoConsequencia = new EventoConsequenciaDTO();

        List<EventoConsequenciaDTO> eventoConsequenciaList = new ArrayList<>();
        eventoConsequenciaList.add(eventoConsequencia);

        eventoRisco.setConsequencias(eventoConsequenciaList);
        assertEquals(eventoConsequenciaList, eventoRisco.getConsequencias());
    }

    @Test
    public void getCalculoRiscoInerente() throws Exception {
        CalculoRiscoDTO calculoRisco = new CalculoRiscoDTO();

        eventoRisco.setCalculoRiscoInerente(calculoRisco);
        assertEquals(calculoRisco, eventoRisco.getCalculoRiscoInerente());
    }

    @Test
    public void getCalculoRiscoResidual() throws Exception {
        CalculoRiscoDTO calculoRisco = new CalculoRiscoDTO();

        eventoRisco.setCalculoRiscoResidual(calculoRisco);
        assertEquals(calculoRisco, eventoRisco.getCalculoRiscoResidual());
    }

    @Test
    public void getControleEventos() throws Exception {
        ControleEventoDTO controleEvento = new ControleEventoDTO();

        List<ControleEventoDTO> controleEventoList = new ArrayList<>();
        controleEventoList.add(controleEvento);

        eventoRisco.setControleEventos(controleEventoList);
        assertEquals(controleEventoList, eventoRisco.getControleEventos());
    }

    @Test
    public void getRespostas() throws Exception {
        PlanoControleDTO respostaRisco = new PlanoControleDTO();

        List<PlanoControleDTO> respostaRiscoList = new ArrayList<>();
        respostaRiscoList.add(respostaRisco);

        eventoRisco.setControles(respostaRiscoList);
        assertEquals(respostaRiscoList, eventoRisco.getControles());
    }

    @Test
    public void getCpf() throws Exception {
        eventoRisco.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, eventoRisco.getCpf());
    }

}