package br.gov.mpog.gestaoriscos.features.runner.manteroperacaocontrole;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by janaina.santos on 23/06/2017
 */
    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = {"src/test/resources/features/manteroperacaocontrole/manteroperacaocontrole.feature"})
    public class ManterOperacaoControleTestFN {
    }