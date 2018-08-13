package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Desenho;
import br.gov.mpog.gestaoriscos.modelo.dto.DesenhoDTO;
import br.gov.mpog.gestaoriscos.repositorio.DesenhoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.DesenhoServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.DesenhoMapper;
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
public class DesenhoServiceTest {

    @InjectMocks
    private DesenhoServiceImpl desenhoService;

    @Mock
    private DesenhoRepository desenhoRepository;

    @Mock
    private TaxonomiaBaseCustomRepositorioImpl taxonomiaBaseCustomRepositorio;

    @Mock
    private Desenho desenho;

    @Mock
    private DesenhoDTO desenhoDTO;

    @Mock
    private Page<Desenho> desenhoPage;

    @Mock
    private Page<DesenhoDTO> desenhoDTOPage;

    @Mock
    private DesenhoMapper desenhoMapper;

    @Mock
    private Pageable pageable;

    private final Long ID = 1L;
    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(desenhoRepository.save(any(Desenho.class))).thenReturn(desenho);
        when(desenhoRepository.findOne(anyLong())).thenReturn(desenho);
        when(desenhoMapper.desenhoDTOToDesenho(any(DesenhoDTO.class))).thenReturn(desenho);
        when(desenhoMapper.desenhoToDesenhoDTO(any(Desenho.class))).thenReturn(desenhoDTO);
        when(desenho.getDescricao()).thenReturn(DESCRICAO);
        when(desenhoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(desenhoRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(desenhoPage);
        when(desenhoRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(desenhoPage);

        //noinspection unchecked
        when(desenhoPage.map(any(Converter.class))).thenReturn(desenhoDTOPage);
    }

    @Test
    public void save() {
        DesenhoDTO desenhoDTO = desenhoService.save(this.desenhoDTO);
        assertNotNull(desenhoDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(desenho.getDescricao()).thenReturn(DESCRICAO);
        Page<DesenhoDTO> result = desenhoService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<DesenhoDTO> result = desenhoService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        DesenhoDTO result = desenhoService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        desenhoService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(desenhoRepository.findBySearchIgnoreCase(anyString())).thenReturn(desenho);
        when(desenho.getId()).thenReturn(1L);
        when(desenhoDTO.getId()).thenReturn(2L);
        Boolean exitencia = desenhoService.verificarExistencia(desenhoDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(desenhoRepository.findBySearchIgnoreCase(anyString())).thenReturn(desenho);
        Boolean exitencia = desenhoService.verificarExistencia(desenhoDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = desenhoService.searchByDescricao("desenho");
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = desenhoService.searchByDescricao("teste1000");
        assertNull(result);
    }

}
