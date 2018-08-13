package br.gov.mpog.gestaoriscos.features.runner.mantercalculadora;

import br.gov.mpog.gestaoriscos.features.pageobjects.mantercalculadora.ManterCalculadoraPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

/**
 * Created by gabriel.neves on 23/06/2017.
 */
public class ManterCalculadoraStefDef extends ComumStepDef {

    ManterCalculadoraPO manterCalculadoraPO;


    @Before
    public void init() throws IOException {
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
    }

    //CENARIO 1
    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessarPaginaUm() throws Throwable {
        manterCalculadoraPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção 'Calculadora'$")
    public void acionarCalculadora() throws Throwable {
        manterCalculadoraPO.verificaPagina();
    }

    @Então("^o sistema apresenta os parâmetros, com as opções 'Cancelar' e 'Gravar' conforme protótipo$")
    public void apresentarCampos() throws Throwable {
        manterCalculadoraPO.verificarCampos();
    }

    //CENARIO 2
    @Dado("^que o usuário esteja em calculadora$")
    public void queOUsuárioEstejaEmCalculadora() throws Throwable {
        manterCalculadoraPO.acessarPagina();
    }

    @E("^selecionou o tipo de calculadora que deseja atualizar$")
    public void selecionaTipoCalculadora() throws Throwable {
        manterCalculadoraPO.selecionaTipoCalculadora();
    }

    @E("^informou parâmetros necessários$")
    public void informaParametros() throws Throwable {
        manterCalculadoraPO.verificarParamentros();
    }

    @Quando("^o usuário acionar a opção 'Gravar'$")
    public void acionarGravar() throws Throwable {
        manterCalculadoraPO.acionarSalvar();
    }
    
    @E("^atualiza o dados na etapa \"([^\"]*)\"$")
    public void atualizaODadosNaEtapa(String arg0) throws Throwable {
        manterCalculadoraPO.verificarParamentros();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void apresentarMensagem(String pMensagem) throws Throwable {
        manterCalculadoraPO.verificarParamentros();
    }

    //CENARIO 3
    @Quando("^o usuário acionar a opção 'Cancelar'$")
    public void acionarCancelar() throws Throwable {
        manterCalculadoraPO.clicarCancelar();
    }

    @Então("^o sistema cancela operação.$")
    public void cancelaOperacao() throws Throwable {
        manterCalculadoraPO.verificarParamentros();
    }

    @E("^retorna para a tela anterior.$")
    public void retornarTela() throws Throwable {
        manterCalculadoraPO.verificarParamentros();
    }
}
