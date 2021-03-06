package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class CategoriaUnidadeDTOTest {

    CategoriaUnidadeDTO categoriaUnidade;

    @Before
    public void setUp() throws Exception {
        categoriaUnidade = new CategoriaUnidadeDTO();
    }

    @Test
    public void getId() throws Exception {
        categoriaUnidade.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), categoriaUnidade.getId());
    }

    @Test
    public void getSigla() throws Exception {
        categoriaUnidade.setSigla(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, categoriaUnidade.getSigla());
    }

    @Test
    public void getNome() throws Exception {
        categoriaUnidade.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, categoriaUnidade.getNome());
    }

}