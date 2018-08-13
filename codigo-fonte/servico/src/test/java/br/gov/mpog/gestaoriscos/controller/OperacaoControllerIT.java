package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.OperacaoDTO;
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
public class OperacaoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/operacaos";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void createOperacao() {
        OperacaoDTO operacaoDTO = criarOperacao(null, "teste");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createOperacaoIdNotNull() {
        OperacaoDTO operacaoDTO = criarOperacao(1L, "teste");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createOperacaoDescricaoIgual() {
        OperacaoDTO operacaoDTO = criarOperacao(null, "Descricao Operacao 1");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateOperacao() {
        OperacaoDTO operacaoDTO = criarOperacao(1L, "teste");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateOperacaoIdNull() {
        OperacaoDTO operacaoDTO = criarOperacao(null, "teste");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateOperacaoDescricaoIgual() {
        OperacaoDTO operacaoDTO = criarOperacao(1L, "Descricao Operacao 2");
        String requestJson = toJson(operacaoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateOperacaoDescricaoDiferente() {
        OperacaoDTO operacaoDTO = criarOperacao(1L, "Descricao Operacao 1");
        String requestJson = toJson(operacaoDTO);
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
    public void removerhasProcesso() {
        mockMvc.perform(delete(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getOperacao() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllOperacaos() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Descricao"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllOperacaosIfFilters() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Descricao")
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
                .param("descricao", "Operacao"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

   @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Operacao teste teste"))
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

    private OperacaoDTO criarOperacao(Long id, String descricao) {
        OperacaoDTO operacaoDTO = new OperacaoDTO();
        operacaoDTO.setId(id);
        operacaoDTO.setDescricao(descricao);
        operacaoDTO.setSearch("teste");
        operacaoDTO.setStatus(Boolean.TRUE);
        operacaoDTO.setExcluido(Boolean.FALSE);
        operacaoDTO.setOrgao(null);
        return operacaoDTO;
    }

}
