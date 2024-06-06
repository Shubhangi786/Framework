package unittests;

import org.testng.annotations.Test;

import pageEvents.FreeCRM;

public class TC1_FreeCrmLoginUrl extends TestSetup{
	FreeCRM freeCrm = new FreeCRM();
	
	@Test
	public void validateFreeCrmLoginUrl() {
		freeCrm.navigateToFreeCrm();
		freeCrm.clickOnLoginBtn();
		freeCrm.validateFreeCrmLoginUrl();
	}

}
