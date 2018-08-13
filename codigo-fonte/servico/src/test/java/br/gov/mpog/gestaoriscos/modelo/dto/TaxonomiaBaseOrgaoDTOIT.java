package br.gov.mpog.gestaoriscos.modelo.dto;

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
public class TaxonomiaBaseOrgaoDTOIT {

    TaxonomiaOrgaoBaseDTO taxonomiaBaseOrgao;

    @Before
    public void setUp() throws Exception {
        taxonomiaBaseOrgao = new TaxonomiaOrgaoBaseDTO();
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        taxonomiaBaseOrgao.setOrgao(orgao);
        assertEquals(orgao, taxonomiaBaseOrgao.getOrgao());
    }

}