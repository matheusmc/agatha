package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
public class RespostaRiscoDTOTest {

    RespostaRiscoDTO tipoRespostaRisco;

    @Before
    public void setUp() throws Exception {
        tipoRespostaRisco = new RespostaRiscoDTO();
    }

    @Test
    public void getId() throws Exception {
        tipoRespostaRisco.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), tipoRespostaRisco.getId());
    }

    @Test
    public void getNome() throws Exception {
        tipoRespostaRisco.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, tipoRespostaRisco.getNome());
    }

    @Test
    public void isExcluido() throws Exception {
        tipoRespostaRisco.setExcluido(true);
        assertEquals(true, tipoRespostaRisco.isExcluido());
    }

}