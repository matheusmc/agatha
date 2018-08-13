package br.gov.mpog.gestaoriscos.features.runner.mantercategoriarisco;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author jose.rodrigues
 * @since 22/06/2017
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/mantercategoriarisco/mantercategoriarisco.feature"})
public class ManterCategoriaRiscoTestFN {
}