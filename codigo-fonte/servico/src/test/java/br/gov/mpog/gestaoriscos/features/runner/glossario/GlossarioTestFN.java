package br.gov.mpog.gestaoriscos.features.runner.glossario;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author miller-macedo
 * @since 23/06/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/glossario/glossario.feature"})
public class GlossarioTestFN {
}