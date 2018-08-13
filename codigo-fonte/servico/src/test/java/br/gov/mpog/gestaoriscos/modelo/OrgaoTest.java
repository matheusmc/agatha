package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 22/06/17.
 */
public class OrgaoTest {

    Orgao orgao;

    @Before
    public void setUp() throws Exception {
        orgao = new Orgao();
    }

    @Test
    public void constructoTest1() throws Exception {
        Orgao orgao = new Orgao(Long.valueOf(1));

        assertEquals(Long.valueOf(1), orgao.getId());
    }

    @Test
    public void constructoTest2() throws Exception {
        Orgao orgaoPai = new Orgao();
        CategoriaUnidade categoriaUnidade = new CategoriaUnidade();
        NaturezaJuridica naturezaJuridica = new NaturezaJuridica();

        Orgao orgao = new Orgao(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING, categoriaUnidade, naturezaJuridica, orgaoPai);

        assertEquals(Long.valueOf(1), orgao.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getSigla());
        assertEquals(orgaoPai, orgao.getOrgaoPai());
        assertEquals(categoriaUnidade, orgao.getCategoriaUnidade());
        assertEquals(naturezaJuridica, orgao.getNaturezaJuridica());
    }

    @Test
    public void constructoTest3() throws Exception {
        Orgao orgaoPai = new Orgao(Long.valueOf(1));
        CategoriaUnidade categoriaUnidade = new CategoriaUnidade(Long.valueOf(1));
        NaturezaJuridica naturezaJuridica = new NaturezaJuridica(Short.valueOf("1"));

        Orgao orgao = new Orgao(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING, Long.valueOf(1), Long.valueOf(1), Short.valueOf("1"));

        assertEquals(Long.valueOf(1), orgao.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getSigla());
        assertEquals(orgaoPai.getId(), orgao.getOrgaoPai().getId());
        assertEquals(categoriaUnidade.getId(), orgao.getCategoriaUnidade().getId());
        assertEquals(Long.valueOf(1), orgao.getIdCategoriaUnidade());
        assertEquals(naturezaJuridica.getId(), orgao.getNaturezaJuridica().getId());
        assertEquals(Short.valueOf("1"), orgao.getIdNaturezaJuridica());
    }

    @Test
    public void getId() throws Exception {
        orgao.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), orgao.getId());
    }

    @Test
    public void getNome() throws Exception {
        orgao.setNome(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getNome());
    }

    @Test
    public void getSigla() throws Exception {
        orgao.setSigla(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, orgao.getSigla());
    }

    @Test
    public void getCategoriaUnidade() throws Exception {
        CategoriaUnidade categoriaUnidade = new CategoriaUnidade();

        orgao.setCategoriaUnidade(categoriaUnidade);
        assertEquals(categoriaUnidade, orgao.getCategoriaUnidade());
    }

    @Test
    public void getNaturezaJuridica() throws Exception {
        NaturezaJuridica naturezaJuridica = new NaturezaJuridica();

        orgao.setNaturezaJuridica(naturezaJuridica);
        assertEquals(naturezaJuridica, orgao.getNaturezaJuridica());
    }

    @Test
    public void getOrgaoPai() throws Exception {
        Orgao orgaoPai = new Orgao();

        orgao.setOrgaoPai(orgaoPai);
        assertEquals(orgaoPai, orgao.getOrgaoPai());
    }

    @Test
    public void getOrgaosFilhos() throws Exception {
        Orgao orgaoFilho = new Orgao();

        List<Orgao> orgaoFilhoList = new ArrayList<>();
        orgaoFilhoList.add(orgaoFilho);

        orgao.setOrgaosFilhos(orgaoFilhoList);
        assertEquals(orgaoFilhoList, orgao.getOrgaosFilhos());
    }

    @Test
    public void getUsuarios() throws Exception {
        Usuario usuario = new Usuario();

        List<Usuario> usuarioList = new ArrayList<>();
        usuarioList.add(usuario);

        orgao.setUsuarios(usuarioList);
        assertEquals(usuarioList, orgao.getUsuarios());
    }

    @Test
    public void getIdCategoriaUnidade() throws Exception {
        orgao.setIdCategoriaUnidade(Long.valueOf(1));
        assertEquals(Long.valueOf(1), orgao.getIdCategoriaUnidade());
    }

    @Test
    public void getIdNaturezaJuridica() throws Exception {
        orgao.setIdNaturezaJuridica(Short.valueOf("1"));
        assertEquals(Short.valueOf("1"), orgao.getIdNaturezaJuridica());
    }

}