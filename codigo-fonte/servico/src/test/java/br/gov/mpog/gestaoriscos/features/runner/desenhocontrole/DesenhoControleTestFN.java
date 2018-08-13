package br.gov.mpog.gestaoriscos.features.runner.desenhocontrole;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author miller-macedo
 * @since 22/06/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/desenhocontrole/desenhocontrole.feature"})
public class DesenhoControleTestFN {
}