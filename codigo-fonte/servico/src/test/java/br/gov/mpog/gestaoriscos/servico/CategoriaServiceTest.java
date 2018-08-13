package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Categoria;
import br.gov.mpog.gestaoriscos.modelo.Processo;
import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaDTO;
import br.gov.mpog.gestaoriscos.repositorio.CategoriaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.CategoriaServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.CategoriaMapper;
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
public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private ProcessoRepository processoRepository;

    @Mock
    private TaxonomiaBaseCustomRepositorioImpl taxonomiaBaseCustomRepositorio;

    @Mock
    private Categoria categoria;

    @Mock
    private CategoriaDTO categoriaDTO;

    @Mock
    private Page<Categoria> categoriaPage;

    @Mock
    private Page<CategoriaDTO> categoriaDTOPage;

    @Mock
    private CategoriaMapper categoriaMapper;

    @Mock
    private List<Processo> processos;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
        when(categoriaRepository.findOne(anyLong())).thenReturn(categoria);
        when(categoriaMapper.categoriaDTOToCategoria(any(CategoriaDTO.class))).thenReturn(categoria);
        when(categoriaMapper.categoriaToCategoriaDTO(any(Categoria.class))).thenReturn(categoriaDTO);
        when(categoria.getDescricao()).thenReturn(DESCRICAO);
        when(categoriaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(categoriaRepository.findBySearchContainingIgnoreCaseAndStatusOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(categoriaPage);
        when(categoriaRepository.findBySearchContainingIgnoreCaseOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(categoriaPage);

        //noinspection unchecked
        when(categoriaPage.map(any(Converter.class))).thenReturn(categoriaDTOPage);
    }

    @Test
    public void save() {
        CategoriaDTO categoriaDTO = categoriaService.save(this.categoriaDTO);
        assertNotNull(categoriaDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(categoria.getDescricao()).thenReturn(DESCRICAO);
        Page<CategoriaDTO> result = categoriaService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<CategoriaDTO> result = categoriaService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        CategoriaDTO result = categoriaService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        categoriaService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(categoriaRepository.findBySearchIgnoreCase(anyString())).thenReturn(categoria);
        when(categoria.getId()).thenReturn(1L);
        when(categoriaDTO.getId()).thenReturn(2L);
        Boolean exitencia = categoriaService.verificarExistencia(categoriaDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(categoriaRepository.findBySearchIgnoreCase(anyString())).thenReturn(categoria);
        Boolean exitencia = categoriaService.verificarExistencia(categoriaDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = categoriaService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = categoriaService.searchByDescricao("teste10000");
        assertNull(result);
    }

    @Test
    public void hasProcessoTrue() {
        when(processoRepository.findByCategoriaId(anyLong())).thenReturn(processos);
        when(processos.isEmpty()).thenReturn(false);
        Boolean exitencia = categoriaService.hasProcesso(1L);
        assertEquals(true, exitencia);
    }

    @Test
    public void hasProcessoFalse() {
        when(processoRepository.findByCategoriaId(anyLong())).thenReturn(Arrays.asList());
        Boolean exitencia = categoriaService.hasProcesso(2L);
        assertEquals(false, exitencia);
    }
}
