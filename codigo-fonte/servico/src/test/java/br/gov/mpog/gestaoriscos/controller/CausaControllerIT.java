package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.CausaDTO;
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
public class CausaControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/causas";

    @Before
    @SneakyThrows
    public void setUp() {
    }

    @Mock
    private Pageable pageable;

    @Test
    @SneakyThrows
    public void createCausaIdNull() {
        CausaDTO causaDTO = criarCausa(null, "teste");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createCausaIdNotNull() {
        CausaDTO causaDTO = criarCausa(1L, "teste");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createCausaIdNullDescricaoIgual() {
        CausaDTO causaDTO = criarCausa(null, "Causa 1");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateCausa() {
        CausaDTO causaDTO = criarCausa(1L, "teste");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCausaIdNull() {
        CausaDTO causaDTO = criarCausa(null, "teste");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCausaDescricaoIgual() {
        CausaDTO causaDTO = criarCausa(1L, "Causa 2");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateCausaDescricaoDiferente() {
        CausaDTO causaDTO = criarCausa(1L, "Causa 1");
        String requestJson = toJson(causaDTO);
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
        mockMvc.perform(delete(URL_BASE + "/45")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getCausa() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllCausas() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", ""))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllCausasIfFilter() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("page", "1")
                .param("size", "5")
                .param("descricao", "Causa")
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
                .param("descricao", "Causa"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Causa  teste teste"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspacoSize3() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a  a a"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    private CausaDTO criarCausa(Long id, String descricao) {
        CausaDTO causaDTO = new CausaDTO();
        causaDTO.setId(id);
        causaDTO.setDescricao(descricao);
        causaDTO.setSearch("teste");
        causaDTO.setCpf("11111111111");
        causaDTO.setStatus(Boolean.TRUE);
        causaDTO.setExcluido(Boolean.FALSE);
        return causaDTO;
    }

}
