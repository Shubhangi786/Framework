package unittests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import base.BaseTest;

public class TestSetup {


	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		BaseTest.setDriver(browser);
	}
	
	@AfterMethod
	public void tearDown() {
		if(BaseTest.driver!=null) {
			BaseTest.driver.get().quit();
		}
		
	}
	
}
