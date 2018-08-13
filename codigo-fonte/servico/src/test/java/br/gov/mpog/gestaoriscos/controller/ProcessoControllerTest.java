package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.*;
import br.gov.mpog.gestaoriscos.servico.ProcessoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessoControllerTest {

    @InjectMocks
    private ProcessoController processoController;

    @Mock
    private ProcessoService processoService;

    @Mock
    private ProcessoDTO processoDTO;

    @Mock
    private OrgaosDTO orgaosDTO;

    @Mock
    private PermissaoProcessoDTO permissaoProcessoDTO;

    @Mock
    private EventoRiscoDTO eventoRiscoDTO;

    @Mock
    private Pageable pageable;

    @Mock
    private Page page;

    @Mock
    private AvaliacaoDTO avaliacaoDTO;

    @Mock
    private EventoDTO eventoDTO;

    @Mock
    private CausaDTO causaDTO;

    @Mock
    private ConsequenciaDTO consequenciaDTO;

    @Mock
    private EventoCausaDTO eventoCausaDTO;

    @Mock
    private EventoConsequenciaDTO eventoConsquenciaDTO;

    @Mock
    private ConsequenciaDTO ConsquenciaDTO;

    @Mock
    private ControleDTO controleDTO;

    @Mock
    private ControleEventoDTO controleEventoDTO;

    @Mock
    private CalculadoraDTO calculadoraDTO;

    @Mock
    private IdentificacaoDTO identificacaoDTO;

    @Mock
    private OperacaoDTO operacaoDTO;

    @Mock
    private UsuarioDTO usuarioDTO;

    @Mock
    private TipoMatrizDTO tipoMatrizDTO;

    @Mock
    private DesenhoDTO desenhoDTO;

    @Mock
    private TipoControleDTO tipoControleDTO;

    @Mock
    private RespostaRiscoDTO respostaRiscoDTO;

    @Mock
    private ObjetivoControleDTO objetivoControleDTO;

    @Mock
    private NaturezaDTO naturezaDTO;

    @Mock
    private StatusProcessoDTO statusProcessoDTO;

    @Mock
    private CategoriaDTO categoriaDTO;


    @Before
    public void setUp() {
        when(processoService.save(any(ProcessoDTO.class))).thenReturn(new ProcessoDTO());
    }


    @Test
    public void createProcesso() throws Exception {
        ResponseEntity<ProcessoDTO> processoSalvaDTO =
                processoController.createProcesso(processoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void updateProcesso() throws Exception {
        ResponseEntity<ProcessoDTO> processoSalvaDTO =
                processoController.updateProcesso(processoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void getProcesso() throws Exception {
        when(processoService.findOne(anyLong())).thenReturn(processoDTO);

        ResponseEntity<ProcessoDTO> RetornoDTO =
                processoController.getProcesso(1L);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getAllProcessos() throws Exception {
        when(processoService.findAll(any(Pageable.class), anyString(), anyString(), anyString(), anyLong(), anyLong(), anyLong())).thenReturn(page);
        ResponseEntity<List<ProcessoListagemDTO>> RetornoDTO = processoController.getAllProcessos(pageable, "", "", "", 1L, 1L, 1L);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void deleteProcesso() throws Exception {
        ResponseEntity responseEntity = processoController.deleteProcesso(1L);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void findAllUsuarios() throws Exception {
        when(processoService.findAllAnalistas()).thenReturn(Arrays.asList(usuarioDTO));
        ResponseEntity<List<UsuarioDTO>> RetornoDTO = processoController.findAllUsuarios();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void findAllGestores() throws Exception {
        when(processoService.findAllGestores()).thenReturn(Arrays.asList(usuarioDTO));
        ResponseEntity<List<UsuarioDTO>> RetornoDTO = processoController.findAllGestores();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void findAllTiposMatriz() throws Exception {
        when(processoService.findAllTiposMatriz()).thenReturn(Arrays.asList(tipoMatrizDTO));
        ResponseEntity<List<TipoMatrizDTO>> RetornoDTO = processoController.findAllTiposMatriz();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getOrgaosByCpf() throws Exception {
        when(processoService.findOrgaosByCPF(anyString())).thenReturn(orgaosDTO);
        ResponseEntity<OrgaosDTO> RetornoDTO =
                processoController.getOrgaosByCpf("AA");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getPermissoes() throws Exception {
        when(processoService.findPermissaoByCPF(anyString())).thenReturn(permissaoProcessoDTO);
        ResponseEntity<PermissaoProcessoDTO> RetornoDTO =
                processoController.getPermissoes("AA");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getAllEventosRisco() throws Exception {
        when(processoService.findAllEventosRisco(any(Pageable.class), anyLong())).thenReturn(page);
        ResponseEntity<List<EventoRiscoDTO>> RetornoDTO = processoController.getAllEventosRisco(pageable, 1L);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getAllEventosRiscoId() throws Exception {
        when(processoService.findAllEventosRisco(anyLong())).thenReturn(Arrays.asList(eventoRiscoDTO));
        ResponseEntity<List<EventoRiscoDTO>> RetornoDTO = processoController.getAllEventosRisco(1L);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getEventoRisco() throws Exception {
        when(processoService.findOne(anyLong())).thenReturn(processoDTO);

        ResponseEntity<EventoRiscoDTO> RetornoDTO =
                processoController.getEventoRisco(1l);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void createEventoRisco() throws Exception {
        ResponseEntity<EventoRiscoDTO> processoSalvaDTO =
                processoController.createEventoRisco(eventoRiscoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void updateEventoRisco() throws Exception {
        ResponseEntity<EventoRiscoDTO> processoSalvaDTO =
                processoController.updateEventoRisco(eventoRiscoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void deleteEventoRisco() throws Exception {
        ResponseEntity responseEntity = processoController.deleteEventoRisco(1l);
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void getEventos() throws Exception {
        when(processoService.findEventoByDescricaoAndCPF(anyString(), anyString())).thenReturn(asList(eventoDTO));
        ResponseEntity<List<EventoDTO>> RetornoDTO =
                processoController.getEventos("AA", "00");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getCausas() throws Exception {
        when(processoService.findCausaByDescricaoAndCPF(anyString(), anyString())).thenReturn(asList(causaDTO));
        ResponseEntity<List<CausaDTO>> RetornoDTO =
                processoController.getCausas("AA", "00");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getConsequencias() throws Exception {
        when(processoService.findConsequenciaByDescricaoAndCPF(anyString(), anyString())).thenReturn(asList(consequenciaDTO));
        ResponseEntity<List<ConsequenciaDTO>> RetornoDTO =
                processoController.getConsequencias("AA", "00");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getCategorias() throws Exception {
        when(processoService.findAllCategoria()).thenReturn(Arrays.asList(categoriaDTO));
        ResponseEntity<List<CategoriaDTO>> RetornoDTO = processoController.getCategorias();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getNaturezas() throws Exception {
        when(processoService.findAllNatureza()).thenReturn(Arrays.asList(naturezaDTO));
        ResponseEntity<List<NaturezaDTO>> RetornoDTO = processoController.getNaturezas();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void verificarEvento() throws Exception {
        ResponseEntity<PerfilDTO> processoSalvaDTO =
                processoController.verificarEvento(eventoRiscoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void atualizarEvento() throws Exception {
        ResponseEntity<EventoDTO> processoSalvaDTO =
                processoController.atualizarEvento(eventoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void substituirEvento() throws Exception {
        ResponseEntity<EventoRiscoDTO> processoSalvaDTO =
                processoController.substituirEvento(eventoRiscoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void verificarCausa() throws Exception {
        ResponseEntity<PerfilDTO> processoSalvaDTO =
                processoController.verificarCausa(eventoCausaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void atualizarCausa() throws Exception {
        ResponseEntity<CausaDTO> processoSalvaDTO =
                processoController.atualizarCausa(causaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void substituirCausa() throws Exception {
        ResponseEntity<EventoCausaDTO> processoSalvaDTO =
                processoController.substituirCausa(eventoCausaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void verificarConsequencia() throws Exception {
        ResponseEntity<PerfilDTO> processoSalvaDTO =
                processoController.verificarConsequencia(eventoConsquenciaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void atualizarConsequencia() throws Exception {
        ResponseEntity<ConsequenciaDTO> processoSalvaDTO =
                processoController.atualizarConsequencia(ConsquenciaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void substituirConsequencia() throws Exception {
        ResponseEntity<EventoConsequenciaDTO> processoSalvaDTO =
                processoController.substituirConsequencia(eventoConsquenciaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void searchByNome() throws Exception {
        when(processoService.searchOrgaoByNome(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> RetornoDTO =
                processoController.searchByNome("AA");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void searchByDescricao() throws Exception {
        when(processoService.searchByDescricao(anyString())).thenReturn(new ArrayList<>());
        ResponseEntity<List<String>> RetornoDTO =
                processoController.searchByDescricao("AA");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getStatus() throws Exception {
        when(processoService.getStatus()).thenReturn(Arrays.asList(statusProcessoDTO));
        ResponseEntity<List<StatusProcessoDTO>> RetornoDTO = processoController.getStatus();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getDesenhos() throws Exception {
        when(processoService.findAllDesenhos()).thenReturn(Arrays.asList(desenhoDTO));
        ResponseEntity<List<DesenhoDTO>> RetornoDTO = processoController.getDesenhos();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getOperacoes() throws Exception {
        when(processoService.findAllOperacoes()).thenReturn(Arrays.asList(operacaoDTO));
        ResponseEntity<List<OperacaoDTO>> RetornoDTO = processoController.getOperacoes();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getControles() throws Exception {
        when(processoService.findControleByDescricaoAndCPF(anyString(), anyString())).thenReturn(asList(controleDTO));
        ResponseEntity<List<ControleDTO>> RetornoDTO =
                processoController.getControles("AA", "00");
        assertNotNull(RetornoDTO);
    }

    @Test
    public void verificarControle() throws Exception {
        ResponseEntity<PerfilDTO> processoSalvaDTO =
                processoController.verificarControle(controleEventoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void atualizarControle() throws Exception {
        ResponseEntity<ControleDTO> processoSalvaDTO =
                processoController.atualizarControle(controleDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void substituirControle() throws Exception {
        ResponseEntity<ControleEventoDTO> processoSalvaDTO =
                processoController.substituirControle(controleEventoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void getCalculadoraInerente() throws Exception {
        when(processoService.getCalculadoraInerenteByProcessoId(anyLong())).thenReturn(calculadoraDTO);

        ResponseEntity<CalculadoraDTO> RetornoDTO =
                processoController.getCalculadoraInerente(1l);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getCalculadoraResidual() throws Exception {
        when(processoService.getCalculadoraResidualByProcessoId(anyLong())).thenReturn(calculadoraDTO);

        ResponseEntity<CalculadoraDTO> RetornoDTO =
                processoController.getCalculadoraResidual(1l);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void salvarCalculo() throws Exception {
        ResponseEntity<IdentificacaoDTO> processoSalvaDTO =
                processoController.salvarCalculo(identificacaoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void getIgnorarRiscoInerenteByProcesso() throws Exception {
        when(processoService.getIgnorarRiscoInerenteByProcesso(anyLong())).thenReturn(anyBoolean());

        ResponseEntity<Boolean> RetornoDTO =
                processoController.getIgnorarRiscoInerenteByProcesso(1l);
        assertNotNull(RetornoDTO);
    }

    @Test
    public void alterarIgnorarRiscoInerente() throws Exception {
        ResponseEntity<Boolean> processoSalvaDTO =
                processoController.alterarIgnorarRiscoInerente(processoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void salvarTaxonomiaCausa() throws Exception {
        ResponseEntity<TaxonomiaDTO> processoSalvaDTO =
                processoController.salvarTaxonomiaCausa(causaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void salvarTaxonomiaConsequencia() throws Exception {
        ResponseEntity<TaxonomiaDTO> processoSalvaDTO =
                processoController.salvarTaxonomiaConsequencia(consequenciaDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void salvarTaxonomiaControle() throws Exception {
        ResponseEntity<TaxonomiaDTO> processoSalvaDTO =
                processoController.salvarTaxonomiaControle(controleDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void salvarTaxonomiaEvento() throws Exception {
        ResponseEntity<TaxonomiaDTO> processoSalvaDTO =
                processoController.salvarTaxonomiaEvento(eventoDTO);
        assertNotNull(processoSalvaDTO);
    }

    @Test
    public void getTiposControle() throws Exception {
        when(processoService.getTiposControle()).thenReturn(Arrays.asList(tipoControleDTO));
        ResponseEntity<List<TipoControleDTO>> RetornoDTO = processoController.getTiposControle();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getTiposResposta() throws Exception {
        when(processoService.getTiposResposta()).thenReturn(Arrays.asList(respostaRiscoDTO));
        ResponseEntity<List<RespostaRiscoDTO>> RetornoDTO = processoController.getTiposResposta();
        assertNotNull(RetornoDTO);
    }

    @Test
    public void getObjetivosControle() throws Exception {
        when(processoService.getObjetivosControle()).thenReturn(Arrays.asList(objetivoControleDTO));
        ResponseEntity<List<ObjetivoControleDTO>> RetornoDTO = processoController.getObjetivosControle();
        assertNotNull(RetornoDTO);
    }

}