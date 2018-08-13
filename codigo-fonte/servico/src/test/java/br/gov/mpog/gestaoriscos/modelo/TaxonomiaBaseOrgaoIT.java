package br.gov.mpog.gestaoriscos.modelo;

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
public class TaxonomiaBaseOrgaoIT {

    TaxonomiaOrgaoBase taxonomiaBaseOrgao;

    @Before
    public void setUp() throws Exception {
        taxonomiaBaseOrgao = new TaxonomiaOrgaoBase();
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        taxonomiaBaseOrgao.setOrgao(orgao);
        assertEquals(orgao, taxonomiaBaseOrgao.getOrgao());
    }

}