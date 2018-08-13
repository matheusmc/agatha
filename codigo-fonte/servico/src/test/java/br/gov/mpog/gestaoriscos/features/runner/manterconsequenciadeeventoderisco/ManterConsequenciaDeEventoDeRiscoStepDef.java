package br.gov.mpog.gestaoriscos.features.runner.manterconsequenciadeeventoderisco;

import br.gov.mpog.gestaoriscos.features.pageobjects.manterconsequenciadeeventoderisco.ManterConsequenciaDeEventoDeRiscoPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;


/**
 * Created by isabelle.gomes on 22/06/2017.
 */
public class ManterConsequenciaDeEventoDeRiscoStepDef extends ComumStepDef {
    private ManterConsequenciaDeEventoDeRiscoPO manterConsequenciaRiscoPO;

    @Before
    public void init() throws IOException {
        getConnectionSample().prepararCarga("insert-manterconsequenciadeeventoderisco.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("delete-manterconsequenciadeeventoderisco.sql");
        getWebDriver().quit();
    }

    //CENARIO 1
    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessarPaginaUm() throws Throwable {
        manterConsequenciaRiscoPO.acessarPagina();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções 'Limpar', 'Consultar' e 'Novo'$")
    public void verificarPresencaDeCampos() throws Throwable {
        manterConsequenciaRiscoPO.verificarPresencaCampos();
    }


    @E("^apresenta a lista de consequencia de eventos de riscos que foram cadastrados anteriormente com as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Descrição do Evento$")
    public void apresentarCamposHistorico() throws Throwable {
        manterConsequenciaRiscoPO.apresentarOutrosCampos();
    }

    //    CENARIO 2
    @Dado("^que o usuário esteja em consequencia de evento de risco$")
    public void acessarPaginaDois() throws Throwable {
        manterConsequenciaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void acionarIncluir(String opcao) throws Throwable {
        if (opcao.equals("Consequencia de Evento de Risco")) {
//            manterConsequenciaRiscoPO.acessarPagina();
        } else if (opcao.equals("Incluir")) {
            manterConsequenciaRiscoPO.incluirRisco();
        } else if (opcao.equals("Alterar")) {
            manterConsequenciaRiscoPO.alterarRisco();
        } else if (opcao.equals("Ok")) {
            manterConsequenciaRiscoPO.acionarAcao(opcao);
        } else if (opcao.equals("Limpar")) {
            manterConsequenciaRiscoPO.acionarAcao(opcao);
        }
    }

    @Então("^o sistema apresenta o formulário para informar dados do consequencia de evento de risco$")
    public void apresentarParaPreenchimento() throws Throwable {
        manterConsequenciaRiscoPO.camposPreenchimento();
    }

    //CENARIO 3
    @Dado("^que o usuário esteja em lista de Consequencias de Eventos de Risco salvos$")
    public void acessarAlterar() throws Throwable {
        manterConsequenciaRiscoPO.acessarPagina();
    }

    @E("^informou os parâmetros necessários$")
    public void informouOsParametros() throws Throwable {
    }

    @Então("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        manterConsequenciaRiscoPO.getAjaxStatus().waitUntilNotVisible();
    }

    @E("^adiciona o item salvo na lista$")
    public void adicionaItemSalvoLista() throws Throwable {
//        manterConsequenciaRiscoPO.adicionaItemSalvoLista();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagem(String mensagem) throws Throwable {
        manterConsequenciaRiscoPO.exibeMensagem(mensagem);
    }

    @Então("^o sistema apresenta os dados para serem alterados$")
    public void apresentaCampos() throws Throwable {
        manterConsequenciaRiscoPO.camposHabilitados();
    }

    //CENARIO 4
    @E("^informou dados de um item já existente$")
    public void eInformouOsParametrosExistentes() throws Throwable {
        manterConsequenciaRiscoPO.incluirRisco();
        manterConsequenciaRiscoPO.eInformouOsParametrosExistentes();
    }

    @Quando("^o usuário acionar a opção 'Incluir'$")
    public void acionarOpcaoIncluir() throws Throwable {
        manterConsequenciaRiscoPO.clicarIncluir();
    }

    @Então("^o sistema apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagemErro(String mensagem) throws Throwable {
        manterConsequenciaRiscoPO.exibeMensagem(mensagem);
    }

    //CENARIO 5
    @Quando("^o usuário acionar a opção \"([^\"]*)\" no item desejado$")
    public void oUsuarioAcionarAOpcaoNoItemDesejado(String comando) throws Throwable {
        manterConsequenciaRiscoPO.acionarAcao(comando);
    }

    //CENARIO 6
    @Dado("^que o usuário esteja alterando dados do consequencia de evento de risco$")
    public void alterandoDados() {
        manterConsequenciaRiscoPO.acessarPagina();
        manterConsequenciaRiscoPO.acionarAcao("Alterar");
    }

    //CENARIO 7
    @Dado("^que o usuário esteja em lista de Consequencias de Eventos de Risco$")
    public void acessarListagem() {
        manterConsequenciaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja inativado$")
    public void acionarAtivar(String opcao) {
        manterConsequenciaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema ativa o Consequencia de Evento de Risco selecionado$")
    public void ativaSelecionado() {
        manterConsequenciaRiscoPO.verificarRegistroAtivado();
    }

    @E("^fica disponível para a vinculação a uma etapa$")
    public void disponívelParaVincular() {

    }

    //CENARIO 8
    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja ativado")
    public void acionarInativar(String opcao) {
        manterConsequenciaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema inativa o Consequencia de Evento de Risco selecionado$")
    public void inativaSelecionado() {
        manterConsequenciaRiscoPO.verificarRegistroInativado();
    }

    @E("^desvincula o item a uma etapa, caso esteja vinculado$")
    public void desvinculaItem() {

    }

    //CENARIO 9
    @Quando("^o usuário acionar a opção 'Excluir' de um item desejado$")
    public void acionarExcluir() throws Throwable {
        manterConsequenciaRiscoPO.acionarExcluir();
    }

    @Então("^o sistema apresenta mensagem \"([^\"]*)\", com as opções 'OK' e 'Cancelar'$")
    public void apresentaMensagem(String mensagem) throws Throwable {
        manterConsequenciaRiscoPO.apresentarMsg(mensagem);
    }

    //CENARIO 10
    @Dado("^que o usuário esteja excluindo um Consequencia de Evento de Risco$")
    public void excluindoEventoRisco() {
        manterConsequenciaRiscoPO.acessarPagina();
        manterConsequenciaRiscoPO.acionarExcluir();
    }

    @Então("^o sistema exclui logicamente o registro$")
    public void excluiRegistro() {

    }

    //CENARIO 11
    @Dado("^que o usuário esteja em formulário para preenchimento do dado consequencia de evento de risco$")
    public void preenchimentoEventoRisco() {
        manterConsequenciaRiscoPO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        manterConsequenciaRiscoPO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void destacarCampos() throws Throwable {
        manterConsequenciaRiscoPO.validarCamposObrigatorios();
    }

    //CENARIO 12

    @Então("^o sistema limpa os dados informados$")
    public void limparDadosInformados() throws Throwable {
        manterConsequenciaRiscoPO.limparDadoInformados();
    }
}
