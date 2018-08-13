package br.gov.mpog.gestaoriscos.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class OrgaoSiorgControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/siorg";

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void getUnidadesRaizes() {
        mockMvc.perform(get(URL_BASE + "/orgao")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }
//
//    @Test
//    @SneakyThrows
//    public void testarImportacao() throws Exception {
//        mockMvc.perform(get(URL_BASE + "/importar")
//                .contentType(contentType))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isNotEmpty());
//
//        mockMvc.perform(get("/processos/orgaosbycpf")
//                .contentType(contentType)
//                .param("cpf", "77777777777"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isNotEmpty());
//    }

    @Test
    @SneakyThrows
    public void filtrarOrgaos() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/filtrar")
                .contentType(contentType)
                .param("nomeOrgao", "orgao"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getUnidadePeloId() throws JsonProcessingException {
        mockMvc.perform(get(URL_BASE + "/orgao/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void getUnidadePeloIdComErro() throws Exception {
        mockMvc.perform(get(URL_BASE + "/orgao/1000000")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().is(500));

    }

}