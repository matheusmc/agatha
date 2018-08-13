package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.EventoDTO;
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
public class EventoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/eventos";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void createEvento() {
        EventoDTO eventoDTO = criarEvento(null, "teste");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void createEventoIdNotNull() {
        EventoDTO eventoDTO = criarEvento(1L, "teste");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createEventoDescricaoIgual() {
        EventoDTO eventoDTO = criarEvento(null, "evento1");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateEvento() {
        EventoDTO eventoDTO = criarEvento(1L, "descricao");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void updateEventoIdNull() {
        EventoDTO eventoDTO = criarEvento(null, "descricao");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void updateEventoDescricaoIgual() {
        EventoDTO eventoDTO = criarEvento(1l, "evento2");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateEventoDescricaoDiferente() {
        EventoDTO eventoDTO = criarEvento(1l, "evento1");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
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
    public void removerIdvinculado() {
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
    public void getEvento() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllEventos() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "evento"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllEventosIfFiltes() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "evento")
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
                .param("descricao", "evento"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "evento teste teste"))
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

    private EventoDTO criarEvento(Long id, String descricao) {
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(id);
        eventoDTO.setDescricao(descricao);
        eventoDTO.setSearch("teste");
        eventoDTO.setCpf("11111111111");
        eventoDTO.setStatus(Boolean.TRUE);
        eventoDTO.setExcluido(Boolean.FALSE);
        return eventoDTO;
    }

}
