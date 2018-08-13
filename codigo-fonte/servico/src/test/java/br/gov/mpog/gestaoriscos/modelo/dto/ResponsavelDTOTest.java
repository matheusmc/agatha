package br.gov.mpog.gestaoriscos.modelo.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ResponsavelDTOTest {

    ResponsavelDTO responsavel;

    @Before
    public void setUp() throws Exception {
        responsavel = new ResponsavelDTO();
    }

    @Test
    public void getId() throws Exception {
        responsavel.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), responsavel.getId());
    }

    @Test
    public void isExcluido() throws Exception {
        responsavel.setExcluido(true);
        assertEquals(true, responsavel.isExcluido());
    }

    @Test
    public void getProcesso() throws Exception {
        ProcessoDTO processo = new ProcessoDTO();

        responsavel.setProcesso(processo);
        assertEquals(processo, responsavel.getProcesso());
    }

    @Test
    public void getUsuario() throws Exception {
        UsuarioDTO usuario = new UsuarioDTO();

        responsavel.setUsuario(usuario);
        assertEquals(usuario, responsavel.getUsuario());
    }

}