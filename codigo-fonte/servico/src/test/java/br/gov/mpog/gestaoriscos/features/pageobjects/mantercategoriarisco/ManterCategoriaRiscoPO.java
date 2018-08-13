package br.gov.mpog.gestaoriscos.features.pageobjects.mantercategoriarisco;

import br.com.basis.selenium.componentes.grids.angular.DataTableAngularFacade;
import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * @author jose.rodrigues
 * @since 22/06/2017
 */
public class ManterCategoriaRiscoPO extends ComumPO {

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(css = "md-input-container .md-input")
    private WebElementFacade descricaoCategoria;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade statusCategoria;

    @FindBy(jquery = "button:contains('Limpar')")
    private WebElementFacade botaoLimpar;

    @FindBy(jquery = "button:contains('Consultar')")
    private WebElementFacade botaoConsultar;

    @FindBy(jquery = "button:contains('Incluir')")
    private WebElementFacade botaoIncluir;

    @FindBy(tagName = "md-toast")
    private WebElementFacade toastMensagem;

    @FindBy(tagName = "md-table-container")
    private DataTableAngularFacade dataTableAngularFacade;

    public ManterCategoriaRiscoPO(WebDriver driver) {
        super(driver);
    }

    public ManterCategoriaRiscoPO(WebDriver driver, int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterCategoria");

    }

    public void acionarAcao(String acao) {
        getAjaxStatus().waitUntilNotVisible();
        switch (acao) {
            case "Incluir":
                botaoIncluir.waitUntilVisible().waitUntilClickable().click();
                break;

            case "Limpar":
                botaoLimpar.waitUntilVisible().waitUntilClickable().click();
                break;

        }
    }

    public void oSistemaLimpaOsDadosInformados() {
        Assert.assertTrue(descricaoCategoria.getValue().equals(""));
        Assert.assertTrue(statusCategoria.getText().equals("Status da Categoria"));
    }

    public void oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelho() {
        Assert.assertTrue(descricaoCategoria.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }

    public void oSistemaApresentaOFormularioParaInformarDadosDaCausaDoEventoDeRisco() {
        Assert.assertTrue(descricaoCategoria.isCurrentlyVisible());
        Assert.assertTrue(statusCategoria.isCurrentlyVisible());
    }

    public void eInformouOsParametrosNecessarios() {
        descricaoCategoria.waitUntilClickable().type("Nova Categoria");
        getAjaxStatus().waitUntilNotVisible();
        statusCategoria.abrirSelect().selectItem("Ativo");
    }

    public void adicionaItemSalvoLista() {
        getAjaxStatus().waitUntilNotVisible();
        dataTableAngularFacade.validarRegistroGrid("Nova Categoria");
    }

    public void exibeMensagem(String mensagem) {
        Assert.assertEquals(toastMensagem.waitUntilPresent().getText(), mensagem);
    }

    public void eInformouOsParametrosExistentes() {
        getAjaxStatus().waitUntilNotVisible();
        statusCategoria.waitUntilClickable();
        statusCategoria.abrirSelect().selectItem("Ativo");
        descricaoCategoria.waitUntilClickable().typeAndTab("Fiscal");
    }

}

