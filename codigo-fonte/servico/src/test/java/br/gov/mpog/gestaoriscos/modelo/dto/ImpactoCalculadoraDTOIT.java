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
public class ImpactoCalculadoraDTOIT {

    ImpactoCalculadoraDTO impactoCalculadora;

    @Before
    public void setUp() throws Exception {
        impactoCalculadora = new ImpactoCalculadoraDTO();
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
    public void isDesabilitado() throws Exception {
        impactoCalculadora.setDesabilitado(true);
        assertEquals(true, impactoCalculadora.getDesabilitado());
    }

    @Test
    public void getCalculadora() throws Exception {
        CalculadoraDTO calculadora = new CalculadoraDTO();

        impactoCalculadora.setCalculadora(calculadora);
        assertEquals(calculadora, impactoCalculadora.getCalculadora());
    }

}