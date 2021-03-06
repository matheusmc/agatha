package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class CausaDTOTest {

    CausaDTO causa;

    @Before
    public void setUp() throws Exception {
        causa = new CausaDTO();
    }

    @Test
    public void getId() throws Exception {
        causa.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), causa.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        causa.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, causa.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        causa.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, causa.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        causa.setStatus(true);
        assertEquals(true, causa.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        causa.setExcluido(true);
        assertEquals(true, causa.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        causa.setOrgao(orgao);
        assertEquals(orgao, causa.getOrgao());
    }
}