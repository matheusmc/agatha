package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class StatusProcessoTest {

    StatusProcesso statusProcesso;

    @Before
    public void setUp() throws Exception {
        statusProcesso = new StatusProcesso();
    }

    @Test
    public void getId() throws Exception {
        statusProcesso.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), statusProcesso.getId());
    }

    @Test
    public void getNome() throws Exception {
        statusProcesso.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, statusProcesso.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        statusProcesso.setExcluido(true);
        assertEquals(true, statusProcesso.isExcluido());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        StatusProcesso statusProcesso1 = new StatusProcesso();
        statusProcesso1.setId(Long.valueOf(1));
        statusProcesso1.setNome(AnnotationStringUtil.TEST_STRING);
        statusProcesso1.setExcluido(true);

        StatusProcesso statusProcesso2 = new StatusProcesso();
        statusProcesso2.setId(Long.valueOf(2));
        statusProcesso2.setNome(AnnotationStringUtil.TEST_STRING);
        statusProcesso2.setExcluido(true);

        assertNotEquals(statusProcesso1.hashCode(), statusProcesso2.hashCode());
    }

}