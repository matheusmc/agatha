package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class PermissaoProcessoDTOTest {

    PermissaoProcessoDTO permissaoProcesso;

    @Before
    public void setUp() throws Exception {
        permissaoProcesso = new PermissaoProcessoDTO();
    }

    @Test
    public void getCriar() throws Exception {
        permissaoProcesso.setCriar(true);
        assertEquals(true, permissaoProcesso.getCriar());
    }

    @Test
    public void getValidar() throws Exception {
        permissaoProcesso.setValidar(true);
        assertEquals(true, permissaoProcesso.getValidar());
    }

    @Test
    public void getExcluir() throws Exception {
        permissaoProcesso.setExcluir(true);
        assertEquals(true, permissaoProcesso.getExcluir());
    }

    @Test
    public void getEnviarParaValidacao() throws Exception {
        permissaoProcesso.setEnviarParaValidacao(true);
        assertEquals(true, permissaoProcesso.getEnviarParaValidacao());
    }

    @Test
    public void getCriarEventoRisco() throws Exception {
        permissaoProcesso.setCriarEventoRisco(true);
        assertEquals(true, permissaoProcesso.getCriarEventoRisco());
    }

    @Test
    public void getConsultarUnidade() throws Exception {
        permissaoProcesso.setConsultarUnidade(true);
        assertEquals(true, permissaoProcesso.getConsultarUnidade());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        permissaoProcesso.setOrgao(orgao);
        assertEquals(orgao, permissaoProcesso.getOrgao());
    }

}