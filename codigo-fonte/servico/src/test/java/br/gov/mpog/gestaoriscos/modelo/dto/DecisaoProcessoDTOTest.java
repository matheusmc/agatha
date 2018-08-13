package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecisaoProcessoDTOTest {

    DecisaoProcessoDTO decisaoProcessoDTO;

    @Before
    public void setUp() throws Exception {
        decisaoProcessoDTO = new DecisaoProcessoDTO();
    }

    @Test
    public void getId() throws Exception {
        decisaoProcessoDTO.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), decisaoProcessoDTO.getId());
    }

}