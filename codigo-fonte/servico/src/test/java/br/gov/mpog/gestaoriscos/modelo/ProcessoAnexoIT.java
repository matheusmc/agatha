package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class ProcessoAnexoIT {

    ProcessoAnexo processoAnexo;

    @Before
    public void setUp() throws Exception {
        processoAnexo = new ProcessoAnexo();
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
    public void getProcesso() throws Exception {
        Processo processo = new Processo();

        processoAnexo.setProcesso(processo);
        assertEquals(processo, processoAnexo.getProcesso());
    }

    @Test
    public void getArquivoAnexo() throws Exception {
        ArquivoAnexo arquivoAnexo = new ArquivoAnexo();

        processoAnexo.setArquivoAnexo(arquivoAnexo);
        assertEquals(arquivoAnexo, processoAnexo.getArquivoAnexo());
    }

}