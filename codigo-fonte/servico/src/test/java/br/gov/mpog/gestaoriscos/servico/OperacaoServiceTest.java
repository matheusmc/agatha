package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Operacao;
import br.gov.mpog.gestaoriscos.modelo.dto.OperacaoDTO;
import br.gov.mpog.gestaoriscos.repositorio.OperacaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaBaseCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.OperacaoServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.OperacaoMapper;
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
public class OperacaoServiceTest {

    @InjectMocks
    private OperacaoServiceImpl operacaoService;

    @Mock
    private OperacaoRepository operacaoRepository;

    @Mock
    private TaxonomiaBaseCustomRepositorioImpl taxonomiaBaseCustomRepositorio;

    @Mock
    private Operacao operacao;

    @Mock
    private OperacaoDTO operacaoDTO;

    @Mock
    private Page<Operacao> operacaoPage;

    @Mock
    private Page<OperacaoDTO> operacaoDTOPage;

    @Mock
    private OperacaoMapper operacaoMapper;

    @Mock
    private Pageable pageable;

    private final Long ID = 1L;
    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;

    @Before
    public void setUp() {
        when(operacaoRepository.save(any(Operacao.class))).thenReturn(operacao);
        when(operacaoRepository.findOne(anyLong())).thenReturn(operacao);
        when(operacaoMapper.operacaoDTOToOperacao(any(OperacaoDTO.class))).thenReturn(operacao);
        when(operacaoMapper.operacaoToOperacaoDTO(any(Operacao.class))).thenReturn(operacaoDTO);
        when(operacao.getDescricao()).thenReturn(DESCRICAO);
        when(operacaoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(operacaoRepository.findBySearchContainingIgnoreCaseAndStatusAndOrgaoIsNullOrderByDescricaoAsc(anyString(), anyBoolean(), any(Pageable.class))).thenReturn(operacaoPage);
        when(operacaoRepository.findBySearchContainingIgnoreCaseAndOrgaoIsNullOrderByDescricaoAsc(anyString(), any(Pageable.class))).thenReturn(operacaoPage);

        //noinspection unchecked
        when(operacaoPage.map(any(Converter.class))).thenReturn(operacaoDTOPage);
    }

    @Test
    public void save() {
        OperacaoDTO operacaoDTO = operacaoService.save(this.operacaoDTO);
        assertNotNull(operacaoDTO);
    }

    @Test
    public void findAllStatusNotNull() {
        when(operacao.getDescricao()).thenReturn(DESCRICAO);
        Page<OperacaoDTO> result = operacaoService.findAll(this.pageable, DESCRICAO, STATUS);
        assertNotNull(result);
    }

    @Test
    public void findAllStatusNull() {
        Page<OperacaoDTO> result = operacaoService.findAll(this.pageable, DESCRICAO, null);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        OperacaoDTO result = operacaoService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        operacaoService.delete(anyLong());
    }

    @Test
    public void verificarExistenciaTrue() {
        when(operacaoRepository.findBySearchIgnoreCase(anyString())).thenReturn(operacao);
        when(operacao.getId()).thenReturn(1L);
        when(operacaoDTO.getId()).thenReturn(2L);
        Boolean exitencia = operacaoService.verificarExistencia(operacaoDTO);
        assertEquals(true, exitencia);
    }

    @Test
    public void verificarExistenciaFalse() {
        when(operacaoRepository.findBySearchIgnoreCase(anyString())).thenReturn(operacao);
        Boolean exitencia = operacaoService.verificarExistencia(operacaoDTO);
        assertEquals(false, exitencia);
    }

    @Test
    public void searchByDescricaoResultNotNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(new ArrayList<>());
        List<String> result = operacaoService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricaoResultNull() {
        when(taxonomiaBaseCustomRepositorio.searchByDescricao(anyString(), anyString())).thenReturn(null);
        List<String> result = operacaoService.searchByDescricao("operacao");
        assertNull(result);
    }

}
