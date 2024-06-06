package pageEvents;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import base.BaseTest;
import listeners.TestListener;
import pageObjects.UI_Cogmento_Page;
import pageObjects.FreeCRM_Page;
import utils.ElementUtil;

public class FreeCRM {
	FreeCRM_Page freeCrmPage;
	ElementUtil elementUtil;
	UI_Cogmento_Page uiCogmentoPage;
	TestListener log;
	
	public FreeCRM() {
		freeCrmPage = new FreeCRM_Page();
		elementUtil = new ElementUtil();
		uiCogmentoPage = new UI_Cogmento_Page();
		log = new TestListener();
	}
	
	public void clickOnLoginBtn() {
		elementUtil.getWebElement("XPATH", freeCrmPage.loginBtn).click();
		log.message("Clicked on 'Log In' button");
		WebDriverWait wait = new WebDriverWait(BaseTest.driver.get(),Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe(uiCogmentoPage.loginUrl));
	}
	
	public void navigateToFreeCrm() {
		elementUtil.navigateToUrl(freeCrmPage.baseUrl);
		log.message("Navigated to login page");
	}
	
	public void validateFreeCrmLoginUrl() {
		String loginUrl = elementUtil.getCurrentUrl();
		Assert.assertTrue(loginUrl.equals(uiCogmentoPage.loginUrl));
	}

}
