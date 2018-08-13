package br.gov.mpog.gestaoriscos.features.runner.autenticacaoopenam;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * @author silas.silva
 * @since 22/06/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/autenticacaoopenam/autenticacaoopenam.feature"})
public class AutenticacaoOpenAmTestFN {
}