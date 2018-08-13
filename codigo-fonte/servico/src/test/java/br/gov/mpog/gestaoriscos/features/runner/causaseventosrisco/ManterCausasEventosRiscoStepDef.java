package br.gov.mpog.gestaoriscos.features.runner.causaseventosrisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.causaseventosrisco.ManterCausasEventosRiscoPO;
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
public class ManterCausasEventosRiscoStepDef extends ComumStepDef {

    private ManterCausasEventosRiscoPO manterCausasEventosRiscoPO;

    @Before
    public void init() {
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em causa de evento de risco$")
    public void queOUsuarioEstejaEmCausaDeEventoDeRisco() throws Throwable {
        manterCausasEventosRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void oUsuarioAcionarAOpcao(String opcao) throws Throwable {
        manterCausasEventosRiscoPO.acionarAcao(opcao);
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado Causas de Eventos de Risco$")
    public void queOUsuarioEstejaEmFormularioParaPreenchimentoDoDadoCausasDeEventosDeRisco() throws Throwable {
        manterCausasEventosRiscoPO.acessarPagina();
    }

    @Então("^o sistema limpa os dados informados$")
    public void oSistemaLimpaOsDadosInformados() throws Throwable {
        manterCausasEventosRiscoPO.oSistemaLimpaOsDadosInformados();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String acao) throws Throwable {
        manterCausasEventosRiscoPO.acionarAcao(acao);
    }

    @Então("^o sistema deve destacar os campos que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelhoEApresentarAsMensagensPadroes() throws Throwable {
        manterCausasEventosRiscoPO.oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelho();
    }

    @Então("^o sistema apresenta o formulário para informar dados da causa do evento de risco$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaCausaDoEventoDeRisco() throws Throwable {
        manterCausasEventosRiscoPO.oSistemaApresentaOFormularioParaInformarDadosDaCausaDoEventoDeRisco();
    }
}
