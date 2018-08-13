package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.Processo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class CalculadoraDTOTest {

    CalculadoraDTO calculadora;

    @Before
    public void setUp() throws Exception {
        calculadora = new CalculadoraDTO();
    }

    @Test
    public void getId() throws Exception {
        calculadora.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), calculadora.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        calculadora.setExcluido(true);
        assertEquals(true, calculadora.isExcluido());
    }

    @Test
    public void getTipo() throws Exception {
        TipoCalculadoraDTO tipoCalculadora = new TipoCalculadoraDTO();

        calculadora.setTipo(tipoCalculadora);
        assertEquals(tipoCalculadora, calculadora.getTipo());
    }

    @Test
    public void getImpactos() throws Exception {
        ImpactoCalculadoraDTO impactoCalculadora = new ImpactoCalculadoraDTO();

        List<ImpactoCalculadoraDTO> impactoCalculadoraList = new ArrayList<>();
        impactoCalculadoraList.add(impactoCalculadora);

        calculadora.setImpactos(impactoCalculadoraList);
        assertEquals(impactoCalculadoraList, calculadora.getImpactos());
    }

    @Test
    public void getProbabilidades() throws Exception {
        ProbabilidadeCalculadoraDTO probabilidadeCalculadora = new ProbabilidadeCalculadoraDTO();

        List<ProbabilidadeCalculadoraDTO> probabilidadeCalculadoraList = new ArrayList<>();
        probabilidadeCalculadoraList.add(probabilidadeCalculadora);

        calculadora.setProbabilidades(probabilidadeCalculadoraList);
        assertEquals(probabilidadeCalculadoraList, calculadora.getProbabilidades());
    }

    @Test
    public void getProcesso() throws Exception {
        Processo processo = new Processo();

        calculadora.setProcesso(processo);
        assertEquals(processo, calculadora.getProcesso());
    }

}