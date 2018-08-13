package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaUnidadeDTO;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ProbabilidadeCalculadoraTest {

    ProbabilidadeCalculadora probabilidadeCalculadora;

    @Before
    public void setUp() throws Exception {
        probabilidadeCalculadora = new ProbabilidadeCalculadora();
    }

    @Test
    public void constructoTest1() throws Exception {
        ProbabilidadeCalculadora probabilidadeCalculadoraTeste = new ProbabilidadeCalculadora();
        probabilidadeCalculadoraTeste.setNome(AnnotationStringUtil.TEST_STRING);
        probabilidadeCalculadoraTeste.setFrequencia(Long.valueOf(1));
        probabilidadeCalculadoraTeste.setExcluido(false);

        Calculadora calculadoraTeste = new Calculadora();

        ProbabilidadeCalculadora probabilidadeCalculadora = new ProbabilidadeCalculadora(probabilidadeCalculadoraTeste, calculadoraTeste);

        assertEquals(probabilidadeCalculadoraTeste.getNome(), probabilidadeCalculadora.getNome());
        assertEquals(probabilidadeCalculadoraTeste.getFrequencia(), probabilidadeCalculadora.getFrequencia());
        assertEquals(probabilidadeCalculadoraTeste.isExcluido(), probabilidadeCalculadora.isExcluido());
        assertEquals(calculadoraTeste, probabilidadeCalculadora.getCalculadora());
    }

    @Test
    public void getId() throws Exception {
        probabilidadeCalculadora.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), probabilidadeCalculadora.getId());
    }

    @Test
    public void getNome() throws Exception {
        probabilidadeCalculadora.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, probabilidadeCalculadora.getNome());
    }

    @Test
    public void getFrequencia() throws Exception {
        probabilidadeCalculadora.setFrequencia(Long.valueOf(1));
        assertEquals(Long.valueOf(1), probabilidadeCalculadora.getFrequencia());
    }

    @Test
    public void isExcluido() throws Exception {
        probabilidadeCalculadora.setExcluido(true);
        assertEquals(true, probabilidadeCalculadora.isExcluido());
    }

    @Test
    public void getCalculadora() throws Exception {
        Calculadora calculadora = new Calculadora();

        probabilidadeCalculadora.setCalculadora(calculadora);
        assertEquals(calculadora, probabilidadeCalculadora.getCalculadora());
    }

}