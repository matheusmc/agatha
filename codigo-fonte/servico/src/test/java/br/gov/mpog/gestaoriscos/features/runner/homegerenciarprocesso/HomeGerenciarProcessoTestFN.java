package br.gov.mpog.gestaoriscos.features.runner.homegerenciarprocesso;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author Ludmily
 * @since 22/06/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/homegerenciarprocesso/homegerenciarprocesso.feature"})
public class HomeGerenciarProcessoTestFN {
}
