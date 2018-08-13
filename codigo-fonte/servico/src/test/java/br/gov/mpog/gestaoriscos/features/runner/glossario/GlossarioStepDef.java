package br.gov.mpog.gestaoriscos.features.runner.glossario;

import br.gov.mpog.gestaoriscos.features.pageobjects.glossario.GlossarioPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author miller-macedo
 * @since 22/06/2017.
 */
public class GlossarioStepDef extends ComumStepDef {

    private GlossarioPO glossarioPO;

    @Before
    public void before() {
        getWebDriver().manage().window().maximize();
    }

    @Dado("^que o usuário esteja em Glossário$")
    public void acessarPagina() throws Throwable {
        glossarioPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void oUsuarioAcionarAOpcao(String opcao) throws Throwable {
        glossarioPO.acionarAcao(opcao);
    }

    @Então("^o sistema apresenta o formulário para informar dados do Glossário$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaNaturezaDeRisco() throws Throwable {
        glossarioPO.verificarCamposHabilitados();
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado Glossário$")
    public void queOUsuarioEstejaEmFormularioParaPreenchimentoDoDadoNaturezaDeRisco() throws Throwable {
        glossarioPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        glossarioPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void oSistemaDeveDestacarOSCampoSQueNãoForamPreenchidosEmVermelhoEApresentarAsMensagensPadrões() throws Throwable {
        glossarioPO.validarCamposObrigatorios();
    }

    @Então("^o sistema limpa os dados informados$")
    public void oSistemaLimpaOsDadosInformados() throws Throwable {
        glossarioPO.validarCamposVazios();
    }
}
