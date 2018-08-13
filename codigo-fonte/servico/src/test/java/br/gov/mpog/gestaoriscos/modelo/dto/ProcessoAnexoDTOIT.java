package br.gov.mpog.gestaoriscos.modelo.dto;

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
public class ProcessoAnexoDTOIT {

    ProcessoAnexoDTO processoAnexo;

    @Before
    public void setUp() throws Exception {
        processoAnexo = new ProcessoAnexoDTO();
    }

    @Test
    public void getId() throws Exception {
        processoAnexo.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), processoAnexo.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        processoAnexo.setExcluido(true);
        assertEquals(true, processoAnexo.isExcluido());
    }

    @Test
    public void getArquivoAnexo() throws Exception {
        ArquivoAnexoDTO arquivoAnexo = new ArquivoAnexoDTO();

        processoAnexo.setArquivoAnexo(arquivoAnexo);
        assertEquals(arquivoAnexo, processoAnexo.getArquivoAnexo());
    }

}