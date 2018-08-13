package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class PermissaoContainerDTOTest {

    PermissaoContainerDTO permissaoContainer;

    @Before
    public void setUp() throws Exception {
        permissaoContainer = new PermissaoContainerDTO();
    }

    @Test
    public void getPermissaos() throws Exception {
        PermissaoDTO permissoes = new PermissaoDTO();

        List<PermissaoDTO> permissoesList = new ArrayList<>();
        permissoesList.add(permissoes);

        permissaoContainer.setPermissaos(permissoesList);
        assertEquals(permissoesList, permissaoContainer.getPermissaos());
    }

}