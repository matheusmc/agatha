package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.DesenhoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class DesenhoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/desenhos";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {
    }

    @Test
    @SneakyThrows
    public void createDesenho() {
        DesenhoDTO desenhoDTO = criarDesenho(null, "teste");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createDesenhoIdNotNull() {
        DesenhoDTO desenhoDTO = criarDesenho(1L, "teste");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createDesenhoDescricaoIgual() {
        DesenhoDTO desenhoDTO = criarDesenho(null, "desenho3");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateDesenho() {
        DesenhoDTO desenhoDTO = criarDesenho(1L, "teste");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateDesenhoIdNull() {
        DesenhoDTO desenhoDTO = criarDesenho(null, "teste");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateDesenhoDescricaoIgual() {
        DesenhoDTO desenhoDTO = criarDesenho(1L, "desenho3");
        String requestJson = toJson(desenhoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateDesenhoDescricaoDiferente() {
        DesenhoDTO desenhoDTO = criarDesenho(1L, "desenho1");
        String requestJson = toJson(desenhoDTO);
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
    public void removerHasProcesso() {
        mockMvc.perform(delete(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getDesenho() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllDesenhos() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "desenho"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllDesenhosIfFilters() {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "desenho1")
                .param("status", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "desenho"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "desenho teste teste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspacoS3() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private DesenhoDTO criarDesenho(Long id, String descricao) {
        DesenhoDTO desenhoDTO = new DesenhoDTO();
        desenhoDTO.setId(id);
        desenhoDTO.setDescricao(descricao);
        desenhoDTO.setSearch("teste");
        desenhoDTO.setStatus(Boolean.TRUE);
        desenhoDTO.setExcluido(Boolean.FALSE);
        desenhoDTO.setOrgao(null);
        return desenhoDTO;
    }

}
