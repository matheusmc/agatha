package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
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
public class AgrupamentoTaxonomiaDTOIT {

    AgrupamentoTaxonomiaDTO agrupamentoTaxonomia;

    @Before
    public void setUp() throws Exception {
        agrupamentoTaxonomia = new AgrupamentoTaxonomiaDTO();
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
        TaxonomiaDTO taxonomia = new TaxonomiaDTO();

        agrupamentoTaxonomia.setTaxonomia(taxonomia);
        assertEquals(taxonomia, agrupamentoTaxonomia.getTaxonomia());
    }

    @Test
    public void getTaxonomias() throws Exception {
        TaxonomiaDTO taxonomia = new TaxonomiaDTO();

        List<TaxonomiaDTO> taxonomiaList = new ArrayList<>();
        taxonomiaList.add(taxonomia);

        agrupamentoTaxonomia.setTaxonomias(taxonomiaList);
        assertEquals(taxonomiaList, agrupamentoTaxonomia.getTaxonomias());
    }

    @Test
    public void getCpf() throws Exception {
        agrupamentoTaxonomia.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, agrupamentoTaxonomia.getCpf());
    }

}