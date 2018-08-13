package br.gov.mpog.gestaoriscos.features.pageobjects.calcularriscoinerente;

import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by isabelle.gomes on 23/06/2017.
 */
public class CalcularRiscoInerentePO extends ComumPO {
    public CalcularRiscoInerentePO(final WebDriver driver) {
        super( driver );
    }

    public CalcularRiscoInerentePO(WebDriver driver, int ajaxTimeout) {
        super( driver, ajaxTimeout );
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;


    @FindBy(ngModel = "scope.registro.impactos[0].peso")
    private WebElementFacade campo1;

    @FindBy(ngModel = "scope.registro.impactos[1].peso")
    private WebElementFacade campo2;

    @FindBy(ngModel = "scope.registro.impactos[2].peso")
    private WebElementFacade campo3;

    @FindBy(ngModel = "scope.registro.impactos[3].peso")
    private WebElementFacade campo4;

    @FindBy(ngModel = "scope.registro.impactos[4].peso")
    private WebElementFacade campo5;

    @FindBy(ngModel = "scope.registro.impactos[5].peso")
    private WebElementFacade campo6;

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina( "/manterCalculadora" );
        getAjaxStatus().waitUntilNotVisible();
    }

    public void informarDados() {
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[0].peso\"]")).get(0).sendKeys( "10" );
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[1].peso\"]")).get(0).sendKeys( "12" );
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[2].peso\"]")).get(0).sendKeys( "14" );
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[3].peso\"]")).get(0).sendKeys( "16" );
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[4].peso\"]")).get(0).sendKeys( "18" );
        thenReturnElementList( By.jquery("input[ng-model=\"scope.registro.impactos[5].peso\"]")).get(0).sendKeys( "13" );

    }

    public void porcentagem() {
        Assert.assertTrue(thenReturnElementList( By.jquery( "div[class=\"md-block flex-gt-xs flex-10\"]" ) ).get( 0 ).isDisplayed() );

    }

    public void limparCampos() {
        campo1.clear();
        Assert.assertTrue(campo1.getValue().isEmpty());
        campo2.clear();
        Assert.assertTrue(campo2.getValue().isEmpty());
        campo3.clear();
        Assert.assertTrue(campo3.getValue().isEmpty());
        campo4.clear();
        Assert.assertTrue(campo4.getValue().isEmpty());
        campo5.clear();
        Assert.assertTrue(campo5.getValue().isEmpty());
        campo6.clear();
        Assert.assertTrue(campo6.getValue().isEmpty());

    }
}