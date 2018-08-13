package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Causa;
import br.gov.mpog.gestaoriscos.modelo.Processo;
import br.gov.mpog.gestaoriscos.modelo.dto.CausaDTO;
import br.gov.mpog.gestaoriscos.repositorio.CausaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseOrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.CausaServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.CausaMapper;
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
public class CausaServiceTest {

    @InjectMocks
    private CausaServiceImpl causaService;

    @Mock
    private CausaRepository causaRepository;

    @Mock
    private ProcessoRepository processoRepository;

    @Mock
    private TaxonomiaBaseOrgaoCustomRepositorioImpl taxonomiaBaseOrgaoCustomRepositorio;

    @Mock
    private Causa causa;

    @Mock
    private CausaDTO causaDTO;

    @Mock
    private Page<Causa> causaPage;

    @Mock
    private Page<CausaDTO> causaDTOPage;

    @Mock
    private CausaMapper causaMapper;

    @Mock
    private List<Processo> processos;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(causaRepository.save(any(Causa.class))).thenReturn(causa);
        when(causaRepository.findOne(anyLong())).thenReturn(causa);
        when(causaMapper.causaDTOToCausa(any(CausaDTO.class))).thenReturn(causa);
        when(causaMapper.causaToCausaDTO(any(Causa.class))).thenReturn(causaDTO);
        when(causa.getDescricao()).thenReturn(DESCRICAO);
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(causaRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(causaPage);
        when(causaRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(causaPage);

        //noinspection unchecked
        when(causaPage.map(any(Converter.class))).thenReturn(causaDTOPage);
    }

    @Test
    public void save() {
        CausaDTO causaDTO = causaService.save(this.causaDTO);
        assertNotNull(causaDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(causa.getDescricao()).thenReturn(DESCRICAO);
        Page<CausaDTO> result = causaService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<CausaDTO> result = causaService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        CausaDTO result = causaService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        causaService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(causaRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(causa);
        when(causa.getId()).thenReturn(1L);
        when(causaDTO.getId()).thenReturn(2L);
        Boolean exitencia = causaService.verificarExistencia(causaDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(causaRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(causa);
        Boolean exitencia = causaService.verificarExistencia(causaDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = causaService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = causaService.searchByDescricao("teste10000");
        assertNull(result);
    }

    @Test
    public void hasProcessoTrue() {
        when(processoRepository.findByCausaId(anyLong())).thenReturn(processos);
        when(processos.isEmpty()).thenReturn(false);
        Boolean exitencia = causaService.hasProcesso(1L);
        assertEquals(true, exitencia);
    }

    @Test
    public void hasProcessoFalse() {
        when(processoRepository.findByCausaId(anyLong())).thenReturn(Arrays.asList());
        Boolean exitencia = causaService.hasProcesso(2L);
        assertEquals(false, exitencia);
    }
}
