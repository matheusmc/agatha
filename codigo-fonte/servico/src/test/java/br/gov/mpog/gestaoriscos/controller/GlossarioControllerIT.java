package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.GlossarioDTO;
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
public class GlossarioControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/glossarios";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void createGlossario() {
        GlossarioDTO glossarioDTO = criarGlossario(null, "teste");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createGlossarioIdNotNull() {
        GlossarioDTO glossarioDTO = criarGlossario(1L, "teste");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createGlossarioDescricaoIgual() {
        GlossarioDTO glossarioDTO = criarGlossario(null, "Descricao Glossario 1");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateGlossario() {
        GlossarioDTO glossarioDTO = criarGlossario(1L, "teste");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateGlossarioIdNull() {
        GlossarioDTO glossarioDTO = criarGlossario(null, "teste");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateGlossarioDescricaoIgual() {
        GlossarioDTO glossarioDTO = criarGlossario(1l, "Descricao Glossario 2");
        String requestJson = toJson(glossarioDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateGlossarioDescricaoDiferente() {
        GlossarioDTO glossarioDTO = criarGlossario(1l, "Descricao Glossario 1");
        String requestJson = toJson(glossarioDTO);
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
    public void getGlossario() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllGlossarios() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("termo", "Descricao")
                .param("descricao", "Descricao"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllGlossariosIfFilters() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("termo", "Descricao")
                .param("descricao", "Descricao")
                .param("status", "true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void findAllGlossarios() {
        mockMvc.perform(get(URL_BASE + "/findall")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "glossario"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "glossario teste teste"))
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

    @Test
    @SneakyThrows
    public void searchByTermo() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchtermo")
                .contentType(contentType)
                .param("termo", "glossario"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByTermoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchtermo")
                .contentType(contentType)
                .param("termo", "glossario teste teste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByTermoEspacoS3() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchtermo")
                .contentType(contentType)
                .param("termo", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private GlossarioDTO criarGlossario(Long id, String descricao) {
        GlossarioDTO glossarioDTO = new GlossarioDTO();
        glossarioDTO.setId(id);
        glossarioDTO.setDescricao(descricao);
        glossarioDTO.setTermo(descricao);
        glossarioDTO.setDescricaoSearch("teste");
        glossarioDTO.setTermoSearch("teste");
        glossarioDTO.setStatus(Boolean.TRUE);
        glossarioDTO.setExcluido(Boolean.FALSE);
        return glossarioDTO;
    }

}
