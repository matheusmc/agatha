package br.gov.mpog.gestaoriscos.features.runner.mantercalculadora;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by gabriel.neves on 23/06/2017.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/mantercalculadora/mantercalculadora.feature"})
public class ManterCalculadoraTestFN {
}
