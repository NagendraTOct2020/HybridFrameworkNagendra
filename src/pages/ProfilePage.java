package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFunctions.CommonMethods;

public class ProfilePage extends CommonMethods{

	public String getHeaderText() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String headerText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header_user_info span")))
				.getText();
		return headerText;
	}
}
