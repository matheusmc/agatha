package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.*;

/**
 * Created by luizfernando on 25/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class ServicoDTOTest {

    ServicoDTO servicoDTO;

    @Before
    public void setUp() throws Exception {
        servicoDTO = new ServicoDTO();
    }

    @Test
    public void getCodigoErro() throws Exception {
        servicoDTO.setCodigoErro(Long.valueOf(1));
        assertEquals(1, servicoDTO.getCodigoErro());
    }

    @Test
    public void getMensagem() throws Exception {
        servicoDTO.setMensagem(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, servicoDTO.getMensagem());
    }

    @Test
    public void getData() throws Exception {
        servicoDTO.setData(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, servicoDTO.getData());
    }

    @Test
    public void getIpRequisitante() throws Exception {
        servicoDTO.setIpRequisitante(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, servicoDTO.getIpRequisitante());
    }

    @Test
    public void getTicket() throws Exception {
        servicoDTO.setTicket(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, servicoDTO.getTicket());
    }

    @Test
    public void getVersaoServico() throws Exception {
        servicoDTO.setVersaoServico(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, servicoDTO.getVersaoServico());
    }

}