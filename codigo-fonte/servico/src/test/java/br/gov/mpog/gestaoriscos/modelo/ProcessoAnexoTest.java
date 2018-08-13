package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ProcessoAnexoTest {

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