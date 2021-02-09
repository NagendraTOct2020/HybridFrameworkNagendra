package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFunctions.CommonMethods;

public class AuthenticationPage extends CommonMethods {

	public void enterEmailAddress(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create"))).sendKeys(email);
		System.out.println("Enter email addressfor the create user name");
	}

	public CreateAccountPage clickOnCreateAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("SubmitCreate"))).click();
		System.out.println("Clicked on the submit button to fill the other details");
		System.out.println("Navigate to create account page");
		return new CreateAccountPage();
	}
	
	public boolean isAuthenticationHeaderVisible(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='home']//following::span[text()='	Authentication']")));
		return element.isDisplayed();
	}
}
