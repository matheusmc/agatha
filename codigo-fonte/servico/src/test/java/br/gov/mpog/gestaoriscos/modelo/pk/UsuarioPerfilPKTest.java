package br.gov.mpog.gestaoriscos.modelo.pk;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
public class UsuarioPerfilPKTest {

    UsuarioPerfilPK usuarioPerfilPK;

    @Before
    public void setUp() throws Exception {
        usuarioPerfilPK = new UsuarioPerfilPK();
    }

    @Test
    public void getIdUsuario() throws Exception {
        usuarioPerfilPK.setIdUsuario(Long.valueOf(1));
        assertEquals(Long.valueOf(1), usuarioPerfilPK.getIdUsuario());
    }

    @Test
    public void getIdPerfil() throws Exception {
        usuarioPerfilPK.setIdPerfil(Long.valueOf(1));
        assertEquals(Long.valueOf(1), usuarioPerfilPK.getIdPerfil());
    }

}