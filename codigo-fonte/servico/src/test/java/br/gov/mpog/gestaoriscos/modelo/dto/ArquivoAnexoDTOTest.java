package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ArquivoAnexoDTOTest {

    ArquivoAnexoDTO arquivoAnexo;

    @Before
    public void setUp() throws Exception {
        arquivoAnexo = new ArquivoAnexoDTO();
    }

    @Test
    public void getId() throws Exception {
        arquivoAnexo.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), arquivoAnexo.getId());
    }

    @Test
    public void getNomeArquivo() throws Exception {
        arquivoAnexo.setNomeArquivo(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, arquivoAnexo.getNomeArquivo());
    }

    @Test
    public void getNomeDocumento() throws Exception {
        arquivoAnexo.setNomeDocumento(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, arquivoAnexo.getNomeDocumento());
    }

    @Test
    public void getTamanho() throws Exception {
        arquivoAnexo.setTamanho(1);
        assertEquals(Integer.valueOf(1), arquivoAnexo.getTamanho());
    }

    @Test
    public void getDataUpload() throws Exception {
        Date date = new Date();
        arquivoAnexo.setDataUpload(date);
        assertEquals(date, arquivoAnexo.getDataUpload());
    }

    @Test
    public void isExcluido() throws Exception {
        arquivoAnexo.setExcluido(true);
        assertEquals(true, arquivoAnexo.isExcluido());
    }

}