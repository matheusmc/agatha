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
public class ObjetivoControleIT {

    ObjetivoControle objetivoControle;

    @Before
    public void setUp() throws Exception {
        objetivoControle = new ObjetivoControle();
    }

    @Test
    public void getId() throws Exception {
        objetivoControle.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), objetivoControle.getId());
    }

    @Test
    public void getNome() throws Exception {
        objetivoControle.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, objetivoControle.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        objetivoControle.setExcluido(true);
        assertEquals(true, objetivoControle.isExcluido());
    }

}