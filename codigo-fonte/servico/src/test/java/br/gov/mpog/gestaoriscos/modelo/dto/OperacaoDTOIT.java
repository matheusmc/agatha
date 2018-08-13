package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class OperacaoDTOIT {

    OperacaoDTO operacao;

    @Before
    public void setUp() throws Exception {
        operacao = new OperacaoDTO();
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
        OrgaoDTO orgao = new OrgaoDTO();

        operacao.setOrgao(orgao);
        assertEquals(orgao, operacao.getOrgao());
    }

}