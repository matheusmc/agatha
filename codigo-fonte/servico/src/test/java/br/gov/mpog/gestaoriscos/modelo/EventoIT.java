package br.gov.mpog.gestaoriscos.modelo;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 22/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class EventoIT {

    Evento evento;

    @Before
    public void setUp() throws Exception {
        evento = new Evento();
    }

    @Test
    public void getId() throws Exception {
        evento.setId(Long.valueOf(1));
        assertEquals(Long.valueOf(1), evento.getId());
    }

    @Test
    public void getDescricao() throws Exception {
        evento.setDescricao(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, evento.getDescricao());
    }

    @Test
    public void getSearch() throws Exception {
        evento.setSearch(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, evento.getSearch());
    }

    @Test
    public void isStatus() throws Exception {
        evento.setStatus(true);
        assertEquals(true, evento.isStatus());
    }

    @Test
    public void isExcluido() throws Exception {
        evento.setExcluido(true);
        assertEquals(true, evento.isExcluido());
    }

    @Test
    public void getOrgao() throws Exception {
        Orgao orgao = new Orgao();

        evento.setOrgao(orgao);
        assertEquals(orgao, evento.getOrgao());
    }

}