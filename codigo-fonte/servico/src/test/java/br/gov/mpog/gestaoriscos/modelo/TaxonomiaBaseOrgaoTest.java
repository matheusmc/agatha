package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class TaxonomiaBaseOrgaoTest {

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