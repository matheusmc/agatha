package br.gov.mpog.gestaoriscos.features.pageobjects.manteroperacaocontrole;

import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by janaina.santos on 23/06/2017
 */

public class ManterOperacaoControlePO extends ComumPO {

    public ManterOperacaoControlePO(WebDriver driver) {
        super(driver);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(jquery = "a[aria-label=\"Alterar\"]")
    private WebElementFacade botaoAlterar;

    @FindBy(jquery = "div:contains('Ativo')")
    private WebElementFacade status;

    @FindBy(jquery = "button:contains('Limpar')")
    private WebElementFacade botaoLimpar;

    @FindBy(jquery = "div[id=\"loading-bar\"]")
    private WebElementFacade loadingBar;

    @FindBy(jquery = "div[class=\"md-scroll-mask\"]")
    private WebElementFacade mask;

    @FindBy(jquery = "button:contains(\"Incluir\")")
    private WebElementFacade buttonIncluir;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade selectStatus;

    @FindBy(ngModel = "$mdAutocompleteCtrl.scope.searchText")
    private WebElementFacade descricao;

    public void acessarPagina() {
       autenticacaoOpenAmPO.acessarPagina("/manterOperacao");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void opcaoLimpar() {
        mask.waitUntilNotVisible();
        botaoAlterar.waitUntilClickable().click();
        botaoLimpar.waitUntilClickable().click();
    }

    public void limparDadoInformados() {
       Assert.assertTrue(descricao.getValue().isEmpty());
        Assert.assertFalse(status.isSelected());
    }

    public void opcaoIncluir() {
        buttonIncluir.waitUntilClickable().click();
    }

    public void verificarCamposHabilitados() {
        Assert.assertTrue(descricao.isCurrentlyEnabled());
        Assert.assertTrue(selectStatus.isCurrentlyEnabled());
    }

    public void validarCamposObrigatorios() {
        Assert.assertTrue(descricao.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }
}

