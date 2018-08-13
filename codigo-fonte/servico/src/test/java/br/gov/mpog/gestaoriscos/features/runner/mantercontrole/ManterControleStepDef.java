package br.gov.mpog.gestaoriscos.features.runner.mantercontrole;

import br.gov.mpog.gestaoriscos.features.pageobjects.mantercontrole.ManterControlePO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

/**
 * Created by janaina.santos on 22/06/2017
 */
public class ManterControleStepDef extends ComumStepDef {

    private ManterControlePO manterControlePO;

    @Before
    public void init() throws IOException {
        getConnectionSample().prepararCarga("insert-mantercontrole.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("delete-mantercontrole.sql");
        getWebDriver().quit();
    }

    //CENARIO 1
    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessarPaginaUm() throws Throwable {
        manterControlePO.acessarPagina();
    }

    @Então("^o sistema apresenta os parâmetros para consulta, acrescido das opções 'Limpar', 'Consultar' e 'Novo'$")
    public void verificarPresencaDeCampos() throws Throwable {
        manterControlePO.verificarPresencaCampos();
    }


    @E("^apresenta a lista de controles que foram cadastrados anteriormente com as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Descrição do Controle$")
    public void apresentarCamposHistorico() throws Throwable {
        manterControlePO.apresentarOutrosCampos();
    }

    //    CENARIO 2
    @Dado("^que o usuário esteja em controle$")
    public void acessarPaginaDois() throws Throwable {
        manterControlePO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\"$")
    public void acionarIncluir(String opcao) throws Throwable {
        if (opcao.equals("Controle")) {
//            manterControlePO.acessarPagina();
        } else if (opcao.equals("Incluir")) {
            manterControlePO.incluirRisco();
        } else if (opcao.equals("Alterar")) {
            manterControlePO.alterarRisco();
        } else if (opcao.equals("Ok")) {
            manterControlePO.acionarAcao(opcao);
        } else if (opcao.equals("Limpar")) {
            manterControlePO.acionarAcao(opcao);
        }
    }

    @Então("^o sistema apresenta o formulário para informar dados do controle$")
    public void apresentarParaPreenchimento() throws Throwable {
        manterControlePO.camposPreenchimento();
    }

    //CENARIO 3
    @Dado("^que o usuário esteja em lista de Controle salvos$")
    public void acessarAlterar() throws Throwable {
        manterControlePO.acessarPagina();
    }

    @E("^informou os parâmetros necessários$")
    public void informouOsParametros() throws Throwable {
    }

    @Então("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        manterControlePO.getAjaxStatus().waitUntilNotVisible();
    }

    @E("^adiciona o item salvo na lista$")
    public void adicionaItemSalvoLista() throws Throwable {
//        manterControlePO.adicionaItemSalvoLista();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagem(String mensagem) throws Throwable {
        manterControlePO.exibeMensagem(mensagem);
    }

    @Então("^o sistema apresenta os dados para serem alterados$")
    public void apresentaCampos() throws Throwable {
        manterControlePO.camposHabilitados();
    }

    //CENARIO 4
    @E("^informou dados de um item já existente$")
    public void eInformouOsParametrosExistentes() throws Throwable {
        manterControlePO.incluirRisco();
        manterControlePO.eInformouOsParametrosExistentes();
    }

    @Quando("^o usuário acionar a opção 'Incluir'$")
    public void acionarOpcaoIncluir() throws Throwable {
        manterControlePO.clicarIncluir();
    }

    @Então("^o sistema apresenta a mensagem \"([^\"]*)\"$")
    public void exibeMensagemErro(String mensagem) throws Throwable {
        manterControlePO.exibeMensagem(mensagem);
    }

    //CENARIO 5
    @Quando("^o usuário acionar a opção \"([^\"]*)\" no item desejado$")
    public void oUsuarioAcionarAOpcaoNoItemDesejado(String comando) throws Throwable {
        manterControlePO.acionarAcao(comando);
    }

    //CENARIO 6
    @Dado("^que o usuário esteja alterando dados do controle$")
    public void alterandoDados() {
        manterControlePO.acessarPagina();
        manterControlePO.acionarAcao("Alterar");
    }

    //CENARIO 7
    @Dado("^que o usuário esteja em lista de Controle$")
    public void acessarListagem() {
        manterControlePO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja inativado$")
    public void acionarAtivar(String opcao) {
        manterControlePO.acionarAcao(opcao);
    }

    @Então("^o sistema ativa o Controle selecionado$")
    public void ativaSelecionado() {
        manterControlePO.verificarRegistroAtivado();
    }

    @E("^fica disponível para a vinculação a uma etapa$")
    public void disponívelParaVincular() {

    }

    //CENARIO 8
    @Quando("^o usuário acionar a opção \"([^\"]*)\" de um item que esteja ativado")
    public void acionarInativar(String opcao) {
        manterControlePO.acionarAcao(opcao);
    }

    @Então("^o sistema inativa o Controle selecionado$")
    public void inativaSelecionado() {
        manterControlePO.verificarRegistroInativado();
    }

    @E("^desvincula o item a uma etapa, caso esteja vinculado$")
    public void desvinculaItem() {

    }

    //CENARIO 9
    @Quando("^o usuário acionar a opção 'Excluir' de um item desejado$")
    public void acionarExcluir() throws Throwable {
        manterControlePO.acionarExcluir();
    }

    @Então("^o sistema apresenta mensagem \"([^\"]*)\", com as opções 'OK' e 'Cancelar'$")
    public void apresentaMensagem(String mensagem) throws Throwable {
        manterControlePO.apresentarMsg(mensagem);
    }

    //CENARIO 10
    @Dado("^que o usuário esteja excluindo um Controle$")
    public void excluindoEventoRisco() {
        manterControlePO.acessarPagina();
        manterControlePO.acionarExcluir();
    }

    @Então("^o sistema exclui logicamente o registro$")
    public void excluiRegistro() {

    }

    //CENARIO 11
    @Dado("^que o usuário esteja em formulário para preenchimento do dado controle$")
    public void preenchimentoEventoRisco() {
        manterControlePO.acessarPagina();
    }

    @Quando("^o usuário acionar a opção \"([^\"]*)\" sem preencher algum dos campos definidos como obrigatório$")
    public void oUsuarioAcionarAOpcaoSemPreencherAlgumDosCamposDefinidosComoObrigatorio(String opcao) throws Throwable {
        manterControlePO.acionarAcao(opcao);
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void destacarCampos() throws Throwable {
        manterControlePO.validarCamposObrigatorios();
    }

    //CENARIO 12

    @Então("^o sistema limpa os dados informados$")
    public void limparDadosInformados() throws Throwable {
        manterControlePO.limparDadoInformados();
    }

}
