package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class OperacaoTest {

    Operacao operacao;

    @Before
    public void setUp() throws Exception {
        operacao = new Operacao();
    }

    @Test
    public void getId() throws Exception {
        operacao.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), operacao.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        operacao.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, operacao.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        operacao.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, operacao.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        operacao.setStatus(true);
        assertEquals(true, operacao.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        operacao.setExcluido(true);
        assertEquals(true, operacao.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        operacao.setOrgao(orgao);
        assertEquals(orgao, operacao.getOrgao());
    }

}