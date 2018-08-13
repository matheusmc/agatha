package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class AnaliseTest {

    private Analise analise;

    @Before
    public void setUp() throws Exception {
        analise = new Analise();
    }

    @Test
    public void getId() throws Exception {
        analise.setId(1L);
        assertEquals(Long.valueOf(1), analise.getId());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        analise.setOrgao(orgao);
        assertEquals(orgao, analise.getOrgao());
    }

    @Test
    public void getSecretaria() throws Exception {
        Orgao orgao = new Orgao();

        analise.setSecretaria(orgao);
        assertEquals(orgao, analise.getSecretaria());
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
        MatrizSwot matrizSwot = new MatrizSwot();

        List<MatrizSwot> matrizSwotList = new ArrayList<>();
        matrizSwotList.add(matrizSwot);

        analise.setMatrizes(matrizSwotList);
        assertEquals(matrizSwotList, analise.getMatrizes());
    }

    @Test
    public void getProcesso() throws Exception {
        Processo processo = new Processo();

        analise.setProcesso(processo);
        assertEquals(processo, analise.getProcesso());
    }

    @Test
    public void isExcluido() throws Exception {
        analise.setExcluido(true);
        assertEquals(true, analise.isExcluido());
    }

      @Test
    public void hashCodeNotEquals() throws Exception {
        Analise analise1 = new Analise();
        analise1.setProcesso(null);
        analise1.setOrgao(null);
        analise1.setId(1L);

        Analise analise2 = new Analise();
        analise2.setProcesso(new Processo());
        analise1.setOrgao(new Orgao(1L));
        analise2.setId(2L);

        assertNotEquals(analise1.hashCode(), analise2.hashCode());
    }

}