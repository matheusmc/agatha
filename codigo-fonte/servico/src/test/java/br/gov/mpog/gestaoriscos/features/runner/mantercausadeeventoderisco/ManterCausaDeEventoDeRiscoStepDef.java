package br.gov.mpog.gestaoriscos.features.runner.mantercausadeeventoderisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.mantercausadeeventoderisco.ManterCausaDeEventoDeRiscoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

/**
 * Created by fabrica.wgl on 27/12/2017.
 */


public class ManterCausaDeEventoDeRiscoStepDef extends ComumStepDef {

    private ManterCausaDeEventoDeRiscoPO manterCausaDeEventoDeRiscoPO;

    @Before
    public void init() throws IOException {
        getConnectionSample().prepararCarga("insert-mantercausadeeventoderisco.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("delete-mantercausadeeventoderisco.sql");
        getWebDriver().quit();
    }

    //CENARIO 1
    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessarPaginaUm() throws Throwable {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções 'Limpar', 'Consultar' e 'Novo'$")
    public void verificarPresencaDeCampos() throws Throwable {
        manterCausaDeEventoDeRiscoPO.verificarPresencaCampos();
    }


    @E("^apresenta a lista de causas de eventos de risco que foram cadastrados anteriormente com as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Descrição da Causa")
    public void apresentarCamposHistorico() throws Throwable {
        manterCausaDeEventoDeRiscoPO.apresentarOutrosCampos();
    }

    //    CENARIO 2
    @Dado("^que o usuário esteja em causa de evento de risco$")
    public void acessarPaginaDois() throws Throwable {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void acionarIncluir(String opcao) throws Throwable {
        if (opcao.equals("Causa de Evento de Risco")) {
//            manterCausaDeEventoDeRiscoPO.acessarPagina();
        } else if (opcao.equals("Incluir")) {
            manterCausaDeEventoDeRiscoPO.incluirRisco();
        } else if (opcao.equals("Alterar")) {
            manterCausaDeEventoDeRiscoPO.alterarRisco();
        } else if (opcao.equals("Ok")) {
            manterCausaDeEventoDeRiscoPO.acionarAcao(opcao);
        } else if (opcao.equals("Limpar")) {
            manterCausaDeEventoDeRiscoPO.acionarAcao(opcao);
        }
    }

    @Então("^o sistema apresenta o formulário para informar dados do causa de evento de risco$")
    public void apresentarParaPreenchimento() throws Throwable {
        manterCausaDeEventoDeRiscoPO.camposPreenchimento();
    }

    //CENARIO 3
    @Dado("^que o usuário esteja em lista de Causas de Eventos de Risco salvos$")
    public void acessarAlterar() throws Throwable {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
    }

    @E("^informou os parâmetros necessários$")
    public void informouOsParametros() throws Throwable {
    }

    @Então("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        manterCausaDeEventoDeRiscoPO.getAjaxStatus().waitUntilNotVisible();
    }

    @E("^adiciona o item salvo na lista$")
    public void adicionaItemSalvoLista() throws Throwable {
//        manterCausaDeEventoDeRiscoPO.adicionaItemSalvoLista();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagem(String mensagem) throws Throwable {
        manterCausaDeEventoDeRiscoPO.exibeMensagem(mensagem);
    }

    @Então("^o sistema apresenta os dados para serem alterados$")
    public void apresentaCampos() throws Throwable {
        manterCausaDeEventoDeRiscoPO.camposHabilitados();
    }

    //CENARIO 4
    @E("^informou dados de um item já existente$")
    public void eInformouOsParametrosExistentes() throws Throwable {
        manterCausaDeEventoDeRiscoPO.incluirRisco();
        manterCausaDeEventoDeRiscoPO.eInformouOsParametrosExistentes();
    }

    @Quando("^o usuário acionar a opção 'Incluir'$")
    public void acionarOpcaoIncluir() throws Throwable {
        manterCausaDeEventoDeRiscoPO.clicarIncluir();
    }

    @Então("^o sistema apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagemErro(String mensagem) throws Throwable {
        manterCausaDeEventoDeRiscoPO.exibeMensagem(mensagem);
    }

    //CENARIO 5
    @Quando("^o usuário acionar a opção \"([^\"]*)\" no item desejado$")
    public void oUsuarioAcionarAOpcaoNoItemDesejado(String comando) throws Throwable {
        manterCausaDeEventoDeRiscoPO.acionarAcao(comando);
    }

    //CENARIO 6
    @Dado("^que o usuário esteja alterando dados do causa de evento de risco$")
    public void alterandoDados() {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
        manterCausaDeEventoDeRiscoPO.acionarAcao("Alterar");
    }

    //CENARIO 7
    @Dado("^que o usuário esteja em lista de Causas de Eventos de Risco$")
    public void acessarListagem() {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja inativado$")
    public void acionarAtivar(String opcao) {
        manterCausaDeEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema ativa o Causa de Evento de Risco selecionado$")
    public void ativaSelecionado() {
        manterCausaDeEventoDeRiscoPO.verificarRegistroAtivado();
    }

    @E("^fica disponível para a vinculação a uma etapa$")
    public void disponívelParaVincular() {

    }

    //CENARIO 8
    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja ativado")
    public void acionarInativar(String opcao) {
        manterCausaDeEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema inativa o Causa de Evento de Risco selecionado$")
    public void inativaSelecionado() {
        manterCausaDeEventoDeRiscoPO.verificarRegistroInativado();
    }

    @E("^desvincula o item a uma etapa, caso esteja vinculado$")
    public void desvinculaItem() {

    }

    //CENARIO 9
    @Quando("^o usuário acionar a opção 'Excluir' de um item desejado$")
    public void acionarExcluir() throws Throwable {
        manterCausaDeEventoDeRiscoPO.acionarExcluir();
    }

    @Então("^o sistema apresenta mensagem \"([^\"]*)\", com as opções 'OK' e 'Cancelar'$")
    public void apresentaMensagem(String mensagem) throws Throwable {
        manterCausaDeEventoDeRiscoPO.apresentarMsg(mensagem);
    }

    //CENARIO 10
    @Dado("^que o usuário esteja excluindo um Causa de Evento de Risco$")
    public void excluindoEventoRisco() {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
        manterCausaDeEventoDeRiscoPO.acionarExcluir();
    }

    @Então("^o sistema exclui logicamente o registro$")
    public void excluiRegistro() {

    }

    //CENARIO 11
    @Dado("^que o usuário esteja em formulário para preenchimento do dado causa de evento de risco$")
    public void preenchimentoEventoRisco() {
        manterCausaDeEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        manterCausaDeEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void destacarCampos() throws Throwable {
        manterCausaDeEventoDeRiscoPO.validarCamposObrigatorios();
    }

    //CENARIO 12

    @Então("^o sistema limpa os dados informados$")
    public void limparDadosInformados() throws Throwable {
        manterCausaDeEventoDeRiscoPO.limparDadoInformados();
    }
}
