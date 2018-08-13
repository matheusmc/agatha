package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.ConsequenciaDTO;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;

import java.awt.print.Pageable;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class ConsequenciaControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/consequencias";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {
    }

    @Test
    @SneakyThrows
    public void createConsequencia() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(null, "teste");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createConsequenciaIdNotNull() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(1L, "teste");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createConsequenciaDescricaoIgual() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(null, "consequencia2");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateConsequencia() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(1L, "teste1");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateConsequenciaIdNull() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(null, "teste1");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateConsequenciaDescricaoIgual() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(1L, "consequencia2");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateConsequenciaDescricaoDifernte() {
        ConsequenciaDTO consequenciaDTO = criarConsequencia(1L, "consequencia1");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
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
    public void removerIdVinculado() {
        mockMvc.perform(delete(URL_BASE + "/4")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void removerHasTaxonomia() {
        mockMvc.perform(delete(URL_BASE + "/7")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getConsequencia() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllConsequencias() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "consequencia"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllConsequenciasIfFilter() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "consequencia")
                .param("status", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "consequencia"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }


    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "consequencia teste teste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

@Test
    @SneakyThrows
    public void searchByDescricaoEspacoS3() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());

    }


    private ConsequenciaDTO criarConsequencia(Long id,String descricao) {
        ConsequenciaDTO consequenciaDTO = new ConsequenciaDTO();
        consequenciaDTO.setId(id);
        consequenciaDTO.setDescricao(descricao);
        consequenciaDTO.setSearch("teste");
        consequenciaDTO.setCpf("11111111111");
        consequenciaDTO.setStatus(Boolean.TRUE);
        consequenciaDTO.setExcluido(Boolean.FALSE);
        consequenciaDTO.setOrgao(null);
        return consequenciaDTO;
    }

}
