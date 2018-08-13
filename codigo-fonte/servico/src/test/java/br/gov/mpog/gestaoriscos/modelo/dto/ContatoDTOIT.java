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
 * Created by luizfernando on 25/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class ContatoDTOIT {

    ContatoDTO contato;

    @Before
    public void setUp() throws Exception {
        contato = new ContatoDTO();
    }

    @Test
    public void getEmail() throws Exception {
        List<String> stringList = new ArrayList<>();

        stringList.add(AnnotationStringUtil.TEST_STRING);

        contato.setEmail(stringList);
        assertEquals(stringList, contato.getEmail());
    }

    @Test
    public void getTelefone() throws Exception {
        List<String> stringList = new ArrayList<>();

        stringList.add(AnnotationStringUtil.TEST_STRING);

        contato.setTelefone(stringList);
        assertEquals(stringList, contato.getTelefone());
    }

    @Test
    public void getSite() throws Exception {
        List<WebsiteDTO> websiteList = new ArrayList<>();

        websiteList.add(new WebsiteDTO());

        contato.setSite(websiteList);
        assertEquals(websiteList, contato.getSite());
    }

}