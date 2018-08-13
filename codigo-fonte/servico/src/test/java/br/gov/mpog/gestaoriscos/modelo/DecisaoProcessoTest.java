package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DecisaoProcessoTest {

    DecisaoProcesso decisaoProcesso;

    @Before
    public void setUp() throws Exception {
        decisaoProcesso = new DecisaoProcesso();
    }

    @Test
    public void getId() throws Exception {
        decisaoProcesso.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), decisaoProcesso.getId());
    }
}