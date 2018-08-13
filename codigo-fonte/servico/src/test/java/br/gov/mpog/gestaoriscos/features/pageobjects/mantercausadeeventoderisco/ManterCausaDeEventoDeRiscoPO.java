package br.gov.mpog.gestaoriscos.features.pageobjects.mantercausadeeventoderisco;

import br.com.basis.selenium.componentes.grids.angular.DataTableAngularFacade;
import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 * Created by gabriel.neves on 21/06/2017.
 */
public class ManterCausaDeEventoDeRiscoPO extends ComumPO {

    public ManterCausaDeEventoDeRiscoPO(final WebDriver driver) {
        super(driver);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(jquery = "button[ng-click=\"scope.limparFiltros()\"]")
    private WebElementFacade botaoLimpar;

    @FindBy(jquery = "button[ng-click=\"scope.filtrar()\"]")
    private WebElementFacade botaoConsultar;

    @FindBy(jquery = "button[ng-click=\"!scope.registro.id\"]")
    private WebElementFacade botaoNovo;

    @FindBy(jquery = "a[aria-label=\"Alterar\"]")
    private WebElementFacade botaoAlterar;

    @FindBy(jquery = "a[ng-click=\"scope.alterarStatus(item)\"]")
    private WebElementFacade botaoAlterarStatus;

    @FindBy(jquery = "a[aria-label=\"Excluir\"]")
    private WebElementFacade botaoExcluir;

    @FindBy(id = "idToken1")
    private WebElementFacade campoLogin;

    @FindBy(id = "idToken2")
    private WebElementFacade campoSenha;

    @FindBy(id = "loginButton_0")
    private WebElementFacade botaoLogin;

    @FindBy(ngModel = "$mdAutocompleteCtrl.scope.searchText")
    private WebElementFacade campoDescricao;

    @FindBy(ngModel = "scope.registro.status")
    private SelectAngularFacade selectStatus;

    @FindBy(id = "loading-bar")
    private WebElementFacade loading;

    @FindBy(tagName = "md-table-container")
    private DataTableAngularFacade dataTableAngularFacade;

    @FindBy(tagName = "md-toast")
    private WebElementFacade toastMensagem;

    @FindBy(tagName = "md-dialog")
    private WebElementFacade dialog;

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/manterCausaEventoRisco");
    }

    public void verificarPresencaCampos() {
        thenReturnElementList(By.jquery("button[ng-click=\"scope.limparFiltros()\"]")).get(0).isDisplayed();
        thenReturnElementList(By.jquery("button[ng-click=\"scope.filtrar()\"]")).get(0).isDisplayed();
        thenReturnElementList(By.jquery("md-icon:contains('add')")).get(0).isDisplayed();
    }

    public void incluirRisco() {
        loading.waitUntilNotVisible();
        campoDescricao.typeAndTab("Descricao do Causa");
        loading.waitUntilNotVisible();
        thenReturnElementList(By.jquery("md-icon:contains('add')")).get(0).click();
    }

    public void alterarRisco() {
        loading.waitUntilNotVisible();
        campoDescricao.typeAndTab("Descricao do Causa");
        loading.waitUntilNotVisible();
        thenReturnElementList(By.jquery("md-icon:contains('check')")).get(0).click();
    }

    public void clicarIncluir() {
        loading.waitUntilNotVisible();
        toastMensagem.waitUntilNotVisible();
        thenReturnElementList(By.jquery("md-icon:contains('add')")).get(0).click();
    }

    public void apresentarOutrosCampos() {
        Assert.assertTrue(botaoAlterar.isVisible());
        Assert.assertTrue(botaoExcluir.isVisible());
        Assert.assertTrue(botaoAlterarStatus.isVisible());
    }

    public void camposPreenchimento() {
        Assert.assertTrue(campoDescricao.isVisible());
    }

    public void exibeMensagem(String mensagem) {
        loading.waitUntilNotVisible();
        Assert.assertEquals(toastMensagem.getText(), mensagem);
    }

    public void verificarRegistroAtivado() {
        Assert.assertTrue(dataTableAngularFacade.validarRegistroGrid("Ativo"));
    }

    public void verificarRegistroInativado() {
        Assert.assertTrue(dataTableAngularFacade.validarRegistroGrid("Inativo"));
    }

    public void acionarAlterar() {
        loading.waitUntilNotVisible();
        botaoAlterar.waitUntilClickable();
        thenReturnElementList(By.jquery("a[ng-click=\"scope.findBy(item.id)\"]")).get(0).click();
    }

    public void acionarAtivar() {
        loading.waitUntilNotVisible();
        botaoAlterarStatus.waitUntilClickable();
        thenReturnElementList(By.jquery("a[ng-click=\"scope.alterarStatus(item)\"]")).get(1).click();
    }

    public void acionarInativar() {
        loading.waitUntilNotVisible();
        botaoAlterarStatus.waitUntilClickable();
        thenReturnElementList(By.jquery("a[ng-click=\"scope.alterarStatus(item)\"]")).get(0).click();
    }

    public void eInformouOsParametrosExistentes() {
        getAjaxStatus().waitUntilNotVisible();
        campoDescricao.waitUntilClickable().typeAndTab("Descricao do Causa");
    }

    public void camposHabilitados() {
        Assert.assertTrue(campoDescricao.isEnabled());
    }

    public void acionarExcluir() {
        loading.waitUntilNotVisible();
        thenReturnElementList(By.jquery("a[aria-label=\"Excluir\"]")).get(0).click();
    }

    public void apresentarMsg(String msg) {
        Assert.assertEquals(getDriver().findElement(By.jquery(".md-dialog-content-body p")).getText(), msg);
    }

    private void acionarOk() {
        dialog.waitUntilVisible();
        getDriver().findElement(By.jquery("md-dialog-actions button span:contains('OK')")).click();
    }


    public void acionarAcao(String opcao) {

        switch (opcao) {
            case "Alterar":
                acionarAlterar();
                getAjaxStatus().waitUntilNotVisible();
                break;
            case "Ativar":
                acionarAtivar();
                getAjaxStatus().waitUntilNotVisible();
                break;
            case "Inativar":
                acionarInativar();
                getAjaxStatus().waitUntilNotVisible();
                break;
            case "Ok":
                acionarOk();
                break;
            case "Incluir":
                loading.waitUntilNotVisible();
                thenReturnElementList(By.jquery("md-icon:contains('add')")).get(0).click();
                break;
            case "Limpar":
                loading.waitUntilNotVisible();
                thenReturnElementList(By.jquery("md-icon:contains('filter_list')")).get(0).click();
                break;
            default:
                break;
        }
    }

    public void validarCamposObrigatorios() {
        Assert.assertEquals(toastMensagem.getText(), "Campo(s) obrigatório(s) não preenchido(s)");
        Assert.assertTrue(campoDescricao.getAttribute("class").contains("ng-invalid ng-invalid-required"));
    }

    public void limparDadoInformados() {
        Assert.assertTrue(campoDescricao.getValue().isEmpty());
    }

}
