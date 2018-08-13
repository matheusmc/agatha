package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ImpactoCalculadoraTest {

    ImpactoCalculadora impactoCalculadora;

    @Before
    public void setUp() throws Exception {
        impactoCalculadora = new ImpactoCalculadora();
    }

    @Test
    public void constructoTest1() throws Exception {
        ImpactoCalculadora impactoCalculadoraTeste = new ImpactoCalculadora();
        impactoCalculadoraTeste.setNome(AnnotationStringUtil.TEST_STRING);
        impactoCalculadoraTeste.setPeso(Long.valueOf(1));
        impactoCalculadoraTeste.setExcluido(false);

        Calculadora calculadoraTeste = new Calculadora();

        ImpactoCalculadora impactoCalculadora = new ImpactoCalculadora(impactoCalculadoraTeste, calculadoraTeste);

        assertEquals(impactoCalculadoraTeste.getNome(), impactoCalculadora.getNome());
        assertEquals(impactoCalculadoraTeste.getPeso(), impactoCalculadora.getPeso());
        assertEquals(impactoCalculadoraTeste.isExcluido(), impactoCalculadora.isExcluido());
        assertEquals(calculadoraTeste, impactoCalculadora.getCalculadora());
    }

    @Test
    public void getId() throws Exception {
        impactoCalculadora.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), impactoCalculadora.getId());
    }

    @Test
    public void getNome() throws Exception {
        impactoCalculadora.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, impactoCalculadora.getNome());
    }

    @Test
    public void getPeso() throws Exception {
        impactoCalculadora.setPeso(Long.valueOf(1));
        assertEquals(Long.valueOf(1), impactoCalculadora.getPeso());
    }

    @Test
    public void isExcluido() throws Exception {
        impactoCalculadora.setExcluido(true);
        assertEquals(true, impactoCalculadora.isExcluido());
    }

    @Test
    public void isDesabilidado() throws Exception {
        impactoCalculadora.setDesabilitado(true);
        assertEquals(true, impactoCalculadora.getDesabilitado());
    }

    @Test
    public void getCalculadora() throws Exception {
        Calculadora calculadora = new Calculadora();

        impactoCalculadora.setCalculadora(calculadora);
        assertEquals(calculadora, impactoCalculadora.getCalculadora());
    }

}