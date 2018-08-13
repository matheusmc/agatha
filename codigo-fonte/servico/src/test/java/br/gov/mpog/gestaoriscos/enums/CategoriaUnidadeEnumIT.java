package br.gov.mpog.gestaoriscos.enums;

import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class CategoriaUnidadeEnumIT {

    @Test
    public void getIdUnidadeAdministrativa() {
        CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.setId(1L);
        Long id = CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.getId();
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.getId());
    }

    @Test
    public void getUrlRefUnidadeAdministrativa() {
        CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.setUrlRef("AA");
        String id = CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.getUrlRef();
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.getUrlRef());
    }

    @Test
    public void obterIdPorUrlRefUnidadeAdministrativa() {
        Long id = CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.obterIdPorUrlRef("AA");
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_ADMINISTRATIVA.obterIdPorUrlRef("AA"));
    }

    @Test
    public void getIdUnidadeColegiada() {
        CategoriaUnidadeEnum.UNIDADE_COLEGIADA.setId(1L);
        Long id = CategoriaUnidadeEnum.UNIDADE_COLEGIADA.getId();
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_COLEGIADA.getId());
    }

    @Test
    public void getUrlRefUnidadeColegiada() {
        CategoriaUnidadeEnum.UNIDADE_COLEGIADA.setUrlRef("AA");
        String id = CategoriaUnidadeEnum.UNIDADE_COLEGIADA.getUrlRef();
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_COLEGIADA.getUrlRef());
    }

    @Test
    public void obterIdPorUrlRefUnidadeColegiada() {
        Long id = CategoriaUnidadeEnum.UNIDADE_COLEGIADA.obterIdPorUrlRef("AA");
        assertEquals(id, CategoriaUnidadeEnum.UNIDADE_COLEGIADA.obterIdPorUrlRef("AA"));
    }

    @Test
    public void getIdEntidade() {
        CategoriaUnidadeEnum.ENTIDADE.setId(1L);
        Long id = CategoriaUnidadeEnum.ENTIDADE.getId();
        assertEquals(id, CategoriaUnidadeEnum.ENTIDADE.getId());
    }

    @Test
    public void getUrlRefEntidade() {
        CategoriaUnidadeEnum.ENTIDADE.setUrlRef("AA");
        String id = CategoriaUnidadeEnum.ENTIDADE.getUrlRef();
        assertEquals(id, CategoriaUnidadeEnum.ENTIDADE.getUrlRef());
    }

    @Test
    public void obterIdPorUrlRefEntidade() {
        Long id = CategoriaUnidadeEnum.ENTIDADE.obterIdPorUrlRef("AA");
        assertEquals(id, CategoriaUnidadeEnum.ENTIDADE.obterIdPorUrlRef("AA"));
    }

    @Test
    public void getIdOrgao() {
        CategoriaUnidadeEnum.ORGAO.setId(1L);
        Long id = CategoriaUnidadeEnum.ORGAO.getId();
        assertEquals(id, CategoriaUnidadeEnum.ORGAO.getId());
    }

    @Test
    public void getUrlRefOrgao() {
        CategoriaUnidadeEnum.ORGAO.setUrlRef("AA");
        String id = CategoriaUnidadeEnum.ORGAO.getUrlRef();
        assertEquals(id, CategoriaUnidadeEnum.ORGAO.getUrlRef());
    }

    @Test
    public void obterIdPorUrlRefOrgao() {
        Long id = CategoriaUnidadeEnum.ORGAO.obterIdPorUrlRef("AA");
        assertEquals(id, CategoriaUnidadeEnum.ORGAO.obterIdPorUrlRef("AA"));
    }

    @Test
    public void getIdEnte() {
        CategoriaUnidadeEnum.ENTE.setId(1L);
        Long id = CategoriaUnidadeEnum.ENTE.getId();
        assertEquals(id, CategoriaUnidadeEnum.ENTE.getId());
    }

    @Test
    public void getUrlRefEnte() {
        CategoriaUnidadeEnum.ENTE.setUrlRef("AA");
        String id = CategoriaUnidadeEnum.ENTE.getUrlRef();
        assertEquals(id, CategoriaUnidadeEnum.ENTE.getUrlRef());
    }

    @Test
    public void obterIdPorUrlRefEnte() {
        Long id = CategoriaUnidadeEnum.ENTE.obterIdPorUrlRef("AA");
        assertEquals(id, CategoriaUnidadeEnum.ENTE.obterIdPorUrlRef("AA"));
    }

}
