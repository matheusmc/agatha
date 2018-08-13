package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.Orgao;
import br.gov.mpog.gestaoriscos.modelo.Usuario;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 23/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class UsuarioDTOIT {

    UsuarioDTO usuario;

    @Before
    public void setUp() throws Exception {
        usuario = new UsuarioDTO();
    }

    @Test
    public void constructoTest1() throws Exception {
        Usuario usuario = new Usuario(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING);
        usuario.setOrgao(new Orgao(Long.valueOf(1)));

        UsuarioDTO usuarioTeste = new UsuarioDTO(usuario);

        assertEquals(Long.valueOf(1), usuarioTeste.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuarioTeste.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuarioTeste.getCpf());
        assertEquals(usuario.getOrgao().getId(), usuarioTeste.getOrgao().getId());
    }

    @Test
    public void getId() throws Exception {
        usuario.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), usuario.getId());
    }

    @Test
    public void getNome() throws Exception {
        usuario.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getNome());
    }

    @Test
    public void getCpf() throws Exception {
        usuario.setCpf(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getCpf());
    }

    @Test
    public void getOrgao() throws Exception {
        OrgaoDTO orgao = new OrgaoDTO();

        usuario.setOrgao(orgao);
        assertEquals(orgao, usuario.getOrgao());
    }

    @Test
    public void getPermissoes() throws Exception {
        PermissaoDTO permissao = new PermissaoDTO();

        List<PermissaoDTO> permissaoList = new ArrayList<>();
        permissaoList.add(permissao);

        usuario.setPermissoes(permissaoList);
        assertEquals(permissaoList, usuario.getPermissoes());
    }

}