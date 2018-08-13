package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.Perfil;
import br.gov.mpog.gestaoriscos.modelo.Permissao;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class PermissaoDTOIT {

    PermissaoDTO permissao;

    @Before
    public void setUp() throws Exception {
        permissao = new PermissaoDTO();
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

        PermissaoDTO permissaoTeste = new PermissaoDTO(permissao);

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
        UsuarioDTO usuario = new UsuarioDTO();

        permissao.setUsuario(usuario);
        assertEquals(usuario, permissao.getUsuario());
    }

    @Test
    public void getPerfil() throws Exception {
        PerfilDTO perfil = new PerfilDTO();

        permissao.setPerfil(perfil);
        assertEquals(perfil, permissao.getPerfil());
    }

    @Test
    public void getDtCadastro() throws Exception {
        Date date = new Date();
        permissao.setDtCadastro(date);
        assertEquals(date, permissao.getDtCadastro());
    }

    @Test
    public void isExcluido() throws Exception {
        permissao.setExcluido(true);
        assertEquals(true, permissao.isExcluido());
    }
}