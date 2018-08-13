package br.gov.mpog.gestaoriscos.features.pageobjects.naturezarisco;

import br.com.basis.selenium.componentes.grids.angular.DataTableAngularFacade;
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
public class NaturezaRiscoPO extends ComumPO {
    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(ngModel = "$mdAutocompleteCtrl.scope.searchText")
    private WebElementFacade inputDescricaoNatureza;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade selectStatus;

    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade buttonLimpar;

    @FindBy(jquery = "button:contains(\"Incluir\")")
    private WebElementFacade buttonIncluir;

    @FindBy(tagName = "table")
    private DataTableAngularFacade tabelaListagem;

    @FindBy(jquery = "a[ng-click='scope.findBy(item.id)']")
    private WebElementFacade botaoAlterar;


    public NaturezaRiscoPO(WebDriver driver) {
        super(driver);
    }

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterNatureza");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void acionarAcao(String opcao) {
        switch (opcao) {
            case "Incluir":
                buttonIncluir.waitUntilClickable().click();
                break;

            case "Limpar":
                inputDescricaoNatureza.sendKeys("Teste");
                inputDescricaoNatureza.sendKeys(Keys.TAB);
                buttonLimpar.waitUntilVisible().waitUntilClickable().click();
                break;

            case "Alterar":
                botaoAlterar.waitUntilClickable().click();
                getAjaxStatus().waitUntilNotVisible();
                break;
            default:
                break;
        }
    }

    public void verificarCamposHabilitados() {
        Assert.assertTrue(inputDescricaoNatureza.isCurrentlyEnabled());
        Assert.assertTrue(selectStatus.isCurrentlyEnabled());
    }

    public void validarCamposObrigatorios() {
        Assert.assertTrue(inputDescricaoNatureza.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }

    public void validarCamposVazios() {
        Assert.assertEquals("", inputDescricaoNatureza.getValue());
        Assert.assertNull(selectStatus.getValue());
    }

    public void validarCamposParaEdicao() {
        Assert.assertNotNull(inputDescricaoNatureza.getValue());
    }
}

