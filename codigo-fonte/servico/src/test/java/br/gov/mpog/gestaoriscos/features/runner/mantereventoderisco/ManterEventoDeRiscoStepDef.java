package br.gov.mpog.gestaoriscos.features.runner.mantereventoderisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.mantereventoderisco.ManterEventoDeRiscoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;
import java.util.List;

/**
 * Created by fabrica.wgl on 27/12/2017.
 */


public class ManterEventoDeRiscoStepDef extends ComumStepDef {

    private ManterEventoDeRiscoPO manterEventoDeRiscoPO;

    @Before
    public void init() throws IOException {
        getConnectionSample().prepararCarga("insert-mantereventoderisco.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("delete-mantereventoderisco.sql");
        getWebDriver().quit();
    }

    //CENARIO 1
    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessarPaginaUm() throws Throwable {
        manterEventoDeRiscoPO.acessarPagina();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções 'Limpar', 'Consultar' e 'Novo'$")
    public void verificarPresencaDeCampos() throws Throwable {
        manterEventoDeRiscoPO.verificarPresencaCampos();
    }


    @E("^apresenta a lista de eventos de riscos que foram cadastrados anteriormente com as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Descrição do Evento$")
    public void apresentarCamposHistorico() throws Throwable {
        manterEventoDeRiscoPO.apresentarOutrosCampos();
    }

    //    CENARIO 2
    @Dado("^que o usuário esteja em evento de risco$")
    public void acessarPaginaDois() throws Throwable {
        manterEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void acionarIncluir(String opcao) throws Throwable {
        if (opcao.equals("Evento de Risco")) {
//            manterEventoDeRiscoPO.acessarPagina();
        } else if (opcao.equals("Incluir")) {
            manterEventoDeRiscoPO.incluirRisco();
        } else if (opcao.equals("Alterar")) {
            manterEventoDeRiscoPO.alterarRisco();
        } else if (opcao.equals("Ok")) {
            manterEventoDeRiscoPO.acionarAcao(opcao);
        } else if (opcao.equals("Limpar")) {
            manterEventoDeRiscoPO.acionarAcao(opcao);
        }
    }

    @Então("^o sistema apresenta o formulário para informar dados do evento de risco$")
    public void apresentarParaPreenchimento() throws Throwable {
        manterEventoDeRiscoPO.camposPreenchimento();
    }

    //CENARIO 3
    @Dado("^que o usuário esteja em lista de Eventos de Risco salvos$")
    public void acessarAlterar() throws Throwable {
        manterEventoDeRiscoPO.acessarPagina();
    }

    @E("^informou os parâmetros necessários$")
    public void informouOsParametros() throws Throwable {
    }

    @Então("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        manterEventoDeRiscoPO.getAjaxStatus().waitUntilNotVisible();
    }

    @E("^adiciona o item salvo na lista$")
    public void adicionaItemSalvoLista() throws Throwable {
//        manterEventoDeRiscoPO.adicionaItemSalvoLista();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagem(String mensagem) throws Throwable {
        manterEventoDeRiscoPO.exibeMensagem(mensagem);
    }

    @Então("^o sistema apresenta os dados para serem alterados$")
    public void apresentaCampos() throws Throwable {
        manterEventoDeRiscoPO.camposHabilitados();
    }

    //CENARIO 4
    @E("^informou dados de um item já existente$")
    public void eInformouOsParametrosExistentes() throws Throwable {
        manterEventoDeRiscoPO.incluirRisco();
        manterEventoDeRiscoPO.eInformouOsParametrosExistentes();
    }

    @Quando("^o usuário acionar a opção 'Incluir'$")
    public void acionarOpcaoIncluir() throws Throwable {
        manterEventoDeRiscoPO.clicarIncluir();
    }

    @Então("^o sistema apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagemErro(String mensagem) throws Throwable {
        manterEventoDeRiscoPO.exibeMensagem(mensagem);
    }

    //CENARIO 5
    @Quando("^o usuário acionar a opção \"([^\"]*)\" no item desejado$")
    public void oUsuarioAcionarAOpcaoNoItemDesejado(String comando) throws Throwable {
        manterEventoDeRiscoPO.acionarAcao(comando);
    }

    //CENARIO 6
    @Dado("^que o usuário esteja alterando dados do evento de risco$")
    public void alterandoDados() {
        manterEventoDeRiscoPO.acessarPagina();
        manterEventoDeRiscoPO.acionarAcao("Alterar");
    }

    //CENARIO 7
    @Dado("^que o usuário esteja em lista de Eventos de Risco$")
    public void acessarListagem() {
        manterEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja inativado$")
    public void acionarAtivar(String opcao) {
        manterEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema ativa o Evento de Risco selecionado$")
    public void ativaSelecionado() {
        manterEventoDeRiscoPO.verificarRegistroAtivado();
    }

    @E("^fica disponível para a vinculação a uma etapa$")
    public void disponívelParaVincular() {

    }

    //CENARIO 8
    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja ativado")
    public void acionarInativar(String opcao) {
        manterEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema inativa o Evento de Risco selecionado$")
    public void inativaSelecionado() {
        manterEventoDeRiscoPO.verificarRegistroInativado();
    }

    @E("^desvincula o item a uma etapa, caso esteja vinculado$")
    public void desvinculaItem() {

    }

    //CENARIO 9
    @Quando("^o usuário acionar a opção 'Excluir' de um item desejado$")
    public void acionarExcluir() throws Throwable {
        manterEventoDeRiscoPO.acionarExcluir();
    }

    @Então("^o sistema apresenta mensagem \"([^\"]*)\", com as opções 'OK' e 'Cancelar'$")
    public void apresentaMensagem(String mensagem) throws Throwable {
        manterEventoDeRiscoPO.apresentarMsg(mensagem);
    }

    //CENARIO 10
    @Dado("^que o usuário esteja excluindo um Evento de Risco$")
    public void excluindoEventoRisco() {
        manterEventoDeRiscoPO.acessarPagina();
        manterEventoDeRiscoPO.acionarExcluir();
    }

    @Então("^o sistema exclui logicamente o registro$")
    public void excluiRegistro() {

    }

    //CENARIO 11
    @Dado("^que o usuário esteja em formulário para preenchimento do dado evento de risco$")
    public void preenchimentoEventoRisco() {
        manterEventoDeRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        manterEventoDeRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void destacarCampos() throws Throwable {
        manterEventoDeRiscoPO.validarCamposObrigatorios();
    }

    //CENARIO 12

    @Então("^o sistema limpa os dados informados$")
    public void limparDadosInformados() throws Throwable {
        manterEventoDeRiscoPO.limparDadoInformados();
    }
}
