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
public class CategoriaIT {

    Categoria categoria;

    @Before
    public void setUp() throws Exception {
        categoria = new Categoria();
    }

    @Test
    public void getId() throws Exception {
        categoria.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), categoria.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        categoria.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, categoria.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        categoria.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, categoria.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        categoria.setStatus(true);
        assertEquals(true, categoria.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        categoria.setExcluido(true);
        assertEquals(true, categoria.isExcluido());
    }
}