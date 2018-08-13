package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class CausaIT {

    Causa causa;

    @Before
    public void setUp() throws Exception {
        causa = new Causa();
    }

    @Test
    public void getId() throws Exception {
        causa.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), causa.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        causa.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, causa.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        causa.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, causa.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        causa.setStatus(true);
        assertEquals(true, causa.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        causa.setExcluido(true);
        assertEquals(true, causa.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        causa.setOrgao(orgao);
        assertEquals(orgao, causa.getOrgao());
    }
}