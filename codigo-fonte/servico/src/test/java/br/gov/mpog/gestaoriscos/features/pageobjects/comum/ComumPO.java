package br.gov.mpog.gestaoriscos.features.pageobjects.comum;

import br.com.basis.selenium.componentes.mensagem.angular.MensagemToastFacade;
import br.com.basis.selenium.componentes.tabview.angular.TabAngularFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Created by marcus.ribeiro on 21/06/2017.
 */

public class ComumPO extends PageObject {

    public ComumPO(final WebDriver driver) {
        super(driver);
    }

    public ComumPO(final WebDriver driver, final int ajaxTimeout) {
        super(driver, ajaxTimeout);
    }

    @FindBy(id = "loading-bar")
    private WebElementFacade ajaxStatus;

    @FindBy(tagName = "md-toast")
    private MensagemToastFacade mensagem;

    @FindBy(tagName = "md-tabs")
    private TabAngularFacade tabCadastroNecessidades;

    /**
     * @return o valor ao campo {@link WebElementFacade}
     */
    public WebElementFacade getAjaxStatus() {
        return ajaxStatus;
    }

    /**
     * @return o valor ao campo {@link MensagemToastFacade}
     */
    public MensagemToastFacade getMensagem() {
        return mensagem;
    }

    /**
     * @return o valor ao campo {@link TabAngularFacade}
     */
    public TabAngularFacade getTabCadastroNecessidades() {
        return tabCadastroNecessidades;
    }
}


