package br.gov.mpog.gestaoriscos.features.runner.desenhocontrole;

import br.gov.mpog.gestaoriscos.features.pageobjects.desenhocontrole.DesenhoControlePO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author miller-macedo
 * @since 22/06/2017.
 */
public class DesenhoControleStepDef extends ComumStepDef {

    private DesenhoControlePO desenhoControlePO;

    @Before
    public void before() {
        getWebDriver().manage().window().maximize();
    }

    @Dado("^que o usuário esteja em desenho de controle de risco$")
    public void acessarPagina() throws Throwable {
        desenhoControlePO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void oUsuarioAcionarAOpcao(String opcao) throws Throwable {
        desenhoControlePO.acionarAcao(opcao);
    }

    @Então("^o sistema apresenta o formulário para informar dados do Desenho de Controle$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaNaturezaDeRisco() throws Throwable {
        desenhoControlePO.verificarCamposHabilitados();
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado Desenho de Controle$")
    public void queOUsuarioEstejaEmFormularioParaPreenchimentoDoDadoNaturezaDeRisco() throws Throwable {
        desenhoControlePO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        desenhoControlePO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void oSistemaDeveDestacarOSCampoSQueNãoForamPreenchidosEmVermelhoEApresentarAsMensagensPadrões() throws Throwable {
        desenhoControlePO.validarCamposObrigatorios();
    }

    @Então("^o sistema limpa os dados informados$")
    public void oSistemaLimpaOsDadosInformados() throws Throwable {
        desenhoControlePO.validarCamposVazios();
    }
}
