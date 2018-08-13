package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class TaxonomiaDTOTest {

    TaxonomiaDTO taxonomia;

    @Before
    public void setUp() throws Exception {
        taxonomia = new TaxonomiaDTO();
    }

    @Test
    public void getId() throws Exception {
        taxonomia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), taxonomia.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        taxonomia.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomia.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        taxonomia.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomia.getSearch());
    }

    @Test
    public void getDtCadastro() throws Exception {
        Calendar date = Calendar.getInstance();
        taxonomia.setDtCadastro(date);
        assertEquals(date, taxonomia.getDtCadastro());
    }

    @Test
    public void isExcluido() throws Exception {
        taxonomia.setExcluido(true);
        assertEquals(true, taxonomia.isExcluido());
    }

    @Test
    public void getJustificativa() throws Exception {
        taxonomia.setJustificativa(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomia.getJustificativa());
    }

    @Test
    public void getTipo() throws Exception {
        TipoTaxonomiaDTO tipoTaxonomia = new TipoTaxonomiaDTO();

        taxonomia.setTipo(tipoTaxonomia);
        assertEquals(tipoTaxonomia, taxonomia.getTipo());
    }

    @Test
    public void getStatus() throws Exception {
        StatusTaxonomiaDTO status = new StatusTaxonomiaDTO();

        taxonomia.setStatus(status);
        assertEquals(status, taxonomia.getStatus());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        taxonomia.setOrgao(orgao);
        assertEquals(orgao, taxonomia.getOrgao());
    }

    @Test
    public void getEvento() throws Exception {
        EventoDTO evento = new EventoDTO();

        taxonomia.setEvento(evento);
        assertEquals(evento, taxonomia.getEvento());
    }

    @Test
    public void getCausa() throws Exception {
        CausaDTO causa = new CausaDTO();

        taxonomia.setCausa(causa);
        assertEquals(causa, taxonomia.getCausa());
    }

    @Test
    public void getConsequencia() throws Exception {
        ConsequenciaDTO consequencia = new ConsequenciaDTO();

        taxonomia.setConsequencia(consequencia);
        assertEquals(consequencia, taxonomia.getConsequencia());
    }

    @Test
    public void getControle() throws Exception {
        ControleDTO controle = new ControleDTO();

        taxonomia.setControle(controle);
        assertEquals(controle, taxonomia.getControle());
    }

    @Test
    public void getAgrupamento() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomia = new AgrupamentoTaxonomiaDTO();

        taxonomia.setAgrupamento(agrupamentoTaxonomia);
        assertEquals(agrupamentoTaxonomia, taxonomia.getAgrupamento());
    }

}