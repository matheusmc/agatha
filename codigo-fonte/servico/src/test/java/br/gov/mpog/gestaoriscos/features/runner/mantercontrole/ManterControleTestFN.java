package br.gov.mpog.gestaoriscos.features.runner.mantercontrole;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by janaina.santos on 22/06/2017
 */
    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = {"src/test/resources/features/mantercontrole/mantercontrole.feature"})
    public class ManterControleTestFN {
    }