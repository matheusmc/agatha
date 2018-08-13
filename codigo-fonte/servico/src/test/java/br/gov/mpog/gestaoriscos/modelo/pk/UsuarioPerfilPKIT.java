package br.gov.mpog.gestaoriscos.modelo.pk;

import br.gov.mpog.gestaoriscos.modelo.AgrupamentoTaxonomia;
import br.gov.mpog.gestaoriscos.modelo.Taxonomia;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 23/06/17.
 */
public class UsuarioPerfilPKIT {

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