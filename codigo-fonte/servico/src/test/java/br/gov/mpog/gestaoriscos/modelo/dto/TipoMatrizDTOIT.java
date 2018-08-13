package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TipoMatrizDTOIT {

    TipoMatrizDTO tipoMatriz;

    @Before
    public void setUp() throws Exception {
        tipoMatriz = new TipoMatrizDTO();
    }

    @Test
    public void getId() throws Exception {
        tipoMatriz.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoMatriz.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoMatriz.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoMatriz.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoMatriz.setExcluido(true);
        assertEquals(true, tipoMatriz.isExcluido());
    }

}