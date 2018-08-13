package br.gov.mpog.gestaoriscos.features.runner.autenticacaoopenam;

import br.gov.mpog.gestaoriscos.features.pageobjects.autenticacaoopenam.AutenticacaoOpenAmPO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.Before;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * @author silas.silva
 * @since 22/06/2017.
 */
public class AutenticacaoOpenAmStepDef extends ComumStepDef {

    private AutenticacaoOpenAmPO autenticacaoOpenAmPO;

    @Before
    public void before() {
        getWebDriver().manage().window().maximize();
    }

    @E("^tenha informado os parâmetros necessários para autenticação, sem pendências$")
    public void acessarPagina() throws Throwable {
        autenticacaoOpenAmPO.abrirPagina();
    }

    @Quando("^o usuário acionar a opção 'Acessar'$")
    public void acionarUsuario() throws Throwable {
        autenticacaoOpenAmPO.preencherCampos();
    }

    @Então("^o sistema valida os dados informados$")
    public void oSistemaValidaOsDadosInformados() throws Throwable {
        autenticacaoOpenAmPO.localizarPagina("/");
    }

    @E("^apresenta a tela inicial do sistema, conforme as permissões de acesso$")
    public void apresentaATelaInicialDoSistemaConforme() throws Throwable {
        autenticacaoOpenAmPO.verificarUrl("/");
    }
}
