package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.controller.mockserver.MockServerUtils;
import br.gov.mpog.gestaoriscos.modelo.dto.CalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ImpactoCalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProbabilidadeCalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoCalculadoraDTO;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class CalculadoraControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/calculadoras";
    private MockServerUtils mockServerUtils;

    @Before
    @SneakyThrows
    public void setUp() {}

    @Test
    @SneakyThrows
    public void getAllCalculadoras() throws Exception {
        mockMvc.perform(get(URL_BASE)
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllTipodCalculadoras() throws Exception {
        mockMvc.perform(get(URL_BASE + "/tipos")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateCalculadora() throws Exception {
        CalculadoraDTO calculadoraDTO = criarCalculadora();
        String requestJson = toJson(calculadoraDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    private CalculadoraDTO criarCalculadora() {
        CalculadoraDTO calculadoraDTO = new CalculadoraDTO();
        calculadoraDTO.setId(1L);
        calculadoraDTO.setExcluido(Boolean.FALSE);
        calculadoraDTO.setExcluido(Boolean.FALSE);
        calculadoraDTO.setTipo(criarTipoCalculadora());
        calculadoraDTO.setImpactos(criarListaImpactoCalculadora());
        calculadoraDTO.setProbabilidades(criarListaProbrabilidadeCalculadora());
        return calculadoraDTO;
    }

    private TipoCalculadoraDTO criarTipoCalculadora() {
        TipoCalculadoraDTO tipoCalculadoraDTO = new TipoCalculadoraDTO();
        tipoCalculadoraDTO.setId(1L);
        return tipoCalculadoraDTO;
    }

    private List<ImpactoCalculadoraDTO> criarListaImpactoCalculadora() {
        ImpactoCalculadoraDTO impactoCalculadoraDTO = new ImpactoCalculadoraDTO();
        impactoCalculadoraDTO.setId(1L);
        impactoCalculadoraDTO.setNome("Esforço de Gestão");
        impactoCalculadoraDTO.setDesabilitado(false);
        impactoCalculadoraDTO.setExcluido(false);
        impactoCalculadoraDTO.setPeso(1L);
        return asList(impactoCalculadoraDTO);
    }

    private List<ProbabilidadeCalculadoraDTO> criarListaProbrabilidadeCalculadora() {
        ProbabilidadeCalculadoraDTO probabilidadeCalculadoraDTO = new ProbabilidadeCalculadoraDTO();
        probabilidadeCalculadoraDTO.setId(1L);
        probabilidadeCalculadoraDTO.setNome("Evento esperado que ocorra na maioria das circunstâncias");
        return asList(probabilidadeCalculadoraDTO);
    }
}
