package br.gov.mpog.gestaoriscos.controller.ultil;

import br.gov.mpog.gestaoriscos.controller.util.ResponseUtil;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.annotation.DirtiesContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

/**
 * Created by Fábrica WGL on 03/07/17.
 */
@RunWith(PowerMockRunner.class)
@IntegrationTest("server.port:0")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ResponseUtilIT {

    @Test(expected = IllegalAccessError.class)
    @SneakyThrows
    public void testaConstrutorPrivado() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<ResponseUtil> constructor = ResponseUtil.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
