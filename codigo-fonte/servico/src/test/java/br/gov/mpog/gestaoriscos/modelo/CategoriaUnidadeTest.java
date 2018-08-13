package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaUnidadeDTO;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class CategoriaUnidadeTest {

    CategoriaUnidade categoriaUnidade;

    @Before
    public void setUp() throws Exception {
        categoriaUnidade = new CategoriaUnidade();
    }

    @Test
    public void constructoTest1() throws Exception {
        CategoriaUnidadeDTO categoriaUnidadeDTO = new CategoriaUnidadeDTO(Long.valueOf(1));
        categoriaUnidadeDTO.setNome(AnnotationStringUtil.TEST_STRING);
        categoriaUnidadeDTO.setSigla(AnnotationStringUtil.TEST_STRING);

        CategoriaUnidade categoriaUnidade = new CategoriaUnidade(categoriaUnidadeDTO);

        assertEquals(categoriaUnidadeDTO.getId(), categoriaUnidade.getId());
        assertEquals(categoriaUnidadeDTO.getNome(), categoriaUnidade.getNome());
        assertEquals(categoriaUnidadeDTO.getSigla(), categoriaUnidade.getSigla());
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