package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TipoTaxonomiaDTOIT {

    TipoTaxonomiaDTO tipoTaxonomia;

    @Before
    public void setUp() throws Exception {
        tipoTaxonomia = new TipoTaxonomiaDTO();
    }

    @Test
    public void getId() throws Exception {
        tipoTaxonomia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoTaxonomia.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoTaxonomia.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoTaxonomia.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoTaxonomia.setExcluido(true);
        assertEquals(true, tipoTaxonomia.isExcluido());
    }

}