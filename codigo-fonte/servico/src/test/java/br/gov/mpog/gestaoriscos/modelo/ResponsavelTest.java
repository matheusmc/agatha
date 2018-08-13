package br.gov.mpog.gestaoriscos.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class ResponsavelTest {

    Responsavel responsavel;

    @Before
    public void setUp() throws Exception {
        responsavel = new Responsavel();
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
        Processo processo = new Processo();

        responsavel.setProcesso(processo);
        assertEquals(processo, responsavel.getProcesso());
    }

    @Test
    public void getUsuario() throws Exception {
        Usuario usuario = new Usuario();

        responsavel.setUsuario(usuario);
        assertEquals(usuario, responsavel.getUsuario());
    }

}