package br.gov.mpog.gestaoriscos.servico;

import br.gov.mpog.gestaoriscos.modelo.*;
import br.gov.mpog.gestaoriscos.modelo.dto.TaxonomiaContainerDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TaxonomiaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoTaxonomiaDTO;
import br.gov.mpog.gestaoriscos.repositorio.CausaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ConsequenciaRepository;
import br.gov.mpog.gestaoriscos.repositorio.ControleRepository;
import br.gov.mpog.gestaoriscos.repositorio.EventoRepository;
import br.gov.mpog.gestaoriscos.repositorio.OrgaoCustomRepositorio;
import br.gov.mpog.gestaoriscos.repositorio.StatusTaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.TaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.TipoTaxonomiaRepository;
import br.gov.mpog.gestaoriscos.repositorio.impl.TaxonomiaCustomRepositorioImpl;
import br.gov.mpog.gestaoriscos.servico.impl.TaxonomiaServiceImpl;
import br.gov.mpog.gestaoriscos.servico.mapper.TaxonomiaMapper;
import br.gov.mpog.gestaoriscos.servico.mapper.TipoTaxonomiaMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.when;

/**
 * Created by gabrielfreire on 22/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class TaxonomiaServiceTest {
    @InjectMocks
    private TaxonomiaServiceImpl taxonomiaService;
    @Mock
    private TaxonomiaCustomRepositorioImpl taxonomiaCustomRepositorio;
    @Mock
    private Causa causa;
    @Mock
    private Consequencia consequencia;
    @Mock
    private Controle controle;
    @Mock
    private Evento evento;
    @Mock
    private Taxonomia taxonomiaEvento;
    @Mock
    private Taxonomia taxonomiaCausa;
    @Mock
    private Taxonomia taxonomiaConsequencia;
    @Mock
    private Taxonomia taxonomiaControle;
    @Mock
    private TaxonomiaDTO taxonomiaDTO;
    @Mock
    private TaxonomiaMapper taxonomiaMapper;
    @Mock
    private TipoTaxonomiaMapper tipoTaxonomiaMapper;
    @Mock
    private TaxonomiaRepository taxonomiaRepository;
    @Mock
    private TipoTaxonomiaRepository tipoTaxonomiaRepository;
    private final String DESCRICAO = "TESTE";
    private final Boolean STATUS = Boolean.TRUE;
    @Mock
    private TipoTaxonomia tipoTaxonomia;
    @Mock
    private TipoTaxonomia tipoTaxonomiaEvento;
    @Mock
    private TipoTaxonomia tipoTaxonomiaCausa;
    @Mock
    private TipoTaxonomia tipoTaxonomiaConsequencia;
    @Mock
    private TipoTaxonomia tipoTaxonomiaControle;
    @Mock
    private TipoTaxonomiaDTO tipoTaxonomiaDTO;
    @Mock
    private TaxonomiaContainerDTO taxonomiaContainerDTO;
    @Mock
    private OrgaoCustomRepositorio orgaoCustomRepositorio;
    @Mock
    private StatusTaxonomiaRepository statusTaxonomiaRepository;
    @Mock
    private EventoRepository eventoRepository;
    @Mock
    private CausaRepository causaRepository;
    @Mock
    private ConsequenciaRepository consequenciaRepository;
    @Mock
    private ControleRepository controleRepository;


    @Before
    public void setUp() {
        when(tipoTaxonomiaMapper.tipoTaxonomiasToTipoTaxonomiaDTOs(anyListOf(TipoTaxonomia.class))).thenReturn(Arrays.asList(tipoTaxonomiaDTO));
        when(taxonomiaMapper.taxonomiaToTaxonomiaDTO(any(Taxonomia.class))).thenReturn(taxonomiaDTO);
        when(orgaoCustomRepositorio.searchByNome(anyString())).thenReturn(new ArrayList<>());
    }

    @Test
    public void aprovarTaxonomiaEmptyList() {
        List<TaxonomiaDTO> taxonomiaDTOList = new ArrayList<>();
        taxonomiaDTOList.add(taxonomiaDTO);

        when(taxonomiaContainerDTO.getTaxonomias()).thenReturn(taxonomiaDTOList);
        taxonomiaService.aprovarTaxonomia(taxonomiaContainerDTO);
    }

    @Test
    public void aprovarTaxonomia() {
        List<TaxonomiaDTO> taxonomiaDTOList = new ArrayList<>();
        taxonomiaDTOList.add(taxonomiaDTO);

        List<Taxonomia> taxonomiaList = new ArrayList<>();
        taxonomiaList.add(taxonomiaCausa);
        taxonomiaList.add(taxonomiaConsequencia);
        taxonomiaList.add(taxonomiaControle);
        taxonomiaList.add(taxonomiaEvento);

        when(taxonomiaContainerDTO.getTaxonomias()).thenReturn(taxonomiaDTOList);
        when(taxonomiaMapper.taxonomiaDTOsToTaxonomias(taxonomiaDTOList)).thenReturn(taxonomiaList);
        when(taxonomiaCausa.getId()).thenReturn(1L);
        when(taxonomiaConsequencia.getId()).thenReturn(2L);
        when(taxonomiaControle.getId()).thenReturn(3L);
        when(taxonomiaEvento.getId()).thenReturn(4L);
        when(taxonomiaRepository.findOne(taxonomiaCausa.getId())).thenReturn(taxonomiaCausa);
        when(taxonomiaRepository.findOne(taxonomiaConsequencia.getId())).thenReturn(taxonomiaConsequencia);
        when(taxonomiaRepository.findOne(taxonomiaControle.getId())).thenReturn(taxonomiaControle);
        when(taxonomiaRepository.findOne(taxonomiaEvento.getId())).thenReturn(taxonomiaEvento);
        when(taxonomiaRepository.save(taxonomiaCausa)).thenReturn(taxonomiaCausa);
        when(taxonomiaRepository.save(taxonomiaConsequencia)).thenReturn(taxonomiaConsequencia);
        when(taxonomiaRepository.save(taxonomiaControle)).thenReturn(taxonomiaControle);
        when(taxonomiaRepository.save(taxonomiaEvento)).thenReturn(taxonomiaEvento);
        when(taxonomiaCausa.getTipo()).thenReturn(tipoTaxonomiaCausa);
        when(taxonomiaConsequencia.getTipo()).thenReturn(tipoTaxonomiaConsequencia);
        when(taxonomiaControle.getTipo()).thenReturn(tipoTaxonomiaControle);
        when(taxonomiaEvento.getTipo()).thenReturn(tipoTaxonomiaEvento);
        when(taxonomiaCausa.getCausa()).thenReturn(causa);
        when(taxonomiaConsequencia.getConsequencia()).thenReturn(consequencia);
        when(taxonomiaControle.getControle()).thenReturn(controle);
        when(taxonomiaEvento.getEvento()).thenReturn(evento);
        when(tipoTaxonomiaCausa.getNome()).thenReturn("Causa");
        when(tipoTaxonomiaConsequencia.getNome()).thenReturn("Consequência");
        when(tipoTaxonomiaControle.getNome()).thenReturn("Controle");
        when(tipoTaxonomiaEvento.getNome()).thenReturn("Evento");
        taxonomiaService.aprovarTaxonomia(taxonomiaContainerDTO);
    }

    @Test
    public void findAllTiposTaxonomia() {
        when(tipoTaxonomiaRepository.findAll()).thenReturn(Arrays.asList(tipoTaxonomia));
        List<TipoTaxonomiaDTO> result = taxonomiaService.findAllTiposTaxonomia();
        assertNotNull(result);
    }


    @Test
    public void searchOrgaoByNome() {
        List<String> result = taxonomiaService.searchOrgaoByNome("teste");
        assertNotNull(result);
    }

    @Test
    public void searchByDescricao() {
        when(taxonomiaCustomRepositorio.searchByDescricao(DESCRICAO, STATUS)).thenReturn(new ArrayList<>());
        List<String> result = taxonomiaService.searchByDescricao(DESCRICAO);
        assertNotNull(result);
    }

}
