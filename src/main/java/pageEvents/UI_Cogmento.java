package pageEvents;

import org.testng.Assert;

import listeners.TestListener;
import pageObjects.UI_Cogmento_Page;
import utils.ElementUtil;

public class UI_Cogmento {
	
	UI_Cogmento_Page uiCogmentoPage;
	ElementUtil elementUtil;
	TestListener log;
	
	public UI_Cogmento() {
		uiCogmentoPage = new UI_Cogmento_Page();
		elementUtil = new ElementUtil();
		log = new TestListener();
	}
	
	public void navigateToLoginUrl() {
		elementUtil.navigateToUrl(uiCogmentoPage.loginUrl);
		log.message("Navigated to Sign up page");
	}
	
	public void enterCredentials(String userEmail, String password) {
		elementUtil.getWebElement("xpath", uiCogmentoPage.emailInput).sendKeys(userEmail);
		elementUtil.getWebElement("xpath", uiCogmentoPage.passwrdInput).sendKeys(password);
		log.message("Entered email and password");
	}

	public void clickOnSubmit() {
		elementUtil.getWebElement("xpath", uiCogmentoPage.submitBtn).click();
		log.message("Clicked on submit");
	}
	
	public void validateErrorForInvalidDetails() {
		boolean isError = elementUtil.getWebElement("xpath", uiCogmentoPage.invalidErrText).isDisplayed();
		Assert.assertTrue(isError, "Error message not displayed for invalid login");
	}
}
