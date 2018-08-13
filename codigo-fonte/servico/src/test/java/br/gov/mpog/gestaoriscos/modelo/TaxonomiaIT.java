package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TaxonomiaIT {

    Taxonomia taxonomia;

    @Before
    public void setUp() throws Exception {
        taxonomia = new Taxonomia();
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
        TipoTaxonomia tipoTaxonomia = new TipoTaxonomia();

        taxonomia.setTipo(tipoTaxonomia);
        assertEquals(tipoTaxonomia, taxonomia.getTipo());
    }

    @Test
    public void getStatus() throws Exception {
        StatusTaxonomia status = new StatusTaxonomia();

        taxonomia.setStatus(status);
        assertEquals(status, taxonomia.getStatus());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        taxonomia.setOrgao(orgao);
        assertEquals(orgao, taxonomia.getOrgao());
    }

    @Test
    public void getEvento() throws Exception {
        Evento evento = new Evento();

        taxonomia.setEvento(evento);
        assertEquals(evento, taxonomia.getEvento());
    }

    @Test
    public void getCausa() throws Exception {
        Causa causa = new Causa();

        taxonomia.setCausa(causa);
        assertEquals(causa, taxonomia.getCausa());
    }

    @Test
    public void getConsequencia() throws Exception {
        Consequencia consequencia = new Consequencia();

        taxonomia.setConsequencia(consequencia);
        assertEquals(consequencia, taxonomia.getConsequencia());
    }

    @Test
    public void getControle() throws Exception {
        Controle controle = new Controle();

        taxonomia.setControle(controle);
        assertEquals(controle, taxonomia.getControle());
    }

    @Test
    public void getAgrupamento() throws Exception {
        AgrupamentoTaxonomia agrupamentoTaxonomia = new AgrupamentoTaxonomia();

        taxonomia.setAgrupamento(agrupamentoTaxonomia);
        assertEquals(agrupamentoTaxonomia, taxonomia.getAgrupamento());
    }

}