package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
public class EnderecoDTOTest {

    EnderecoDTO enderecoDTO;

    @Before
    public void setUp() throws Exception {
        enderecoDTO = new EnderecoDTO();
    }


    @Test
    public void getBairro() throws Exception {
        enderecoDTO.setBairro(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getBairro());
    }

    @Test
    public void getCep() throws Exception {
        enderecoDTO.setCep(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getCep());
    }

    @Test
    public void getComplemento() throws Exception {
        enderecoDTO.setComplemento(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getComplemento());
    }

    @Test
    public void getHorarioDeFuncionamento() throws Exception {
        enderecoDTO.setHorarioDeFuncionamento(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getHorarioDeFuncionamento());
    }

    @Test
    public void getLogradouro() throws Exception {
        enderecoDTO.setLogradouro(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getLogradouro());
    }

    @Test
    public void getMunicipio() throws Exception {
        enderecoDTO.setMunicipio(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getMunicipio());
    }

    @Test
    public void getNumero() throws Exception {
        enderecoDTO.setNumero(1);
        assertEquals(1, enderecoDTO.getNumero());
    }

    @Test
    public void getPais() throws Exception {
        enderecoDTO.setPais(1);
        assertEquals(1, enderecoDTO.getPais());
    }

    @Test
    public void getTipoEndereco() throws Exception {
        enderecoDTO.setTipoEndereco(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getTipoEndereco());
    }

    @Test
    public void getUf() throws Exception {
        enderecoDTO.setUf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, enderecoDTO.getUf());
    }

}