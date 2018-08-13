package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TaxonomiaBaseDTOIT {

    EntidadeBaseDescricaoStatusSearchDTO taxonomiaBase;

    @Before
    public void setUp() throws Exception {
        taxonomiaBase = new EntidadeBaseDescricaoStatusSearchDTO();
    }

    @Test
    public void getDescricao() throws Exception {
        taxonomiaBase.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomiaBase.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        taxonomiaBase.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomiaBase.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        taxonomiaBase.setStatus(true);
        assertEquals(true, taxonomiaBase.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        taxonomiaBase.setExcluido(true);
        assertEquals(true, taxonomiaBase.isExcluido());
    }

    @Test
    public void getCpf() throws Exception {
        taxonomiaBase.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomiaBase.getCpf());
    }

}