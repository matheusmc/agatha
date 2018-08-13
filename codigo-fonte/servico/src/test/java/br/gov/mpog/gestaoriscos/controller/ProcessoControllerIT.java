package br.gov.mpog.gestaoriscos.controller;

import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.modelo.dto.AnaliseDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ArquivoAnexoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.AvaliacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CalculoRiscoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CategoriaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.CausaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ConsequenciaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ControleDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ControleEventoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.DecisaoProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.DesenhoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoCausaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoConsequenciaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.EventoRiscoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.IdentificacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ImpactoCalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.MacroprocessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.MatrizSwotDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.NaturezaDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ObjetivoControleDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.OperacaoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PesoEventoRiscoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.PlanoControleDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProbabilidadeCalculadoraDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProcessoAnexoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.ResponsavelDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.StatusProcessoDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoControleDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.TipoMatrizDTO;
import br.gov.mpog.gestaoriscos.modelo.dto.UsuarioDTO;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest("server.port:0")
public class ProcessoControllerIT extends BaseIntegrationTestCofig {

    private String URL_BASE = "/processos";

    @Mock
    private Usuario usuario;

    @Mock
    private Pageable pageable;

    @Before
    @SneakyThrows
    public void setUp() {

    }

    @Test
    @SneakyThrows
    public void upload() throws Exception {
        String name = "name";
        MockMultipartFile files = new MockMultipartFile("file", "file.doc", MediaType.APPLICATION_OCTET_STREAM_VALUE, "meu_arquivo".getBytes());
        String requestJson = toJson(name);
        mockMvc.perform(fileUpload(URL_BASE + "/uploadfile")
                .file(files)
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
                .param("name", requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void uploadEmpty() throws Exception {

        mockMvc.perform(fileUpload(URL_BASE + "/uploadfileEmpty")
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void createProcess() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTOEmpty();

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createProcessDecisoes() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTOEmpty();
        processoDTO.getAnalise().setId(null);
        processoDTO.setIdentificacao(getIdentificacaoDTO());
        processoDTO.getIdentificacao().setId(null);
        processoDTO.setAvaliacao(getAvaliacaoDTO());
        processoDTO.getAvaliacao().setId(null);
        processoDTO.setCalculadoras(new ArrayList<>());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createProcessHasId() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTOEmpty();
        processoDTO.setId(1L);

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateProcessoIdIsNull() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTOEmpty();

        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateProcessoEqualsValidar() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(1L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateProcessDescricaoMacroProcessoEquals() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(1L);
        processoDTO.getMacroprocesso().setDescricao("Macroprocesso 01");
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateProcessoDecisaoEqualsReprovar() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(1L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).getProbabilidades().add(getProbabilidadeCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).getProbabilidades().get(0).setNome("Evento esperado que ocorra na maioria das circunstâncias");
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).getImpactos().add(getImpactoCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).getImpactos().get(0).setNome("Esforço de Gestão");
        processoDTO.getCalculadoras().get(0).getImpactos().get(0).setDesabilitado(false);
        processoDTO.setAnexos(new ArrayList<>());
        processoDTO.getAnexos().add(getProcessoAnexoDTO());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateProcessoDecisaoEqualsNull() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(1L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.setAnalise(getAnaliseDTOWithId());
        processoDTO.getAnalise().setId(1L);
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).getProbabilidades().add(getProbabilidadeCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).getProbabilidades().get(0).setNome("Evento esperado que ocorra na maioria das circunstâncias");
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).getImpactos().add(getImpactoCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).getImpactos().get(0).setNome("Esforço de Gestão");
        processoDTO.getCalculadoras().get(0).getImpactos().get(0).setDesabilitado(false);
        processoDTO.setAnexos(new ArrayList<>());
        processoDTO.getAnexos().add(getProcessoAnexoDTO());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE)
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllProcesso() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsGestor() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "11111111111")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "1")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterDataFimNull() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "11111111111")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "1")
                .param("dtInicio", "0"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterDataInicioNull() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "11111111111")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "1")
                .param("dtFim", "400000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsEmpty() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "11111111111")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "1")
                .param("dtInicio", "0")
                .param("dtFim", "40000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsAnalista() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "22222222222")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsAnalista2() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "77777777777")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsAnalistaAndGestor() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "12121212121")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsAnalistaNotGestor() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "55555555555")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsUnidade() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "33333333333")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterIsNucleo() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "44444444444")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllProcessoIfFilterComite() throws Exception {

        mockMvc.perform(get(URL_BASE)
                .contentType(contentType)
                .content(toJson(pageable))
                .param("cpf", "66666666666")
                .param("orgao", "orgao")
                .param("descricao", "Processo")
                .param("statusId", "2")
                .param("dtInicio", "0")
                .param("dtFim", "4000000000000"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getProcesso() throws Exception {

        mockMvc.perform(get(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void deleteProcesso() throws Exception {

        mockMvc.perform(delete(URL_BASE + "/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void createEventoRisco() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        String requestJson = toJson(eventoRiscoDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createEventoRiscoCondicoes() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCausas(new ArrayList<>());
        eventoRiscoDTO.getCausas().add(getEventoCausaDTO());
        eventoRiscoDTO.getCausas().get(0).getCausa().setId(1L);
        eventoRiscoDTO.getConsequencias().add(getEventoConsequenciaDTO());
        eventoRiscoDTO.getConsequencias().get(0).getConsequencia().setId(1L);
        eventoRiscoDTO.getControleEventos().add(getControleEventoDTO());
        eventoRiscoDTO.getControleEventos().get(0).getControle().setId(null);
        eventoRiscoDTO.getControles().add((getRespostaRiscoDTO()));
        eventoRiscoDTO.getControles().get(0).getControle().setId(1L);
        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createEventoRiscoCondicoes2() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCausas(new ArrayList<>());
        eventoRiscoDTO.getCausas().add(getEventoCausaDTO());
        eventoRiscoDTO.getCausas().get(0).getCausa().setId(1L);
        eventoRiscoDTO.getConsequencias().add(getEventoConsequenciaDTO());
        eventoRiscoDTO.getConsequencias().get(0).getConsequencia().setId(1L);
        eventoRiscoDTO.setControleEventos(new ArrayList<>());
        eventoRiscoDTO.setControles(new ArrayList<>());
        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createEventoRiscoCondicoes3() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCausas(new ArrayList<>());
        eventoRiscoDTO.getCausas().add(getEventoCausaDTO());
        eventoRiscoDTO.getCausas().get(0).getCausa().setId(1L);
        eventoRiscoDTO.getConsequencias().add(getEventoConsequenciaDTO());
        eventoRiscoDTO.getConsequencias().get(0).getConsequencia().setId(1L);
        eventoRiscoDTO.setControleEventos(null);
        eventoRiscoDTO.setControles(null);
        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void createEventoRiscoHasId() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @SneakyThrows
    public void updateEventoRiscoIdIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setCalculoRiscoInerente(new CalculoRiscoDTO());
        eventoRiscoDTO.getCalculoRiscoInerente().setPesos(new ArrayList<>());
        eventoRiscoDTO.getCalculoRiscoInerente().setMediaPeso(new BigDecimal(1L));
        eventoRiscoDTO.getCalculoRiscoInerente().setFrequencia(1);
        eventoRiscoDTO.getCalculoRiscoInerente().setNivel(new BigDecimal(1L));
        eventoRiscoDTO.setCalculoRiscoResidual(new CalculoRiscoDTO());
        eventoRiscoDTO.getCalculoRiscoResidual().setPesos(new ArrayList<>());
        eventoRiscoDTO.getCalculoRiscoResidual().setMediaPeso(new BigDecimal(1L));
        eventoRiscoDTO.getCalculoRiscoResidual().setFrequencia(1);
        eventoRiscoDTO.getCalculoRiscoResidual().setNivel(new BigDecimal(1L));

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(put(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void updateEventoRisco() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(14L);
        eventoRiscoDTO.setCausas(new ArrayList<>());
        eventoRiscoDTO.setConsequencias(new ArrayList<>());
        eventoRiscoDTO.setControleEventos(new ArrayList<>());
        eventoRiscoDTO.setControles(new ArrayList<>());
        eventoRiscoDTO.setCalculoRiscoInerente(new CalculoRiscoDTO());
        eventoRiscoDTO.getCalculoRiscoInerente().setPesos(new ArrayList<>());
        eventoRiscoDTO.getCalculoRiscoInerente().setMediaPeso(new BigDecimal(1L));
        eventoRiscoDTO.getCalculoRiscoInerente().setFrequencia(1);
        eventoRiscoDTO.getCalculoRiscoInerente().setNivel(new BigDecimal(1L));
        eventoRiscoDTO.setCalculoRiscoResidual(new CalculoRiscoDTO());
        eventoRiscoDTO.getCalculoRiscoResidual().setPesos(new ArrayList<>());
        eventoRiscoDTO.getCalculoRiscoResidual().setMediaPeso(new BigDecimal(1L));
        eventoRiscoDTO.getCalculoRiscoResidual().setFrequencia(1);
        eventoRiscoDTO.getCalculoRiscoResidual().setNivel(new BigDecimal(1L));

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(put(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void findAllUsuarios() {
        mockMvc.perform(get(URL_BASE + "/analistas")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void findAllGestores() {
        mockMvc.perform(get(URL_BASE + "/gestores")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void findAllTiposMatriz() {
        mockMvc.perform(get(URL_BASE + "/tiposmatriz")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getOrgaosByCpf() {
        mockMvc.perform(get(URL_BASE + "/orgaosbycpf")
                .contentType(contentType)
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getOrgaosByCpfIsOrgaoPai() {
        mockMvc.perform(get(URL_BASE + "/orgaosbycpf")
                .contentType(contentType)
                .param("cpf", "77777777777"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoes() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesAllPermissoes() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "22222222222"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesNotPermissoes() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "77777777777"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsUnidadade() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "33333333333"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsUnidadadeIsgestor() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "11111111112"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsComite() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "66666666666"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsComiteIsNucleo() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "66666666666"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsSubcomite() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "55555555555"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getPermissoesIsNucleo() {
        mockMvc.perform(get(URL_BASE + "/permissao")
                .contentType(contentType)
                .param("cpf", "44444444444"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getAllEventosRisco() {
        mockMvc.perform(get(URL_BASE + "/eventosrisco")
                .contentType(contentType)
                .content(toJson(pageable))
                .param("processoId", "12"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getAllEventosRiscoPage() {
        mockMvc.perform(get(URL_BASE + "/eventosriscowithoutpage/12")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEventoRisco() {
        mockMvc.perform(get(URL_BASE + "/eventosrisco/14")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(14));
    }

    @Test
    @SneakyThrows
    public void deleteEventoRisco() {
        mockMvc.perform(delete(URL_BASE + "/eventosrisco/14")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void deletePlanoControle() {
        mockMvc.perform(delete(URL_BASE + "/plano-controle/2")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void getEventos() {
        mockMvc.perform(get(URL_BASE + "/eventos")
                .contentType(contentType)
                .param("descricao", "evento")
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getEventosNotExist() {
        mockMvc.perform(get(URL_BASE + "/eventos")
                .contentType(contentType)
                .param("descricao", "a")
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getCausas() {
        mockMvc.perform(get(URL_BASE + "/causas")
                .contentType(contentType)
                .param("descricao", "causa")
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getConsequencias() {
        mockMvc.perform(get(URL_BASE + "/consequencias")
                .contentType(contentType)
                .param("descricao", "consequencia")
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getCategorias() {
        mockMvc.perform(get(URL_BASE + "/categorias")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getDecisoes() {
        mockMvc.perform(get(URL_BASE + "/decisoes")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getNaturezas() {
        mockMvc.perform(get(URL_BASE + "/naturezas")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getStatus() {
        mockMvc.perform(get(URL_BASE + "/status")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getControles() {
        mockMvc.perform(get(URL_BASE + "/controles")
                .contentType(contentType)
                .param("descricao", "controle")
                .param("cpf", "11111111111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getDesenhos() {
        mockMvc.perform(get(URL_BASE + "/desenhos")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getOperacoes() {
        mockMvc.perform(get(URL_BASE + "/operacoes")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getCalculadoraInerente() {
        mockMvc.perform(get(URL_BASE + "/calculadorainerente/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getCalculadoraResidual() {
        mockMvc.perform(get(URL_BASE + "/calculadoraresidual/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getIgnorarRiscoInerenteByProcesso() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/ignorar/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void getTiposResposta() {
        mockMvc.perform(get(URL_BASE + "/tiposresposta")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getMacroprocesso() {
        mockMvc.perform(get(URL_BASE + "/macroprocesso")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getTiposControle() {
        mockMvc.perform(get(URL_BASE + "/tiposcontrole")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getObjetivosControle() {
        mockMvc.perform(get(URL_BASE + "/objetivoscontrole")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificaRiscoInerente() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/risco-inerente/verifica/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void verificaRiscoInerenteNotValid() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/risco-inerente/verifica/7")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void verificaRiscoInerenteNotValidEmprty() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/risco-inerente/verifica/10")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void verificaControleEvento() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/controle-evento/verifica/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void verificaControleEvento2() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/controle-evento/verifica/2")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void verificaControleEvento3() {
        mockMvc.perform(get(URL_BASE + "/avaliacao/controle-evento/verifica/9")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByDescricao() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Processo"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "Processo teste teste"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByDescricaoEspacos3() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchdescricao")
                .contentType(contentType)
                .param("descricao", "a a a"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void searchByNome() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void searchByNomeEspaco() throws Exception {
        mockMvc.perform(get(URL_BASE + "/searchorgao")
                .contentType(contentType)
                .param("nome", "orgao1 teste teste"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(2L);

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoDescricaoNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.getEvento().setDescricao("evento1");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsNucleoOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("44444444444");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsUnidadeOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("33333333333");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsUnidadeProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);
        eventoRiscoDTO.getEvento().setId(4L);
        eventoRiscoDTO.setCpf("33333333333");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsUnidade() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);
        eventoRiscoDTO.getEvento().setId(5L);
        eventoRiscoDTO.setCpf("33333333333");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsGestorOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsGestorIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("99999999999");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsGestorIsAnalistaNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("66666666666");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsGestorProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);
        eventoRiscoDTO.getEvento().setId(4L);
        eventoRiscoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsGestor() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);
        eventoRiscoDTO.getEvento().setId(5L);
        eventoRiscoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsAnalistaOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.setCpf("00000000000");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarEventoIsAnalistaProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);
        eventoRiscoDTO.getEvento().setId(4L);
        eventoRiscoDTO.setCpf("22222222222");

        String requestJson = toJson(eventoRiscoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(2L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(2L);

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaDescricaoNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.getEvento().setDescricao("evento1");

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Causa 1");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsNucleoOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("44444444444");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsUnidadeOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsUnidadeProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(4L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(4L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsUnidade() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(5L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(5L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsGestorOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsGestorIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("99999999999");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsGestorIsAnalistaNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("66666666666");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsGestorProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(4L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(4L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsGestor() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(5L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(5L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsAnalistaOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(1L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("00000000000");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsAnalistaProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(4L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(4L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("22222222222");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarCausaIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setId(5L);
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setId(5L);
        eventoCausaDTO.getCausa().setDescricao("Teste");
        eventoCausaDTO.setCpf("22222222222");

        String requestJson = toJson(eventoCausaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(2L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(2L);

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaDescricaoNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.getEvento().setDescricao("evento1");

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("consequencia1");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsNucleoOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("44444444444");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsUnidadeOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsUnidadeProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(4L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(4L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsUnidade() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(5L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(5L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("33333333333");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsGestorOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsGestorIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("99999999999");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsGestorProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(4L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(4L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsGestor() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(5L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(5L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsAnalistaOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(1L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("00000000000");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsAnalistaProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(4L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(4L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("22222222222");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsAnalistaIsGestorNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(4L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(4L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("66666666666");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarConsequenciaIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(5L);
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setId(5L);
        eventoConsequenciaDTO.getConsequencia().setDescricao("Teste");
        eventoConsequenciaDTO.setCpf("22222222222");

        String requestJson = toJson(eventoConsequenciaDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(2L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        OperacaoDTO operacaoDTO = getOperacaoDTO();
        DesenhoDTO desenhoDTO = getDesenhoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(2L);
        controleEventoDTO.setOperacao(operacaoDTO);
        controleEventoDTO.setDesenho(desenhoDTO);
        controleEventoDTO.getControle().setId(2L);

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleDescricaoNotEqualsPersisted() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);
        eventoRiscoDTO.getEvento().setId(1L);
        eventoRiscoDTO.getEvento().setDescricao("evento1");

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("controle1");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsNucleoOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("44444444444");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsUnidadeOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("33333333333");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsUnidadeProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        OperacaoDTO operacaoDTO = getOperacaoDTO();
        DesenhoDTO desenhoDTO = getDesenhoDTO();
        controleEventoDTO.setId(4L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(4L);
        controleEventoDTO.setOperacao(operacaoDTO);
        controleEventoDTO.setDesenho(desenhoDTO);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("33333333333");

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsUnidade() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(5L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(5L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("33333333333");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsGestorOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());
        controleEventoDTO.setCpf("11111111111");

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsGestorIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("99999999999");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsGestorIsAnalistaNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("66666666666");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsGestorProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(4L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(4L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("11111111111");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsGestor() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(5L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(5L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("11111111111");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsAnalistaOrgaoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(1L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(1L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("00000000000");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsAnalistaProcessoIsNull() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(4L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(4L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(4L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("22222222222");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void verificarControleIsAnalista() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = criarEventoRiscoDTOEmpty();
        eventoRiscoDTO.setId(5L);

        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setId(5L);
        controleEventoDTO.setControle(new ControleDTO());
        controleEventoDTO.getControle().setId(5L);
        controleEventoDTO.getControle().setDescricao("Teste");
        controleEventoDTO.setCpf("22222222222");
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setDesenho(getDesenhoDTO());

        String requestJson = toJson(controleEventoDTO);

        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/verificar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void atualizarEvento() throws Exception {
        EventoDTO eventoDTO = getEventoDTO();
        eventoDTO.setExcluido(Boolean.FALSE);
        eventoDTO.setDescricao("teste");
        eventoDTO.setSearch("teste");
        eventoDTO.setStatus(Boolean.TRUE);
        eventoDTO.setCpf("00000000000");
        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/atualizar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void substituirEvento() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = getEventoRiscoDTO();
        eventoRiscoDTO.setExcluido(Boolean.FALSE);
        eventoRiscoDTO.setId(14L);
        eventoRiscoDTO.setCpf("00000000000");
        eventoRiscoDTO.setCategoria(getCategoriaDTO());
        eventoRiscoDTO.setEvento(getEventoDTO());
        eventoRiscoDTO.setIdentificacao(getIdentificacaoDTO());
        String requestJson = toJson(eventoRiscoDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/evento/substituir")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void atualizarCausa() throws Exception {
        CausaDTO causaDTO = getCausaDTO();
        causaDTO.setExcluido(Boolean.FALSE);
        causaDTO.setDescricao("teste");
        causaDTO.setSearch("teste");
        causaDTO.setStatus(Boolean.TRUE);
        causaDTO.setCpf("00000000000");
        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/atualizar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void substituirCausa() throws Exception {
        EventoCausaDTO eventoCausaDTO = getEventoCausaDTO();
        eventoCausaDTO.setId(1L);
        eventoCausaDTO.setExcluido(Boolean.FALSE);
        eventoCausaDTO.setCpf("00000000000");
        eventoCausaDTO.setCausa(getCausaDTO());
        eventoCausaDTO.setEventoRisco(getEventoRiscoDTO());
        String requestJson = toJson(eventoCausaDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/causa/substituir")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void atualizarConsequencia() throws Exception {
        ConsequenciaDTO consequenciaDTO = getConsequenciaDTO();
        consequenciaDTO.setExcluido(Boolean.FALSE);
        consequenciaDTO.setDescricao("teste");
        consequenciaDTO.setSearch("teste");
        consequenciaDTO.setStatus(Boolean.TRUE);
        consequenciaDTO.setCpf("00000000000");
        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/atualizar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void substituirConsequencia() throws Exception {
        EventoConsequenciaDTO eventoConsequenciaDTO = getEventoConsequenciaDTO();
        eventoConsequenciaDTO.setId(1L);
        eventoConsequenciaDTO.setExcluido(Boolean.FALSE);
        eventoConsequenciaDTO.setCpf("00000000000");
        eventoConsequenciaDTO.setConsequencia(getConsequenciaDTO());
        eventoConsequenciaDTO.setEventoRisco(getEventoRiscoDTO());
        String requestJson = toJson(eventoConsequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/consequencia/substituir")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void atualizarControle() throws Exception {
        ControleDTO controleDTO = getControleDTO();
        controleDTO.setExcluido(Boolean.FALSE);
        controleDTO.setDescricao("teste");
        controleDTO.setSearch("teste");
        controleDTO.setStatus(Boolean.TRUE);
        controleDTO.setCpf("00000000000");
        String requestJson = toJson(controleDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/atualizar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void substituirControle() throws Exception {
        ControleEventoDTO controleEventoDTO = getControleEventoDTO();
        controleEventoDTO.setId(1L);
        controleEventoDTO.setExcluido(Boolean.FALSE);
        controleEventoDTO.setCpf("00000000000");
        controleEventoDTO.setDesenho(getDesenhoDTO());
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setEventoRisco(getEventoRiscoDTO());
        String requestJson = toJson(controleEventoDTO);
        mockMvc.perform(post(URL_BASE + "/eventosrisco/controle/substituir")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaEventoWhenNotEqualPersistido() throws Exception {
        EventoDTO eventoDTO = getEventoDTO();
        eventoDTO.setDescricao("Evento Tetse");
        eventoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/evento")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaEventoIdnull() throws Exception {
        EventoDTO eventoDTO = getEventoDTO();
        eventoDTO.setDescricao("Evento Tetse");
        eventoDTO.setCpf("11111111111");
        eventoDTO.setId(null);

        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/evento")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaEventoWhenEqualPersistido() throws Exception {
        EventoDTO eventoDTO = getEventoDTO();
        eventoDTO.setDescricao("evento1");
        eventoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/evento")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaEventohasId() throws Exception {
        EventoDTO eventoDTO = getEventoDTO();
        eventoDTO.setId(1L);
        eventoDTO.setDescricao("evento1");
        eventoDTO.setCpf("11111111111");

        String requestJson = toJson(eventoDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/evento")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaCausaWhenNotEqualPersistido() throws Exception {
        CausaDTO causaDTO = getCausaDTO();
        causaDTO.setDescricao("Causa Tetse");
        causaDTO.setCpf("11111111111");

        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/causa")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaCausaIdNull() throws Exception {
        CausaDTO causaDTO = getCausaDTO();
        causaDTO.setDescricao("Causa Tetse");
        causaDTO.setCpf("11111111111");
        causaDTO.setId(null);

        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/causa")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaCausaWhenEqualPersistido() throws Exception {
        CausaDTO causaDTO = getCausaDTO();
        causaDTO.setDescricao("causa1");
        causaDTO.setCpf("11111111111");

        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/causa")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaCausahasId() throws Exception {
        CausaDTO causaDTO = getCausaDTO();
        causaDTO.setId(1L);
        causaDTO.setDescricao("Causa 1");
        causaDTO.setCpf("11111111111");

        String requestJson = toJson(causaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/causa")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaConsequenciaWhenNotEqualPersistido() throws Exception {
        ConsequenciaDTO consequenciaDTO = getConsequenciaDTO();
        consequenciaDTO.setDescricao("Consequencia Tetse");
        consequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/consequencia")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaConsequenciaWhenEqualPersistido() throws Exception {
        ConsequenciaDTO consequenciaDTO = getConsequenciaDTO();
        consequenciaDTO.setDescricao("consequencia1");
        consequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/consequencia")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaConsequenciaIdNull() throws Exception {
        ConsequenciaDTO consequenciaDTO = getConsequenciaDTO();
        consequenciaDTO.setDescricao("consequencia1");
        consequenciaDTO.setCpf("11111111111");
        consequenciaDTO.setId(null);

        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/consequencia")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaConsequenciahasId() throws Exception {
        ConsequenciaDTO consequenciaDTO = getConsequenciaDTO();
        consequenciaDTO.setId(1L);
        consequenciaDTO.setDescricao("consequencia1");
        consequenciaDTO.setCpf("11111111111");

        String requestJson = toJson(consequenciaDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/consequencia")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaControleWhenNotEqualPersistido() throws Exception {
        ControleDTO controleDTO = getControleDTO();
        controleDTO.setDescricao("Controle Tetse");
        controleDTO.setCpf("11111111111");

        String requestJson = toJson(controleDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/controle")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaControleWhenEqualPersistido() throws Exception {
        ControleDTO controleDTO = getControleDTO();
        controleDTO.setDescricao("controle1");
        controleDTO.setCpf("11111111111");

        String requestJson = toJson(controleDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/controle")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaControleIdNull() throws Exception {
        ControleDTO controleDTO = getControleDTO();
        controleDTO.setDescricao("controle1");
        controleDTO.setCpf("11111111111");
        controleDTO.setId(null);

        String requestJson = toJson(controleDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/controle")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarTaxonomiaControlehasId() throws Exception {
        ControleDTO controleDTO = getControleDTO();
        controleDTO.setId(1L);
        controleDTO.setDescricao("controle1");
        controleDTO.setCpf("11111111111");

        String requestJson = toJson(controleDTO);
        mockMvc.perform(post(URL_BASE + "/taxonomia/controle")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void salvarCalculo() throws Exception {
        IdentificacaoDTO identificacaoDTO = getIdentificacaoDTO();
        identificacaoDTO.setEventos(Arrays.asList(getEventoRiscoDTO()));
        identificacaoDTO.setExcluido(Boolean.FALSE);
        String requestJson = toJson(identificacaoDTO);

        mockMvc.perform(post(URL_BASE + "/salvarcalculo")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void salvarCalculoCalculoRiscoInerente() throws Exception {
        IdentificacaoDTO identificacaoDTO = getIdentificacaoDTO();
        identificacaoDTO.setEventos(Arrays.asList(getEventoRiscoDTO()));

        String requestJson = toJson(identificacaoDTO);
        mockMvc.perform(post(URL_BASE + "/salvarcalculo")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void alterarIgnorarRiscoInerente() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(1L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE + "/avaliacao/alterarignorar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void alterarIgnorarRiscoInerenteTrue() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(7L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());
        processoDTO.setAvaliacao(new AvaliacaoDTO());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE + "/avaliacao/alterarignorar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void alterarIgnorarRiscoInerenteTrue2() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        processoDTO.setId(10L);
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setStatus(getStatusProcessoDTO());
        processoDTO.getResponsaveis().get(0).setUsuario(getUsuarioDTO());
        processoDTO.getCalculadoras().add(getCalculadoraDTO());
        processoDTO.getCalculadoras().get(0).setProbabilidades(new ArrayList<>());
        processoDTO.getCalculadoras().get(0).setImpactos(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());
        processoDTO.setAvaliacao(new AvaliacaoDTO());

        String requestJson = toJson(processoDTO);
        mockMvc.perform(post(URL_BASE + "/avaliacao/alterarignorar")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    @SneakyThrows
    public void alterarStatusImpactoCalculadora() throws Exception {
        CalculadoraDTO calculadoraDTO = getCalculadoraDTO();
        calculadoraDTO.setId(1l);
        ImpactoCalculadoraDTO impactoCalculadoraDTO = getImpactoCalculadoraDTO();
        impactoCalculadoraDTO.setDesabilitado(true);
        impactoCalculadoraDTO.setId(1l);
        impactoCalculadoraDTO.setPeso(1l);

        List<ImpactoCalculadoraDTO> impactoCalculadoraDTOList = new ArrayList<>();
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        calculadoraDTO.setImpactos(impactoCalculadoraDTOList);
        String requestJson = toJson(calculadoraDTO);
        mockMvc.perform(post(URL_BASE + "/impacto-calculadora/alterar-status")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void alterarStatusImpactoCalculadoras() throws Exception {
        CalculadoraDTO calculadoraDTO = getCalculadoraDTO();
        calculadoraDTO.setId(1l);
        ImpactoCalculadoraDTO impactoCalculadoraDTO = getImpactoCalculadoraDTO();
        impactoCalculadoraDTO.setDesabilitado(true);
        impactoCalculadoraDTO.setId(1l);
        impactoCalculadoraDTO.setPeso(1l);

        List<ImpactoCalculadoraDTO> impactoCalculadoraDTOList = new ArrayList<>();
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        calculadoraDTO.setImpactos(impactoCalculadoraDTOList);
        String requestJson = toJson(calculadoraDTO);
        mockMvc.perform(post(URL_BASE + "/impacto-calculadora/alterar-status/1")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void alterarStatusImpactoCalculadoras2() throws Exception {
        CalculadoraDTO calculadoraDTO = getCalculadoraDTO();
        calculadoraDTO.setId(2l);
        ImpactoCalculadoraDTO impactoCalculadoraDTO = getImpactoCalculadoraDTO();
        impactoCalculadoraDTO.setDesabilitado(true);
        impactoCalculadoraDTO.setId(1l);
        impactoCalculadoraDTO.setPeso(1l);

        List<ImpactoCalculadoraDTO> impactoCalculadoraDTOList = new ArrayList<>();
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        calculadoraDTO.setImpactos(impactoCalculadoraDTOList);
        String requestJson = toJson(calculadoraDTO);
        mockMvc.perform(post(URL_BASE + "/impacto-calculadora/alterar-status/2")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void alterarStatusImpactoCalculadoras3() throws Exception {
        CalculadoraDTO calculadoraDTO = getCalculadoraDTO();
        calculadoraDTO.setId(1l);
        ImpactoCalculadoraDTO impactoCalculadoraDTO = getImpactoCalculadoraDTO();
        impactoCalculadoraDTO.setDesabilitado(true);
        impactoCalculadoraDTO.setId(1l);
        impactoCalculadoraDTO.setPeso(1l);

        List<ImpactoCalculadoraDTO> impactoCalculadoraDTOList = new ArrayList<>();
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        impactoCalculadoraDTOList.add(impactoCalculadoraDTO);
        calculadoraDTO.setImpactos(impactoCalculadoraDTOList);
        String requestJson = toJson(calculadoraDTO);
        mockMvc.perform(post(URL_BASE + "/impacto-calculadora/alterar-status/7")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void saveRespostaRisco() throws Exception {
        EventoRiscoDTO eventoRiscoDTO = getEventoRiscoDTO();
        String requestJson = toJson(eventoRiscoDTO);
        mockMvc.perform(put(URL_BASE + "/resposta-risco/1")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void validarProcesso() throws Exception {
        ProcessoDTO processoDTO = criarProcessoDTO();
        DecisaoProcessoDTO decisaoDTO = new DecisaoProcessoDTO();
        decisaoDTO.setId(1L);
        decisaoDTO.setExcluido(false);
        decisaoDTO.setNome("Validar");
        processoDTO.setId(1L);
        processoDTO.setDecisao(decisaoDTO);
        String requestJson = toJson(processoDTO);
        mockMvc.perform(put(URL_BASE + "/validar-processo")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void savePlanoControle() throws Exception {
        PlanoControleDTO planoControleDTO = new PlanoControleDTO();
        planoControleDTO.setCpf("00000000000");
        planoControleDTO.setAreaResponsavel("teste");
        planoControleDTO.setImplementacao("teste");
        planoControleDTO.setResponsavel("teste");
        planoControleDTO.setInterveniente("teste");
        planoControleDTO.setExcluido(false);
        planoControleDTO.setEventoRisco(getEventoRiscoDTO());
        planoControleDTO.setControle(getControleDTO());
        TipoControleDTO tipoControleDTO = new TipoControleDTO();
        tipoControleDTO.setId(1l);
        planoControleDTO.setTipoControle(tipoControleDTO);
        ObjetivoControleDTO objetivoControleDTO = new ObjetivoControleDTO();
        objetivoControleDTO.setId(1l);
        planoControleDTO.setObjetivo(objetivoControleDTO);
        String requestJson = toJson(planoControleDTO);
        mockMvc.perform(post(URL_BASE + "/plano-controle/")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void savePlanoControleIdNull() throws Exception {
        PlanoControleDTO planoControleDTO = new PlanoControleDTO();
        planoControleDTO.setCpf("00000000000");
        planoControleDTO.setAreaResponsavel("teste");
        planoControleDTO.setImplementacao("teste");
        planoControleDTO.setResponsavel("teste");
        planoControleDTO.setInterveniente("teste");
        planoControleDTO.setExcluido(false);
        planoControleDTO.setEventoRisco(getEventoRiscoDTO());
        planoControleDTO.setControle(getControleDTO());
        planoControleDTO.getControle().setId(null);
        TipoControleDTO tipoControleDTO = new TipoControleDTO();
        tipoControleDTO.setId(1l);
        planoControleDTO.setTipoControle(tipoControleDTO);
        ObjetivoControleDTO objetivoControleDTO = new ObjetivoControleDTO();
        objetivoControleDTO.setId(1l);
        planoControleDTO.setObjetivo(objetivoControleDTO);
        String requestJson = toJson(planoControleDTO);
        mockMvc.perform(post(URL_BASE + "/plano-controle/")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void updatePlanoControle() throws Exception {
        PlanoControleDTO planoControleDTO = new PlanoControleDTO();
        planoControleDTO.setId(1L);
        planoControleDTO.setCpf("00000000000");
        planoControleDTO.setAreaResponsavel("teste");
        planoControleDTO.setImplementacao("teste");
        planoControleDTO.setResponsavel("teste");
        planoControleDTO.setInterveniente("teste");
        planoControleDTO.setExcluido(false);
        planoControleDTO.setEventoRisco(getEventoRiscoDTO());
        planoControleDTO.setControle(getControleDTO());
        TipoControleDTO tipoControleDTO = new TipoControleDTO();
        tipoControleDTO.setId(1l);
        planoControleDTO.setTipoControle(tipoControleDTO);
        ObjetivoControleDTO objetivoControleDTO = new ObjetivoControleDTO();
        objetivoControleDTO.setId(1l);
        planoControleDTO.setObjetivo(objetivoControleDTO);
        String requestJson = toJson(planoControleDTO);
        mockMvc.perform(put(URL_BASE + "/plano-controle/1")
                .contentType(contentType)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void findEventoWithControles() throws Exception {

        mockMvc.perform(get(URL_BASE + "/plano-controle/14")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void download() throws Exception {
        mockMvc.perform(get(URL_BASE + "/download/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/1")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso2() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/12")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void getEtapaProcesso3() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/7")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso4() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/13")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso5() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/2")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso6() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/4")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso7() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/11")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso8() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/14")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void getEtapaProcesso9() throws Exception {
        mockMvc.perform(get(URL_BASE + "/etapa/19")
                .contentType(contentType))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private CalculoRiscoDTO getCalculoRiscoDTO() {
        CalculoRiscoDTO calculoRiscoDTO = new CalculoRiscoDTO();
        calculoRiscoDTO.setId(2L);
        PesoEventoRiscoDTO pesoEventoRiscoDTO = new PesoEventoRiscoDTO();
        pesoEventoRiscoDTO.setId(1L);
        pesoEventoRiscoDTO.setPeso(3);
        pesoEventoRiscoDTO.setExcluido(Boolean.FALSE);
        calculoRiscoDTO.setPesos(Arrays.asList(pesoEventoRiscoDTO));
        return calculoRiscoDTO;
    }

    private PesoEventoRiscoDTO getPesoEventoRiscoDTO() {
        PesoEventoRiscoDTO pesoEventoRiscoDTO = new PesoEventoRiscoDTO();
        pesoEventoRiscoDTO.setId(1L);
        pesoEventoRiscoDTO.setPeso(3);
        pesoEventoRiscoDTO.setExcluido(Boolean.FALSE);
        pesoEventoRiscoDTO.setCalculoRisco(getCalculoRiscoDTO());
        return pesoEventoRiscoDTO;
    }

    private ProcessoDTO criarProcessoDTOEmpty() {
        ProcessoDTO processoDTO = new ProcessoDTO();
        processoDTO.setDtInicio(Calendar.getInstance());
        processoDTO.setDtCadastro(Calendar.getInstance());
        processoDTO.setDtFim(Calendar.getInstance());
        processoDTO.setGestor(getUsuarioDTO());
        processoDTO.setAnalise(getAnaliseDTOEmpty());
        processoDTO.setResponsaveis(new ArrayList<>());
        return processoDTO;
    }

    private ProcessoDTO criarProcessoDTO() {
        MacroprocessoDTO macroprocessoDTO = new MacroprocessoDTO();
        macroprocessoDTO.setId(1L);
        macroprocessoDTO.setDescricao("Macroprocesso");
        macroprocessoDTO.setSearch("Macroprocesso");
        ProcessoDTO processoDTO = criarProcessoDTOEmpty();
        processoDTO.setMacroprocesso(macroprocessoDTO);
        processoDTO.setProcesso("Processo");
        processoDTO.setGestor(getUsuarioDTO());
        processoDTO.setAnalise(getAnaliseDTOWithId());
        processoDTO.setIdentificacao(getIdentificacaoDTO());
        processoDTO.setAvaliacao(getAvaliacaoDTO());
        processoDTO.setCalculadoras(new ArrayList<>());
        processoDTO.setAnexos(new ArrayList<>());

        processoDTO.getAnalise().getMatrizes().add(getMatrizSwotDTO());
        processoDTO.getResponsaveis().add(getResponsavelDTO());
        return processoDTO;
    }

    private UsuarioDTO getUsuarioDTO() {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        usuarioDTO.setId(1L);
        return usuarioDTO;
    }

    private AnaliseDTO getAnaliseDTOEmpty() {
        AnaliseDTO analiseDTO = new AnaliseDTO();
        analiseDTO.setEtica(true);
        analiseDTO.setEstrutura(true);
        analiseDTO.setRecursosHumanos(true);
        analiseDTO.setAtribuicoes(true);
        analiseDTO.setNormasInternas(true);
        analiseDTO.setMissao(true);
        analiseDTO.setVisao(true);
        analiseDTO.setObjetivos(true);
        analiseDTO.setMatrizes(new ArrayList<>());
        return analiseDTO;
    }

    private AnaliseDTO getAnaliseDTOWithId() {
        AnaliseDTO analiseDTO = getAnaliseDTOEmpty();
        analiseDTO.setId(1L);
        return analiseDTO;
    }

    private IdentificacaoDTO getIdentificacaoDTO() {
        IdentificacaoDTO identificacaoDTO = new IdentificacaoDTO();
        identificacaoDTO.setId(1L);
        return identificacaoDTO;
    }

    private AvaliacaoDTO getAvaliacaoDTO() {
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO();
        avaliacaoDTO.setId(1L);
        avaliacaoDTO.setIgnorarRiscoInerente(true);
        return avaliacaoDTO;
    }

    private MatrizSwotDTO getMatrizSwotDTO() {
        MatrizSwotDTO matrizSwotDTO = new MatrizSwotDTO();
        matrizSwotDTO.setId(1L);
        matrizSwotDTO.setDescricao("Descricao");
        matrizSwotDTO.setTipoMatriz(new TipoMatrizDTO());
        matrizSwotDTO.getTipoMatriz().setId(1L);

        return matrizSwotDTO;
    }

    private ResponsavelDTO getResponsavelDTO() {
        ResponsavelDTO responsavelDTO = new ResponsavelDTO();
        responsavelDTO.setId(1L);

        return responsavelDTO;
    }

    private StatusProcessoDTO getStatusProcessoDTO() {
        StatusProcessoDTO statusProcessoDTO = new StatusProcessoDTO();
        statusProcessoDTO.setId(1L);

        return statusProcessoDTO;
    }

    private CalculadoraDTO getCalculadoraDTO() {
        return new CalculadoraDTO();
    }

    private ImpactoCalculadoraDTO getImpactoCalculadoraDTO() {
        return new ImpactoCalculadoraDTO();
    }

    private ProbabilidadeCalculadoraDTO getProbabilidadeCalculadoraDTO() {
        return new ProbabilidadeCalculadoraDTO();
    }

    private ProcessoAnexoDTO getProcessoAnexoDTO() {
        ProcessoAnexoDTO processoAnexoDTO = new ProcessoAnexoDTO();
        processoAnexoDTO.setArquivoAnexo(new ArquivoAnexoDTO());
        processoAnexoDTO.getArquivoAnexo().setId(1L);
        return processoAnexoDTO;
    }

    private EventoDTO getEventoDTO() {
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(1L);

        return eventoDTO;
    }

    private CategoriaDTO getCategoriaDTO() {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(1L);
        categoriaDTO.setDescricao("teste");
        categoriaDTO.setSearch("teste");
        categoriaDTO.setStatus(Boolean.TRUE);
        categoriaDTO.setExcluido(Boolean.FALSE);
        categoriaDTO.setNatureza(getNaturezaDTO());

        return categoriaDTO;
    }

    private NaturezaDTO getNaturezaDTO() {
        NaturezaDTO naturezaDTO = new NaturezaDTO();
        naturezaDTO.setId(1L);
        naturezaDTO.setDescricao("teste");
        naturezaDTO.setSearch("teste");
        naturezaDTO.setStatus(Boolean.TRUE);
        naturezaDTO.setExcluido(Boolean.FALSE);

        return naturezaDTO;
    }

    private DesenhoDTO getDesenhoDTO() {
        DesenhoDTO desenhoDTO = new DesenhoDTO();
        desenhoDTO.setId(1L);

        return desenhoDTO;
    }

    private OperacaoDTO getOperacaoDTO() {
        OperacaoDTO operacaoDTO = new OperacaoDTO();
        operacaoDTO.setId(1L);

        return operacaoDTO;
    }

    private ControleDTO getControleDTO() {
        ControleDTO controleDTO = new ControleDTO();
        controleDTO.setId(1L);

        return controleDTO;
    }

    private ControleEventoDTO getControleEventoDTO() {
        ControleEventoDTO controleEventoDTO = new ControleEventoDTO();
        controleEventoDTO.setDesenho(getDesenhoDTO());
        controleEventoDTO.setOperacao(getOperacaoDTO());
        controleEventoDTO.setControle(getControleDTO());
        controleEventoDTO.getControle().setDescricao("Controle Teste");

        return controleEventoDTO;
    }

    private EventoConsequenciaDTO getEventoConsequenciaDTO() {
        EventoConsequenciaDTO eventoConsequenciaDTO = new EventoConsequenciaDTO();
        eventoConsequenciaDTO.setConsequencia(new ConsequenciaDTO());
        eventoConsequenciaDTO.getConsequencia().setDescricao("Consequência Teste");

        return eventoConsequenciaDTO;
    }

    private EventoCausaDTO getEventoCausaDTO() {
        EventoCausaDTO eventoCausaDTO = new EventoCausaDTO();
        eventoCausaDTO.setCausa(new CausaDTO());
        eventoCausaDTO.getCausa().setDescricao("Causa Teste");

        return eventoCausaDTO;
    }

    private PlanoControleDTO getRespostaRiscoDTO() {
        PlanoControleDTO planoControleDTO = new PlanoControleDTO();
        planoControleDTO.setControle(new ControleDTO());
        planoControleDTO.getControle().setDescricao("Resposta Teste");

        planoControleDTO.setObjetivo(new ObjetivoControleDTO());
        planoControleDTO.getObjetivo().setId(1L);

        return planoControleDTO;
    }

    private EventoRiscoDTO criarEventoRiscoDTOEmpty() {
        EventoRiscoDTO eventoRiscoDTO = new EventoRiscoDTO();
        eventoRiscoDTO.setCpf("11111111111");
        eventoRiscoDTO.setIdentificacao(getIdentificacaoDTO());
        eventoRiscoDTO.getIdentificacao().setProcesso(criarProcessoDTO());
        eventoRiscoDTO.getIdentificacao().getProcesso().setId(1L);
        eventoRiscoDTO.setEvento(new EventoDTO());
        eventoRiscoDTO.getEvento().setDescricao("Evento Teste");
        eventoRiscoDTO.setCausas(new ArrayList<>());
        eventoRiscoDTO.getCausas().add(getEventoCausaDTO());
        eventoRiscoDTO.setConsequencias(new ArrayList<>());
        eventoRiscoDTO.getConsequencias().add(getEventoConsequenciaDTO());
        eventoRiscoDTO.setControleEventos(new ArrayList<>());
        eventoRiscoDTO.getControleEventos().add(getControleEventoDTO());
        eventoRiscoDTO.setControles(new ArrayList<>());
        eventoRiscoDTO.getControles().add(getRespostaRiscoDTO());
        eventoRiscoDTO.setCategoria(getCategoriaDTO());

        return eventoRiscoDTO;
    }

    private CausaDTO getCausaDTO() {
        CausaDTO causaDTO = new CausaDTO();
        causaDTO.setId(1L);
        return causaDTO;
    }

    private ConsequenciaDTO getConsequenciaDTO() {
        ConsequenciaDTO consequenciaDTO = new ConsequenciaDTO();
        consequenciaDTO.setId(1L);
        return consequenciaDTO;
    }

    private EventoRiscoDTO getEventoRiscoDTO() {
        EventoRiscoDTO eventoRiscoDTO = new EventoRiscoDTO();
        eventoRiscoDTO.setId(1L);
        return eventoRiscoDTO;
    }

}
