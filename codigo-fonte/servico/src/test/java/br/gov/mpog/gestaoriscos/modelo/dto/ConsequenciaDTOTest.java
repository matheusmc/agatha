package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ConsequenciaDTOTest {

    ConsequenciaDTO consequencia;

    @Before
    public void setUp() throws Exception {
        consequencia = new ConsequenciaDTO();
    }

    @Test
    public void getId() throws Exception {
        consequencia.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), consequencia.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        consequencia.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, consequencia.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        consequencia.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, consequencia.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        consequencia.setStatus(true);
        assertEquals(true, consequencia.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        consequencia.setExcluido(true);
        assertEquals(true, consequencia.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        consequencia.setOrgao(orgao);
        assertEquals(orgao, consequencia.getOrgao());
    }

}