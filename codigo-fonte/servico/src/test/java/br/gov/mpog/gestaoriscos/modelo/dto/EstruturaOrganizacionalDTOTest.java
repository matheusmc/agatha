package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class EstruturaOrganizacionalDTOTest {

    EstruturaOrganizacionalDTO estruturaOrganizacionalDTO;

    @Before
    public void setUp() throws Exception {
        estruturaOrganizacionalDTO = new EstruturaOrganizacionalDTO();
    }

    @Test
    public void getServico() throws Exception {
        ServicoDTO servico = new ServicoDTO();

        estruturaOrganizacionalDTO.setServico(servico);
        assertEquals(servico, estruturaOrganizacionalDTO.getServico());
    }

    @Test
    public void getUnidades() throws Exception {
        OrgaoCargaDTO orgao = new OrgaoCargaDTO();

        List<OrgaoCargaDTO> orgaoList = new ArrayList<>();
        orgaoList.add(orgao);

        estruturaOrganizacionalDTO.setUnidades(orgaoList);
        assertEquals(orgaoList, estruturaOrganizacionalDTO.getUnidades());
    }

}