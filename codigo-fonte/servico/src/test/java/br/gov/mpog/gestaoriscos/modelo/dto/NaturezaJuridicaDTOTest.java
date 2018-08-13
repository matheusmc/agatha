package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class NaturezaJuridicaDTOTest {

    NaturezaJuridicaDTO naturezaJuridica;

    @Before
    public void setUp() throws Exception {
        naturezaJuridica = new NaturezaJuridicaDTO();
    }

    @Test
    public void getId() throws Exception {
        naturezaJuridica.setId(Short.valueOf("1"));
        assertEquals(Short.valueOf("1"), naturezaJuridica.getId());
    }

    @Test
    public void getNome() throws Exception {
        naturezaJuridica.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, naturezaJuridica.getNome());
    }

}