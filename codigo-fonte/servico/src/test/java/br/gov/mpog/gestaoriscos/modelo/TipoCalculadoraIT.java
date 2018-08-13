package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 23/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TipoCalculadoraIT {

    TipoCalculadora tipoCalculadora;
    @Before
    public void setUp() throws Exception {
        tipoCalculadora = new TipoCalculadora();
    }

    @Test
    public void getId() throws Exception {
        tipoCalculadora.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoCalculadora.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoCalculadora.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoCalculadora.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoCalculadora.setExcluido(true);
        assertEquals(true, tipoCalculadora.isExcluido());
    }

}