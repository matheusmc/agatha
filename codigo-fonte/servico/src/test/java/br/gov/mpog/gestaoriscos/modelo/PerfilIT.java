package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class PerfilIT {

    Perfil perfil;

    @Before
    public void setUp() throws Exception {
        perfil = new Perfil();
    }

    @Test
    public void getId() throws Exception {
        perfil.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), perfil.getId());
    }

    @Test
    public void getNome() throws Exception {
        perfil.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, perfil.getNome());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        Perfil perfil1 = new Perfil();
        perfil1.setId(Long.valueOf(1));
        perfil1.setNome(AnnotationStringUtil.TEST_STRING);

        Perfil perfil2 = new Perfil();
        perfil2.setId(Long.valueOf(2));
        perfil2.setNome(AnnotationStringUtil.TEST_STRING);

        assertNotEquals(perfil1.hashCode(), perfil2.hashCode());
    }

}