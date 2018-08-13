package br.gov.mpog.gestaoriscos.features.pageobjects.taxonomia;

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
public class ManterTaxonomiaPO extends ComumPO {


    public ManterTaxonomiaPO(WebDriver driver) {
        super(driver);
    }

    public ManterTaxonomiaPO(WebDriver driver, int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;


    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade botaoLimparPrincipal;

    @FindBy(jquery = "button:contains(\"Consultar\")")
    private WebElementFacade botaoConsultarPrincipal;

    @FindBy(jquery = "sgr-glossario:contains(\"Consultar Agrupamento\")")
    private WebElementFacade botaoConsultarAgrupamentoPrincipal;

    @FindBy(jquery = "sgr-glossario:contains(\"Aprovar\")")
    private WebElementFacade botaoAprovarPrincipal;

    @FindBy(jquery = "sgr-glossario:contains(\"Agrupar\")")
    private WebElementFacade botaoAgruparPrincipal;

    @FindBy(jquery = "sgr-glossario:contains(\"Reprovar\")")
    private WebElementFacade botaoReprovarPrincipal;

    @FindBy(jquery = "button:contains(\"Limpar\")")
    private WebElementFacade botaoLimparConsultarAgrupamento;

    @FindBy(jquery = "button:contains(\"Consultar\")")
    private WebElementFacade botaoConsultarConsultarAgrupamento;

    @FindBy(jquery = "sgr-glossario:contains(\"Cancelar\")")
    private WebElementFacade botaoCancelarConsultarAgrupamento;

    public void logar() {
        autenticacaoOpenAmPO.abrirPagina();
        autenticacaoOpenAmPO.preencherCampos();
    }

    public void acessarPagina() {
        autenticacaoOpenAmPO.localizarPagina("/taxonomia/");
    }

    public void apresentaAListaDeSugestoes() {
        Assert.assertTrue(botaoConsultarAgrupamentoPrincipal.isCurrentlyVisible());
        Assert.assertTrue(botaoAprovarPrincipal.isCurrentlyVisible());
        Assert.assertTrue(botaoAgruparPrincipal.isCurrentlyVisible());
        Assert.assertTrue(botaoReprovarPrincipal.isCurrentlyVisible());
    }

    public void oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoes() {
        getAjaxStatus().waitUntilNotVisible();
        Assert.assertTrue(botaoLimparPrincipal.isCurrentlyVisible());
        Assert.assertTrue(botaoConsultarPrincipal.isCurrentlyVisible());
    }

    public void queOUsuarioEstejaEmConsultaDeSugestaoDeTaxonomia() {
        autenticacaoOpenAmPO.acessarPagina("/taxonomia/");
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oUsuarioAcionarAOpcaoConsultarAgrupamento() {
        botaoConsultarAgrupamentoPrincipal.waitUntilVisible().click();
        getAjaxStatus().waitUntilNotVisible();
    }

    public void oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoesLimparEConsultarConformePrototipo() {
        botaoLimparConsultarAgrupamento.waitUntilVisible();
        Assert.assertTrue(botaoLimparConsultarAgrupamento.isCurrentlyVisible());
        Assert.assertTrue(botaoConsultarConsultarAgrupamento.isCurrentlyVisible());
    }

    public void oUsuarioAcionarAOpcaoCancelar() {
        botaoCancelarConsultarAgrupamento.waitUntilVisible().click();
    }

    public void cancelaOperacao() {
        getAjaxStatus().waitUntilNotVisible();
        botaoCancelarConsultarAgrupamento.waitUntilNotVisible();
    }

    public void retornaParaATelaAnterior() {
        getAjaxStatus().waitUntilNotVisible();
        Assert.assertTrue(botaoLimparPrincipal.isCurrentlyVisible());
        Assert.assertTrue(botaoConsultarPrincipal.isCurrentlyVisible());
    }
}
