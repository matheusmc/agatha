package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class EtapaProcessoDTOTest {

    EtapaProcessoDTO etapaProcessoDTO;

    @Before
    public void setUp() throws Exception {
        etapaProcessoDTO = new EtapaProcessoDTO();
    }

    @Test
    public void getId() throws Exception {
        etapaProcessoDTO.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), etapaProcessoDTO.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        etapaProcessoDTO.setExcluido(true);
        assertEquals(true, etapaProcessoDTO.isExcluido());
    }

}