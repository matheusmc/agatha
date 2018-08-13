package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
public class TipoControleTest {

    TipoControle tipoControle;

    @Before
    public void setUp() throws Exception {
        tipoControle = new TipoControle();
    }

    @Test
    public void getId() throws Exception {
        tipoControle.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoControle.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoControle.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoControle.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoControle.setExcluido(true);
        assertEquals(true, tipoControle.isExcluido());
    }

}