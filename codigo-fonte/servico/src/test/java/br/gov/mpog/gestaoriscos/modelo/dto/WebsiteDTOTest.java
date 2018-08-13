package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.TipoMatriz;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class WebsiteDTOTest {

    WebsiteDTO website;

    @Before
    public void setUp() throws Exception {
        website = new WebsiteDTO();
    }

    @Test
    public void getOutroTipoSite() throws Exception {
        website.setOutroTipoSite(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, website.getOutroTipoSite());
    }

    @Test
    public void getSite() throws Exception {
        website.setSite(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, website.getSite());
    }

    @Test
    public void getTipo() throws Exception {
        website.setTipo(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, website.getTipo());
    }
}