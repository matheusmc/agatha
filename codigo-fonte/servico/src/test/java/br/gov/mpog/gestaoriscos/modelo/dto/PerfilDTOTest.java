package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class PerfilDTOTest {

    PerfilDTO perfil;

    @Before
    public void setUp() throws Exception {
        perfil = new PerfilDTO();
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

}