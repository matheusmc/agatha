package br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam;

import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * @author silas.silva
 * @since 22/06/2017.
 */
@DefaultUrl("/")
public class AutenticacaoOpenAmPO extends ComumPO {

    @FindBy(id = "idToken1")
    private WebElementFacade userName;

    @FindBy(id = "idToken2")
    private WebElementFacade pass;

    @FindBy(id = "loginButton_0")
    private WebElementFacade submit;

    public AutenticacaoOpenAmPO(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo resposnsavel por realizar login
     * e acessar a pagina
     *
     * @param urlPagina url da pagina a ser acessada
     */
    public void acessarPagina(String urlPagina) {
        abrirPagina();
        preencherCampos();
        localizarPagina(urlPagina);
        verificarUrl(urlPagina);
    }

    public void localizarPagina(String urlPagina) {
        waitForCondition().until(drv -> getDriver().getCurrentUrl().contains(System.getProperty("webdriver.base.url")));
        getDriver().get(System.getProperty("webdriver.base.url").concat(urlPagina));
    }

    public void preencherCampos() {
        userName.waitUntilVisible().sendKeys("61914509153");
        pass.type("123456789");
        submit.click();
    }

    public void abrirPagina() {
        open();
        getDriver().navigate().refresh();
    }

    public void verificarUrl(String urlPagina){
        Assert.assertEquals(System.getProperty("webdriver.base.url").concat(urlPagina), getDriver().getCurrentUrl());
    }
}

