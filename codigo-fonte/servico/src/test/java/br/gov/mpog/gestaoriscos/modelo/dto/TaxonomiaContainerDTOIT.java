package br.gov.mpog.gestaoriscos.modelo.dto;

import br.gov.mpog.gestaoriscos.util.AnnotationStringUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by luizfernando on 25/06/17.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
public class TaxonomiaContainerDTOIT {

    TaxonomiaContainerDTO taxonomiaContainerDTO;

    @Before
    public void setUp() throws Exception {
        taxonomiaContainerDTO = new TaxonomiaContainerDTO();
    }

    @Test
    public void getTaxonomias() throws Exception {
        TaxonomiaDTO taxonomias = new TaxonomiaDTO();

        List<TaxonomiaDTO> taxonomiasList = new ArrayList<>();
        taxonomiasList.add(taxonomias);

        taxonomiaContainerDTO.setTaxonomias(taxonomiasList);
        assertEquals(taxonomiasList, taxonomiaContainerDTO.getTaxonomias());
    }

    @Test
    public void getJustificativa() throws Exception {
        taxonomiaContainerDTO.setJustificativa(AnnotationStringUtil.TEST_STRING);
        assertEquals(AnnotationStringUtil.TEST_STRING, taxonomiaContainerDTO.getJustificativa());
    }

}