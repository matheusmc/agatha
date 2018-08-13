package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Consequencia;
import br.gov.mpog.gestaoriscos.modelo.Processo;
import br.gov.mpog.gestaoriscos.modelo.dto.ConsequenciaDTO;
import br.gov.mpog.gestaoriscos.repositorio.ConsequenciaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseOrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.ConsequenciaServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.ConsequenciaMapper;
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
public class ConsequenciaServiceTest {

    @InjectMocks
    private ConsequenciaServiceImpl consequenciaService;

    @Mock
    private ConsequenciaRepository consequenciaRepository;

    @Mock
    private ProcessoRepository processoRepository;

    @Mock
    private TaxonomiaBaseOrgaoCustomRepositorioImpl taxonomiaBaseOrgaoCustomRepositorio;

    @Mock
    private Consequencia consequencia;

    @Mock
    private ConsequenciaDTO consequenciaDTO;

    @Mock
    private Page<Consequencia> consequenciaPage;

    @Mock
    private Page<ConsequenciaDTO> consequenciaDTOPage;

    @Mock
    private ConsequenciaMapper consequenciaMapper;

    @Mock
    private List<Processo> processos;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(consequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(consequencia);
        when(consequenciaMapper.consequenciaDTOToConsequencia(any(ConsequenciaDTO.class))).thenReturn(consequencia);
        when(consequenciaMapper.consequenciaToConsequenciaDTO(any(Consequencia.class))).thenReturn(consequenciaDTO);
        when(consequencia.getDescricao()).thenReturn(DESCRICAO);
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(consequenciaRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(consequenciaPage);
        when(consequenciaRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(consequenciaPage);

        //noinspection unchecked
        when(consequenciaPage.map(any(Converter.class))).thenReturn(consequenciaDTOPage);
    }

    @Test
    public void save() {
        ConsequenciaDTO consequenciaDTO = consequenciaService.save(this.consequenciaDTO);
        assertNotNull(consequenciaDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(consequencia.getDescricao()).thenReturn(DESCRICAO);
        Page<ConsequenciaDTO> result = consequenciaService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<ConsequenciaDTO> result = consequenciaService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        ConsequenciaDTO result = consequenciaService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        consequenciaService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(consequenciaRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(consequencia);
        when(consequencia.getId()).thenReturn(1L);
        when(consequenciaDTO.getId()).thenReturn(2L);
        Boolean exitencia = consequenciaService.verificarExistencia(consequenciaDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(consequenciaRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(consequencia);
        Boolean exitencia = consequenciaService.verificarExistencia(consequenciaDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = consequenciaService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = consequenciaService.searchByDescricao("teste1000");
        assertNull(result);
    }

    @Test
    public void hasProcessoTrue() {
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(processos);
        when(processos.isEmpty()).thenReturn(false);
        Boolean exitencia = consequenciaService.hasProcesso(1L);
        assertEquals(true, exitencia);
    }

    @Test
    public void hasProcessoFalse() {
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(Arrays.asList());
        Boolean exitencia = consequenciaService.hasProcesso(2L);
        assertEquals(false, exitencia);
    }
}
