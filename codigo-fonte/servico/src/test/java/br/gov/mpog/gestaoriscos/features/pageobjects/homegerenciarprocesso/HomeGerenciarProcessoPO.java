package br.gov.mpog.gestaoriscos.features.pageobjects.homegerenciarprocesso;

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
public class HomeGerenciarProcessoPO extends ComumPO {


    public HomeGerenciarProcessoPO(WebDriver driver) {
        super(driver);
    }

    public HomeGerenciarProcessoPO(WebDriver driver, int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @FindBy(jquery = "ng-md-icon[icon='search']")
    private WebElementFacade botaoVisualizarPrincipal;

    @FindBy(jquery = "ng-md-icon[icon='check_box']")
    private WebElementFacade botaoValidarPrincipal;

    @FindBy(jquery = "ng-md-icon[icon='create']")
    private WebElementFacade botaoAlterarPrincipal;

    @FindBy(jquery = "md-icon:contains(\"add\")")
    private WebElementFacade botaoIncluirPrincipal;

    @FindBy(jquery = "md-tab-item:contains(\"Análise de Ambiente e de Fixação de Objetivos\")")
    private WebElementFacade abaFormularioInformacoes;

    @FindBy(ngModel = "scope.registro.diretoria")
    private WebElementFacade inputDiretoria;

    public void acessarPagina() {
        autenticacaoOpenAmPO.acessarPagina("/");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oSistemaApresentaAEtapaSelecionadaParaVisualizacaoComAsOpcoesVoltarEImprimir() {
        Assert.assertTrue(abaFormularioInformacoes.isCurrentlyVisible());
        Assert.assertTrue(inputDiretoria.getValue().equals("teste"));
    }

    public void oUsuarioAcionarAOpcaoVisualizar() {
        botaoVisualizarPrincipal.waitUntilVisible().click();
    }

    public void oSistemaApresentaAFuncionalidadeUSFormularioDeLevantamentoDeInformacoesSobreAmbienteESobreAFixacaoDeObjetivos() {
        Assert.assertTrue(abaFormularioInformacoes.isCurrentlyVisible());
        Assert.assertTrue(inputDiretoria.getValue().equals(""));
    }

    public void oUsuarioAcionarAOpcaoIncluir() {
        botaoIncluirPrincipal.waitUntilVisible().click();
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oUsuarioAcionarAOpcaoAlterarEmUmaEtapaDesejada() {
        botaoAlterarPrincipal.waitUntilVisible().click();
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oSistemaApresentaOFormularioDaEtapaSelecionadaParaAlteracao() {
        Assert.assertTrue(abaFormularioInformacoes.isCurrentlyVisible());
        Assert.assertTrue(inputDiretoria.getValue().equals("teste"));
    }

    public void oUsuarioAcionarAOpcaoValidar() {
        botaoValidarPrincipal.waitUntilVisible().click();
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oSistemaApresentaOFormularioSelecionadoParaAValidacao() {
        Assert.assertTrue(abaFormularioInformacoes.isCurrentlyVisible());
        Assert.assertTrue(inputDiretoria.getValue().equals("teste"));
    }
}
