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
public class StatusProcessoDTOIT {

    StatusProcessoDTO statusProcesso;

    @Before
    public void setUp() throws Exception {
        statusProcesso = new StatusProcessoDTO();
    }

    @Test
    public void getId() throws Exception {
        statusProcesso.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), statusProcesso.getId());
    }

    @Test
    public void getNome() throws Exception {
        statusProcesso.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, statusProcesso.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        statusProcesso.setExcluido(true);
        assertEquals(true, statusProcesso.isExcluido());
    }

}