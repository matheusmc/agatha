package br.gov.mpog.gestaoriscos.features.pageobjects.gerenciarpermissoes;

import br.com.basis.selenium.componentes.mensagem.primeng.MensagemGrowlNGFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by marcus.ribeiro on 21/06/2017.
 */
@DefaultUrl("/preparacao")
public class GerenciarPermissoesPO extends ComumPO{

    public GerenciarPermissoesPO(WebDriver driver) {
        super(driver);
    }

    public GerenciarPermissoesPO(WebDriver driver, int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;


    @FindBy(id = "menu-button")
    private WebElementFacade menu;

    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade limpar;

    @FindBy(jquery = "button:contains(\"Consultar\")")
    private WebElementFacade consultar;

    @FindBy(jquery = "button:contains(\"search\")")
    private WebElementFacade search;

    @FindBy(jquery = "sgr-glossario[termo=\"Novo\"]")
    private WebElementFacade novo;

    @FindBy(jquery = "sgr-glossario[termo=\"Cancelar\"]")
    private WebElementFacade cancelar;

    @FindBy(jquery = "tree-view-orgao")
    private WebElementFacade arvoreOrgaoEntidade;

    @FindBy(jquery = "md-checkbox")
    private WebElementFacade primeiroUsrArvorePresidencia;

    @FindBy(jquery = "md-icon:contains(\"add\")")
    private WebElementFacade addUsuario;

    @FindBy(jquery = "md-select[aria-label=\"Perfil\"]")
    private WebElementFacade perfilSelect;

    @FindBy(jquery = "md-option:contains(\"Gestor do Processo\")")
    private WebElementFacade gestorProcessoOption;

    @FindBy(jquery = "span:contains(\"Presidência da República\")")
    private WebElementFacade presidenteDaRepOption;

    @FindBy(jquery = "md-table-container")
    private WebElementFacade tabelaPermissoesDeUsr;

    @FindBy(jquery = "a[aria-label=\"Alterar\"]")
    private WebElementFacade editarUsr;

    @FindBy(ngModel = "scope._permissao.perfil.id")
    private WebElementFacade selecionarPerfil;

    @FindBy(jquery = "md-toast" )
    private MensagemGrowlNGFacade growlMessage;

    @FindBy(jquery = "md-toast" )
    private MensagemGrowlNGFacade toastMessage;

    public WebElement usuarioInput(){
       return (WebElement) getDriver().findElements(By.jquery("input")).get(2);
    }

    public WebElement orgaoInput(){
        return (WebElement) getDriver().findElements(By.jquery("input")).get(1);
    }

    public WebElement informacoesUsuario(int usr){
        return (WebElement) getDriver().findElements(By.jquery("tr[ng-repeat=\"item in scope._registros\"]")).get(usr);
    }

    public WebElement salvarEdicaoUsr(){
        return (WebElement) getDriver().findElements(By.jquery("button:contains(\"Salvar\")")).get(1);
    }

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/gerenciarPermissoes/");
    }

    public void apresentaParametros() {
        Assert.assertTrue(limpar.isDisplayed());
        Assert.assertTrue(consultar.isDisplayed());
        Assert.assertTrue(novo.isDisplayed());
    }

    public void acionaAlterarPermissoes() {
        getAjaxStatus().waitUntilNotVisible();
        novo.click();
    }

    public void cancelaCadastro() {
        getAjaxStatus().waitUntilNotVisible();
        cancelar.click();
    }

    public void retornaParaATelaAnterior() {
        getAjaxStatus().waitUntilNotVisible();
        Assert.assertFalse(cancelar.isVisible());
        Assert.assertTrue(novo.isVisible());
    }

    public void acionarNovo() {
        getAjaxStatus().waitUntilNotVisible();
        novo.click();
    }

    public void apresentarArvore() {
        getAjaxStatus().waitUntilNotVisible();
        arvoreOrgaoEntidade.isVisible();
    }

    public void cadastrarUmUsuario() {
        getAjaxStatus().waitUntilNotVisible();
        this.expandeArvorePresidencia();
    }

    public void expandeArvorePresidencia(){
        getDriver().findElements(By.jquery("i")).get(3).click();
    }

    public boolean closeUsuarioIsDisplayed() {
       return getDriver().findElements(By.jquery("md-icon:contains(\"close\")")).get(1).isDisplayed();
    }

    public void incluirSegundoPerfil() {
        getAjaxStatus().waitUntilNotVisible();
        primeiroUsrArvorePresidencia.click();
    }

    public void acinarAdd() {
        getAjaxStatus().waitUntilNotVisible();
        addUsuario.waitUntilVisible();
    }

    public void apresentarOutroCampoDePerfil() {
        addUsuario.click();
        Assert.assertTrue(closeUsuarioIsDisplayed());
    }

    public void informarParametrosConsulta() {
        getAjaxStatus().waitUntilNotVisible();
        orgaoInput().sendKeys("Presidência da República");
        presidenteDaRepOption.click();
        perfilSelect.click();
        gestorProcessoOption.waitUntilClickable();
        gestorProcessoOption.click();
        usuarioInput().sendKeys("Ryan Correia Dias");
        //waitForCondition().until(drv -> usuarioInput().getText().contains("Ryan Correia Dias"));
    }

    public void acionarConsultar() {
        search.click();
    }

    public void apresentarResultados() {
        Assert.assertTrue(tabelaPermissoesDeUsr.getText().contains("Item"));
        Assert.assertTrue(tabelaPermissoesDeUsr.getText().contains("Nome do Usuário"));
        Assert.assertTrue(tabelaPermissoesDeUsr.getText().contains("Perfil"));
        Assert.assertTrue(tabelaPermissoesDeUsr.getText().contains("Ação"));
    }

    public void ordenarUsuarios() {
        getAjaxStatus().waitUntilNotVisible();
        Assert.assertTrue(informacoesUsuario(0).getText().contains("Ryan"));
        Assert.assertTrue(informacoesUsuario(1).getText().contains("Alfredo"));
    }

    public void alterarPerfil() {
        editarUsr.click();
        selecionarPerfil.click();
        getAjaxStatus().waitUntilNotVisible();
        gestorProcessoOption.click();
    }

    public void acionarSalvar() {
        salvarEdicaoUsr().click();
    }

    public void apresentarMensagem(String pMensagem) {
        growlMessage.waitUntilVisible();
        Assert.assertTrue(toastMessage.getText().contains("Registro alterado com sucesso!"));
    }
}

