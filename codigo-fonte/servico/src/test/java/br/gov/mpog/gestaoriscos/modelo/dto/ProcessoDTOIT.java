package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class ProcessoDTOIT {

    ProcessoDTO processo;

    @Before
    public void setUp() throws Exception {
        processo = new ProcessoDTO();
    }

    @Test
    public void getId() throws Exception {
        processo.setId(1L);
        assertEquals(Long.valueOf(1), processo.getId());
    }

    @Test
    public void getProcesso() throws Exception {
        processo.setProcesso(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getProcesso());
    }

    @Test
    public void getSearch() throws Exception {
        processo.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getSearch());
    }

    @Test
    public void getDiretoria() throws Exception {
        processo.setDiretoria(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getDiretoria());
    }

    @Test
    public void getCoordenacao() throws Exception {
        processo.setCoordenacao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getCoordenacao());
    }

    @Test
    public void getObjetivo() throws Exception {
        processo.setObjetivo(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getObjetivo());
    }

    @Test
    public void getLei() throws Exception {
        processo.setLei(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getLei());
    }

    @Test
    public void getSistema() throws Exception {
        processo.setSistema(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, processo.getSistema());
    }

    @Test
    public void getDtCadastro() throws Exception {
        Calendar date = Calendar.getInstance();
        processo.setDtCadastro(date);
        assertEquals(date, processo.getDtCadastro());
    }

    @Test
    public void getDtInicio() throws Exception {
        Calendar date = Calendar.getInstance();
        processo.setDtInicio(date);
        assertEquals(date, processo.getDtInicio());
    }

    @Test
    public void getDtFim() throws Exception {
        Calendar date = Calendar.getInstance();
        processo.setDtFim(date);
        assertEquals(date, processo.getDtFim());
    }

    @Test
    public void isExcluido() throws Exception {
        processo.setExcluido(true);
        assertEquals(true, processo.isExcluido());
    }

    @Test
    public void getStatus() throws Exception {
        StatusProcessoDTO status = new StatusProcessoDTO();

        processo.setStatus(status);
        assertEquals(status, processo.getStatus());
    }

    @Test
    public void getGestor() throws Exception {
        UsuarioDTO usuario = new UsuarioDTO();

        processo.setGestor(usuario);
        assertEquals(usuario, processo.getGestor());
    }

    @Test
    public void getResponsaveis() throws Exception {
        ResponsavelDTO responsavel = new ResponsavelDTO();

        List<ResponsavelDTO> responsavelList = new ArrayList<>();
        responsavelList.add(responsavel);

        processo.setResponsaveis(responsavelList);
        assertEquals(responsavelList, processo.getResponsaveis());
    }

    @Test
    public void getAnexos() throws Exception {
        ProcessoAnexoDTO processoAnexo = new ProcessoAnexoDTO();

        List<ProcessoAnexoDTO> processoAnexoList = new ArrayList<>();
        processoAnexoList.add(processoAnexo);

        processo.setAnexos(processoAnexoList);
        assertEquals(processoAnexoList, processo.getAnexos());
    }

    @Test
    public void getAnalise() throws Exception {
        AnaliseDTO analise = new AnaliseDTO();

        processo.setAnalise(analise);
        assertEquals(analise, processo.getAnalise());
    }

    @Test
    public void getIdentificacao() throws Exception {
        IdentificacaoDTO identificacao = new IdentificacaoDTO();

        processo.setIdentificacao(identificacao);
        assertEquals(identificacao, processo.getIdentificacao());
    }

    @Test
    public void getAvaliacao() throws Exception {
        AvaliacaoDTO avaliacao = new AvaliacaoDTO();

        processo.setAvaliacao(avaliacao);
        assertEquals(avaliacao, processo.getAvaliacao());
    }

    @Test
    public void getCalculadoras() throws Exception {
        CalculadoraDTO calculadora = new CalculadoraDTO();

        List<CalculadoraDTO> calculadoraList = new ArrayList<>();
        calculadoraList.add(calculadora);

        processo.setCalculadoras(calculadoraList);
        assertEquals(calculadoraList, processo.getCalculadoras());
    }

}