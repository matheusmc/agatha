package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.MacroprocessoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;

import java.awt.print.Pageable;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class MacroProcessoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/macroprocessos";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {
    }

    @Test
    @SneakyThrows
    public void createMacroprocessoIdNull() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(null, "teste");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createMacroprocessoIdNotNull() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(1L,"teste");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createMacroprocessoIdNullDescricaoIgual() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(null,"Macroprocesso 01");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createMacroprocessoIdNotNullAcento() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(null, "téste");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateMacroprocesso() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(1L, "teste1");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateMacroprocessoIdNull() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(null, "teste1");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateMacroprocessoDescricaoDiferente() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(1L, "Estrategico");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateMacroprocessoDescricaoAndIdIgual() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(2L, "Macroprocesso 02");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateMacroprocessoDescricaoIgual() {
        MacroprocessoDTO macroprocesssoDTO = criarMacroprocesso(1L, "Macroprocesso 02");
        String requestJson = toJson(macroprocesssoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void remover() {
        mockMvc.perform(delete(URL_BASE + "/3")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void removerIdHasProcesso() {
        mockMvc.perform(delete(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getMacroprocesso() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllMacroprocessos() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Fiscal"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllMacroprocessosIfFilter() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Fiscal")
                .param("status", "true"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Operacional"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Operacional teste teste"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspacoSize3() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    private MacroprocessoDTO criarMacroprocesso(Long id, String descricao) {
        MacroprocessoDTO macroprocesssoDTO = new MacroprocessoDTO();
        macroprocesssoDTO.setId(id);
        macroprocesssoDTO.setDescricao(descricao);
        macroprocesssoDTO.setSearch("teste");
        macroprocesssoDTO.setStatus(Boolean.TRUE);
        macroprocesssoDTO.setExcluido(Boolean.FALSE);
        return macroprocesssoDTO;
    }

}
