package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class AnaliseDTOIT {

    private AnaliseDTO analise;

    @Before
    public void setUp() throws Exception {
        analise = new AnaliseDTO();
    }

    @Test
    public void getId() throws Exception {
        analise.setId(1L);
        assertEquals(Long.valueOf(1), analise.getId());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        analise.setOrgao(orgao);
        assertEquals(orgao, analise.getOrgao());

        analise.setOrgao(orgao);
        assertEquals(null, analise.getOrgao().getOrgaoPai());
    }

    @Test
    public void getSecretaria() throws Exception {
        OrgaoDTO secretaria = new OrgaoDTO();

        analise.setSecretaria(secretaria);
        assertEquals(secretaria, analise.getSecretaria());

        analise.setSecretaria(secretaria);
        assertEquals(null, analise.getSecretaria().getOrgaoPai());
    }

    @Test
    public void getEtica() throws Exception {
        analise.setEtica(true);
        assertEquals(true, analise.getEtica());
    }

    @Test
    public void getEstrutura() throws Exception {
        analise.setEstrutura(true);
        assertEquals(true, analise.getEstrutura());
    }

    @Test
    public void getRecursosHumanos() throws Exception {
        analise.setRecursosHumanos(true);
        assertEquals(true, analise.getRecursosHumanos());
    }

    @Test
    public void getAtribuicoes() throws Exception {
        analise.setAtribuicoes(true);
        assertEquals(true, analise.getAtribuicoes());
    }

    @Test
    public void getNormasInternas() throws Exception {
        analise.setNormasInternas(true);
        assertEquals(true, analise.getNormasInternas());
    }

    @Test
    public void getMissao() throws Exception {
        analise.setMissao(true);
        assertEquals(true, analise.getMissao());
    }

    @Test
    public void getVisao() throws Exception {
        analise.setVisao(true);
        assertEquals(true, analise.getVisao());
    }

    @Test
    public void getObjetivos() throws Exception {
        analise.setObjetivos(true);
        assertEquals(true, analise.getObjetivos());
    }

    @Test
    public void getMatrizes() throws Exception {
        MatrizSwotDTO matrizSwot = new MatrizSwotDTO();

        List<MatrizSwotDTO> matrizSwotList = new ArrayList<>();
        matrizSwotList.add(matrizSwot);

        analise.setMatrizes(matrizSwotList);
        assertEquals(matrizSwotList, analise.getMatrizes());
    }

    @Test
    public void isExcluido() throws Exception {
        analise.setExcluido(true);
        assertEquals(true, analise.isExcluido());
    }
}