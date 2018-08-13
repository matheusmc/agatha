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
public class DesenhoIT {

    Desenho desenho;

    @Before
    public void setUp() throws Exception {
        desenho = new Desenho();
    }

    @Test
    public void getId() throws Exception {
        desenho.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), desenho.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        desenho.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, desenho.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        desenho.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, desenho.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        desenho.setStatus(true);
        assertEquals(true, desenho.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        desenho.setExcluido(true);
        assertEquals(true, desenho.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        desenho.setOrgao(orgao);
        assertEquals(orgao, desenho.getOrgao());
    }
}