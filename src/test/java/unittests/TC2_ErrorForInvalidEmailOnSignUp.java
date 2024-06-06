package unittests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageEvents.UI_Cogmento;
import utils.DataProviderForTests;

public class TC2_ErrorForInvalidEmailOnSignUp extends TestSetup{
	UI_Cogmento uiCogmento = new UI_Cogmento();
	
	@Test(dataProvider = "TestData")
	public void validateErrorForInvalidEmailSignUp(String email, String password) {
		uiCogmento.navigateToLoginUrl();
		uiCogmento.enterCredentials(email, password);
		uiCogmento.clickOnSubmit();
		uiCogmento.validateErrorForInvalidDetails();
	}
	
	@DataProvider(name ="TestData")
	public Object[][] getTestdata(){
		
		Object[][] readData = DataProviderForTests.readEmailAddresses(this.getClass().getSimpleName());
		return readData;
	}
	
	
}
