package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Controle;
import br.gov.mpog.gestaoriscos.modelo.dto.ControleDTO;
import br.gov.mpog.gestaoriscos.repositorio.ControleRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseOrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.ControleServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.ControleMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by gabrielfreire on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ControleServiceTest {

    @InjectMocks
    private ControleServiceImpl controleService;

    @Mock
    private ControleRepository controleRepository;

    @Mock
    private TaxonomiaBaseOrgaoCustomRepositorioImpl taxonomiaBaseOrgaoCustomRepositorio;

    @Mock
    private Controle controle;

    @Mock
    private ControleDTO controleDTO;

    @Mock
    private Page<Controle> controlePage;

    @Mock
    private Page<ControleDTO> controleDTOPage;

    @Mock
    private ControleMapper controleMapper;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(controleRepository.save(any(Controle.class))).thenReturn(controle);
        when(controleRepository.findOne(anyLong())).thenReturn(controle);
        when(controleMapper.controleDTOToControle(any(ControleDTO.class))).thenReturn(controle);
        when(controleMapper.controleToControleDTO(any(Controle.class))).thenReturn(controleDTO);
        when(controle.getDescricao()).thenReturn(DESCRICAO);
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);
        when(controleRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(controlePage);
        when(controleRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(controlePage);

        //noinspection unchecked
        when(controlePage.map(any(Converter.class))).thenReturn(controleDTOPage);
    }

    @Test
    public void save() {
        ControleDTO controleDTO = controleService.save(this.controleDTO);
        assertNotNull(controleDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(controle.getDescricao()).thenReturn(DESCRICAO);
        Page<ControleDTO> result = controleService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<ControleDTO> result = controleService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        ControleDTO result = controleService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        controleService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(controleRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(controle);
        when(controle.getId()).thenReturn(1L);
        when(controleDTO.getId()).thenReturn(2L);
        Boolean exitencia = controleService.verificarExistencia(controleDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(controleRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(controle);
        Boolean exitencia = controleService.verificarExistencia(controleDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = controleService.searchByDescricao("controle1");
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = controleService.searchByDescricao("teste35");
        assertNull(result);
    }
}
