package pageEvents;

import javax.swing.text.html.parser.Entity;

import org.openqa.selenium.support.ui.WebDriverWait;

import listeners.TestListener;
import pageObjects.API_Cogmento_Page;
import pageObjects.UI_Cogmento_Page;
import utils.ElementUtil;

public class API_Cogmento {
	
	API_Cogmento_Page apiCogmentoPage;
	ElementUtil elementUtil;
	TestListener log;
	
	public API_Cogmento() {
		apiCogmentoPage = new API_Cogmento_Page();
		elementUtil = new ElementUtil();
		log = new TestListener();
	}
	
	public void navigateToSignUpUrl() {
		elementUtil.navigateToUrl(apiCogmentoPage.signUpUrl);
		log.message("Navigated to Sign up page");
	}
	
	public void enterEmailAndSubmit(String emailAddress) {
		elementUtil.getWebElement("XPATH", apiCogmentoPage.emailInput).sendKeys(emailAddress);
		elementUtil.getWebElement("XPATH", apiCogmentoPage.submitBtn).click();
	}


}
