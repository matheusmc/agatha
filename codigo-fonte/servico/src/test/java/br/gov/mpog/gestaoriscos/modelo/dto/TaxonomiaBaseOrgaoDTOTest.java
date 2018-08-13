package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class TaxonomiaBaseOrgaoDTOTest {

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