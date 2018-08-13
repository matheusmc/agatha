package br.gov.mpog.gestaoriscos.controller.ultil;

import br.gov.mpog.gestaoriscos.controller.util.PaginationUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Fábrica WGL on 23/03/17.
 */

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@IntegrationTest("server.port:0")
@RunWith(MockitoJUnitRunner.class)
public class PaginationUtilIT {

    @InjectMocks
    private PaginationUtil paginationUtil;

    @Mock
    private Page page;

    @Before
    public void setUp() {
    }

    @Test
    public void generatePaginationHttpHeaders() throws Exception {
        HttpHeaders salvaDTO = paginationUtil.generatePaginationHttpHeaders(page, "teste");
        assertNotNull(salvaDTO);
    }

    @Test
    public void generateUri() throws Exception {
        String salvaDTO = paginationUtil.generateUri("teste", 10, 1);
        assertNotNull(salvaDTO);
    }

}