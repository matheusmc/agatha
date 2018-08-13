package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class AgrupamentoTaxonomiaTest {

    AgrupamentoTaxonomia agrupamentoTaxonomia;

    @Before
    public void setUp() throws Exception {
        agrupamentoTaxonomia = new AgrupamentoTaxonomia();
    }

    @Test
    public void getId() throws Exception {
        agrupamentoTaxonomia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), agrupamentoTaxonomia.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        agrupamentoTaxonomia.setExcluido(true);
        assertEquals(true, agrupamentoTaxonomia.isExcluido());
    }

    @Test
    public void getTaxonomia() throws Exception {
        Taxonomia taxonomia = new Taxonomia();

        agrupamentoTaxonomia.setTaxonomia(taxonomia);
        assertEquals(taxonomia, agrupamentoTaxonomia.getTaxonomia());
    }

    @Test
    public void getTaxonomias() throws Exception {
        Taxonomia taxonomia = new Taxonomia();

        List<Taxonomia> taxonomiaList = new ArrayList<>();
        taxonomiaList.add(taxonomia);

        agrupamentoTaxonomia.setTaxonomias(taxonomiaList);
        assertEquals(taxonomiaList, agrupamentoTaxonomia.getTaxonomias());
    }

}