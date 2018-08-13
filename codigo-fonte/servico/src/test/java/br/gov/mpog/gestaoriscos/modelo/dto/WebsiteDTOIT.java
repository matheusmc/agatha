package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 25/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class WebsiteDTOIT {

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