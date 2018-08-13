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
public class NaturezaJuridicaDTOIT {

    NaturezaJuridicaDTO naturezaJuridica;

    @Before
    public void setUp() throws Exception {
        naturezaJuridica = new NaturezaJuridicaDTO();
    }

    @Test
    public void getId() throws Exception {
        naturezaJuridica.setId(Short.valueOf("1"));
        assertEquals(Short.valueOf("1"), naturezaJuridica.getId());
    }

    @Test
    public void getNome() throws Exception {
        naturezaJuridica.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, naturezaJuridica.getNome());
    }

}