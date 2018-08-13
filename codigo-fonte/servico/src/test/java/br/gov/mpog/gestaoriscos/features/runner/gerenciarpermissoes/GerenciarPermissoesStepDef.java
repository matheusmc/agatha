package br.gov.mpog.gestaoriscos.features.runner.gerenciarpermissoes;

import br.gov.mpog.gestaoriscos.features.pageobjects.gerenciarpermissoes.GerenciarPermissoesPO;
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
 * Created by marcus.ribeiro on 21/06/2017.
 */
public class GerenciarPermissoesStepDef extends ComumStepDef {
    private GerenciarPermissoesPO gerenciarPermissoesPO;


    @Before
    public void init() {
        getConnectionSample().prepararCarga("insert-gerenciarpermissoes.sql");
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getConnectionSample().prepararCarga("delete-gerenciarpermissoes.sql");
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em menu do sistema$")
    public void acessar() throws Throwable {
    }

    @Dado("^que o usuário esteja incluindo ou alterando permissões$")
    public void usuarioIncluindoPermissoes() throws Throwable {
        gerenciarPermissoesPO.acessarPagina();
        gerenciarPermissoesPO.acionarNovo();
    }

    @E("^já tenha incluído um perfil ao usuário selecionado$")
    public void incluirPerfil() throws Throwable {
        gerenciarPermissoesPO.cadastrarUmUsuario();
    }

    @E("^deseja incluir mais um perfil$")
    public void incluirSegundoPerfil() throws Throwable {
        gerenciarPermissoesPO.incluirSegundoPerfil();
    }

    @Quando("^o usuário acionar a opção 'Adicionar'$")
    public void acinarAdd() throws Throwable {
        gerenciarPermissoesPO.acinarAdd();
    }

    @Então("^o sistema apresenta mais um campo de seleção de perfil para ser selecionado$")
    public void apresentarOutroCampoDePerfil() throws Throwable {
        gerenciarPermissoesPO.apresentarOutroCampoDePerfil();
    }

    @Dado("^que o usuário esteja em Permissões$")
    public void usuarioEmPermissoes() throws Throwable {
        gerenciarPermissoesPO.acessarPagina();
    }

    @E("^informou os parâmetros necessários para a consulta$")
    public void informouOsParâmetrosNecessáriosParaAConsulta() throws Throwable {
        gerenciarPermissoesPO.informarParametrosConsulta();
    }

    @Quando("^o usuário acionar a opção 'Consultar'$")
    public void acionarConsultar() throws Throwable {
        gerenciarPermissoesPO.acionarConsultar();
    }

    @Então("^o sistema apresenta o resultado da consulta, com as colunas 'Item', 'Nome do Usuário', 'Perfil' e as opções 'Alterar' e 'Excluir'$")
    public void apresentarResultados() throws Throwable {
        gerenciarPermissoesPO.apresentarResultados();
    }

    @E("^não informou os parâmetros necessários$")
    public void naoInformarParametrosNecessario() throws Throwable {
    }

    @Então("^o sistema apresenta a lista de permissões, com as colunas 'Item', 'Nome do Usuário', 'Perfil' e as opções 'Alterar', 'Ativar/Inativar' e 'Excluir', ordenado alfabeticamente pela coluna Nome do usuário$")
    public void apresentarResultadosEOrdenarUsuarios() throws Throwable {
        gerenciarPermissoesPO.apresentarResultados();
        gerenciarPermissoesPO.ordenarUsuarios();
    }

    @Dado("^que o usuário esteja em lista de usuários$")
    public void listarUsuarios() throws Throwable {
        gerenciarPermissoesPO.acessarPagina();
        gerenciarPermissoesPO.informarParametrosConsulta();
    }

    @E("^informou parâmetros necessários para atribuição de perfil de acesso$")
    public void alterarPerfil() throws Throwable {
        gerenciarPermissoesPO.alterarPerfil();
    }

    @Quando("^o usuário acionar o botão 'Gravar'$")
    public void acionarSalvar() throws Throwable {
        gerenciarPermissoesPO.acionarSalvar();
    }

    @Então("^o sistema salva os parâmetros salvos$")
    public void salvarParametros() throws Throwable {
    }

    @E("^apresenta a mensagem \"([^\"]*)\"$")
    public void apresentarMensagem(String pMensagem) throws Throwable {
        gerenciarPermissoesPO.apresentarMensagem(pMensagem);
    }
}