package br.gov.mpog.gestaoriscos.features.runner.naturezarisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.naturezarisco.NaturezaRiscoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author miller-macedo
 * @since 22/06/2017.
 */
public class NaturezaRiscoStepDef extends ComumStepDef {

    private NaturezaRiscoPO naturezaRiscoPO;

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

    @Dado("^que o usuário esteja em natureza de risco$")
    public void acessarPagina() throws Throwable {
        naturezaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void oUsuarioAcionarAOpcao(String opcao) throws Throwable {
        naturezaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema apresenta o formulário para informar dados da natureza de risco$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaNaturezaDeRisco() throws Throwable {
        naturezaRiscoPO.verificarCamposHabilitados();
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado natureza de risco$")
    public void queOUsuarioEstejaEmFormularioParaPreenchimentoDoDadoNaturezaDeRisco() throws Throwable {
        naturezaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        naturezaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelhoEApresentarAsMensagensPadroes() throws Throwable {
        naturezaRiscoPO.validarCamposObrigatorios();
    }

    @Então("^o sistema limpa os dados informados$")
    public void oSistemaLimpaOsDadosInformados() throws Throwable {
        naturezaRiscoPO.validarCamposVazios();
    }

    @Dado("^que o usuário esteja em lista de natureza de risco salvos$")
    public void queOUsuarioEstejaEmListaDeNaturezaDeRiscoSalvos() throws Throwable {
        naturezaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" no item desejado$")
    public void oUsuarioAcionarAOpcaoNoItemDesejado(String comando) throws Throwable {
        naturezaRiscoPO.acionarAcao(comando);
    }

    @Então("^o sistema apresenta os dados para serem alterados$")
    public void oSistemaApresentaOsDadosParaSeremAlterados() throws Throwable {
        naturezaRiscoPO.validarCamposParaEdicao();
    }
}
