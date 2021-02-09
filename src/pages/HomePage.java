package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFunctions.CommonMethods;

public class HomePage extends CommonMethods {
	
	public AuthenticationPage clickOnSignIn(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".header_user_info>a"))).click();
		System.out.println("Clicked on sign in");
		return new AuthenticationPage();
	}

}
