package br.gov.mpog.gestaoriscos.features.runner.comum;

import br.com.basis.selenium.conexoes.ConnectionSample;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

/**
 * Created by marcus.ribeiro on 21/06/2017.
 */
public abstract class ComumStepDef {

    @Managed
    private WebDriver webDriver;
    private ConnectionSample connectionSample = new ConnectionSample();


    /**
     * @return o valor ao campo {@link WebDriver}
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * @param webDriver Atribui o valor ao campo {@link WebDriver}
     */
    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ConnectionSample getConnectionSample() {
        return connectionSample;
    }
}


