package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.controller.mockserver.MockServerUtils;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.*;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.data.domain.Pageable;

import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class AgrupamentoTaxonomiaControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/agrupamentotaxonomias";
    private MockServerUtils mockServerUtils;
    private Usuario usuario;

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEvento() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEventoIsNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        agrupamentoTaxonomiaDTO.getTaxonomia().setEvento(null);
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEventoIDNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        agrupamentoTaxonomiaDTO.getTaxonomia().getEvento().setId(null);
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEventoDescricaoEqualsTaxonomiadescricao() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        agrupamentoTaxonomiaDTO.getTaxonomia().setDescricao("evento1");
        agrupamentoTaxonomiaDTO.getTaxonomia().getEvento().setDescricao("evento1");
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEventoNotNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        agrupamentoTaxonomiaDTO.getTaxonomia().setEvento(getEventoDTO("teste"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaEventoNotNullEquals() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(1L, "Evento");
        agrupamentoTaxonomiaDTO.getTaxonomia().setEvento(getEventoDTO("evento1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaCausa() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Causa");
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }


    @Test
    @SneakyThrows
    public void agruparTaxonomiaCausaNotNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Causa");
        agrupamentoTaxonomiaDTO.getTaxonomia().setCausa(getCausaDTO("teste"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaCausaIDNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Causa");
        agrupamentoTaxonomiaDTO.getTaxonomia().setCausa(getCausaDTO("Causa 1"));
        agrupamentoTaxonomiaDTO.getTaxonomia().getCausa().setId(null);
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaCausaDescricaoEqualsTaxonomiadescricao() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Causa");
        agrupamentoTaxonomiaDTO.getTaxonomia().setDescricao("Causa 1");
        agrupamentoTaxonomiaDTO.getTaxonomia().setCausa(getCausaDTO("Causa 1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }


    @Test
    @SneakyThrows
    public void agruparTaxonomiaCausaNotNullEquals() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Causa");
        agrupamentoTaxonomiaDTO.getTaxonomia().setCausa(getCausaDTO("Causa 1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaConsequencia() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(3L, "Consequência");
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaConsequenciaNotNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(3L, "Consequência");
        agrupamentoTaxonomiaDTO.getTaxonomia().setConsequencia(getConsequenciaDTO("teste"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaConsequenciaIDNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Consequência");
        agrupamentoTaxonomiaDTO.getTaxonomia().setConsequencia(getConsequenciaDTO("consequencia1"));
        agrupamentoTaxonomiaDTO.getTaxonomia().getConsequencia().setId(null);
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaConsequenciaDescricaoEqualsTaxonomiadescricao() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Consequência");
        agrupamentoTaxonomiaDTO.getTaxonomia().setDescricao("consequencia1");
        agrupamentoTaxonomiaDTO.getTaxonomia().setConsequencia(getConsequenciaDTO("consequencia1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaConsequenciaNotNullEquals() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(3L, "Consequência");
        agrupamentoTaxonomiaDTO.getTaxonomia().setConsequencia(getConsequenciaDTO("consequencia1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaControle() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(4L, "Controle");
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaControleNotNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(4L, "Controle");
        agrupamentoTaxonomiaDTO.getTaxonomia().setControle(getControleDTO("teste"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }


    @Test
    @SneakyThrows
    public void agruparTaxonomiaControleIDNull() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Controle");
        agrupamentoTaxonomiaDTO.getTaxonomia().setControle(getControleDTO("controle1"));
        agrupamentoTaxonomiaDTO.getTaxonomia().getControle().setId(null);
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void agruparTaxonomiaControleDescricaoEqualsTaxonomiadescricao() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(2L, "Controle");
        agrupamentoTaxonomiaDTO.getTaxonomia().setDescricao("controle1");
        agrupamentoTaxonomiaDTO.getTaxonomia().setControle(getControleDTO("controle1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }


    @Test
    @SneakyThrows
    public void agruparTaxonomiaControleNotNullEquals() throws Exception {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = criarAgrupamentoTaxonomia(4L, "Controle");
        agrupamentoTaxonomiaDTO.getTaxonomia().setControle(getControleDTO("controle1"));
        String requestJson = toJson(agrupamentoTaxonomiaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomia() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFilter() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("dtInicio", "0")
                .param("dtFim", "40000000000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFilterIsEmpty() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("dtInicio", "0")
                .param("dtFim", "40000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFilterDataFimNull() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("dtInicio", "0")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFilterDataInicioNull() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("dtFim", "40000000000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFilterIdNotNull() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("dtInicio", "0")
                .param("dtFim", "40000000000000")
                .param("statusId", "1")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTiposTaxonomia() throws Exception {
        mockMvc.perform(get(URL_BASE + "/tipos")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByNome() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "taxonomia"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getTaxonomiaBySearch() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchtaxonomia")
                .contentType(contentType)
                .param("descricao", "taxonomia")
                .param("tipoId", "1"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    @Test
    @SneakyThrows
    public void getTaxonomiaBySearchEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchtaxonomia")
                .contentType(contentType)
                .param("descricao", "taxonomia teste teste")
                .param("tipoId", "1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getTaxonomiaBySearchS3() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchtaxonomia")
                .contentType(contentType)
                .param("descricao", "a a a")
                .param("tipoId", "1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getTaxonomiaBySearchIdNull() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchtaxonomia")
                .contentType(contentType)
                .param("descricao", "taxonomia"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getEventosBySearch() throws Exception {
        mockMvc.perform(get(URL_BASE + "/eventos")
                .contentType(contentType)
                .param("descricao", "evento"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getCausasBySearch() throws Exception {
        mockMvc.perform(get(URL_BASE + "/causas")
                .contentType(contentType)
                .param("descricao", "Causa"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getCausasBySearchNotFound() throws Exception {
        mockMvc.perform(get(URL_BASE + "/causas")
                .contentType(contentType)
                .param("descricao", "Ca sa a"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getConsequenciasBySearch() throws Exception {
        mockMvc.perform(get(URL_BASE + "/consequencias")
                .contentType(contentType)
                .param("descricao", "Consequencia"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getConsequenciasBySearchNotFound() throws Exception {
        mockMvc.perform(get(URL_BASE + "/consequencias")
                .contentType(contentType)
                .param("descricao", "co oc o"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getControlesBySearch() throws Exception {
        mockMvc.perform(get(URL_BASE + "/controles")
                .contentType(contentType)
                .param("descricao", "Controle"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getControlesBySearchNotFount() throws Exception {
        mockMvc.perform(get(URL_BASE + "/controles")
                .contentType(contentType)
                .param("descricao", "co on t"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private AgrupamentoTaxonomiaDTO criarAgrupamentoTaxonomia(Long id, String tipo) {
        AgrupamentoTaxonomiaDTO agrupamentoTaxonomiaDTO = new AgrupamentoTaxonomiaDTO();
        agrupamentoTaxonomiaDTO.setCpf("11111111111");
        agrupamentoTaxonomiaDTO.setTaxonomia(criarTaxonomia(id, tipo));
        agrupamentoTaxonomiaDTO.setTaxonomias(getListaTaxonomia(id, tipo));
        return agrupamentoTaxonomiaDTO;
    }

    private TaxonomiaDTO criarTaxonomia(Long id, String tipo) {
        TaxonomiaDTO taxonomiaDTO = new TaxonomiaDTO();
        taxonomiaDTO.setDescricao("taxonomia1");
        taxonomiaDTO.setEvento(criarEvento());
        taxonomiaDTO.setTipo(getTipoTaxonomia(id, tipo));
        return taxonomiaDTO;
    }

    private List<TaxonomiaDTO> getListaTaxonomia(Long id, String tipo) {
        TaxonomiaDTO taxonomiaDTO = new TaxonomiaDTO();
        taxonomiaDTO.setExcluido(Boolean.FALSE);
        taxonomiaDTO.setId(1L);
        taxonomiaDTO.setDescricao("teste");
        taxonomiaDTO.setDtCadastro(Calendar.getInstance());
        taxonomiaDTO.setJustificativa("teste");
        taxonomiaDTO.setSearch("teste");
        taxonomiaDTO.setCausa(criarCausa());
        taxonomiaDTO.setConsequencia(criarConsequencia());
        taxonomiaDTO.setControle(criarControle());
        taxonomiaDTO.setEvento(criarEvento());
        taxonomiaDTO.setOrgao(criarOrgao());
        taxonomiaDTO.setStatus(criarStatusTaxonomia());
        taxonomiaDTO.setTipo(getTipoTaxonomia(id, tipo));
        return asList(taxonomiaDTO);
    }

    private CausaDTO criarCausa() {
        CausaDTO causaDTO = new CausaDTO();
        causaDTO.setExcluido(Boolean.FALSE);
        causaDTO.setId(1L);
        causaDTO.setDescricao("teste");
        causaDTO.setCpf("11111111111");
        causaDTO.setSearch("teste");
        causaDTO.setStatus(Boolean.TRUE);
        causaDTO.setOrgao(criarOrgao());
        return causaDTO;
    }

    private ConsequenciaDTO criarConsequencia() {
        ConsequenciaDTO consequenciaDTO = new ConsequenciaDTO();
        consequenciaDTO.setId(1L);
        consequenciaDTO.setCpf("11111111111");
        consequenciaDTO.setDescricao("teste");
        consequenciaDTO.setSearch("String");
        consequenciaDTO.setStatus(Boolean.TRUE);
        consequenciaDTO.setOrgao(criarOrgao());
        return consequenciaDTO;
    }

    private ControleDTO criarControle() {
        ControleDTO controleDTO = new ControleDTO();
        controleDTO.setId(1L);
        controleDTO.setCpf("11111111111");
        controleDTO.setDescricao("teste");
        controleDTO.setSearch("String");
        controleDTO.setStatus(Boolean.TRUE);
        controleDTO.setOrgao(criarOrgao());
        return controleDTO;
    }

    private EventoDTO criarEvento() {
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(1L);
        eventoDTO.setCpf("11111111111");
        eventoDTO.setDescricao("teste");
        eventoDTO.setSearch("String");
        eventoDTO.setStatus(Boolean.TRUE);
        eventoDTO.setOrgao(criarOrgao());
        return eventoDTO;
    }

    private StatusTaxonomiaDTO criarStatusTaxonomia() {
        StatusTaxonomiaDTO statusTaxonomiaDTO = new StatusTaxonomiaDTO();
        statusTaxonomiaDTO.setId(1L);
        statusTaxonomiaDTO.setNome("teste");
        return statusTaxonomiaDTO;
    }

    private TipoTaxonomiaDTO getTipoTaxonomia(Long id, String tipo) {
        TipoTaxonomiaDTO tipoTaxonomiaDTO = new TipoTaxonomiaDTO();
        tipoTaxonomiaDTO.setId(id);
        tipoTaxonomiaDTO.setNome(tipo);
        return tipoTaxonomiaDTO;
    }

    private OrgaoDTO criarOrgao() {
        OrgaoDTO orgaoDTO = new OrgaoDTO(1L, "teste", "teste");
        orgaoDTO.setId(1L);
        orgaoDTO.setNome("teste");
        orgaoDTO.setIdCategoriaUnidade(1L);
        orgaoDTO.setSigla("T");
        orgaoDTO.setUsuarios(criarListaUsuario());
        return orgaoDTO;
    }

    private List<UsuarioDTO> criarListaUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(1L);
        usuarioDTO.setCpf("00000000000");
        usuarioDTO.setNome("Teste");
        return asList(usuarioDTO);
    }

    private CausaDTO getCausaDTO(String descricao) {
        CausaDTO causaDTO = new CausaDTO();
        causaDTO.setId(1L);
        causaDTO.setCpf("11111111111");
        causaDTO.setExcluido(Boolean.FALSE);
        causaDTO.setSearch(descricao);
        causaDTO.setDescricao(descricao);
        causaDTO.setStatus(Boolean.TRUE);
        return causaDTO;
    }

    private ConsequenciaDTO getConsequenciaDTO(String descricao) {
        ConsequenciaDTO consequenciaDTO = new ConsequenciaDTO();
        consequenciaDTO.setId(1L);
        consequenciaDTO.setCpf("11111111111");
        consequenciaDTO.setExcluido(Boolean.FALSE);
        consequenciaDTO.setSearch(descricao);
        consequenciaDTO.setDescricao(descricao);
        consequenciaDTO.setStatus(Boolean.TRUE);
        return consequenciaDTO;
    }

    private EventoDTO getEventoDTO(String descricao) {
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(1L);
        eventoDTO.setCpf("11111111111");
        eventoDTO.setExcluido(Boolean.FALSE);
        eventoDTO.setSearch(descricao);
        eventoDTO.setDescricao(descricao);
        eventoDTO.setStatus(Boolean.TRUE);
        return eventoDTO;
    }

    private ControleDTO getControleDTO(String descricao) {
        ControleDTO controleDTO = new ControleDTO();
        controleDTO.setId(1L);
        controleDTO.setCpf("11111111111");
        controleDTO.setExcluido(Boolean.FALSE);
        controleDTO.setSearch(descricao);
        controleDTO.setDescricao(descricao);
        controleDTO.setStatus(Boolean.TRUE);
        return controleDTO;
    }

}