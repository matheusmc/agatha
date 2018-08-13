package br.gov.mpog.gestaoriscos.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

    @Mock
    private DateUtil dateUltil;

    @Before
    public void setUp() {
    }


    @Test
    public void getDateMinimizedHours() throws Exception {
        Date salvaDTO = dateUltil.getDateMinimizedHours(new Date());
        assertNotNull(salvaDTO);
    }

    @Test
    public void getDateMaximizedHours() throws Exception {
        Date salvaDTO = dateUltil.getDateMaximizedHours(new Date());
        assertNotNull(salvaDTO);
    }

    @Test
    public void getCalendarMinimizedHours() throws Exception {
        Calendar salvaDTO = dateUltil.getCalendarMinimizedHours(new Date());
        assertNotNull(salvaDTO);
    }

    @Test
    public void getCalendarMaximizedHours() throws Exception {
        Calendar salvaDTO = dateUltil.getCalendarMaximizedHours(new Date());
        assertNotNull(salvaDTO);
    }

    public void getDBTimestamp() throws Exception {
        String salvaDTO = dateUltil.getDBTimestamp(new Date());
        assertNotNull(salvaDTO);
    }

}