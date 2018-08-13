package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class GlossarioTest {
    Glossario glossario;

    @Before
    public void setUp() throws Exception {
        glossario = new Glossario();
    }

    @Test
    public void getId() throws Exception {
        glossario.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), glossario.getId());
    }

    @Test
    public void getTermo() throws Exception {
        glossario.setTermo(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, glossario.getTermo());
    }

    @Test
    public void getDescricao() throws Exception {
        glossario.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, glossario.getDescricao());
    }

    @Test
    public void getTermoSearch() throws Exception {
        glossario.setTermoSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, glossario.getTermoSearch());
    }

    @Test
    public void getDescricaoSearch() throws Exception {
        glossario.setDescricaoSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, glossario.getDescricaoSearch());
    }

    @Test
    public void isStatus() throws Exception {
        glossario.setStatus(true);
        assertEquals(true, glossario.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        glossario.setExcluido(true);
        assertEquals(true, glossario.isExcluido());
    }

}