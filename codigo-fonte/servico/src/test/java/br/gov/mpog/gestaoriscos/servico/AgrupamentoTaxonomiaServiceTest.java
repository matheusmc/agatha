package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.*;
import br.gov.mpog.gestaoriscos.modelo.dto.*;
import br.gov.mpog.gestaoriscos.repositorio.*;
import br.gov.mpog.gestaoriscos.repositorio.impl.CausaCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.ConsequenciaCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.repositorio.impl.EventoCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.AgrupamentoTaxonomiaServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.*;
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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by matheusbarbosa on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AgrupamentoTaxonomiaServiceTest {

    private static final String DESCRICAO = "TESTE";
    private static final String DESCRICAO_1 = "TESTE 1";
    private static final String CPF = "000.000.000-00";

    private static final String NOME = "TESTE";
    private static final Long INICIO = 1L;
    private static final Long FIM = 2L;
    private static final Long TIPO = 1L;

    @InjectMocks
    private AgrupamentoTaxonomiaServiceImpl agrupamentoTaxonomiaService;

    @Mock
    private AgrupamentoTaxonomiaRepository agrupamentoTaxonomiaRepository;

    @Mock
    private TipoTaxonomiaRepository tipoTaxonomiaRepository;

    @Mock
    private TaxonomiaRepository taxonomiaRepository;

    @Mock
    private EventoRiscoRepository eventoRiscoRepository;

    @Mock
    private EventoCausaRepository eventoCausaRepository;

    @Mock
    private EventoConsequenciaRepository eventoConsequenciaRepository;

    @Mock
    private ControleEventoRepository controleEventoRepository;

    @Mock
    private PlanoControleRepository planoControleRepository;

    @Mock
    private OrgaoRepository orgaoRepository;

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private CausaRepository causaRepository;

    @Mock
    private ControleRepository controleRepository;

    @Mock
    private ConsequenciaRepository consequenciaRepository;

    @Mock
    private CausaCustomRepositorioImpl causaCustomRepositorio;

    @Mock
    private ConsequenciaCustomRepositorioImpl consequenciaCustomRepositorio;

    @Mock
    private TaxonomiaCustomRepositorio taxonomiaCustomRepositorio;

    @Mock
    private AgrupamentoTaxonomiaCustomRepositorio agrupamentoTaxonomiaCustomRepositorio;

    @Mock
    private EventoCustomRepositorioImpl eventoCustomRepositorio;

    @Mock
    private ControleCustomRepositorio controleCustomRepositorio;

    @Mock
    private AgrupamentoTaxonomiaMapper agrupamentoTaxonomiaMapper;

    @Mock
    private TipoTaxonomiaMapper tipoTaxonomiaMapper;

    @Mock
    private TaxonomiaMapper taxonomiaMapper;

    @Mock
    private EventoMapper eventoMapper;

    @Mock
    private CausaMapper causaMapper;

    @Mock
    private ConsequenciaMapper consequenciaMapper;

    @Mock
    private ControleMapper controleMapper;

    @Mock
    private AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO;

    @Mock
    private AgrupamentoTaxonomia agrupamentoTaxonomia;

    @Mock
    private Page<AgrupamentoTaxonomia> pageAgrupamentoTaxonomia;

    @Mock
    private Page<AgrupamentoTaxonomiaDTO> pageAgrupamentoTaxonomiaDTO;

    @Mock
    private Taxonomia taxonomia;

    @Mock
    private Orgao orgao;

    @Mock
    private List<Evento> eventoList;

    @Mock
    private List<EventoDTO> eventoDTOList;

    @Mock
    private List<Taxonomia> taxonomiaList;

    @Mock
    private List<TaxonomiaDTO> taxonomiaDTOList;

    @Mock
    private List<TipoTaxonomia> tipoTaxonomiaList;

    @Mock
    private List<TipoTaxonomiaDTO> tipoTaxonomiaDTOList;

    @Mock
    private List<Causa> causaList;

    @Mock
    private List<CausaDTO> causaDTOList;

    @Mock
    private List<Consequencia> consequenciaList;

    @Mock
    private List<ConsequenciaDTO> consequenciaDTOList;

    @Mock
    private List<Controle> controleList;

    @Mock
    private List<ControleDTO> controleDTOList;

    @Mock
    private Pageable pageable;

    @Mock
    private StatusTaxonomiaRepository statusTaxonomiaRepository;

    @Test
    public void saveCaseEventoIsNull() throws Exception {
        initSaveCaseEvento(true, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseEventoNotEqualsTaxonomiaEvento() throws Exception {
        initSaveCaseEvento(false, true);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseEventoNotEqualsTaxonomiaDescricao() throws Exception {
        initSaveCaseEvento(false, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseCausaIsNull() throws Exception {
        initSaveCaseCausa(true, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseCausaNotEqualsTaxonomiaCausa() throws Exception {
        initSaveCaseCausa(false, true);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseCausaNotEqualsTaxonomiaDescricao() throws Exception {
        initSaveCaseCausa(false, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseConsequenciaIsNull() throws Exception {
        initSaveCaseConsequencia(true, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseConsequenciaNotEqualsTaxonomiaConsequencia() throws Exception {
        initSaveCaseConsequencia(false, true);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseConsequenciaNotEqualsTaxonomiaDescricao() throws Exception {
        initSaveCaseConsequencia(false, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseControleIsNull() throws Exception {
        initSaveCaseControle(true, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseControleNotEqualsTaxonomiaControle() throws Exception {
        initSaveCaseControle(false, true);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void saveCaseControleNotEqualsTaxonomiaDescricao() throws Exception {
        initSaveCaseControle(false, false);

        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = agrupamentoTaxonomiaService.save(this.agrupamentoTaxonomiaDTO);
        assertNotNull(agrupamentoTaxonomiaDTO);
    }

    @Test
    public void findAll() throws Exception {
        when(agrupamentoTaxonomiaCustomRepositorio.listarAgrupamentoTaxonomias(pageable, NOME, INICIO, FIM, TIPO)).thenReturn(pageAgrupamentoTaxonomia);
        when(pageAgrupamentoTaxonomia.map(any(Converter.class))).thenReturn(pageAgrupamentoTaxonomiaDTO);

        Page<AgrupamentoTaxonomiaDTO> agrupamentoTaxonomiaDTOs = agrupamentoTaxonomiaService.findAll(pageable, NOME, INICIO, FIM, TIPO);
        assertNotNull(agrupamentoTaxonomiaDTOs);
    }

    @Test
    public void searchByDescricao() throws Exception {
        List<String> descricaoList = new ArrayList<>();
        descricaoList.add(DESCRICAO);

        when(taxonomiaCustomRepositorio.searchByDescricao(DESCRICAO, Boolean.FALSE)).thenReturn(descricaoList);

        List<String> descricaos = agrupamentoTaxonomiaService.searchByDescricao(DESCRICAO);
        assertNotNull(descricaos);
    }

    @Test
    public void findAllTiposTaxonomia() throws Exception {
        when(tipoTaxonomiaRepository.findAll()).thenReturn(tipoTaxonomiaList);
        when(tipoTaxonomiaMapper.tipoTaxonomiasToTipoTaxonomiaDTOs(tipoTaxonomiaList)).thenReturn(tipoTaxonomiaDTOList);

        List<TipoTaxonomiaDTO> tipoTaxonomiaDTOs = agrupamentoTaxonomiaService.findAllTiposTaxonomia();
        assertNotNull(tipoTaxonomiaDTOs);
    }

    @Test
    public void getTaxonomiaBySearch() throws Exception {
        when(taxonomiaCustomRepositorio.findBySearch(DESCRICAO, TIPO)).thenReturn(taxonomiaList);
        when(taxonomiaMapper.taxonomiasToTaxonomiaDTOs(taxonomiaList)).thenReturn(taxonomiaDTOList);

        List<TaxonomiaDTO> taxonomiaDTOs = agrupamentoTaxonomiaService.getTaxonomiaBySearch(NOME, TIPO);
        assertNotNull(taxonomiaDTOs);
    }

    @Test
    public void getEventosBySearch() throws Exception {
        when(eventoCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, null)).thenReturn(eventoList);
        when(eventoMapper.eventosToEventoDTOs(eventoList)).thenReturn(eventoDTOList);

        List<EventoDTO> eventoDTOs = agrupamentoTaxonomiaService.getEventosBySearch(NOME);
        assertNotNull(eventoDTOs);
    }

    @Test
    public void getCausasBySearch() throws Exception {
        when(causaCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, null)).thenReturn(causaList);
        when(causaMapper.causasToCausaDTOs(causaList)).thenReturn(causaDTOList);

        List<CausaDTO> causaDTOs = agrupamentoTaxonomiaService.getCausasBySearch(NOME);
        assertNotNull(causaDTOs);
    }

    @Test
    public void getConsequenciasBySearch() throws Exception {
        when(consequenciaCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, null)).thenReturn(consequenciaList);
        when(consequenciaMapper.consequenciasToConsequenciaDTOs(consequenciaList)).thenReturn(consequenciaDTOList);

        List<ConsequenciaDTO> consequenciaDTOs = agrupamentoTaxonomiaService.getConsequenciasBySearch(NOME);
        assertNotNull(consequenciaDTOs);
    }

    @Test
    public void getControlesBySearch() throws Exception {
        when(controleCustomRepositorio.findBySearchAndOrgaoId(DESCRICAO, null)).thenReturn(controleList);
        when(controleMapper.controlesToControleDTOs(controleList)).thenReturn(controleDTOList);

        List<ControleDTO> controleDTOs = agrupamentoTaxonomiaService.getControlesBySearch(NOME);
        assertNotNull(controleDTOs);
    }

    private void initSaveCaseEvento(Boolean isNull, Boolean notEqualTaxonomiaEvento) {
        Evento newEvento = new Evento();
        newEvento.setId(1L);
        newEvento.setDescricao(DESCRICAO);

        TipoTaxonomia tipoTaxonomia = new TipoTaxonomia();
        tipoTaxonomia.setNome("Evento");

        Taxonomia newTaxonomia = new Taxonomia();
        newTaxonomia.setTipo(tipoTaxonomia);
        newTaxonomia.setEvento(newEvento);
        newTaxonomia.setDescricao(DESCRICAO);

        List<Taxonomia> taxonomias = new ArrayList<>();
        taxonomias.add(newTaxonomia);

        EventoRisco newEventoRisco = new EventoRisco();

        List<EventoRisco> eventoRiscos = new ArrayList<>();
        eventoRiscos.add(newEventoRisco);

        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaDTOToAgrupamentoTaxonomia(agrupamentoTaxonomiaDTO)).thenReturn(agrupamentoTaxonomia);

        if(isNull){
            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(taxonomia);
            when(taxonomia.getDescricao()).thenReturn(DESCRICAO);
        } else {
            Evento newEvento1 = new Evento();
            newEvento1.setId(1L);

            if(notEqualTaxonomiaEvento) {
                newEvento1.setDescricao(DESCRICAO_1);
                when(eventoRepository.findOne(1L)).thenReturn(newEvento1);
            } else {
                newEvento.setDescricao(DESCRICAO_1);
                when(eventoRepository.findOne(1L)).thenReturn(newEvento);
            }

            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(newTaxonomia);
        }

        when(agrupamentoTaxonomia.getTaxonomias()).thenReturn(taxonomias);
        when(agrupamentoTaxonomiaDTO.getCpf()).thenReturn(CPF);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(eventoRepository.save(any(Evento.class))).thenReturn(newEvento);
        when(eventoRiscoRepository.findByEventoId(1L)).thenReturn(eventoRiscos);
        when(taxonomiaRepository.save(taxonomia)).thenReturn(any(Taxonomia.class));
        when(agrupamentoTaxonomiaRepository.save(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomia);
        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaToAgrupamentoTaxonomiaDTO(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomiaDTO);
    }

    private void initSaveCaseCausa(Boolean isNull, Boolean notEqualTaxonomiaCausa) {
        Causa newCausa = new Causa();
        newCausa.setId(1L);
        newCausa.setDescricao(DESCRICAO);

        TipoTaxonomia tipoTaxonomia = new TipoTaxonomia();
        tipoTaxonomia.setNome("Causa");

        Taxonomia newTaxonomia = new Taxonomia();
        newTaxonomia.setTipo(tipoTaxonomia);
        newTaxonomia.setCausa(newCausa);
        newTaxonomia.setDescricao(DESCRICAO);

        List<Taxonomia> taxonomias = new ArrayList<>();
        taxonomias.add(newTaxonomia);

        EventoCausa eventoCausa = new EventoCausa();

        List<EventoCausa> eventoCausas = new ArrayList<>();
        eventoCausas.add(eventoCausa);

        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaDTOToAgrupamentoTaxonomia(agrupamentoTaxonomiaDTO)).thenReturn(agrupamentoTaxonomia);

        if(isNull){
            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(taxonomia);
            when(taxonomia.getDescricao()).thenReturn(DESCRICAO);
        } else {
            Causa newCausa1 = new Causa();
            newCausa1.setId(1L);

            if(notEqualTaxonomiaCausa) {
                newCausa1.setDescricao(DESCRICAO_1);
                when(causaRepository.findOne(1L)).thenReturn(newCausa1);
            } else {
                newCausa.setDescricao(DESCRICAO_1);
                when(causaRepository.findOne(1L)).thenReturn(newCausa);
            }

            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(newTaxonomia);
        }

        when(agrupamentoTaxonomia.getTaxonomias()).thenReturn(taxonomias);
        when(agrupamentoTaxonomiaDTO.getCpf()).thenReturn(CPF);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(causaRepository.save(any(Causa.class))).thenReturn(newCausa);
        when(eventoCausaRepository.findByCausaId(1L)).thenReturn(eventoCausas);
        when(taxonomiaRepository.save(taxonomia)).thenReturn(any(Taxonomia.class));
        when(agrupamentoTaxonomiaRepository.save(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomia);
        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaToAgrupamentoTaxonomiaDTO(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomiaDTO);
    }

    private void initSaveCaseConsequencia(Boolean isNull, Boolean notEqualTaxonomiaConsequencia) {
        Consequencia newConsequencia = new Consequencia();
        newConsequencia.setId(1L);
        newConsequencia.setDescricao(DESCRICAO);

        TipoTaxonomia tipoTaxonomia = new TipoTaxonomia();
        tipoTaxonomia.setNome("Consequência");

        Taxonomia newTaxonomia = new Taxonomia();
        newTaxonomia.setTipo(tipoTaxonomia);
        newTaxonomia.setConsequencia(newConsequencia);
        newTaxonomia.setDescricao(DESCRICAO);

        List<Taxonomia> taxonomias = new ArrayList<>();
        taxonomias.add(newTaxonomia);

        EventoConsequencia eventoConsequencia = new EventoConsequencia();

        List<EventoConsequencia> eventoConsequencias = new ArrayList<>();
        eventoConsequencias.add(eventoConsequencia);

        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaDTOToAgrupamentoTaxonomia(agrupamentoTaxonomiaDTO)).thenReturn(agrupamentoTaxonomia);

        if(isNull){
            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(taxonomia);
            when(taxonomia.getDescricao()).thenReturn(DESCRICAO);
        } else {
            Consequencia newConsequencia1 = new Consequencia();
            newConsequencia1.setId(1L);

            if(notEqualTaxonomiaConsequencia) {
                newConsequencia1.setDescricao(DESCRICAO_1);
                when(consequenciaRepository.findOne(1L)).thenReturn(newConsequencia1);
            } else {
                newConsequencia.setDescricao(DESCRICAO_1);
                when(consequenciaRepository.findOne(1L)).thenReturn(newConsequencia);
            }

            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(newTaxonomia);
        }

        when(agrupamentoTaxonomia.getTaxonomias()).thenReturn(taxonomias);
        when(agrupamentoTaxonomiaDTO.getCpf()).thenReturn(CPF);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(consequenciaRepository.save(any(Consequencia.class))).thenReturn(newConsequencia);
        when(eventoConsequenciaRepository.findByConsequenciaId(1L)).thenReturn(eventoConsequencias);
        when(taxonomiaRepository.save(taxonomia)).thenReturn(any(Taxonomia.class));
        when(agrupamentoTaxonomiaRepository.save(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomia);
        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaToAgrupamentoTaxonomiaDTO(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomiaDTO);
    }

    private void initSaveCaseControle(Boolean isNull, Boolean notEqualTaxonomiaControle) {
        Controle newControle = new Controle();
        newControle.setId(1L);
        newControle.setDescricao(DESCRICAO);

        TipoTaxonomia tipoTaxonomia = new TipoTaxonomia();
        tipoTaxonomia.setNome("Controle");

        Taxonomia newTaxonomia = new Taxonomia();
        newTaxonomia.setTipo(tipoTaxonomia);
        newTaxonomia.setControle(newControle);
        newTaxonomia.setDescricao(DESCRICAO);

        List<Taxonomia> taxonomias = new ArrayList<>();
        taxonomias.add(newTaxonomia);

        ControleEvento eventoControle = new ControleEvento();

        List<ControleEvento> eventoControles = new ArrayList<>();
        eventoControles.add(eventoControle);

        PlanoControle planoControle = new PlanoControle();

        List<PlanoControle> planoControles = new ArrayList<>();
        planoControles.add(planoControle);

        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaDTOToAgrupamentoTaxonomia(agrupamentoTaxonomiaDTO)).thenReturn(agrupamentoTaxonomia);

        if(isNull){
            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(taxonomia);
            when(taxonomia.getDescricao()).thenReturn(DESCRICAO);
        } else {
            Controle newControle1 = new Controle();
            newControle1.setId(1L);

            if(notEqualTaxonomiaControle) {
                newControle1.setDescricao(DESCRICAO_1);
                when(controleRepository.findOne(1L)).thenReturn(newControle1);
            } else {
                newControle.setDescricao(DESCRICAO_1);
                when(controleRepository.findOne(1L)).thenReturn(newControle);
            }

            when(agrupamentoTaxonomia.getTaxonomia()).thenReturn(newTaxonomia);
        }

        when(agrupamentoTaxonomia.getTaxonomias()).thenReturn(taxonomias);
        when(agrupamentoTaxonomiaDTO.getCpf()).thenReturn(CPF);
        when(orgaoRepository.findByUsuarioCPF(CPF)).thenReturn(orgao);
        when(controleRepository.save(any(Controle.class))).thenReturn(newControle);
        when(controleEventoRepository.findByControleId(1L)).thenReturn(eventoControles);
        when(planoControleRepository.findByControleId(1L)).thenReturn(planoControles);
        when(taxonomiaRepository.save(taxonomia)).thenReturn(any(Taxonomia.class));
        when(agrupamentoTaxonomiaRepository.save(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomia);
        when(agrupamentoTaxonomiaMapper.agrupamentoTaxonomiaToAgrupamentoTaxonomiaDTO(agrupamentoTaxonomia)).thenReturn(agrupamentoTaxonomiaDTO);
    }

}
