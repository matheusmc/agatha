package br.gov.mpog.gestaoriscos.features.runner.formulariolevantamentoinformacoes;

import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.pageobjects.formulariolevantamentoinformacoes.FormularioLevantamentoInformacoesPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author silas.silva
 * @since 22/06/2017.
 */
public class FormularioLevantamentoInformacoesStepDef extends ComumStepDef {

    private FormularioLevantamentoInformacoesPO formularioPO;

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @Before
    public void init() {
        getConnectionSample().prepararCarga("deletar_permissao_usuario_formulario.sql");
        getConnectionSample().prepararCarga("incluir_permissao_usuario_formulario.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("deletar_permissao_usuario_formulario.sql");
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em formulário de Analise de Ambiente e de Fixação de Objetivos$")
    public void acessarFormulario() throws Throwable {
        autenticacaoOpenAmPO.acessarPagina("/processo/analiseAmbiente/incluir");
    }

    @E("^preencheu todos os parâmetros necessários para o cadastro$")
    public void preencherParametros() throws Throwable {
        formularioPO.preencherRadios();
    }

    @Quando("^o usuário acionar a opção 'Gravar' sem pendências$")
    public void gravarSemPendencia() throws Throwable {
        formularioPO.preencherCampos();
    }

    @Então("^o sistema grava os dados informados$")
    public void gravarDadosInformados() throws Throwable {
        formularioPO.salvarFormulario();
    }

    @Então("^o sistema cancela operação$")
    public void cancelarOperacao() {
        formularioPO.redirecionandoPagina();
    }

    @E("^alterar o status da etapa para 'Iniciada'$")
    public void alterarStatusDaEtapaParaIniciada() throws Throwable {
        formularioPO.camposStatusEstaVisivel();
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void apresentaAMensagem(String mensagem) throws Throwable {
    }

    @Quando("^o usuário acionar a opção 'Cancelar'$")
    public void oUsuarioAcionarAOpcaoCancelar() throws Throwable {
        formularioPO.cancelarFormulario();
    }

    @E("^retorna para a tela anterior$")
    public void retornaParaATelaAnterior() throws Throwable {
        formularioPO.retornaParaATelaAnterior();
    }

    @Dado("^que o usuário esteja em formulário de Analise SWOT$")
    public void queOUsuarioEstejaEmFormularioDeAnaliseSWOT() throws Throwable {
        autenticacaoOpenAmPO.acessarPagina("/processo/analiseAmbiente/incluir");
    }

    @E("^informou os parâmetros necessários$")
    public void informouOsParametrosNecessarios() throws Throwable {
        formularioPO.informouOsParametrosNecessarios();
    }

    @Quando("^o usuário acionar a opção 'Adicionar'$")
    public void oUsuarioAcionarAOpcaoAdicionar() throws Throwable {
        formularioPO.oUsuarioAcionarAOpcaoAdicionar();
    }

    @Então("^o sistema grava os dados$")
    public void sistemaGravaDados() throws Throwable {
        formularioPO.sistemaGravaDados();
    }

    @Quando("^o usuário acionar a opção 'Gravar'e ou 'Enviar para validação' sem preencher algum dos campos definidos como obrigatório$")
    public void preenchimentoObrigatorio() throws Throwable {
        formularioPO.salvarFormulario();
    }

    @Então("^o sistema deve destacar o\\(s\\) campo\\(s\\) que não foram preenchidos, em vermelho e apresentar as mensagens padrões$")
    public void verificarCamposVermelho() {
        formularioPO.verificarMensagemToast("Dados não encontrados");
    }
}
