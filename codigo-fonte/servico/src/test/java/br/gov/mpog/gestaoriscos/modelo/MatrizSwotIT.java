package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class MatrizSwotIT {

    MatrizSwot matrizSwot;

    @Before
    public void setUp() throws Exception {
        matrizSwot = new MatrizSwot();
    }

    @Test
    public void getId() throws Exception {
        matrizSwot.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), matrizSwot.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        matrizSwot.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, matrizSwot.getDescricao());
    }

    @Test
    public void isExcluido() throws Exception {
        matrizSwot.setExcluido(true);
        assertEquals(true, matrizSwot.isExcluido());
    }

    @Test
    public void getTipoMatriz() throws Exception {
        TipoMatriz tipoMatriz = new TipoMatriz();

        matrizSwot.setTipoMatriz(tipoMatriz);
        assertEquals(tipoMatriz, matrizSwot.getTipoMatriz());
    }

    @Test
    public void getAnalise() throws Exception {
        Analise analise = new Analise();

        matrizSwot.setAnalise(analise);
        assertEquals(analise, matrizSwot.getAnalise());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        MatrizSwot matrizSwot1 = new MatrizSwot();
        matrizSwot1.setId(Long.valueOf(1));
        matrizSwot1.setDescricao(AnnotationStringUtil.TEST_STRING);
        matrizSwot1.setExcluido(true);

        MatrizSwot matrizSwot2 = new MatrizSwot();
        matrizSwot2.setId(Long.valueOf(2));
        matrizSwot2.setDescricao(AnnotationStringUtil.TEST_STRING);
        matrizSwot2.setExcluido(true);

        assertNotEquals(matrizSwot1.hashCode(), matrizSwot2.hashCode());
    }

}