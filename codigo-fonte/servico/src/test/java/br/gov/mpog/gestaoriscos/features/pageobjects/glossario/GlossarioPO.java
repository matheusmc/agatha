package br.gov.mpog.gestaoriscos.features.pageobjects.glossario;

import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * @author miller-macedo
 * @since 22/06/2017.
 */
@DefaultUrl("/")
public class GlossarioPO extends ComumPO {
    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(ngModel = "$mdAutocompleteCtrl.scope.searchText")
    private WebElementFacade inputDescricao;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade selectStatus;

    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade buttonLimpar;

    @FindBy(jquery = "button:contains(\"Consultar\")")
    private WebElementFacade buttonConsultar;

    @FindBy(jquery = "button:contains(\"Incluir\")")
    private WebElementFacade buttonIncluir;

    public GlossarioPO(WebDriver driver) {
        super(driver);
    }

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterGlossario");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void acionarAcao(String opcao) {
        switch (opcao) {
            case "Incluir":
                buttonIncluir.waitUntilClickable().click();
                break;

            case "Limpar":
                inputDescricao.sendKeys("Teste de Descrição");
                buttonLimpar.waitUntilVisible().waitUntilClickable().click();
                break;

            default:
                break;
        }
    }

    public void verificarCamposHabilitados() {
        Assert.assertTrue(inputDescricao.isCurrentlyEnabled());
        Assert.assertTrue(selectStatus.isCurrentlyEnabled());
    }

    public void validarCamposObrigatorios() {
        Assert.assertTrue(inputDescricao.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }

    public void validarCamposVazios() {
        Assert.assertEquals("", inputDescricao.getValue());
        Assert.assertNull(selectStatus.getValue());
    }
}

