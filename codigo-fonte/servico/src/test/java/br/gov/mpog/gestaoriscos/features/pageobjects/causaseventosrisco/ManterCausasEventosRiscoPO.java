package br.gov.mpog.gestaoriscos.features.pageobjects.causaseventosrisco;

import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * @author Ludmily
 * @since 22/06/2017.
 */
public class ManterCausasEventosRiscoPO extends ComumPO {

    public ManterCausasEventosRiscoPO(WebDriver driver) {
        super(driver);
    }

    public ManterCausasEventosRiscoPO(WebDriver driver, int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade botaoLimpar;

    @FindBy(jquery = "button:contains(\"Incluir\")")
    private WebElementFacade botaoIncluir;

    @FindBy(ngModel = "$mdAutocompleteCtrl.scope.searchText")
    private WebElementFacade inputDescricao;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade selectCausa;


    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterCausaEventoRisco");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void acionarAcao(String acao) {
        switch (acao) {
            case "Limpar":
                botaoLimpar.waitUntilVisible().waitUntilClickable().click();
                break;

            case "Incluir":
                botaoIncluir.waitUntilVisible().waitUntilClickable().click();
                break;
        }
    }

    public void oSistemaLimpaOsDadosInformados() {
        Assert.assertTrue(inputDescricao.getValue().equals(""));
        Assert.assertTrue(selectCausa.getText().equals("Status da Causa"));
    }

    public void oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelho() {
        Assert.assertTrue(inputDescricao.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }

    public void oSistemaApresentaOFormularioParaInformarDadosDaCausaDoEventoDeRisco(){
        Assert.assertTrue(inputDescricao.isCurrentlyVisible());
        Assert.assertTrue(selectCausa.isCurrentlyVisible());
    }
}
