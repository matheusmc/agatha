package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by luizfernando on 23/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class UsuarioIT {

    Usuario usuario;

    @Before
    public void setUp() throws Exception {
        usuario = new Usuario();
    }

    @Test
    public void constructoTest1() throws Exception {
        Usuario usuario = new Usuario(Long.valueOf(1));

        assertEquals(Long.valueOf(1), usuario.getId());
    }

    @Test
    public void constructoTest2() throws Exception {
        Usuario usuario = new Usuario(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING);

        assertEquals(Long.valueOf(1), usuario.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getCpf());
    }

    @Test
    public void constructoTest3() throws Exception {
        Usuario usuario = new Usuario(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING, Long.valueOf(1));

        assertEquals(Long.valueOf(1), usuario.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, usuario.getCpf());
        assertEquals(Long.valueOf(1), usuario.getOrgao().getId());
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
        Orgao orgao = new Orgao();

        usuario.setOrgao(orgao);
        assertEquals(orgao, usuario.getOrgao());
    }

    @Test
    public void getPermissoes() throws Exception {
        Permissao permissao = new Permissao();

        List<Permissao> permissaoList = new ArrayList<>();
        permissaoList.add(permissao);

        usuario.setPermissoes(permissaoList);
        assertEquals(permissaoList, usuario.getPermissoes());
    }

    @Test
    public void hashCodeNotEquals() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setId(Long.valueOf(1));
        usuario1.setNome(AnnotationStringUtil.TEST_STRING);
        usuario1.setCpf(AnnotationStringUtil.TEST_STRING);

        Usuario usuario2 = new Usuario();
        usuario2.setId(Long.valueOf(2));
        usuario2.setNome(AnnotationStringUtil.TEST_STRING);
        usuario2.setCpf(AnnotationStringUtil.TEST_STRING);

        assertNotEquals(usuario1.hashCode(), usuario2.hashCode());
    }

}