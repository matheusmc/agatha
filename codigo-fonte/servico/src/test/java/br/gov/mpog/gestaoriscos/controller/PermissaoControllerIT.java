package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.Permissao;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.PerfilDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoContainerDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PermissaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.UsuarioDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;

import java.awt.print.Pageable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class PermissaoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/permissaos";

    @Mock
    private Pageable pageable;

    @Mock
    private Permissao permissao;

    @Mock
    private Usuario usuario;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void createPermissao() {
        PermissaoContainerDTO permissaoContainerDTO = criarListaPermissaoConteinerDTO(null, 1L);
        String requestJson = toJson(permissaoContainerDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    @SneakyThrows
    public void createPermissaoIdPerfilNotExist() {
        PermissaoContainerDTO permissaoContainerDTO = criarListaPermissaoConteinerDTO(null, 2L);
        String requestJson = toJson(permissaoContainerDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    @SneakyThrows
    public void updatePermissao() {
        PermissaoDTO permissaoDTO = criarPermissao(1L, 1L);
        String requestJson = toJson(permissaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updatePermissaoNotExist() {
        PermissaoDTO permissaoDTO = criarPermissao(500L, 2L);
        String requestJson = toJson(permissaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updatePermissaoIgual() {
        PermissaoDTO permissaoDTO = criarPermissao(2L, 2L);
        String requestJson = toJson(permissaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void remover() {
        mockMvc.perform(delete(URL_BASE + "/2")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void getPermissao() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllPermissaos() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllPermissaosHasUsuario() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("usuario", "usuario")
                .param("orgao", "orgao")
                .param("perfil", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllPermissaosHasPerfil() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("perfil", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllPermissaosHasPerfilNotExist() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("perfil", "50000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void findAllPerfis() {
        mockMvc.perform(get(URL_BASE + "/perfils")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchUsuarioByNome() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/usuarios")
                .contentType(contentType)
                .param("nome", "usuario"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void searchUsuarioByNomeEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/usuarios")
                .contentType(contentType)
                .param("nome", "usuario  teste teste"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void searchOrgaoByNome() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void searchOrgaoByNomeEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao teste teste"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void searchOrgaoByNomeEspacoS3() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void getPermissoesByCPF() throws Exception {
        mockMvc.perform(get(URL_BASE + "/permissoesbycpf")
                .contentType(contentType)
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    private PermissaoContainerDTO criarListaPermissaoConteinerDTO(Long id, Long id2){
        PermissaoContainerDTO permissaoContainerDTO = new PermissaoContainerDTO();
        permissaoContainerDTO.setPermissaos(criarListaPermissao(id, id2));
        return (permissaoContainerDTO);
    }

    private List<PermissaoDTO> criarListaPermissao(Long id, Long id2) {
        PermissaoDTO permissaoDTO = new PermissaoDTO(permissao);
        permissaoDTO.setId(id);
        permissaoDTO.setPerfil(criarPerfil(id2));
        permissaoDTO.setUsuario(criarUsuario(id2));
        permissaoDTO.setExcluido(Boolean.FALSE);
        return asList(permissaoDTO);
    }

    private PermissaoDTO criarPermissao(Long id, Long id2) {
        PermissaoDTO permissaoDTO = new PermissaoDTO(permissao);
        permissaoDTO.setId(id);
        permissaoDTO.setPerfil(criarPerfil(id2));
        permissaoDTO.setUsuario(criarUsuario(id2));
        permissaoDTO.setExcluido(Boolean.FALSE);
        permissaoDTO.setDtCadastro(new Date());
        return permissaoDTO;
    }

    private UsuarioDTO criarUsuario(Long id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(id);
        return (usuarioDTO);
    }

    private PerfilDTO criarPerfil(Long id) {
        PerfilDTO perfilDTO = new PerfilDTO(1L,"perfil");
        perfilDTO.setId(id);
        return (perfilDTO);
    }

}
