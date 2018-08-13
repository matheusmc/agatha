package br.gov.mpog.gestaoriscos.features.runner.gerenciarpermissoes;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by marcus.ribeiro on 21/06/2017.
 */
    @RunWith(CucumberWithSerenity.class)
    @CucumberOptions(features = {"src/test/resources/features/gerenciarpermissoes/gerenciarpermissoes.feature"})
    public class GerenciarPermissoesTestFN {
    }