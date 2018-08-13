package br.gov.mpog.gestaoriscos.controller.ultil;

import br.gov.mpog.gestaoriscos.controller.util.HeaderUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Fábrica WGL on 23/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class HeaderUtilIT {

    @InjectMocks
    private HeaderUtil headerUltil;

    @Before
    public void setUp() {
    }


    @Test
    public void createAlert() throws Exception {
        HttpHeaders salvaDTO = headerUltil.createAlert("Teste", "teste");
        assertNotNull(salvaDTO);
    }

    @Test
    public void createEntityCreationAlert() throws Exception {
        HttpHeaders salvaDTO = headerUltil.createEntityCreationAlert("Teste", "teste");
        assertNotNull(salvaDTO);
    }

    @Test
    public void createEntityUpdateAlert() throws Exception {
        HttpHeaders salvaDTO = headerUltil.createEntityUpdateAlert("Teste", "teste");
        assertNotNull(salvaDTO);
    }

    @Test
    public void createEntityDeletionAlert() throws Exception {
        HttpHeaders salvaDTO = headerUltil.createEntityDeletionAlert("Teste", "teste");
        assertNotNull(salvaDTO);
    }

    @Test
    public void createFailureAlert() throws Exception {
        HttpHeaders salvaDTO = headerUltil.createFailureAlert("Teste", "teste", "teste");
        assertNotNull(salvaDTO);
    }

}