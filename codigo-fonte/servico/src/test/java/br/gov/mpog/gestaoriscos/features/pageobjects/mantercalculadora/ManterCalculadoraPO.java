package br.gov.mpog.gestaoriscos.features.pageobjects.mantercalculadora;

import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by gabriel.neves on 23/06/2017.
 */
public class ManterCalculadoraPO extends ComumPO {


    public ManterCalculadoraPO(final WebDriver driver) {
        super(driver);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterCalculadora");
    }

    @FindBy(jquery = "button[ng-click=\"scope.init()\"]")
    private WebElementFacade botaoCancelar;


    @FindBy(jquery ="md-radio-button[aria-label=\"Calculadora do Risco Inerente\"]")
    private WebElementFacade calculadoraRisco;


    public void verificaPagina() {
        Assert.assertTrue(botaoCancelar.isVisible());
    }

    public void verificarCampos() {
        Assert.assertTrue(botaoCancelar.isVisible());
        thenReturnElementList(By.jquery("sgr-glossario:contains('Salvar')")).get(0).isDisplayed();
    }

    public void selecionaTipoCalculadora () {
        calculadoraRisco.waitUntilClickable();
        thenReturnElementList(By.jquery("md-radio-button[aria-label=\"Calculadora do Risco Inerente\"]")).get(0).isSelected();
    }

    public void verificarParamentros () {
        thenReturnElementList(By.jquery("input[ng-model=\"scope.registro.impactos[2].peso\"]")).get(0).isDisplayed();
    }

    public void acionarSalvar () {
        thenReturnElementList(By.jquery("sgr-glossario:contains('Salvar')")).get(0).click();
    }

    public void apresentarMensagem (String pMensagem) {
        getMensagem().possuiMensagem(pMensagem);
    }

    public void clicarCancelar () {
        new Actions(getDriver()).moveToElement(botaoCancelar).perform();
        botaoCancelar.waitUntilClickable().isVisible();
    }




}
