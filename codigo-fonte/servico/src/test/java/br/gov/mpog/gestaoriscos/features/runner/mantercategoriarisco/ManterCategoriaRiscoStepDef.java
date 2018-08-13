package br.gov.mpog.gestaoriscos.features.runner.mantercategoriarisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.mantercategoriarisco.ManterCategoriaRiscoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author jose.rodrigues
 * @since 22/06/2017
 */
public class ManterCategoriaRiscoStepDef extends ComumStepDef {

    private ManterCategoriaRiscoPO manterCategoriaRiscoPO;

    @Before
    public void init() {
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
        getConnectionSample().prepararCarga("delete_categoria_risco.sql");
    }

    @Dado("^que o usuário esteja em formulário para preenchimento do dado categoria de risco$")
    public void queOUsuarioEstejaEmFormularioParaPreenchimentoDoDadoCategoriaDeRisco() throws Throwable {
        manterCategoriaRiscoPO.acessarPagina();
    }

    @Dado("^que o usuário esteja em categoria de risco$")
    public void queOUsuarioEstejaEmCategoriaDeRisco() throws Throwable {
        manterCategoriaRiscoPO.acessarPagina();
    }

    @Dado("^que o usuário esteja em inclusão de categoria de risco$")
    public void queOUsuarioEstejaEmInclusaoDeCategoriaDeRisco() throws Throwable {
        manterCategoriaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void oUsuarioAcionarAOpcao(String opcao) throws Throwable {
        manterCategoriaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema limpa os dados informados$")
    public void oSistemaLimpaOsDadosInformados() throws Throwable {
        manterCategoriaRiscoPO.oSistemaLimpaOsDadosInformados();
    }

    @Quando("o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void incluirSemCamposPreenchidos(String opcao) throws Throwable {
        manterCategoriaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar os campos que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelho() throws Throwable {
        manterCategoriaRiscoPO.oSistemaDeveDestacarOSCampoSQueNaoForamPreenchidosEmVermelho();
    }

    @Então("^o sistema apresenta o formulário para informar dados da categoria de risco$")
    public void oSistemaApresentaOFormularioParaInformarDadosDaCategoriaDeRisco() throws Throwable {
        manterCategoriaRiscoPO.oSistemaApresentaOFormularioParaInformarDadosDaCausaDoEventoDeRisco();
    }

    @E("^informou os parâmetros necessários$")
    public void eInformouOsParametrosNecessarios() throws Throwable {
        manterCategoriaRiscoPO.eInformouOsParametrosNecessarios();
    }

    @E("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        //Não faz nada porque já está em transação com o servidor
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagem(String mensagem) throws Throwable {
        manterCategoriaRiscoPO.exibeMensagem(mensagem);
    }

    @E("^adiciona o item salvo na lista$")
    public void adicionaItemSalvoLista() throws Throwable {
        manterCategoriaRiscoPO.adicionaItemSalvoLista();
    }

    @E("^informou dados de um item já existente$")
    public void eInformouOsParametrosExistentes() throws Throwable {
        manterCategoriaRiscoPO.eInformouOsParametrosExistentes();
    }

    @Então("^o sistema apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagemErro(String mensagem) throws Throwable {
        manterCategoriaRiscoPO.exibeMensagem(mensagem);
    }

}
