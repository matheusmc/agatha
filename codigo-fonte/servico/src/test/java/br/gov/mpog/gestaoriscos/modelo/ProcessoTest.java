package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ProcessoTest {

    Processo processo;

    @Before
    public void setUp() throws Exception {
        processo = new Processo();
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
        StatusProcesso status = new StatusProcesso();

        processo.setStatus(status);
        assertEquals(status, processo.getStatus());
    }

    @Test
    public void getGestor() throws Exception {
        Usuario usuario = new Usuario();

        processo.setGestor(usuario);
        assertEquals(usuario, processo.getGestor());
    }

    @Test
    public void getResponsaveis() throws Exception {
        Responsavel responsavel = new Responsavel();

        List<Responsavel> responsavelList = new ArrayList<>();
        responsavelList.add(responsavel);

        processo.setResponsaveis(responsavelList);
        assertEquals(responsavelList, processo.getResponsaveis());
    }

    @Test
    public void getAnexos() throws Exception {
        ProcessoAnexo processoAnexo = new ProcessoAnexo();

        List<ProcessoAnexo> processoAnexoList = new ArrayList<>();
        processoAnexoList.add(processoAnexo);

        processo.setAnexos(processoAnexoList);
        assertEquals(processoAnexoList, processo.getAnexos());
    }

    @Test
    public void getAnalise() throws Exception {
        Analise analise = new Analise();

        processo.setAnalise(analise);
        assertEquals(analise, processo.getAnalise());
    }

    @Test
    public void getIdentificacao() throws Exception {
        Identificacao identificacao = new Identificacao();

        processo.setIdentificacao(identificacao);
        assertEquals(identificacao, processo.getIdentificacao());
    }

    @Test
    public void getAvaliacao() throws Exception {
        Avaliacao avaliacao = new Avaliacao();

        processo.setAvaliacao(avaliacao);
        assertEquals(avaliacao, processo.getAvaliacao());
    }

    @Test
    public void getCalculadoras() throws Exception {
        Calculadora calculadora = new Calculadora();

        List<Calculadora> calculadoraList = new ArrayList<>();
        calculadoraList.add(calculadora);

        processo.setCalculadoras(calculadoraList);
        assertEquals(calculadoraList, processo.getCalculadoras());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        Calendar date = Calendar.getInstance();

        Processo processo1 = new Processo();
        processo1.setId(1L);
        processo1.setProcesso(AnnotationStringUtil.TEST_STRING);
        processo1.setDiretoria(AnnotationStringUtil.TEST_STRING);
        processo1.setSistema(AnnotationStringUtil.TEST_STRING);
        processo1.setCoordenacao(AnnotationStringUtil.TEST_STRING);
        processo1.setDtInicio(date);
        processo1.setDtFim(date);
        processo1.setExcluido(true);

        Processo processo2 = new Processo();
        processo2.setId(2L);
        processo2.setProcesso(AnnotationStringUtil.TEST_STRING);
        processo2.setDiretoria(AnnotationStringUtil.TEST_STRING);
        processo2.setCoordenacao(AnnotationStringUtil.TEST_STRING);
        processo2.setSistema(AnnotationStringUtil.TEST_STRING);
        processo2.setDtInicio(date);
        processo2.setDtFim(date);
        processo2.setExcluido(true);

        assertNotEquals(processo1.hashCode(), processo2.hashCode());
    }
}