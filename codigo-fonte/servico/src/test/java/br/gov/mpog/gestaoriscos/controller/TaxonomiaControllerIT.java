package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.*;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;

import java.awt.print.Pageable;
import java.util.Calendar;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class TaxonomiaControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/taxonomias";

    @Mock
    private Usuario usuario;

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void aprovarTaxonomiaTipoEvento() throws Exception {
        TaxonomiaContainerDTO taxonomiaContainerDTO = criarTaxonomiaContainerDTO(1L);
        String requestJson = toJson(taxonomiaContainerDTO);
        mockMvc.perform(post(URL_BASE + "/aprovar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void aprovarTaxonomiaTipoControle() throws Exception {
        TaxonomiaContainerDTO taxonomiaContainerDTO = criarTaxonomiaContainerDTO(4L);
        String requestJson = toJson(taxonomiaContainerDTO);
        mockMvc.perform(post(URL_BASE + "/aprovar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void aprovarTaxonomiaTipoCausa() throws Exception {
        TaxonomiaContainerDTO taxonomiaContainerDTO = criarTaxonomiaContainerDTO(2L);
        String requestJson = toJson(taxonomiaContainerDTO);
        mockMvc.perform(post(URL_BASE + "/aprovar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void aprovarTaxonomiaTipoConsequencia() throws Exception {
        TaxonomiaContainerDTO taxonomiaContainerDTO = criarTaxonomiaContainerDTO(3l);
        String requestJson = toJson(taxonomiaContainerDTO);
        mockMvc.perform(post(URL_BASE + "/aprovar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void reprovarTaxonomia() throws Exception {
        TaxonomiaContainerDTO taxonomiaContainerDTO = criarTaxonomiaContainerDTO(1L);
        String requestJson = toJson(taxonomiaContainerDTO);
        mockMvc.perform(post(URL_BASE + "/reprovar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
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
    public void getAllTaxonomiaWithFilters() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("orgao", "1")
                .param("descricao", "taxonomia")
                .param("tipoId", "1")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFiltersIsEmpty() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("orgao", "1")
                .param("descricao", "taxonomia")
                .param("tipoId", "1")
                .param("dtInicio", "0")
                .param("dtFim", "4000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFiltersDateInicioNull() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("orgao", "1")
                .param("descricao", "taxonomia")
                .param("tipoId", "1")
                .param("dtFim", "4000000")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllTaxonomiaWithFiltersDateFimNull() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .param("orgao", "1")
                .param("descricao", "taxonomia")
                .param("tipoId", "1")
                .param("dtInicio", "0")
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
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
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByNomeEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao teste teste"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByNomeEspacoS3() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws Exception {
        String search = new String("teste");
        String requestJson = toJson(search);
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "taxonomia"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws Exception {
        String search = new String("teste");
        String requestJson = toJson(search);
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "taxonomia teste teste"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspacoS3() throws Exception {
        String search = new String("teste");
        String requestJson = toJson(search);
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getSecretariaByPerfilAnalista() throws Exception {
        mockMvc.perform(get(URL_BASE + "/secretariabyperfil")
                .contentType(contentType)
                .param("cpf", "00000000000"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getSecretariaByPerfilGestorAndAnalista() throws Exception {
        mockMvc.perform(get(URL_BASE + "/secretariabyperfil")
                .contentType(contentType)
                .param("cpf", "22222222222"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getSecretariaByPerfilGestor() throws Exception {
        mockMvc.perform(get(URL_BASE + "/secretariabyperfil")
                .contentType(contentType)
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getSecretariaByPerfilNot() throws Exception {
        mockMvc.perform(get(URL_BASE + "/secretariabyperfil")
                .contentType(contentType)
                .param("cpf", "88888888888"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    private TaxonomiaContainerDTO criarTaxonomiaContainerDTO(Long idTaxnomia) {
        TaxonomiaContainerDTO taxonomiaContainerDTO = new TaxonomiaContainerDTO();
        taxonomiaContainerDTO.setJustificativa("TESTE");
        taxonomiaContainerDTO.setTaxonomias(criarListaTaxonomia(idTaxnomia));
        return taxonomiaContainerDTO;
    }

    private List<TaxonomiaDTO> criarListaTaxonomia(Long idTaxnomia) {
        TaxonomiaDTO taxonomiaDTO = new TaxonomiaDTO();
        taxonomiaDTO.setExcluido(Boolean.FALSE);
        taxonomiaDTO.setId(idTaxnomia);
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
        taxonomiaDTO.setTipo(criarTipoTaxonomia());
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
        consequenciaDTO.setExcluido(Boolean.FALSE);
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
        controleDTO.setExcluido(Boolean.FALSE);
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
        eventoDTO.setExcluido(Boolean.FALSE);
        eventoDTO.setOrgao(criarOrgao());
        return eventoDTO;
    }

    private StatusTaxonomiaDTO criarStatusTaxonomia() {
        StatusTaxonomiaDTO statusTaxonomiaDTO = new StatusTaxonomiaDTO();
        statusTaxonomiaDTO.setId(1L);
        statusTaxonomiaDTO.setNome("teste");
        statusTaxonomiaDTO.setExcluido(Boolean.FALSE);
        return statusTaxonomiaDTO;
    }

    private TipoTaxonomiaDTO criarTipoTaxonomia(){
        TipoTaxonomiaDTO tipoTaxonomiaDTO = new TipoTaxonomiaDTO();
        tipoTaxonomiaDTO.setId(1L);
        tipoTaxonomiaDTO.setNome("teste");
        tipoTaxonomiaDTO.setExcluido(Boolean.FALSE);
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

}