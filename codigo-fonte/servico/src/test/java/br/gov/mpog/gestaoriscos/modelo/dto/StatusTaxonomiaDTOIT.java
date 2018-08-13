package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class StatusTaxonomiaDTOIT {

    StatusTaxonomiaDTO statusTaxinomia;

    @Before
    public void setUp() throws Exception {
        statusTaxinomia = new StatusTaxonomiaDTO();
    }

    @Test
    public void getId() throws Exception {
        statusTaxinomia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), statusTaxinomia.getId());
    }

    @Test
    public void getNome() throws Exception {
        statusTaxinomia.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, statusTaxinomia.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        statusTaxinomia.setExcluido(true);
        assertEquals(true, statusTaxinomia.isExcluido());
    }

}