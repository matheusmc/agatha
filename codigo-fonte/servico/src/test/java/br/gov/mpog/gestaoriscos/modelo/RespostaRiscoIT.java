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
public class RespostaRiscoIT {

    RespostaRisco respostaRisco;

    @Before
    public void setUp() throws Exception {
        respostaRisco = new RespostaRisco();
    }

    @Test
    public void getId() throws Exception {
        respostaRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), respostaRisco.getId());
    }

    @Test
    public void getNome() throws Exception {
        respostaRisco.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, respostaRisco.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        respostaRisco.setExcluido(true);
        assertEquals(true, respostaRisco.isExcluido());
    }

}