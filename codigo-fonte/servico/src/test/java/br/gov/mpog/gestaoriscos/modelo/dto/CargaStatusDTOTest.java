package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class CargaStatusDTOTest {

    CargaStatusDTO cargaStatus;

    @Before
    public void setUp() throws Exception {
        cargaStatus = new CargaStatusDTO();
    }

    @Test
    public void constructoTest1() throws Exception {
        CargaStatusDTO cargaStatusTeste = new CargaStatusDTO(1, 1, AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING);

        assertEquals(1, cargaStatusTeste.getInsercoes());
        assertEquals(1, cargaStatusTeste.getAtualizacoes());
        assertEquals(AnnotationStringUtil.TEST_STRING, cargaStatusTeste.getMsg());
        assertEquals(AnnotationStringUtil.TEST_STRING, cargaStatusTeste.getTempoGasto());
    }

    @Test
    public void getInsercoes() throws Exception {
        cargaStatus.setInsercoes(1);
        assertEquals(1, cargaStatus.getInsercoes());

    }

    @Test
    public void getAtualizacoes() throws Exception {
        cargaStatus.setAtualizacoes(1);
        assertEquals(1, cargaStatus.getAtualizacoes());
    }

    @Test
    public void getMsg() throws Exception {
        cargaStatus.setMsg(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, cargaStatus.getMsg());
    }

    @Test
    public void getTempoGasto() throws Exception {
        cargaStatus.setTempoGasto(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, cargaStatus.getTempoGasto());
    }

}