package br.gov.mpog.gestaoriscos.features.runner.calcularriscoinerente;

import br.gov.mpog.gestaoriscos.features.pageobjects.calcularriscoinerente.CalcularRiscoInerentePO;
import br.gov.mpog.gestaoriscos.features.runner.comum.ComumStepDef;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

/**
 * Created by isabelle.gomes on 23/06/2017.
 */
public class CalcularRiscoInerenteStepDef extends ComumStepDef {
    private CalcularRiscoInerentePO calcularRiscoInerentePO;

    @Before
    public void init(){
        getWebDriver().manage().window().maximize();
    }

    @After
    public void after() {
        getWebDriver().quit();
    }

    @Dado("^que o usuário esteja em calculadora de calculo de risco inerente$")
    public void usuarioCalculadora() throws Throwable {
        calcularRiscoInerentePO.acessarPagina();
    }

    @Quando("^informar os pesos de cada aspecto avaliativo$")
    public void informarOsPesosDeCadaAspectoAvaliativo() throws Throwable {
        calcularRiscoInerentePO.limparCampos();
        calcularRiscoInerentePO.informarDados();
    }

    @Então("^o sistema calcula automaticamente o total dos pesos informados Regra de Negócio \"([^\"]*)\"$")
    public void oSistemaCalculaAutomaticamenteOTotalDosPesosInformadosRegraDeNegocio(String arg0) throws Throwable {
        calcularRiscoInerentePO.porcentagem();
    }
}
