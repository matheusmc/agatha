package br.gov.mpog.gestaoriscos.features.runner.homegerenciarprocesso;

import br.gov.mpog.gestaoriscos.features.pageobjects.homegerenciarprocesso.HomeGerenciarProcessoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author Ludmily
 * @since 22/06/2017.
 */
public class HomeGerenciarProcessoStepDef extends ComumStepDef {

    private HomeGerenciarProcessoPO homeGerenciarProcessoPO;

    @Before
    public void init() {
        getConnectionSample().prepararCarga("insertHomeGerenciarProcesso.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("deleteHomeGerenciarProcesso.sql");
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja lista de macroprocesso/processos de risco$")
    public void queOUsuarioEstejaListaDeMacroprocessoProcessosDeRisco() throws Throwable {
        homeGerenciarProcessoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção Incluir$")
    public void oUsuarioAcionarAOpcaoIncluir() throws Throwable {
        homeGerenciarProcessoPO.oUsuarioAcionarAOpcaoIncluir();
    }

    @Então("^o sistema apresenta a funcionalidade US004 Formulário de Levantamento de Informações sobre Ambiente e sobre a Fixação de Objetivos$")
    public void oSistemaApresentaAFuncionalidadeUSFormularioDeLevantamentoDeInformacoesSobreAmbienteESobreAFixacaoDeObjetivos() throws Throwable {
        homeGerenciarProcessoPO.oSistemaApresentaAFuncionalidadeUSFormularioDeLevantamentoDeInformacoesSobreAmbienteESobreAFixacaoDeObjetivos();
    }

    @Quando("^o usuário acionar a opção Visualizar$")
    public void oUsuarioAcionarAOpcaoVisualizar() throws Throwable {
        homeGerenciarProcessoPO.oUsuarioAcionarAOpcaoVisualizar();
    }

    @Então("^o sistema apresenta a etapa selecionada para visualização com as opções Voltar e Imprimir$")
    public void oSistemaApresentaAEtapaSelecionadaParaVisualizacaoComAsOpcoesVoltarEImprimir() throws Throwable {
        homeGerenciarProcessoPO.oSistemaApresentaAEtapaSelecionadaParaVisualizacaoComAsOpcoesVoltarEImprimir();
    }

    @Dado("^que o usuário esteja em lista de macroprocesso/processos de risco$")
    public void queOUsuarioEstejaEmListaDeMacroprocessoProcessosDeRisco() throws Throwable {
        homeGerenciarProcessoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção Alterar em uma etapa desejada$")
    public void oUsuarioAcionarAOpcaoAlterarEmUmaEtapaDesejada() throws Throwable {
        homeGerenciarProcessoPO.oUsuarioAcionarAOpcaoAlterarEmUmaEtapaDesejada();
    }

    @Então("^o sistema apresenta o formulário da etapa selecionada para alteração$")
    public void oSistemaApresentaOFormularioDaEtapaSelecionadaParaAlteracao() throws Throwable {
        homeGerenciarProcessoPO.oSistemaApresentaOFormularioDaEtapaSelecionadaParaAlteracao();
    }

    @Quando("^o usuário acionar a opção Validar$")
    public void oUsuarioAcionarAOpcaoValidar() throws Throwable {
        homeGerenciarProcessoPO.oUsuarioAcionarAOpcaoValidar();
    }

    @Então("^o sistema apresenta o formulário selecionado para a validação$")
    public void oSistemaApresentaOFormularioSelecionadoParaAValidacao() throws Throwable {
        homeGerenciarProcessoPO.oSistemaApresentaOFormularioSelecionadoParaAValidacao();
    }
}
