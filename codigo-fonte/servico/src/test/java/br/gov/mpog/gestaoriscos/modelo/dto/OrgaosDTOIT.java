package br.gov.mpog.gestaoriscos.modelo.dto;

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
public class OrgaosDTOIT {

    OrgaosDTO orgaos;

    @Before
    public void setUp() throws Exception {
        orgaos = new OrgaosDTO();
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        orgaos.setOrgao(orgao);
        assertEquals(orgao, orgaos.getOrgao());
    }

    @Test
    public void getSecretaria() throws Exception {
        OrgaoDTO secretaria = new OrgaoDTO();

        orgaos.setSecretaria(secretaria);
        assertEquals(secretaria, orgaos.getSecretaria());
    }

}