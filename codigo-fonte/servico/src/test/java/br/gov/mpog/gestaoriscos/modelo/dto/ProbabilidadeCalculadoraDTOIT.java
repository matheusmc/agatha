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
public class ProbabilidadeCalculadoraDTOIT {

    ProbabilidadeCalculadoraDTO probabilidadeCalculadora;

    @Before
    public void setUp() throws Exception {
        probabilidadeCalculadora = new ProbabilidadeCalculadoraDTO();
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
        CalculadoraDTO calculadora = new CalculadoraDTO();

        probabilidadeCalculadora.setCalculadora(calculadora);
        assertEquals(calculadora, probabilidadeCalculadora.getCalculadora());
    }

}