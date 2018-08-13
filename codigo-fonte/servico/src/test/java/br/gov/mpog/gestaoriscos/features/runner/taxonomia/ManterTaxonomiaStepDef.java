package br.gov.mpog.gestaoriscos.features.runner.taxonomia;

import br.gov.mpog.gestaoriscos.features.pageobjects.taxonomia.ManterTaxonomiaPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author Ludmily
 * @since 22/06/2017.
 */
public class ManterTaxonomiaStepDef extends ComumStepDef {

    private ManterTaxonomiaPO manterTaxonomiaPO;

    @Before
    public void init() {
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em menu do sistema$")
    public void queOUsuarioEstejaEmCausaDeEventoDeRisco() throws Throwable {
        manterTaxonomiaPO.logar();
    }

    @Quando("^o usuário acionar a opção Taxonomia$")
    public void oUsuarioAcionarAOpcao() throws Throwable {
        manterTaxonomiaPO.acessarPagina();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções Limpar e Consultar$")
    public void oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoes() throws Throwable {
        manterTaxonomiaPO.oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoes();
    }

    @E("^apresenta a lista de sugestão de taxonomia recebida com as opções Selecionar, Consultar Agrupamento, Aprovar, Recusar e Agrupar, conforme protótipo$")
    public void apresentaAListaDeSugestoes() throws Throwable {
        manterTaxonomiaPO.apresentaAListaDeSugestoes();
    }

    @Dado("^que o usuário esteja em consulta de sugestão de taxonomia$")
    public void queOUsuarioEstejaEmConsultaDeSugestaoDeTaxonomia() throws Throwable {
        manterTaxonomiaPO.queOUsuarioEstejaEmConsultaDeSugestaoDeTaxonomia();
    }

    @Quando("^o usuário acionar a opção Consultar Agrupamento$")
    public void oUsuarioAcionarAOpcaoConsultarAgrupamento() throws Throwable {
        manterTaxonomiaPO.oUsuarioAcionarAOpcaoConsultarAgrupamento();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções Limpar e Consultar, conforme protótipo$")
    public void oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoesLimparEConsultarConformePrototipo() throws Throwable {
        manterTaxonomiaPO.oSistemaApresentaOsParametrosParaConsultaAcrescidoDasOpcoesLimparEConsultarConformePrototipo();
    }

    @Dado("^que o usuário esteja sugestões de taxonomia$")
    public void queOUsuarioEstejaSugestoesDeTaxonomia() throws Throwable {
        manterTaxonomiaPO.queOUsuarioEstejaEmConsultaDeSugestaoDeTaxonomia();
        manterTaxonomiaPO.oUsuarioAcionarAOpcaoConsultarAgrupamento();
    }

    @Quando("^o usuário acionar a opção Cancelar$")
    public void oUsuarioAcionarAOpcaoCancelar() throws Throwable {
        manterTaxonomiaPO.oUsuarioAcionarAOpcaoCancelar();
    }

    @Então("^o sistema cancela operação$")
    public void cancelaOperacao() throws Throwable {
        manterTaxonomiaPO.cancelaOperacao();
    }

    @E("^retorna para a tela anterior$")
    public void retornaParaATelaAnterior() throws Throwable {
        manterTaxonomiaPO.retornaParaATelaAnterior();
    }
}
