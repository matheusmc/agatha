package br.gov.mpog.gestaoriscos.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilTest {

    @Mock
    private StringUtil stringUtil;

    @Before
    public void setUp() {
    }

    @Test
    public void removerAcento() throws Exception {
        String salvaDTO = stringUtil.removerAcento("ÀÁ");
        assertNotNull(salvaDTO);
    }

}