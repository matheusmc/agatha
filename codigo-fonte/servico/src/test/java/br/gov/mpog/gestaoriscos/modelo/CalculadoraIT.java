package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
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
public class CalculadoraIT {

    Calculadora calculadora;

    @Before
    public void setUp() throws Exception {
        calculadora = new Calculadora();
    }

    @Test
    public void constructoTest1() throws Exception {
        Processo processo = new Processo();
        Calculadora calculadoraBase = new Calculadora();

        ImpactoCalculadora impactoCalculadora = new ImpactoCalculadora();
        impactoCalculadora.setNome(AnnotationStringUtil.TEST_STRING);
        ProbabilidadeCalculadora probabilidadeCalculadora = new ProbabilidadeCalculadora();
        probabilidadeCalculadora.setNome(AnnotationStringUtil.TEST_STRING);

        List<ImpactoCalculadora> impactoCalculadoraList = new ArrayList<>();
        List<ProbabilidadeCalculadora> probabilidadeCalculadoraList = new ArrayList<>();

        impactoCalculadoraList.add(impactoCalculadora);
        probabilidadeCalculadoraList.add(probabilidadeCalculadora);

        calculadoraBase.setImpactos(impactoCalculadoraList);
        calculadoraBase.setProbabilidades(probabilidadeCalculadoraList);

        Calculadora calculadoraTeste = new Calculadora(calculadoraBase, processo);

        assertEquals(false, calculadoraTeste.isExcluido());
        assertEquals(calculadoraBase.getTipo(), calculadoraTeste.getTipo());
        assertEquals(processo, calculadoraTeste.getProcesso());
        assertEquals(calculadoraBase.getImpactos().get(0).getNome(), calculadoraTeste.getImpactos().get(0).getNome());
        assertEquals(calculadoraBase.getProbabilidades().get(0).getNome(), calculadoraTeste.getProbabilidades().get(0).getNome());
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
        TipoCalculadora tipoCalculadora = new TipoCalculadora();

        calculadora.setTipo(tipoCalculadora);
        assertEquals(tipoCalculadora, calculadora.getTipo());
    }

    @Test
    public void getImpactos() throws Exception {
        ImpactoCalculadora impactoCalculadora = new ImpactoCalculadora();

        List<ImpactoCalculadora> impactoCalculadoraList = new ArrayList<>();
        impactoCalculadoraList.add(impactoCalculadora);

        calculadora.setImpactos(impactoCalculadoraList);
        assertEquals(impactoCalculadoraList, calculadora.getImpactos());
    }

    @Test
    public void getProbabilidades() throws Exception {
        ProbabilidadeCalculadora probabilidadeCalculadora = new ProbabilidadeCalculadora();

        List<ProbabilidadeCalculadora> probabilidadeCalculadoraList = new ArrayList<>();
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