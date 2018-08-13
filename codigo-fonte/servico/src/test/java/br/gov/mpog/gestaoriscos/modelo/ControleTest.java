package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ControleTest {

    Controle controle;

    @Before
    public void setUp() throws Exception {
        controle = new Controle();
    }

    @Test
    public void getId() throws Exception {
        controle.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), controle.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        controle.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, controle.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        controle.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, controle.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        controle.setStatus(true);
        assertEquals(true, controle.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        controle.setExcluido(true);
        assertEquals(true, controle.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        controle.setOrgao(orgao);
        assertEquals(orgao, controle.getOrgao());
    }
}