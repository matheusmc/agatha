package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
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
public class TipoBaseIT {

    TipoBase tipoBase;

    @Before
    public void setUp() throws Exception {
        tipoBase = new TipoBase();
    }

    @Test
    public void getNome() throws Exception {
        tipoBase.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoBase.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoBase.setExcluido(true);
        assertEquals(true, tipoBase.isExcluido());
    }

}