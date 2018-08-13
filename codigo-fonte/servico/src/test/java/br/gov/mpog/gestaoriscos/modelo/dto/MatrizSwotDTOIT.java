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
public class MatrizSwotDTOIT {

    MatrizSwotDTO matrizSwot;

    @Before
    public void setUp() throws Exception {
        matrizSwot = new MatrizSwotDTO();
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
        TipoMatrizDTO tipoMatriz = new TipoMatrizDTO();

        matrizSwot.setTipoMatriz(tipoMatriz);
        assertEquals(tipoMatriz, matrizSwot.getTipoMatriz());
    }

}