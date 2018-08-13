package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ProcessoAnexoDTOTest {

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