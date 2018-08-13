package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class ArquivoAnexoIT {

    ArquivoAnexo arquivoAnexo;

    @Before
    public void setUp() throws Exception {
        arquivoAnexo = new ArquivoAnexo();
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
    public void getArquivo() throws Exception {
        byte[] arquivo = new byte[] { 7, 25, 12 };

        arquivoAnexo.setArquivo(arquivo);
        assertArrayEquals(arquivo, arquivoAnexo.getArquivo());
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