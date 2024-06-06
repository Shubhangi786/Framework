package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;

import base.BaseTest;

public class ElementUtil {
	
	public WebElement getWebElement(String identifierType, String identiFierValue) {
		switch(identifierType.toLowerCase()) {
		
		case "xpath":
			return BaseTest.driver.get().findElement(By.xpath(identiFierValue));
			
		case "id":
			return BaseTest.driver.get().findElement(By.id(identiFierValue));
			
			//can add all other remaining locators below
		}
		return null;
	}
	
	public String getCurrentUrl() {
		return BaseTest.driver.get().getCurrentUrl();
	}
	
	public void navigateToUrl(String url) {
		BaseTest.driver.get().get(url);
		
	}
	

}
