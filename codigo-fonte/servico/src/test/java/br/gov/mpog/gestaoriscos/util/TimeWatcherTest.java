package br.gov.mpog.gestaoriscos.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class TimeWatcherTest {

    @Mock
    private TimeWatcher timeWatcher;

    @Before
    public void setUp() {
    }

    @Test
    public void end() throws Exception {
        timeWatcher.end();
    }

    @Test
    public void start() throws Exception {
        TimeWatcher salvaDTO = timeWatcher.start();
        assertNotNull(salvaDTO);
    }

    @Test
    public void elapsedTimeStr() throws Exception {
        String salvaDTO = timeWatcher.elapsedTimeStr();
        assertNull(salvaDTO);
    }

}