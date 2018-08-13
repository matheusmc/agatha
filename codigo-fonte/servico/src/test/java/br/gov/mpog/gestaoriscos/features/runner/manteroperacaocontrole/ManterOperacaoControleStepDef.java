package br.gov.mpog.gestaoriscos.features.runner.manteroperacaocontrole;

import br.gov.mpog.gestaoriscos.features.pageobjects.manteroperacaocontrole.ManterOperacaoControlePO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * Created by janaina.santos on 23/06/2017
 */
public class ManterOperacaoControleStepDef extends ComumStepDef {

    private ManterOperacaoControlePO manterOperacaoControle;

    @Before
    public void init() {
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em desenho de Operação de controle de risco$")
    public void operacaoControle() throws Throwable {
        manterOperacaoControle.acessarPagina();
    }

    @Então("^o sistema apresenta o formulário para informar dados do Operação de Controle$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaNaturezaDeRisco() throws Throwable {
        manterOperacaoControle.verificarCamposHabilitados();
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado Operação de Controle$")
    public void preencherFormulario() throws Throwable {
        manterOperacaoControle.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void acionarOpcao(String pOpcao) throws Throwable {
        manterOperacaoControle.opcaoIncluir();
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void destacarCampos() throws Throwable {
        manterOperacaoControle.validarCamposObrigatorios();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void selecionarOpcao(String pOpcao) throws Throwable {
        manterOperacaoControle.opcaoIncluir();
    }

    @Então("^o usuário acionar a opção 'Limpar'$")
    public void LimparDados() throws Throwable {
        manterOperacaoControle.opcaoLimpar();
    }

    @Então("^o sistema limpa os dados informados$")
    public void limparDadosInformados() throws Throwable {
        manterOperacaoControle.limparDadoInformados();
    }

}
