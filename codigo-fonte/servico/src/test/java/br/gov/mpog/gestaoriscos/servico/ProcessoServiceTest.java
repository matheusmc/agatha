package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.Analise;
import br.gov.mpog.gestaoriscos.modelo.ArquivoAnexo;
import br.gov.mpog.gestaoriscos.modelo.Avaliacao;
import br.gov.mpog.gestaoriscos.modelo.Calculadora;
import br.gov.mpog.gestaoriscos.modelo.CalculoRisco;
import br.gov.mpog.gestaoriscos.modelo.Categoria;
import br.gov.mpog.gestaoriscos.modelo.Causa;
import br.gov.mpog.gestaoriscos.modelo.Consequencia;
import br.gov.mpog.gestaoriscos.modelo.Controle;
import br.gov.mpog.gestaoriscos.modelo.ControleEvento;
import br.gov.mpog.gestaoriscos.modelo.Desenho;
import br.gov.mpog.gestaoriscos.modelo.Evento;
import br.gov.mpog.gestaoriscos.modelo.EventoCausa;
import br.gov.mpog.gestaoriscos.modelo.EventoConsequencia;
import br.gov.mpog.gestaoriscos.modelo.EventoRisco;
import br.gov.mpog.gestaoriscos.modelo.Identificacao;
import br.gov.mpog.gestaoriscos.modelo.ImpactoCalculadora;
import br.gov.mpog.gestaoriscos.modelo.Macroprocesso;
import br.gov.mpog.gestaoriscos.modelo.MatrizSwot;
import br.gov.mpog.gestaoriscos.modelo.Natureza;
import br.gov.mpog.gestaoriscos.modelo.Operacao;
import br.gov.mpog.gestaoriscos.modelo.Orgao;
import br.gov.mpog.gestaoriscos.modelo.Perfil;
import br.gov.mpog.gestaoriscos.modelo.PesoEventoRisco;
import br.gov.mpog.gestaoriscos.modelo.PlanoControle;
import br.gov.mpog.gestaoriscos.modelo.ProbabilidadeCalculadora;
import br.gov.mpog.gestaoriscos.modelo.Processo;
import br.gov.mpog.gestaoriscos.modelo.ProcessoAnexo;
import br.gov.mpog.gestaoriscos.modelo.Responsavel;
import br.gov.mpog.gestaoriscos.modelo.StatusProcesso;
import br.gov.mpog.gestaoriscos.modelo.StatusTaxonomia;
import br.gov.mpog.gestaoriscos.modelo.Taxonomia;
import br.gov.mpog.gestaoriscos.modelo.TipoMatriz;
import br.gov.mpog.gestaoriscos.modelo.TipoTaxonomia;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.ArquivoAnexoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.AvaliacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CausaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ConsequenciaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ControleDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ControleEventoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.DesenhoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoCausaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoConsequenciaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoRiscoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.IdentificacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.NaturezaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.OperacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.OrgaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.OrgaosDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PerfilDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProcessoEtapaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProcessoListagemDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.StatusProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TaxonomiaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoMatrizDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.UsuarioDTO;
import br.gov.mpog.gestaoriscos.repositorio.AnaliseRepository;
import br.gov.mpog.gestaoriscos.repositorio.ArquivoAnexoRepository;
import br.gov.mpog.gestaoriscos.repositorio.AvaliacaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.CalculadoraRepository;
import br.gov.mpog.gestaoriscos.repositorio.CalculoRiscoRepository;
import br.gov.mpog.gestaoriscos.repositorio.CategoriaRepository;
import br.gov.mpog.gestaoriscos.repositorio.CausaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ConsequenciaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ControleEventoRepository;
import br.gov.mpog.gestaoriscos.repositorio.ControleRepository;
import br.gov.mpog.gestaoriscos.repositorio.DesenhoRepository;
import br.gov.mpog.gestaoriscos.repositorio.EventoCausaRepository;
import br.gov.mpog.gestaoriscos.repositorio.EventoConsequenciaRepository;
import br.gov.mpog.gestaoriscos.repositorio.EventoRepository;
import br.gov.mpog.gestaoriscos.repositorio.EventoRiscoRepository;
import br.gov.mpog.gestaoriscos.repositorio.IdentificacaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.NaturezaRepository;
import br.gov.mpog.gestaoriscos.repositorio.OperacaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.OrgaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.PerfilRepository;
import br.gov.mpog.gestaoriscos.repositorio.PermissaoRepository;
import br.gov.mpog.gestaoriscos.repositorio.PlanoControleRepository;
import br.gov.mpog.gestaoriscos.repositorio.ProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.RespostaRiscoRepository;
import br.gov.mpog.gestaoriscos.repositorio.StatusProcessoRepository;
import br.gov.mpog.gestaoriscos.repositorio.StatusTaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.TaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.TipoMatrizRepository;
import br.gov.mpog.gestaoriscos.repositorio.TipoTaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.UsuarioRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.CausaCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.ConsequenciaCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.ControleCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.EventoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.OrgaoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.ProcessoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.ProcessoServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.ArquivoAnexoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.AvaliacaoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.CalculadoraMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.CategoriaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.CausaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.ConsequenciaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.ControleEventoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.ControleMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.DesenhoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.EventoCausaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.EventoConsequenciaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.EventoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.EventoRiscoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.IdentificacaoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.NaturezaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.OperacaoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.OrgaoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.PerfilMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.ProcessoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.StatusProcessoMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.TaxonomiaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.TipoMatrizMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by gabrielfreire on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProcessoServiceTest {

    @InjectMocks
    private ProcessoServiceImpl processoService;

    @Mock
    private ProcessoRepository processoRepository;

    @Mock
    private PermissaoRepository permissaoRepository;

    @Mock
    private TipoTaxonomiaRepository tipoTaxonomiaRepository;

    @Mock
    private StatusTaxonomiaRepository statusTaxonomiaRepository;

    @Mock
    private PerfilRepository perfilRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RespostaRiscoRepository respostaRiscoRepository;

    @Mock
    private PlanoControleRepository planoControleRepository;

    @Mock
    private OrgaoCustomRepositorioImpl orgaoCustomRepositorio;

    @Mock
    private ProcessoCustomRepositorioImpl processoCustomRepositorio;

    @Mock
    private ImpactoCalculadora impactoCalculadora;

    @Mock
    private ProbabilidadeCalculadora probabilidadeCalculadora;

    @Mock
    private MimeMessage mimeMessage;

    @Mock
    private JavaMailSenderImpl mailSender;

    @Mock
    private MultipartFile multipartFile;

    @Mock
    private ProcessoAnexo processoAnexo;

    @Mock
    private Causa causa;

    @Mock
    private CausaDTO causaDTO;

    @Mock
    private ControleDTO controleDTO;

    @Mock
    private ControleEventoDTO controleEventoDTO;

    @Mock
    private CalculadoraDTO calculadoraDTO;

    @Mock
    private TaxonomiaDTO taxonomiaDTO;

    @Mock
    private ConsequenciaDTO consequenciaDTO;

    @Mock
    private Consequencia consequencia;

    @Mock
    private Taxonomia taxonomia;

    @Mock
    private Controle controle;

    @Mock
    private Evento evento;

    @Mock
    private EventoDTO eventoDTO;

    @Mock
    private Avaliacao avaliacao;

    @Mock
    private AvaliacaoDTO avaliacaoDTO;

    @Mock
    private Identificacao identificacao;

    @Mock
    private Responsavel responsavel;

    @Mock
    private MatrizSwot matrizSwot;

    @Mock
    private StatusProcesso statusProcesso;

    @Mock
    private ControleEvento controleEvento;

    @Mock
    private Calculadora calculadora;

    @Mock
    private Usuario usuario;

    @Mock
    private Analise analise;

    @Mock
    private Orgao orgao;

    @Mock
    private Processo processo;

    @Mock
    private Perfil perfil;

    @Mock
    private Perfil perfilGestor;

    @Mock
    private Perfil perfilAnalista;

    @Mock
    private IdentificacaoDTO identificacaoDTO;

    @Mock
    private PerfilDTO perfilDTO;

    @Mock
    private ProcessoDTO processoDTO;

    @Mock
    private List<TipoMatriz> tipoMatrizList;

    @Mock
    private List<TipoMatrizDTO> tipoMatrizDTOList;

    @Mock
    private List<Evento> eventoList;

    @Mock
    private List<EventoDTO> eventoDTOList;

    @Mock
    private List<Causa> causaList;

    @Mock
    private List<CausaDTO> causaDTOList;

    @Mock
    private List<Consequencia> consequenciaList;

    @Mock
    private List<ConsequenciaDTO> consequenciaDTOList;

    @Mock
    private List<Categoria> categoriaList;

    @Mock
    private List<CategoriaDTO> categoriaDTOList;

    @Mock
    private List<Natureza> naturezaList;

    @Mock
    private List<NaturezaDTO> naturezaDTOList;

    @Mock
    private Page<ProcessoListagemDTO> processoPage;

    @Mock
    private Page<ProcessoDTO> processoDTOPage;

    @Mock
    private EventoCausa eventoCausa;

    @Mock
    private EventoCausaDTO eventoCausaDTO;

    @Mock
    private EventoConsequencia eventoConsequencia;

    @Mock
    private EventoConsequenciaDTO eventoConsequenciaDTO;

    @Mock
    private PesoEventoRisco pesoEventoRisco;

    @Mock
    private CalculoRisco calculoRisco;

    @Mock
    private EventoRisco eventoRisco;

    @Mock
    private EventoRiscoDTO eventoRiscoDTO;

    @Mock
    private Page<EventoRisco> eventoRiscoPage;

    @Mock
    private Page<EventoRiscoDTO> eventoRiscoDTOPage;

    @Mock
    private StatusProcessoMapper statusProcessoMapper;

    @Mock
    private DesenhoMapper desenhoMapper;

    @Mock
    private EventoCausaMapper eventoCausaMapper;

    @Mock
    private CalculadoraMapper calculadoraMapper;

    @Mock
    private ControleEventoMapper controleEventoMapper;

    @Mock
    private EventoConsequenciaMapper eventoConsequenciaMapper;

    @Mock
    private CategoriaMapper categoriaMapper;

    @Mock
    private NaturezaMapper naturezaMapper;

    @Mock
    private ProcessoMapper processoMapper;

    @Mock
    private ControleMapper controleMapper;

    @Mock
    private ControleCustomRepositorioImpl controleCustomRepositorio;

    @Mock
    private ArquivoAnexoMapper arquivoAnexoMapper;

    @Mock
    private IdentificacaoMapper identificacaoMapper;

    @Mock
    private TipoMatrizMapper tipoMatrizMapper;

    @Mock
    private EventoMapper eventoMapper;

    @Mock
    private ConsequenciaMapper consequenciaMapper;

    @Mock
    private OperacaoMapper operacaoMapper;

    @Mock
    private AvaliacaoMapper avaliacaoMapper;

    @Mock
    private PerfilMapper perfilMapper;

    @Mock
    private CausaMapper causaMapper;

    @Mock
    private TaxonomiaMapper taxonomiaMapper;

    @Mock
    private Pageable pageable;

    @Mock
    private AnaliseRepository analiseRepository;

    @Mock
    private TipoMatrizRepository tipoMatrizRepository;

    @Mock
    private OrgaoRepository orgaoRepository;

    @Mock
    private DesenhoRepository desenhoRepository;

    @Mock
    private CalculadoraRepository calculadoraRepository;

    @Mock
    private StatusProcessoRepository statusProcessoRepository;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private TaxonomiaRepository taxonomiaRepository;

    @Mock
    private IdentificacaoRepository identificacaoRepository;

    @Mock
    private ArquivoAnexoRepository arquivoAnexoRepository;

    @Mock
    private CausaRepository causaRepository;

    @Mock
    private ConsequenciaRepository consequenciaRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private NaturezaRepository naturezaRepository;

    @Mock
    private ControleRepository controleRepository;

    @Mock
    private ControleEventoRepository controleEventoRepository;

    @Mock
    private CalculoRiscoRepository calculoRiscoRepository;

    @Mock
    private EventoCustomRepositorioImpl eventoCustomRepositorio;

    @Mock
    private CausaCustomRepositorioImpl causaCustomRepositorio;

    @Mock
    private ConsequenciaCustomRepositorioImpl consequenciaCustomRepositorio;

    @Mock
    private OrgaoMapper orgaoMapper;

    @Mock
    private OperacaoRepository operacaoRepository;

    @Mock
    private EventoCausaRepository eventoCausaRepository;

    @Mock
    private EventoConsequenciaRepository eventoConsequenciaRepository;

    @Mock
    private EventoRiscoRepository eventoRiscoRepository;

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private EventoRiscoMapper eventoRiscoMapper;

    @Mock
    private TipoTaxonomia tipoTaxonomia;

    @Mock
    private StatusTaxonomia statusTaxonomia;

    private final Long ID = 1L;
    private final String CPF = "TESTE1";
    private final String ORGAO = "TESTE2";
    private final String DESCRICAO = "TESTE3";
    private final Long STATUS = 1L;
    private final Long INICIO = 2L;
    private final Long FIM = 3L;
    private final Long PROCESSO_ID = 1L;
    private final Long EVENTO_RISCO_ID = 1L;

    @Before
    public void setUp() {
        when(processoRepository.findOne(anyLong())).thenReturn(processo);
        when(processoMapper.processoToProcessoDTO(processo)).thenReturn(processoDTO);
        when(statusProcessoRepository.findByNomeIgnoreCase(anyString())).thenReturn(statusProcesso);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(eventoRiscoRepository.findOne(EVENTO_RISCO_ID)).thenReturn(eventoRisco);
        when(eventoRiscoMapper.eventoRiscoToEventoRiscoDTO(eventoRisco)).thenReturn(eventoRiscoDTO);

        when(processoMapper.processoDTOToProcesso(any(ProcessoDTO.class))).thenReturn(processo);
        when(calculadoraRepository.findByTipoNomeIgnoreCaseAndProcessoIsNull(anyString())).thenReturn(calculadora);
        when(processoRepository.save(processo)).thenReturn(processo);
        when(processoMapper.processoToProcessoDTO(processo)).thenReturn(processoDTO);

        ReflectionTestUtils.setField(processoService, "destinatario", "email@provedor.com");
        ReflectionTestUtils.setField(processoService, "remetente", "email@provedor.com");

        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        when(identificacaoRepository.save(any(Identificacao.class))).thenReturn(identificacao);
        when(identificacaoRepository.findByProcessoId(anyLong())).thenReturn(identificacao);
        when(identificacaoMapper.identificacaoToIdentificacaoDTO(any(Identificacao.class))).thenReturn(identificacaoDTO);
        when(tipoTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(tipoTaxonomia);
        when(statusTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(statusTaxonomia);
    }

    @Test
    public void saveProcessIsEmpty() {
        when(processo.getAnalise()).thenReturn(analise);
        when(processo.getId()).thenReturn(null);

        ProcessoDTO result = processoService.save(processoDTO);
        assertNotNull(result);
    }

    @Test
    public void saveWhenAnaliseHasIdNull() {
        List<Calculadora> calculadoraList = new ArrayList<>();
        calculadoraList.add(calculadora);

        List<ProbabilidadeCalculadora> probabilidadeCalculadoraList = new ArrayList<>();
        probabilidadeCalculadoraList.add(probabilidadeCalculadora);

        List<ImpactoCalculadora> impactoCalculadoraList = new ArrayList<>();
        impactoCalculadoraList.add(impactoCalculadora);

        when(processo.getAnalise()).thenReturn(analise);
        when(analise.getId()).thenReturn(null);
        when(processo.getId()).thenReturn(null);
        when(processo.getCalculadoras()).thenReturn(calculadoraList);
        when(calculadora.getImpactos()).thenReturn(impactoCalculadoraList);
        when(calculadora.getProbabilidades()).thenReturn(probabilidadeCalculadoraList);

        ProcessoDTO result = processoService.save(processoDTO);
        assertNotNull(result);
    }

    @Test
    public void save() {
        List<MatrizSwot> matrizSwotList = new ArrayList<>();
        matrizSwotList.add(matrizSwot);

        List<Responsavel> responsavelList = new ArrayList<>();
        responsavelList.add(responsavel);

        List<Calculadora> calculadoraList = new ArrayList<>();
        calculadoraList.add(calculadora);

        List<ProcessoAnexo> processoAnexoList = new ArrayList<>();
        processoAnexoList.add(processoAnexo);

        Macroprocesso macroprocesso = new Macroprocesso();

        when(processo.getAnalise()).thenReturn(analise);
        when(processo.getMacroprocesso()).thenReturn(macroprocesso);
        when(processo.getProcesso()).thenReturn(DESCRICAO);
        when(processo.getProcesso()).thenReturn(DESCRICAO);
        when(analise.getMatrizes()).thenReturn(matrizSwotList);
        when(processo.getResponsaveis()).thenReturn(responsavelList);
        when(processo.getIdentificacao()).thenReturn(identificacao);
        when(processo.getAvaliacao()).thenReturn(avaliacao);
        when(responsavel.getUsuario()).thenReturn(usuario);
        when(processo.getCalculadoras()).thenReturn(calculadoraList);
        when(processo.getAnexos()).thenReturn(processoAnexoList);

        ProcessoDTO result = processoService.save(processoDTO);
        assertNotNull(result);
    }

    @Test
    public void findAllIsGestorAndIsAnalista() {
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(perfilGestor);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(perfilAnalista);
        when(processoCustomRepositorio.findByFilters(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM, true, true)).thenReturn(processoPage);
        when(processoPage.map(any(Converter.class))).thenReturn(processoDTOPage);

        Page<ProcessoListagemDTO> result = processoService.findAll(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM);
        assertNotNull(result);
    }

    @Test
    public void findAllIsGestor() {
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(perfilGestor);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(null);
        when(processoCustomRepositorio.findByFilters(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM, true, false)).thenReturn(processoPage);
        when(processoPage.map(any(Converter.class))).thenReturn(processoDTOPage);

        Page<ProcessoListagemDTO> result = processoService.findAll(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM);
        assertNotNull(result);
    }

    @Test
    public void findAllIsAnalista() {
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(perfilAnalista);
        when(processoCustomRepositorio.findByFilters(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM, false, true)).thenReturn(processoPage);
        when(processoPage.map(any(Converter.class))).thenReturn(processoDTOPage);

        Page<ProcessoListagemDTO> result = processoService.findAll(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM);
        assertNotNull(result);
    }

    @Test
    public void findAllSemPerfil() {
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(null);
        when(processoCustomRepositorio.findByFilters(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM, false, false)).thenReturn(processoPage);
        when(processoPage.map(any(Converter.class))).thenReturn(processoDTOPage);

        Page<ProcessoListagemDTO> result = processoService.findAll(this.pageable, CPF, ORGAO, DESCRICAO, STATUS, INICIO, FIM);
        assertNotNull(result);
    }

    @Test
    public void findOne() {
        ProcessoDTO result = processoService.findOne(anyLong());
        assertNotNull(result);
    }

    @Test
    public void delete() {
        processoService.delete(anyLong());
    }

    @Test
    public void findAllAnalistasWhenUsuarioIsEmpty() {
        when(perfilRepository.findByNomeIgnoreCase("Analista de Risco")).thenReturn(perfilAnalista);
        when(usuarioRepository.findByPerfil(perfilAnalista.getId())).thenReturn(anyListOf(Usuario.class));

        List<UsuarioDTO> result = processoService.findAllAnalistas();
        assertNotNull(result);
    }

    @Test
    public void findAllAnalistas() {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario);

        when(perfilRepository.findByNomeIgnoreCase("Analista de Risco")).thenReturn(perfilAnalista);
        when(usuarioRepository.findByPerfil(perfilAnalista.getId())).thenReturn(usuarioList);

        List<UsuarioDTO> result = processoService.findAllAnalistas();
        assertNotNull(result);
    }

    @Test
    public void findAllGestoresWhenUsuarioIsEmpty() {
        when(perfilRepository.findByNomeIgnoreCase("Gestor do Processo")).thenReturn(perfilGestor);
        when(usuarioRepository.findByPerfil(perfilGestor.getId())).thenReturn(anyListOf(Usuario.class));

        List<UsuarioDTO> result = processoService.findAllGestores();
        assertNotNull(result);
    }

    @Test
    public void findAllGestores() {
        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario);

        when(perfilRepository.findByNomeIgnoreCase("Gestor do Processo")).thenReturn(perfilGestor);
        when(usuarioRepository.findByPerfil(perfilGestor.getId())).thenReturn(usuarioList);

        List<UsuarioDTO> result = processoService.findAllGestores();
        assertNotNull(result);
    }

    @Test
    public void findAllTiposMatriz() {
        when(tipoMatrizRepository.findAll()).thenReturn(tipoMatrizList);
        when(tipoMatrizMapper.tipoMatrizsToTipoMatrizDTOs(tipoMatrizList)).thenReturn(tipoMatrizDTOList);

        List<TipoMatrizDTO> result = processoService.findAllTiposMatriz();
        assertNotNull(result);
    }

    @Test
    public void findOrgaosByCPFSecretariaIsNotNull() {
        Orgao mock = new Orgao();

        when(orgao.getOrgaoPai()).thenReturn(mock);
        when(orgaoMapper.orgaoToOrgaoDTO(orgao)).thenReturn(any(OrgaoDTO.class));
        when(orgaoMapper.orgaoToOrgaoDTO(mock)).thenReturn(any(OrgaoDTO.class));

        OrgaosDTO result = processoService.findOrgaosByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findOrgaosByCPFSecretariaIsNull() {
        OrgaoDTO mock = new OrgaoDTO();

        when(orgao.getOrgaoPai()).thenReturn(null);
        when(orgaoMapper.orgaoToOrgaoDTO(orgao)).thenReturn(mock);
        when(orgaoMapper.orgaoToOrgaoDTO(orgao)).thenReturn(mock);

        OrgaosDTO result = processoService.findOrgaosByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findPermissaoByCPF() {
        Perfil analista = new Perfil();
        Perfil gestor = new Perfil();
        Perfil unidade = new Perfil();
        Perfil nucleo = new Perfil();
        Perfil subcomite = new Perfil();
        Perfil comite = new Perfil();

        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(analista);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(gestor);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Unidade")).thenReturn(unidade);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Núcleo")).thenReturn(nucleo);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Subcomitê")).thenReturn(subcomite);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Comitê")).thenReturn(comite);

        PermissaoProcessoDTO result = processoService.findPermissaoByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findPermissaoByCPFAnalistaIsNullAndGestorIsNullAndUnidadeIsNull() {
        Perfil nucleo = new Perfil();
        Perfil subcomite = new Perfil();
        Perfil comite = new Perfil();

        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Núcleo")).thenReturn(nucleo);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Subcomitê")).thenReturn(subcomite);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Comitê")).thenReturn(comite);

        PermissaoProcessoDTO result = processoService.findPermissaoByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findPermissaoByCPFNucleoIsNullAndSubcomiteIsNullAndComiteIsNull() {
        Perfil analista = new Perfil();
        Perfil gestor = new Perfil();
        Perfil unidade = new Perfil();

        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(analista);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(gestor);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Unidade")).thenReturn(unidade);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Núcleo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Subcomitê")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Comitê")).thenReturn(null);

        PermissaoProcessoDTO result = processoService.findPermissaoByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findPermissaoByCPFAllNull() {

        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Núcleo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Subcomitê")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(CPF, "Comitê")).thenReturn(null);

        PermissaoProcessoDTO result = processoService.findPermissaoByCPF(CPF);
        assertNotNull(result);
    }

    @Test
    public void findAllEventosRiscoPageable() {
        when(eventoRiscoRepository.findByIdentificacaoProcessoIdOrderByIdAsc(PROCESSO_ID, pageable)).thenReturn(eventoRiscoPage);
        when(eventoRiscoPage.map(any(Converter.class))).thenReturn(eventoRiscoDTOPage);

        Page<EventoRiscoDTO> result = processoService.findAllEventosRisco(this.pageable, PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void findEventoRisco() {
        EventoRiscoDTO result = processoService.findEventoRisco(EVENTO_RISCO_ID);
        assertNotNull(result);
    }

    @Test
    public void deleteEventoRisco() {
        processoService.deleteEventoRisco(EVENTO_RISCO_ID);
    }

    @Test
    public void saveEventoRiscoIsEmpty() {
        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(eventoRiscoDTO)).thenReturn(eventoRisco);
        when(eventoRiscoDTO.getIdentificacao()).thenReturn(identificacaoDTO);
        when(identificacaoDTO.getProcesso()).thenReturn(processoDTO);
        when(identificacaoRepository.findByProcessoId(anyLong())).thenReturn(identificacao);
        when(orgaoRepository.findByUsuarioCPF(anyString())).thenReturn(orgao);
        when(eventoRisco.getEvento()).thenReturn(evento);
        when(evento.getId()).thenReturn(null);
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
        when(eventoRisco.getControles()).thenReturn(null);
        when(eventoRiscoRepository.save(any(EventoRisco.class))).thenReturn(eventoRisco);
        when(eventoRiscoMapper.eventoRiscoToEventoRiscoDTO(any(EventoRisco.class))).thenReturn(eventoRiscoDTO);

        EventoRiscoDTO result = processoService.saveEventoRisco(eventoRiscoDTO, CPF);
        assertNotNull(result);
    }

    @Test
    public void saveEventoRiscoHasEventoHasCausasHasConsequenciasHasControleEventosHasRespostas() {
        EventoCausa eventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        EventoConsequencia eventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        ControleEvento controleEvento = new ControleEvento();
        Controle newControle = new Controle();
        PlanoControle planoControle = new PlanoControle();
        CalculoRisco calculoRisco = new CalculoRisco();

        eventoCausa.setCausa(newCausa);
        eventoConsequencia.setConsequencia(newConsequencia);
        controleEvento.setControle(newControle);
        planoControle.setControle(newControle);

        List<EventoCausa> eventoCausaList = new ArrayList<>();
        eventoCausaList.add(eventoCausa);

        List<EventoConsequencia> eventoConsequenciaList = new ArrayList<>();
        eventoConsequenciaList.add(eventoConsequencia);

        List<ControleEvento> controleEventoList = new ArrayList<>();
        controleEventoList.add(controleEvento);

        List<PlanoControle> planoControleList = new ArrayList<>();
        planoControleList.add(planoControle);

        List<PesoEventoRisco> pesoEventoRiscoList = new ArrayList<>();

        calculoRisco.setPesos(pesoEventoRiscoList);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(eventoRiscoDTO)).thenReturn(eventoRisco);
        when(eventoRiscoDTO.getIdentificacao()).thenReturn(identificacaoDTO);
        when(identificacaoDTO.getProcesso()).thenReturn(processoDTO);
        when(orgaoRepository.findByUsuarioCPF(anyString())).thenReturn(orgao);
        when(eventoRisco.getEvento()).thenReturn(evento);
        when(eventoRisco.getCausas()).thenReturn(eventoCausaList);
        when(eventoRisco.getConsequencias()).thenReturn(eventoConsequenciaList);
        when(eventoRisco.getControleEventos()).thenReturn(controleEventoList);
        when(eventoRisco.getControles()).thenReturn(planoControleList);
        when(eventoRisco.getCalculoRiscoInerente()).thenReturn(calculoRisco);
        when(eventoRisco.getCalculoRiscoResidual()).thenReturn(calculoRisco);

        when(calculoRiscoRepository.save(any(CalculoRisco.class))).thenReturn(calculoRisco);
        when(causaRepository.save(any(Causa.class))).thenReturn(newCausa);
        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(newConsequencia);
        when(controleRepository.save(any(Controle.class))).thenReturn(newControle);
        when(eventoRiscoRepository.save(any(EventoRisco.class))).thenReturn(eventoRisco);
        when(eventoRiscoRepository.findOne(eventoRisco.getId())).thenReturn(eventoRisco);
        when(eventoRiscoMapper.eventoRiscoToEventoRiscoDTO(any(EventoRisco.class))).thenReturn(eventoRiscoDTO);

        EventoRiscoDTO result = processoService.saveEventoRisco(eventoRiscoDTO, CPF);
        assertNotNull(result);
    }

    @Test
    public void findEventoByDescricaoAndCPF() {
        when(eventoCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, 1L)).thenReturn(anyListOf(Evento.class));
        when(eventoMapper.eventosToEventoDTOs(eventoList)).thenReturn(eventoDTOList);

        List<EventoDTO> result = processoService.findEventoByDescricaoAndCPF(DESCRICAO, CPF);
        assertNotNull(result);
    }

    @Test
    public void findCausaByDescricaoAndCPF() {
        when(causaCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, 1L)).thenReturn(anyListOf(Causa.class));
        when(causaMapper.causasToCausaDTOs(causaList)).thenReturn(causaDTOList);

        List<CausaDTO> result = processoService.findCausaByDescricaoAndCPF(DESCRICAO, CPF);
        assertNotNull(result);
    }

    @Test
    public void findConsequenciaByDescricaoAndCPF() {
        when(consequenciaCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, 1L)).thenReturn(anyListOf(Consequencia.class));
        when(consequenciaMapper.consequenciasToConsequenciaDTOs(consequenciaList)).thenReturn(consequenciaDTOList);

        List<ConsequenciaDTO> result = processoService.findConsequenciaByDescricaoAndCPF(DESCRICAO, CPF);
        assertNotNull(result);
    }

    @Test
    public void findAllCategoria() {
        when(categoriaRepository.findByStatusTrueOrderByDescricaoAsc()).thenReturn(categoriaList);
        when(categoriaMapper.categoriasToCategoriaDTOs(categoriaList)).thenReturn(categoriaDTOList);

        List<CategoriaDTO> result = processoService.findAllCategoria();
        assertNotNull(result);
    }

    @Test
    public void findAllNatureza() {
        when(naturezaRepository.findByStatusTrueOrderByDescricaoAsc()).thenReturn(naturezaList);
        when(naturezaMapper.naturezasToNaturezaDTOs(naturezaList)).thenReturn(naturezaDTOList);

        List<NaturezaDTO> result = processoService.findAllNatureza();
        assertNotNull(result);
    }

    @Test
    public void verificarEvento() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(eventoRiscoDTO)).thenReturn(eventoRisco);
        when(eventoRiscoRepository.findOne(eventoRisco.getId())).thenReturn(newEventoRisco);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoRiscoRepository.save(newEventoRisco)).thenReturn(newEventoRisco);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoDescricaoIsEquals() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoRiscoRepository.save(newEventoRisco)).thenReturn(newEventoRisco);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoNucleoNotNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarEventoNucleoNotNullAndOrgaoNotNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoUnidadeNotNullOrgaoIsNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoUnidadeNotNullAndProcessoIsNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoUnidadeNotNullAndProcessoSizeOne() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByEventoId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoUnidadeNotNullAndProcessoSizeMoreOne() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByEventoId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarEventoAnalistaNotNullOrgaoNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoAnalistaNotNullAndProcessoIsNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoAnalistaNotNullAndProcessoSizeOne() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByEventoId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoAnalistaNotNullAndProcessoSizeMoreOne() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEvento.setOrgao(orgao);
        newEventoRisco.setEvento(newEvento);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByEventoId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void verificarEventoGestorNotNullAndAnalistaNotNullOrgaoNull() {
        EventoRisco newEventoRisco = new EventoRisco();
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);
        newEventoRisco.setEvento(newEvento);

        when(eventoRiscoMapper.eventoRiscoDTOToEventoRisco(any(EventoRiscoDTO.class))).thenReturn(newEventoRisco);
        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(newEventoRisco);
        when(eventoRepository.findOne(anyLong())).thenReturn(newEvento);
        when(eventoRiscoDTO.getEvento()).thenReturn(eventoDTO);
        when(eventoDTO.getId()).thenReturn(1L);
        when(eventoDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Gestor do Processo")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoRiscoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarEvento(eventoRiscoDTO);
        assertNull(result);
    }

    @Test
    public void atualizarEvento() {
        when(eventoRepository.findOne(anyLong())).thenReturn(evento);
        when(eventoMapper.eventoToEventoDTO(any(Evento.class))).thenReturn(eventoDTO);

        EventoDTO result = processoService.atualizarEvento(eventoDTO);
        assertNotNull(result);
    }

    @Test
    public void substituirEvento() {
        EventoDTO newEventoDTO = new EventoDTO();
        newEventoDTO.setDescricao(DESCRICAO);

        when(eventoRiscoRepository.findOne(anyLong())).thenReturn(eventoRisco);
        when(eventoRiscoDTO.getEvento()).thenReturn(newEventoDTO);
        when(eventoRiscoMapper.eventoRiscoToEventoRiscoDTO(any(EventoRisco.class))).thenReturn(eventoRiscoDTO);

        EventoRiscoDTO result = processoService.substituirEvento(eventoRiscoDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarCausa() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(eventoCausaDTO)).thenReturn(eventoCausa);
        when(eventoCausaRepository.findOne(eventoCausa.getId())).thenReturn(newEventoCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(eventoCausaRepository.save(newEventoCausa)).thenReturn(newEventoCausa);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaDescricaoIsEquals() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoCausaRepository.save(newEventoCausa)).thenReturn(newEventoCausa);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaNucleoNotNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarCausaNucleoNotNullAndOrgaoNotNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaUnidadeNotNullOrgaoIsNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaUnidadeNotNullAndProcessoIsNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaUnidadeNotNullAndProcessoSizeOne() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByCausaId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaUnidadeNotNullAndProcessoSizeMoreOne() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByCausaId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarCausaAnalistaNotNullOrgaoNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaAnalistaNotNullAndProcessoIsNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaAnalistaNotNullAndProcessoSizeOne() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByCausaId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaAnalistaNotNullAndProcessoSizeMoreOne() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newCausa.setOrgao(orgao);
        newEventoCausa.setCausa(newCausa);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByCausaId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void verificarCausaGestorNotNullAndAnalistaNotNullOrgaoNull() {
        EventoCausa newEventoCausa = new EventoCausa();
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);
        newEventoCausa.setCausa(newCausa);

        when(eventoCausaMapper.eventoCausaDTOToEventoCausa(any(EventoCausaDTO.class))).thenReturn(newEventoCausa);
        when(eventoCausaRepository.findOne(anyLong())).thenReturn(newEventoCausa);
        when(causaRepository.findOne(anyLong())).thenReturn(newCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(causaDTO);
        when(causaDTO.getId()).thenReturn(1L);
        when(causaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Gestor do Processo")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoCausaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarCausa(eventoCausaDTO);
        assertNull(result);
    }

    @Test
    public void atualizarCausa() {
        when(causaRepository.findOne(anyLong())).thenReturn(causa);
        when(causaMapper.causaToCausaDTO(any(Causa.class))).thenReturn(causaDTO);

        CausaDTO result = processoService.atualizarCausa(causaDTO);
        assertNotNull(result);
    }

    @Test
    public void substituirCausa() {
        CausaDTO newCausaDTO = new CausaDTO();
        newCausaDTO.setDescricao(DESCRICAO);

        when(eventoCausaRepository.findOne(anyLong())).thenReturn(eventoCausa);
        when(eventoCausaDTO.getCausa()).thenReturn(newCausaDTO);
        when(eventoCausaMapper.eventoCausaToEventoCausaDTO(any(EventoCausa.class))).thenReturn(eventoCausaDTO);

        EventoCausaDTO result = processoService.substituirCausa(eventoCausaDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarConsequencia() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(eventoConsequenciaDTO)).thenReturn(eventoConsequencia);
        when(eventoConsequenciaRepository.findOne(eventoConsequencia.getId())).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(eventoConsequenciaRepository.save(newEventoConsequencia)).thenReturn(newEventoConsequencia);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaDescricaoIsEquals() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoConsequenciaRepository.save(newEventoConsequencia)).thenReturn(newEventoConsequencia);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaNucleoNotNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarConsequenciaNucleoNotNullAndOrgaoNotNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaUnidadeNotNullOrgaoIsNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaUnidadeNotNullAndProcessoIsNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaUnidadeNotNullAndProcessoSizeOne() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaUnidadeNotNullAndProcessoSizeMoreOne() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarConsequenciaAnalistaNotNullOrgaoNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaAnalistaNotNullAndProcessoIsNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaAnalistaNotNullAndProcessoSizeOne() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaAnalistaNotNullAndProcessoSizeMoreOne() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newConsequencia.setOrgao(orgao);
        newEventoConsequencia.setConsequencia(newConsequencia);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByConsequenciaId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void verificarConsequenciaGestorNotNullAndAnalistaNotNullOrgaoNull() {
        EventoConsequencia newEventoConsequencia = new EventoConsequencia();
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);
        newEventoConsequencia.setConsequencia(newConsequencia);

        when(eventoConsequenciaMapper.eventoConsequenciaDTOToEventoConsequencia(any(EventoConsequenciaDTO.class))).thenReturn(newEventoConsequencia);
        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(newEventoConsequencia);
        when(consequenciaRepository.findOne(anyLong())).thenReturn(newConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(consequenciaDTO);
        when(consequenciaDTO.getId()).thenReturn(1L);
        when(consequenciaDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Gestor do Processo")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(eventoConsequenciaDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarConsequencia(eventoConsequenciaDTO);
        assertNull(result);
    }

    @Test
    public void atualizarConsequencia() {
        when(consequenciaRepository.findOne(anyLong())).thenReturn(consequencia);
        when(consequenciaMapper.consequenciaToConsequenciaDTO(any(Consequencia.class))).thenReturn(consequenciaDTO);

        ConsequenciaDTO result = processoService.atualizarConsequencia(consequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void substituirConsequencia() {
        ConsequenciaDTO newConsequenciaDTO = new ConsequenciaDTO();
        newConsequenciaDTO.setDescricao(DESCRICAO);

        when(eventoConsequenciaRepository.findOne(anyLong())).thenReturn(eventoConsequencia);
        when(eventoConsequenciaDTO.getConsequencia()).thenReturn(newConsequenciaDTO);
        when(eventoConsequenciaMapper.eventoConsequenciaToEventoConsequenciaDTO(any(EventoConsequencia.class))).thenReturn(eventoConsequenciaDTO);

        EventoConsequenciaDTO result = processoService.substituirConsequencia(eventoConsequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void searchOrgaoByNome() {
        List<String> stringList = new ArrayList<>();

        when(orgaoCustomRepositorio.searchByNome(DESCRICAO)).thenReturn(stringList);

        List<String> result = processoService.searchOrgaoByNome(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void searchByDescricao() {
        List<String> stringList = new ArrayList<>();

        when(processoCustomRepositorio.searchByDescricao(DESCRICAO)).thenReturn(stringList);

        List<String> result = processoService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

    @Test
    public void getStatus() {
        List<StatusProcessoDTO> statusProcessoDTOList = new ArrayList<>();
        List<StatusProcesso> statusProcessoList = new ArrayList<>();

        when(statusProcessoMapper.statusProcessosToStatusProcessoDTOs(statusProcessoList)).thenReturn(statusProcessoDTOList);

        List<StatusProcessoDTO> result = processoService.getStatus();
        assertNotNull(result);
    }

    @Test
    public void uploadFileEmpty() throws IOException {
        String[] nome = {"teste", "teste 1"};

        MultipartFile[] files = {};

        List<ArquivoAnexoDTO> arquivoAnexoDTOList = new ArrayList<>();

        when(arquivoAnexoMapper.arquivoAnexosToArquivoAnexoDTOs(anyListOf(ArquivoAnexo.class))).thenReturn(arquivoAnexoDTOList);

        List<ArquivoAnexoDTO> result = processoService.uploadFile(files, nome);
        assertNotNull(result);
    }

    @Test
    public void uploadFile() throws IOException {
        String[] nome = {"teste", "teste 1"};

        byte[] bites = {12};

        MultipartFile[] files = {multipartFile};

        List<ArquivoAnexoDTO> arquivoAnexoDTOList = new ArrayList<>();

        when(arquivoAnexoMapper.arquivoAnexosToArquivoAnexoDTOs(anyListOf(ArquivoAnexo.class))).thenReturn(arquivoAnexoDTOList);
        when(multipartFile.getBytes()).thenReturn(bites);
        when(multipartFile.getOriginalFilename()).thenReturn("http://www.site.com.br");

        List<ArquivoAnexoDTO> result = processoService.uploadFile(files, nome);
        assertNotNull(result);
    }

    @Test
    public void getAnexoById() {
        ArquivoAnexo arquivoAnexo = new ArquivoAnexo();

        when(arquivoAnexoRepository.findOne(ID)).thenReturn(arquivoAnexo);

        ArquivoAnexo result = processoService.getAnexoById(ID);
        assertNotNull(result);
    }

    @Test
    public void findControleByDescricaoAndCPF() {
        List<Controle> controleList = new ArrayList<>();
        List<ControleDTO> controleDTOList = new ArrayList<>();

        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(controleCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, orgao.getId())).thenReturn(controleList);
        when(controleMapper.controlesToControleDTOs(controleList)).thenReturn(controleDTOList);

        List<ControleDTO> result = processoService.findControleByDescricaoAndCPF(DESCRICAO, CPF);
        assertNotNull(result);
    }

    @Test
    public void findAllDesenhos() {
        List<Desenho> desenhoList = new ArrayList<>();
        List<DesenhoDTO> desenhoDTOList = new ArrayList<>();

        when(desenhoRepository.findAll()).thenReturn(desenhoList);
        when(desenhoMapper.desenhosToDesenhoDTOs(desenhoList)).thenReturn(desenhoDTOList);

        List<DesenhoDTO> result = processoService.findAllDesenhos();
        assertNotNull(result);
    }

    @Test
    public void findAllOperacoes() {
        List<Operacao> operacaoList = new ArrayList<>();
        List<OperacaoDTO> operacaoDTOList = new ArrayList<>();

        when(operacaoRepository.findAll()).thenReturn(operacaoList);
        when(operacaoMapper.operacaosToOperacaoDTOs(operacaoList)).thenReturn(operacaoDTOList);

        List<OperacaoDTO> result = processoService.findAllOperacoes();
        assertNotNull(result);
    }

    @Test
    public void verificarControle() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(controleEventoDTO)).thenReturn(controleEvento);
        when(controleEventoRepository.findOne(controleEvento.getId())).thenReturn(newControleEvento);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleEventoRepository.save(newControleEvento)).thenReturn(newControleEvento);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleDescricaoIsEquals() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);
        when(controleEventoRepository.save(newControleEvento)).thenReturn(newControleEvento);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleNucleoNotNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarControleNucleoNotNullAndOrgaoNotNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(perfil);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleUnidadeNotNullOrgaoIsNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleUnidadeNotNullAndProcessoIsNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleUnidadeNotNullAndProcessoSizeOne() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByControleId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleUnidadeNotNullAndProcessoSizeMoreOne() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByControleId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNotNull(result);
    }

    @Test
    public void verificarControleAnalistaNotNullOrgaoNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleAnalistaNotNullAndProcessoIsNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleAnalistaNotNullAndProcessoSizeOne() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByControleId(anyLong())).thenReturn(processoList);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleAnalistaNotNullAndProcessoSizeMoreOne() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControle.setOrgao(orgao);
        newControleEvento.setControle(newControle);

        List<Processo> processoList = new ArrayList<>();
        processoList.add(processo);
        processoList.add(processo);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(processoRepository.findByControleId(anyLong())).thenReturn(processoList);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void verificarControleGestorNotNullAndAnalistaNotNullOrgaoNull() {
        ControleEvento newControleEvento = new ControleEvento();
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);
        newControleEvento.setControle(newControle);

        when(controleEventoMapper.controleEventoDTOToControleEvento(any(ControleEventoDTO.class))).thenReturn(newControleEvento);
        when(controleEventoRepository.findOne(anyLong())).thenReturn(newControleEvento);
        when(controleRepository.findOne(anyLong())).thenReturn(newControle);
        when(controleEventoDTO.getControle()).thenReturn(controleDTO);
        when(controleDTO.getId()).thenReturn(1L);
        when(controleDTO.getDescricao()).thenReturn("DESCRICAO 2");
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Gestor do Processo")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Analista de Risco")).thenReturn(perfil);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Unidade")).thenReturn(null);
        when(permissaoRepository.findPerfilByUsuarioIdAndNomeIgnoreCase(controleEventoDTO.getCpf(), "Núcleo")).thenReturn(null);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(perfilMapper.perfilToPerfilDTO(perfil)).thenReturn(perfilDTO);

        PerfilDTO result = processoService.verificarControle(controleEventoDTO);
        assertNull(result);
    }

    @Test
    public void atualizarControle() {
        when(controleRepository.findOne(anyLong())).thenReturn(controle);
        when(controleMapper.controleToControleDTO(any(Controle.class))).thenReturn(controleDTO);

        ControleDTO result = processoService.atualizarControle(controleDTO);
        assertNotNull(result);
    }

    @Test
    public void substituirControle() {
        ControleDTO newControleDTO = new ControleDTO();
        newControleDTO.setDescricao(DESCRICAO);

        when(controleEventoRepository.findOne(anyLong())).thenReturn(controleEvento);
        when(controleEventoDTO.getControle()).thenReturn(newControleDTO);
        when(controleEventoMapper.controleEventoToControleEventoDTO(any(ControleEvento.class))).thenReturn(controleEventoDTO);

        ControleEventoDTO result = processoService.substituirControle(controleEventoDTO);
        assertNotNull(result);
    }

    @Test
    public void getCalculadoraInerenteByProcessoId() {
        when(calculadoraRepository.findByTipoNomeIgnoreCaseAndProcessoId("Calculadora do Risco Inerente", PROCESSO_ID)).thenReturn(calculadora);
        when(calculadoraMapper.calculadoraToCalculadoraDTO(any(Calculadora.class))).thenReturn(calculadoraDTO);

        CalculadoraDTO result = processoService.getCalculadoraInerenteByProcessoId(PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void getCalculadoraResidualByProcessoId() {
        when(calculadoraRepository.findByTipoNomeIgnoreCaseAndProcessoId("Calculadora do Risco Residual", PROCESSO_ID)).thenReturn(calculadora);
        when(calculadoraMapper.calculadoraToCalculadoraDTO(any(Calculadora.class))).thenReturn(calculadoraDTO);

        CalculadoraDTO result = processoService.getCalculadoraResidualByProcessoId(PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void findAllEventosRisco() {
        List<EventoRiscoDTO> eventoRiscoDTOList = new ArrayList<>();

        when(eventoRiscoMapper.eventoRiscosToEventoRiscoDTOs(anyListOf(EventoRisco.class))).thenReturn(eventoRiscoDTOList);

        List<EventoRiscoDTO> result = processoService.findAllEventosRisco(PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void salvarCalculoIsNull() {
        processoService.salvarCalculo(identificacaoDTO);
    }

    @Test
    public void salvarCalculoEventoListNotEmptyAndCalculoNotNull() {
        List<EventoRisco> eventoRiscoList = new ArrayList<>();
        eventoRiscoList.add(eventoRisco);

        when(eventoRisco.getCalculoRiscoInerente()).thenReturn(calculoRisco);
        when(eventoRisco.getCalculoRiscoResidual()).thenReturn(calculoRisco);
        when(eventoRiscoRepository.findOne(eventoRisco.getId())).thenReturn(eventoRisco);
        when(eventoRiscoMapper.eventoRiscoDTOsToEventoRiscos(identificacaoDTO.getEventos())).thenReturn(eventoRiscoList);

        processoService.salvarCalculo(identificacaoDTO);
    }

    @Test
    public void salvarCalculoEventoListNotEmptyAndCalculoNotNullAndHasPesos() {
        List<EventoRisco> eventoRiscoList = new ArrayList<>();
        eventoRiscoList.add(eventoRisco);

        List<PesoEventoRisco> pesoEventoRiscoList = new ArrayList<>();
        pesoEventoRiscoList.add(pesoEventoRisco);

        when(eventoRisco.getCalculoRiscoInerente()).thenReturn(calculoRisco);
        when(eventoRisco.getCalculoRiscoResidual()).thenReturn(calculoRisco);
        when(calculoRisco.getPesos()).thenReturn(pesoEventoRiscoList);
        when(eventoRiscoRepository.findOne(eventoRisco.getId())).thenReturn(eventoRisco);
        when(eventoRiscoMapper.eventoRiscoDTOsToEventoRiscos(identificacaoDTO.getEventos())).thenReturn(eventoRiscoList);

        processoService.salvarCalculo(identificacaoDTO);
    }

    @Test
    public void getIgnorarRiscoInerenteByProcesso() {
        when(avaliacaoRepository.findByProcessoId(PROCESSO_ID)).thenReturn(avaliacao);
        when(avaliacao.getIgnorarRiscoInerente()).thenReturn(true);

        Boolean result = processoService.getIgnorarRiscoInerenteByProcesso(PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void alterarIgnorarRiscoInerente() {
        when(avaliacaoRepository.findByProcessoId(PROCESSO_ID)).thenReturn(avaliacao);
        when(avaliacao.getIgnorarRiscoInerente()).thenReturn(true);
        when(avaliacaoRepository.save(avaliacao)).thenReturn(avaliacao);

        Boolean result = processoService.alterarIgnorarRiscoInerente(PROCESSO_ID);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaEventoCPFIsNull() {
        when(eventoDTO.getId()).thenReturn(null);
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);

        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaEvento(eventoDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaEventoCPFIsNotNull() {
        when(eventoDTO.getId()).thenReturn(null);
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoDTO.getCpf()).thenReturn(CPF);

        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaEvento(eventoDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaEventoIdIsNotNull() {
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoDTO.getCpf()).thenReturn(CPF);

        when(eventoRepository.findOne(anyLong())).thenReturn(evento);
        when(evento.getDescricao()).thenReturn(DESCRICAO);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaEvento(eventoDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaEventoPersistidoNotEqual() {
        when(eventoDTO.getDescricao()).thenReturn(DESCRICAO);
        when(eventoDTO.getCpf()).thenReturn(CPF);

        when(eventoRepository.findOne(anyLong())).thenReturn(evento);
        when(evento.getDescricao()).thenReturn("DESCRICAO 1");
        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaEvento(eventoDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaCausaCPFIsNull() {
        when(causaDTO.getId()).thenReturn(null);
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);

        when(causaRepository.save(any(Causa.class))).thenReturn(causa);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);
        when(tipoTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(tipoTaxonomia);
        when(statusTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(statusTaxonomia);

        TaxonomiaDTO result = processoService.salvarTaxonomiaCausa(causaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaCausaCPFIsNotNull() {
        when(causaDTO.getId()).thenReturn(null);
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(causaDTO.getCpf()).thenReturn(CPF);

        when(causaRepository.save(any(Causa.class))).thenReturn(causa);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(tipoTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(tipoTaxonomia);
        when(statusTaxonomiaRepository.findByNomeIgnoreCase(anyString())).thenReturn(statusTaxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaCausa(causaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaCausaIdIsNotNull() {
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(causaDTO.getCpf()).thenReturn(CPF);

        when(causaRepository.findOne(anyLong())).thenReturn(causa);
        when(causa.getDescricao()).thenReturn(DESCRICAO);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaCausa(causaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaCausaPersistidoNotEqual() {
        when(causaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(causaDTO.getCpf()).thenReturn(CPF);

        when(causaRepository.findOne(anyLong())).thenReturn(causa);
        when(causa.getDescricao()).thenReturn("DESCRICAO 1");
        when(causaRepository.save(any(Causa.class))).thenReturn(causa);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaCausa(causaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaConsequenciaCPFIsNull() {
        when(consequenciaDTO.getId()).thenReturn(null);
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);

        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(consequencia);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaConsequencia(consequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaConsequenciaCPFIsNotNull() {
        when(consequenciaDTO.getId()).thenReturn(null);
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(consequenciaDTO.getCpf()).thenReturn(CPF);

        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(consequencia);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaConsequencia(consequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaConsequenciaIdIsNotNull() {
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(consequenciaDTO.getCpf()).thenReturn(CPF);

        when(consequenciaRepository.findOne(anyLong())).thenReturn(consequencia);
        when(consequencia.getDescricao()).thenReturn(DESCRICAO);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaConsequencia(consequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaConsequenciaPersistidoNotEqual() {
        when(consequenciaDTO.getDescricao()).thenReturn(DESCRICAO);
        when(consequenciaDTO.getCpf()).thenReturn(CPF);

        when(consequenciaRepository.findOne(anyLong())).thenReturn(consequencia);
        when(consequencia.getDescricao()).thenReturn("DESCRICAO 1");
        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(consequencia);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaConsequencia(consequenciaDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaControleCPFIsNull() {
        when(controleDTO.getId()).thenReturn(null);
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);

        when(controleRepository.save(any(Controle.class))).thenReturn(controle);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaControle(controleDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaControleCPFIsNotNull() {
        when(controleDTO.getId()).thenReturn(null);
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);
        when(controleDTO.getCpf()).thenReturn(CPF);

        when(controleRepository.save(any(Controle.class))).thenReturn(controle);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaControle(controleDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaControleIdIsNotNull() {
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);
        when(controleDTO.getCpf()).thenReturn(CPF);

        when(controleRepository.findOne(anyLong())).thenReturn(controle);
        when(controle.getDescricao()).thenReturn(DESCRICAO);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaControle(controleDTO);
        assertNotNull(result);
    }

    @Test
    public void salvarTaxonomiaControlePersistidoNotEqual() {
        when(controleDTO.getDescricao()).thenReturn(DESCRICAO);
        when(controleDTO.getCpf()).thenReturn(CPF);

        when(controleRepository.findOne(anyLong())).thenReturn(controle);
        when(controle.getDescricao()).thenReturn("DESCRICAO 1");
        when(controleRepository.save(any(Controle.class))).thenReturn(controle);
        when(taxonomiaRepository.save(any(Taxonomia.class))).thenReturn(taxonomia);
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(taxonomia)).thenReturn(taxonomiaDTO);

        TaxonomiaDTO result = processoService.salvarTaxonomiaControle(controleDTO);
        assertNotNull(result);
    }

    @Test
    public void getProcessoEtapa() {

        when(eventoRiscoRepository.countByIdentificacaoProcessoId(anyLong())).thenReturn(1L);
        when(controleEventoRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(1L);
        when(calculoRiscoRepository.countNiveisByProcessoId(anyLong())).thenReturn(1L);
        when(respostaRiscoRepository.countByProcessoId(anyLong())).thenReturn(1L);
        when(planoControleRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(1L);

        ProcessoEtapaDTO result = processoService.getProcessoEtapa(1L);
        assertNotNull(result);
    }

    @Test
    public void getProcessoEtapa2() {

        when(eventoRiscoRepository.countByIdentificacaoProcessoId(anyLong())).thenReturn(0L);
        when(controleEventoRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(0L);
        when(calculoRiscoRepository.countNiveisByProcessoId(anyLong())).thenReturn(0L);
        when(respostaRiscoRepository.countByProcessoId(anyLong())).thenReturn(0L);
        when(planoControleRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(0L);

        ProcessoEtapaDTO result = processoService.getProcessoEtapa(0L);
        assertNotNull(result);
    }

    @Test
    public void getProcessoEtapa3() {

        when(eventoRiscoRepository.countByIdentificacaoProcessoId(anyLong())).thenReturn(0L);
        when(controleEventoRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(1L);
        when(calculoRiscoRepository.countNiveisByProcessoId(anyLong())).thenReturn(0L);
        when(respostaRiscoRepository.countByProcessoId(anyLong())).thenReturn(0L);
        when(planoControleRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(0L);

        ProcessoEtapaDTO result = processoService.getProcessoEtapa(0L);
        assertNotNull(result);
    }

    @Test
    public void getProcessoEtapa4() {

        when(eventoRiscoRepository.countByIdentificacaoProcessoId(anyLong())).thenReturn(0L);
        when(controleEventoRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(0L);
        when(calculoRiscoRepository.countNiveisByProcessoId(anyLong())).thenReturn(1L);
        when(respostaRiscoRepository.countByProcessoId(anyLong())).thenReturn(0L);
        when(planoControleRepository.countByEventoRiscoIdentificacaoProcessoId(anyLong())).thenReturn(0L);

        ProcessoEtapaDTO result = processoService.getProcessoEtapa(0L);
        assertNotNull(result);
    }

}
