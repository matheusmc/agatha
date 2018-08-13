package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Evento;
import br.gov.mpog.gestaoriscos.modelo.Processo;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoDTO;
import br.gov.mpog.gestaoriscos.repositorio.EventoRepository;
import br.gov.mpog.gestaoriscos.repositorio.ProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseOrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.EventoServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.EventoMapper;
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
public class EventoServiceTest {

    @InjectMocks
    private EventoServiceImpl eventoService;

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private ProcessoRepository processoRepository;

    @Mock
    private TaxonomiaBaseOrgaoCustomRepositorioImpl taxonomiaBaseOrgaoCustomRepositorio;

    @Mock
    private Evento evento;

    @Mock
    private EventoDTO eventoDTO;

    @Mock
    private Page<Evento> eventoPage;

    @Mock
    private Page<EventoDTO> eventoDTOPage;

    @Mock
    private EventoMapper eventoMapper;

    @Mock
    private List<Processo> processos;

    @Mock
    private Pageable pageable;

    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
        when(eventoRepository.findOne(anyLong())).thenReturn(evento);
        when(eventoMapper.eventoDTOToEvento(any(EventoDTO.class))).thenReturn(evento);
        when(eventoMapper.eventoToEventoDTO(any(Evento.class))).thenReturn(eventoDTO);
        when(evento.getDescricao()).thenReturn(DESCRICAO);
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(eventoPage);
        when(eventoRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(eventoPage);

        //noinspection unchecked
        when(eventoPage.map(any(Converter.class))).thenReturn(eventoDTOPage);
    }

    @Test
    public void save() {
        EventoDTO eventoDTO = eventoService.save(this.eventoDTO);
        assertNotNull(eventoDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(evento.getDescricao()).thenReturn(DESCRICAO);
        Page<EventoDTO> result = eventoService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<EventoDTO> result = eventoService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        EventoDTO result = eventoService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        eventoService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(eventoRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(evento);
        when(evento.getId()).thenReturn(1L);
        when(eventoDTO.getId()).thenReturn(2L);
        Boolean exitencia = eventoService.verificarExistencia(eventoDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(eventoRepository.findBySearchIgnoreCaseAndOrgaoIdIsNull(anyString())).thenReturn(evento);
        Boolean exitencia = eventoService.verificarExistencia(eventoDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = eventoService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseOrgaoCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = eventoService.searchByDescricao("teste1000");
        assertNull(result);
    }

    @Test
    public void hasProcessoTrue() {
        when(processoRepository.findByEventoId(anyLong())).thenReturn(processos);
        when(processos.isEmpty()).thenReturn(false);
        Boolean exitencia = eventoService.hasProcesso(1L);
        assertEquals(true, exitencia);
    }

    @Test
    public void hasProcessoFalse() {
        when(processoRepository.findByEventoId(anyLong())).thenReturn(Arrays.asList());
        Boolean exitencia = eventoService.hasProcesso(1L);
        assertEquals(false, exitencia);
    }
}
