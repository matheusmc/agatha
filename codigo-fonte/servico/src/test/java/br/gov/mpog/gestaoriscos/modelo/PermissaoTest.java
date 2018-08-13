package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class PermissaoTest {

    Permissao permissao;

    @Before
    public void setUp() throws Exception {
        permissao = new Permissao();
    }

    @Test
    public void constructoTest1() throws Exception {
        Perfil perfil = new Perfil();
        perfil.setId(Long.valueOf(1));
        perfil.setNome(AnnotationStringUtil.TEST_STRING);

        Usuario usuario = new Usuario(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING);

        Permissao permissao = new Permissao();
        permissao.setId(Long.valueOf(1));
        permissao.setExcluido(true);
        permissao.setPerfil(perfil);
        permissao.setUsuario(usuario);

        Permissao permissaoTeste = new Permissao(permissao);

        assertEquals(Long.valueOf(1), permissaoTeste.getId());
        assertEquals(true, permissaoTeste.isExcluido());
        assertEquals(Long.valueOf(1), permissaoTeste.getPerfil().getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, permissaoTeste.getPerfil().getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, permissaoTeste.getUsuario().getNome());
    }

    @Test
    public void getId() throws Exception {
        permissao.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), permissao.getId());
    }

    @Test
    public void getUsuario() throws Exception {
        Usuario usuario = new Usuario();

        permissao.setUsuario(usuario);
        assertEquals(usuario, permissao.getUsuario());
    }

    @Test
    public void getPerfil() throws Exception {
        Perfil perfil = new Perfil();

        permissao.setPerfil(perfil);
        assertEquals(perfil, permissao.getPerfil());
    }

    @Test
    public void isExcluido() throws Exception {
        permissao.setExcluido(true);
        assertEquals(true, permissao.isExcluido());
    }

    @Test
    public void getDtCadastro() throws Exception {
        Date date = new Date();
        permissao.setDtCadastro(date);
        assertEquals(date, permissao.getDtCadastro());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        Permissao permissao1 = new Permissao();
        permissao1.setId(Long.valueOf(1));
        permissao1.setExcluido(true);

        Permissao permissao2 = new Permissao();
        permissao2.setId(Long.valueOf(2));
        permissao2.setExcluido(true);

        assertNotEquals(permissao1.hashCode(), permissao2.hashCode());
    }
}