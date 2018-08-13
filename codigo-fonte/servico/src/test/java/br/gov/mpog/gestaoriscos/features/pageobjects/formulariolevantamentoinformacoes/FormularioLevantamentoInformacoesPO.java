package br.gov.mpog.gestaoriscos.features.pageobjects.formulariolevantamentoinformacoes;

import br.com.basis.selenium.componentes.inputs.radio.angular.RadioGroupAngularFacade;
import br.com.basis.selenium.componentes.mensagem.angular.MensagemToastFacade;
import br.com.basis.selenium.componentes.select.angular.SelectAngularFacade;
import br.gov.mpog.gestaoriscos.features.pageobjects.comum.ComumPO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author silas
 * @since 22/06/17.
 */
public class FormularioLevantamentoInformacoesPO extends ComumPO {

    public FormularioLevantamentoInformacoesPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(ngModel = "scope.registro.analise.etica")
    private RadioGroupAngularFacade radiosEtica;

    @FindBy(ngModel = "scope.registro.analise.estrutura")
    private RadioGroupAngularFacade radiosEstutura;

    @FindBy(ngModel = "scope.registro.analise.recursosHumanos")
    private RadioGroupAngularFacade radiosRecursosHumanos;

    @FindBy(ngModel = "scope.registro.analise.atribuicoes")
    private RadioGroupAngularFacade radiosAtribuicoes;

    @FindBy(ngModel = "scope.registro.analise.normasInternas")
    private RadioGroupAngularFacade radiosNormaisInternas;

    @FindBy(ngModel = "scope.registro.analise.missao")
    private RadioGroupAngularFacade radiosMissao;

    @FindBy(ngModel = "scope.registro.analise.visao")
    private RadioGroupAngularFacade radiosVisao;

    @FindBy(ngModel = "scope.registro.analise.objetivos")
    private RadioGroupAngularFacade radiosObjetivos;

    @FindBy(ngModel = "scope.registro.macroprocesso")
    private WebElementFacade inputMacroProcesso;

    @FindBy(ngModel = "scope.registro.objetivo")
    private WebElementFacade inputObjetivo;

    @FindBy(ngModel = "responsavel.usuario")
    private SelectAngularFacade selectUsuario;

    @FindBy(ngModel = "scope.registro.gestor")
    private SelectAngularFacade selectGestor;

    @FindBy(tagName = "md-toast")
    private MensagemToastFacade mensagemToastFacade;

    @FindBy(jquery = "sgr-glossario:contains(\"Salvar\")")
    private WebElementFacade botaoSalvar;

    @FindBy(jquery = "sgr-glossario:contains(\"Cancelar\")")
    private WebElementFacade botaoCancelar;

    @FindBy(ngModel = "scope.filtros.statusId")
    private SelectAngularFacade selectStatus;

    @FindBy(tagName = "table")
    private WebElementFacade tabelaProcesso;

    @FindBy(ngModel = "scope.matriz.tipoMatriz")
    private WebElementFacade selectTipoItem;

    @FindBy(ngModel = "scope.matriz.descricao")
    private WebElementFacade inputDescricao;

    @FindBy(jquery = "button[ng-click=\"scope.persistirMatriz(scope.matriz)\"]")
    private WebElementFacade bottonAdicionarSWOT;


    public void preencherRadios() {
        getAjaxStatus().waitUntilNotVisible();

        radiosEtica.sendKeys("Sim");
        radiosEstutura.sendKeys("Sim");
        radiosRecursosHumanos.sendKeys("Não");
        radiosAtribuicoes.sendKeys("Não");
        radiosNormaisInternas.sendKeys("Sim");
        radiosMissao.sendKeys("Sim");
        radiosVisao.sendKeys("Sim");
        radiosObjetivos.sendKeys("Não");
    }

    public void preencherCampos() {
        inputMacroProcesso.sendKeys("Macroprocesso Teste");
        inputObjetivo.sendKeys("Objetivo Teste");

        selectGestor.abrirSelect().selectItem("Ryan Correia Dias");
        selectUsuario.abrirSelect().selectItem("Alfredo Bitencourt");
    }

    public void verificarMensagemToast(String... msg) {
        mensagemToastFacade.possuiMensagem(msg);
    }

    public void salvarFormulario() {
        new Actions(getDriver()).moveToElement(botaoSalvar).click().perform();
    }

    public void camposStatusEstaVisivel() {
        Assert.assertTrue(tabelaProcesso.isPresent());
    }

    public void cancelarFormulario() {
        new Actions(getDriver()).moveToElement(botaoCancelar).click().perform();
    }

    public void redirecionandoPagina() {
        getAjaxStatus().waitUntilNotVisible();
    }

    public void retornaParaATelaAnterior() {
        Assert.assertTrue(tabelaProcesso.isPresent());
    }

    public void informouOsParametrosNecessarios() {
        new Actions(getDriver()).moveToElement(selectTipoItem).build().perform();
        selectTipoItem.waitUntilVisible();
        selectTipoItem.sendKeys("Oportunidades");
        inputDescricao.sendKeys("Descrição Teste");
    }

    public void oUsuarioAcionarAOpcaoAdicionar() {
        bottonAdicionarSWOT.waitUntilClickable().click();
    }

    public void sistemaGravaDados(){
        getAjaxStatus().waitUntilNotVisible();
    }
}