package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ObjetivoControleDTOTest {

    ObjetivoControleDTO objetivoControle;

    @Before
    public void setUp() throws Exception {
        objetivoControle = new ObjetivoControleDTO();
    }

    @Test
    public void getId() throws Exception {
        objetivoControle.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), objetivoControle.getId());
    }

    @Test
    public void getNome() throws Exception {
        objetivoControle.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, objetivoControle.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        objetivoControle.setExcluido(true);
        assertEquals(true, objetivoControle.isExcluido());
    }

}