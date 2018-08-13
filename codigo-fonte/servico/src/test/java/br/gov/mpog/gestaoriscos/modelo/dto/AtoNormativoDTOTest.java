package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class AtoNormativoDTOTest {

    AtoNormativoDTO atoNormativo;

    @Before
    public void setUp() throws Exception {
        atoNormativo = new AtoNormativoDTO();
    }

    @Test
    public void getTipoAto() throws Exception {
        atoNormativo.setTipoAto(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getTipoAto());
    }

    @Test
    public void getCodigoUnidade() throws Exception {
        atoNormativo.setCodigoUnidade(1);
        assertEquals(1, atoNormativo.getCodigoUnidade());
    }

    @Test
    public void getNumero() throws Exception {
        atoNormativo.setNumero(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getNumero());
    }

    @Test
    public void getDataAssinatura() throws Exception {
        atoNormativo.setDataAssinatura(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getDataAssinatura());
    }

    @Test
    public void getDataPublicacao() throws Exception {
        atoNormativo.setDataPublicacao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getDataPublicacao());
    }

    @Test
    public void getEmenta() throws Exception {
        atoNormativo.setEmenta(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getEmenta());
    }

    @Test
    public void getUrl() throws Exception {
        atoNormativo.setUrl(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, atoNormativo.getUrl());
    }

}