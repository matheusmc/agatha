package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Orgao;
import br.gov.mpog.gestaoriscos.modelo.dto.OrgaoDTO;
import br.gov.mpog.gestaoriscos.repositorio.OrgaoCustomRepositorio;
import br.gov.mpog.gestaoriscos.servico.impl.OrgaoServicoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by matheusbarbosa on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrgaoServiceTest {

    private static final Long ID = 1L;
    private static final String NOME = "NOME";

    @InjectMocks
    private OrgaoServicoImpl orgaoServico;

    @Mock
    private OrgaoCustomRepositorio orgaoCustomRepositorio;

    @Before
    public void setUp(){
        Orgao orgao = new Orgao(ID);

        List<Orgao> orgaoList = new ArrayList<>();
        orgaoList.add(orgao);

        when(orgaoCustomRepositorio.listarOrgaos(ID)).thenReturn(orgaoList);
        when(orgaoCustomRepositorio.filtrar(NOME)).thenReturn(orgaoList);
    }

    @Test
    public void listarOrgaos() throws Exception {

        List<OrgaoDTO> orgaoDTOs = orgaoServico.listarOrgaos(ID);
        assertNotNull(orgaoDTOs);
    }

    @Test
    public void filtrar() throws Exception {

        List<OrgaoDTO> orgaoDTOs = orgaoServico.filtrar(NOME);
        assertNotNull(orgaoDTOs);
    }

}
