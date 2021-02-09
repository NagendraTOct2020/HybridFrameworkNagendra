package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pojo.CreateAccountDetailsPojo;
import seleniumFunctions.CommonMethods;

public class CreateAccountPage extends CommonMethods {
	WebDriverWait wait;

	private void selectGender(boolean isMail) {
		System.out.println("STEP - Select  title");
		WebElement titleElement;
		wait = new WebDriverWait(driver, 30);
		titleElement = isMail ? wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")))
				: wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		wait.until(ExpectedConditions.elementToBeClickable(titleElement));
		titleElement.click();
	}

	private void enterFirstName(String fName) {
		System.out.println("STEP - Enter First Name");
		if (fName != null) {
			driver.findElement(By.id("customer_firstname")).sendKeys(fName);
		} else {
			System.out.println("First Name Can not be blank");

		}
	}

	private void enterLastName(String lName) {
		System.out.println("STEP - Enter Last Name");
		if (lName != null) {
			driver.findElement(By.id("customer_lastname")).sendKeys(lName);
		} else {
			System.out.println("Last  Name Can not be blank");

		}
	}

	private void enterPassword(String password) {
		System.out.println("STEP - Enter Password");
		if (password != null && password.length() >= 4) {
			driver.findElement((By.id("passwd"))).sendKeys(password);
		} else {
			System.out.println("Password lenth Can not be less then 4");
		}
	}
	
	private void selectBirthdayFromDropDown(String day){
		System.out.println("STEP - select  Birthdate  from drop down");
		driver.findElement(By.id("uniform-days")).click();
		Select s = new Select(driver.findElement(By.id("days")));
		s.selectByValue(day);

	}
	private void selectBirthdayMonthFromDropDown(String month){
		System.out.println("STEP - Birth month selected");
		driver.findElement(By.id("uniform-months")).click();
		Select s = new Select(driver.findElement(By.id("months")));
		s.selectByVisibleText(month + " ");
	}
	
	private void selectBirthdayYearFromDropDown(String year){
		System.out.println("STEP - Birth year selected");
		driver.findElement(By.id("uniform-years")).click();
		Select s = new Select(driver.findElement(By.id("years")));
		s.selectByValue(year);
	}
	
	private void enterCompanyName(String companyName){
		System.out.println("STEP - Company Name is entered");
		
		driver.findElement(By.id("company")).sendKeys(companyName);
	}
	
	private void enterAddress(String address){
		System.out.println("STEP - Address Name is entered");
		driver.findElement(By.id("address1")).sendKeys(address);
	}
	
	private void enterCityName(String cityName){
		System.out.println("City Name is entered");
		driver.findElement(By.id("city")).sendKeys(cityName);
	}
	
	private void selectStateFromDropDown(String dropDownValue){
		System.out.println("STEP - State is selected");
		driver.findElement(By.id("uniform-id_state")).click();
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByVisibleText(dropDownValue);
	}
	
	private void enterostCodeValue(String postCode){
		System.out.println("STEP - Postcode is entered");
		if(postCode!=null){
		driver.findElement(By.id("postcode")).sendKeys(postCode);
		}else{
			System.out.println("postcode Can not be null");

		}
	}
	
	private void enterAdditionalInformation(String additionalInformation){
		System.out.println("STEP - Other information is entered");
		if(additionalInformation!=null){
		driver.findElement(By.id("other")).sendKeys(additionalInformation);
		}else{
			System.out.println("Additional Information Can not be null");

		}
	}
	
	private void enterMobileNumber(String mobileNumber){
		System.out.println("STEP - Home mobile number is entered");
		if(mobileNumber!=null){
		driver.findElement(By.id("phone")).sendKeys(mobileNumber);
		}else{
			System.out.println("Phone Number Can not be null");
		}
	}
	
	private void enterPhoneNumber(String phoneNumber){
		System.out.println("Mobile number is entered");
		if(phoneNumber!=null){
		driver.findElement(By.id("phone_mobile")).sendKeys(phoneNumber);
		}else{
			System.out.println("Phone Number Can not be null");
		}
	}

	public void inputCreateAccountDetails(CreateAccountDetailsPojo createAccountDetailsPojo) {
		selectGender(createAccountDetailsPojo.isMail());
		enterFirstName(createAccountDetailsPojo.getFirstName());
		enterLastName(createAccountDetailsPojo.getLastName());
		enterPassword(createAccountDetailsPojo.getPassword());
		selectBirthdayFromDropDown(createAccountDetailsPojo.getDays());
		selectBirthdayMonthFromDropDown(createAccountDetailsPojo.getMonth());
		selectBirthdayYearFromDropDown(createAccountDetailsPojo.getYears());
		enterCompanyName(createAccountDetailsPojo.getCompany());
		enterAddress(createAccountDetailsPojo.getAddress());
		enterCityName(createAccountDetailsPojo.getCity());
		selectStateFromDropDown(createAccountDetailsPojo.getState());
		enterostCodeValue(createAccountDetailsPojo.getPostCode());
		enterAdditionalInformation(createAccountDetailsPojo.getAdditionalInfo());
		enterMobileNumber(createAccountDetailsPojo.getPhone());
		enterPhoneNumber(createAccountDetailsPojo.getmNumber());

	}

	public boolean isCreateAnAccountPageHeaderDislayed() {
		 wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='noSlide']//h1[text()='Create an account']"),
				"CREATE AN ACCOUNT"));

	}

	public ProfilePage clickOnRegistration() {
		 wait = new WebDriverWait(driver, 30);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount")));
		element.click();
		System.out.println("Details Registered in Application");
		return new ProfilePage();
	}
	
	public List<String> getErrorMessage(){
		List<WebElement> listoferror=driver.findElements(By.xpath("//ol//li"));
		List<String> errorlistText=new ArrayList<String>();
		String totalErrorCount=driver.findElement(By.cssSelector(".alert.alert-danger>p")).getText();
		errorlistText.add(totalErrorCount);
		for( WebElement element:listoferror){
			errorlistText.add(element.getText());
		}
		return errorlistText;
	} 
	
}
