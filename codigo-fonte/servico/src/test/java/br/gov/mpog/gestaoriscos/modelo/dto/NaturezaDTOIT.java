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
public class NaturezaDTOIT {

    NaturezaDTO natureza;

    @Before
    public void setUp() throws Exception {
        natureza = new NaturezaDTO();
    }

    @Test
    public void getId() throws Exception {
        natureza.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), natureza.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        natureza.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, natureza.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        natureza.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, natureza.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        natureza.setStatus(true);
        assertEquals(true, natureza.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        natureza.setExcluido(true);
        assertEquals(true, natureza.isExcluido());
    }
}