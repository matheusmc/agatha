package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Glossario;
import br.gov.mpog.gestaoriscos.modelo.dto.GlossarioDTO;
import br.gov.mpog.gestaoriscos.repositorio.GlossarioRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.GlossarioCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.GlossarioServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.GlossarioMapper;
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
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by gabrielfreire on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GlossarioServiceTest {

    @InjectMocks
    private GlossarioServiceImpl glossarioService;

    @Mock
    private GlossarioRepository glossarioRepository;

    @Mock
    private GlossarioCustomRepositorioImpl glossarioCustomRepositorio;

    @Mock
    private Glossario glossario;

    @Mock
    private GlossarioDTO glossarioDTO;

    @Mock
    private Page<Glossario> glossarioPage;

    @Mock
    private Page<GlossarioDTO> glossarioDTOPage;

    @Mock
    private GlossarioMapper glossarioMapper;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final String TERMO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(glossarioRepository.save(any(Glossario.class))).thenReturn(glossario);
        when(glossarioRepository.findOne(anyLong())).thenReturn(glossario);
        when(glossarioMapper.glossarioDTOToGlossario(any(GlossarioDTO.class))).thenReturn(glossario);
        when(glossarioMapper.glossarioToGlossarioDTO(any(Glossario.class))).thenReturn(glossarioDTO);
        when(glossario.getTermo()).thenReturn(TERMO);
        when(glossario.getDescricao()).thenReturn(DESCRICAO);
        when(glossarioDTO.getTermo()).thenReturn(TERMO);
        when(glossarioDTO.getDescricao()).thenReturn(DESCRICAO);
        when(glossarioRepository.findByTermoSearchContainingIgnoreCaseAndDescricaoSearchContainingIgnoreCaseAndStatusOrderByTermoAsc(anyString(), anyString(), anyBoolean(), any(Pageable.class))).thenReturn(glossarioPage);
        when(glossarioRepository.findByTermoSearchContainingIgnoreCaseAndDescricaoSearchContainingIgnoreCaseOrderByTermoAsc(anyString(), anyString(), any(Pageable.class))).thenReturn(glossarioPage);

        //noinspection unchecked
        when(glossarioPage.map(any(Converter.class))).thenReturn(glossarioDTOPage);
    }

    @Test
    public void save() {
        GlossarioDTO glossarioDTO = glossarioService.save(this.glossarioDTO);
        assertNotNull(glossarioDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(glossario.getDescricao()).thenReturn(DESCRICAO);
        Page<GlossarioDTO> result = glossarioService.findAll(this.pageable, TERMO, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<GlossarioDTO> result = glossarioService.findAll(this.pageable, TERMO, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        GlossarioDTO result = glossarioService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        glossarioService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaResultIsNull() {
        when(glossarioRepository.findByTermoSearchIgnoreCase(anyString())).thenReturn(null);
        Boolean exitencia = glossarioService.verificarExistencia(glossarioDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void verificarExistenciaTrue() {
        when(glossarioRepository.findByTermoSearchIgnoreCase(anyString())).thenReturn(glossario);
        when(glossario.getId()).thenReturn(1L);
        when(glossarioDTO.getId()).thenReturn(2L);
        Boolean exitencia = glossarioService.verificarExistencia(glossarioDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(glossarioRepository.findByTermoSearchIgnoreCase(anyString())).thenReturn(glossario);
        Boolean exitencia = glossarioService.verificarExistencia(glossarioDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByTermoResultNotNull() {
        when(glossarioCustomRepositorio.searchByTermo(anyString())).thenReturn(anyListOf(String.class));
        List<String> result = glossarioService.searchByTermo(TERMO);
        assertNotNull(result);
    }

    @Test
    public void searchByTermoResultNull() {
        when(glossarioCustomRepositorio.searchByTermo(anyString())).thenReturn(null);
        List<String> result = glossarioService.searchByTermo(anyString());
        assertNull(result);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(glossarioCustomRepositorio.searchByDescricao(anyString())).thenReturn(anyListOf(String.class));
        List<String> result = glossarioService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(glossarioCustomRepositorio.searchByDescricao(anyString())).thenReturn(null);
        List<String> result = glossarioService.searchByDescricao(anyString());
        assertNull(result);
    }

    @Test
    public void findAll() {
        doReturn(new ArrayList<>()).when(glossarioRepository).findByStatusTrue();
        doReturn(new ArrayList<>()).when(glossarioMapper).glossariosToGlossarioDTOs(anyListOf(Glossario.class));
        List<GlossarioDTO> result = glossarioService.findAll();
        assertNotNull(result);
    }
}
