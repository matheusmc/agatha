package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.NaturezaDTO;
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
public class CategoriaControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/categorias";

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {
    }

    @Test
    @SneakyThrows
    public void createCategoriaIdNull() {
        CategoriaDTO categoriaDTO = criarCategoria(null, "teste");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createCategoriaIdNotNull() {
        CategoriaDTO categoriaDTO = criarCategoria(1L,"teste");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createCategoriaIdNullDescricaoIgual() {
        CategoriaDTO categoriaDTO = criarCategoria(null,"Operacional");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void createCategoriaIdNotNullAcento() {
        CategoriaDTO categoriaDTO = criarCategoria(null, "téste");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCategoria() {
        CategoriaDTO categoriaDTO = criarCategoria(1L, "teste1");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCategoriaIdNull() {
        CategoriaDTO categoriaDTO = criarCategoria(null, "teste1");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCategoriaDescricaoIgual() {
        CategoriaDTO categoriaDTO = criarCategoria(1L, "Estrategico");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCategoriaDescricaoDiferente() {
        CategoriaDTO categoriaDTO = criarCategoria(1L, "Integridade");
        String requestJson = toJson(categoriaDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void remover() {
        mockMvc.perform(delete(URL_BASE + "/6")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void removerIdNotExist() {
        mockMvc.perform(delete(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void getCategoria() {
        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    @SneakyThrows
    public void getAllCategorias() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Fiscal"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getNaturezas() throws Exception {
        mockMvc.perform(get(URL_BASE + "/naturezas")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllCategoriasIfFilter() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("descricao", "Fiscal")
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

    private CategoriaDTO criarCategoria(Long id, String descricao) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(id);
        categoriaDTO.setDescricao(descricao);
        categoriaDTO.setSearch("teste");
        categoriaDTO.setStatus(Boolean.TRUE);
        categoriaDTO.setExcluido(Boolean.FALSE);
        categoriaDTO.setNatureza(createNatureza(1L, "teste"));
        return categoriaDTO;
    }

    private NaturezaDTO createNatureza(Long id, String descricao) {
        NaturezaDTO naturezaDTO = new NaturezaDTO();
        naturezaDTO.setId(id);
        naturezaDTO.setDescricao(descricao);
        naturezaDTO.setSearch("teste");
        naturezaDTO.setStatus(Boolean.TRUE);
        naturezaDTO.setExcluido(Boolean.FALSE);
        return naturezaDTO;
    }

}
