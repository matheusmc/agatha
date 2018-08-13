package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.modelo.Orgao;
import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
public class OrgaoDTOTest {

    OrgaoDTO orgao;

    @Before
    public void setUp() throws Exception {
        orgao = new OrgaoDTO();
    }

    @Test
    public void constructoTest1() throws Exception {
        OrgaoDTO orgaoTeste = new OrgaoDTO(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING);

        assertEquals(Long.valueOf(1), orgaoTeste.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoTeste.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoTeste.getSigla());
    }

    @Test
    public void constructoTest2() throws Exception {
        OrgaoDTO orgaoTeste = new OrgaoDTO(Long.valueOf(1), AnnotationStringUtil.TEST_STRING, AnnotationStringUtil.TEST_STRING, Long.valueOf(1), Short.valueOf("1"));

        assertEquals(Long.valueOf(1), orgaoTeste.getId());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoTeste.getNome());
        assertEquals(AnnotationStringUtil.TEST_STRING, orgaoTeste.getSigla());
        assertEquals(Long.valueOf(1), orgaoTeste.getCategoriaUnidade().getId());
        assertEquals(Short.valueOf("1"), orgaoTeste.getNaturezaJuridica().getId());
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
        CategoriaUnidadeDTO categoriaUnidade = new CategoriaUnidadeDTO();

        orgao.setCategoriaUnidade(categoriaUnidade);
        assertEquals(categoriaUnidade, orgao.getCategoriaUnidade());
    }

    @Test
    public void getNaturezaJuridica() throws Exception {
        NaturezaJuridicaDTO naturezaJuridica = new NaturezaJuridicaDTO();

        orgao.setNaturezaJuridica(naturezaJuridica);
        assertEquals(naturezaJuridica, orgao.getNaturezaJuridica());
    }

    @Test
    public void getOrgaoPai() throws Exception {
        OrgaoDTO orgaoPai = new OrgaoDTO();

        orgao.setOrgaoPai(orgaoPai);
        assertEquals(orgaoPai, orgao.getOrgaoPai());
    }

    @Test
    public void getOrgaosFilhos() throws Exception {
        OrgaoDTO orgaoFilho = new OrgaoDTO();

        List<OrgaoDTO> orgaoFilhoList = new ArrayList<>();
        orgaoFilhoList.add(orgaoFilho);

        orgao.setOrgaosFilhos(orgaoFilhoList);
        assertEquals(orgaoFilhoList, orgao.getOrgaosFilhos());
    }

    @Test
    public void getUsuarios() throws Exception {
        UsuarioDTO usuario = new UsuarioDTO();

        List<UsuarioDTO> usuarioList = new ArrayList<>();
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