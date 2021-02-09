package automationScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.ProfilePage;
import pojo.CreateAccountDetailsPojo;

public class ProfileCreationScript extends TestBase {

	@Test
	public void newUserProfileCreation() {
		HomePage homePage = new HomePage();
		System.out.println("STEP - Click on Signin");
		AuthenticationPage authenticationPage = homePage.clickOnSignIn();
		System.out.println("STEP - Verify Authentication page Header is displayed");
		boolean isauthenticationPageHeaderDisplayed = authenticationPage.isAuthenticationHeaderVisible();
		Assert.assertTrue(isauthenticationPageHeaderDisplayed);
		System.out.println("STEP -Enter Email Address");
		authenticationPage.enterEmailAddress("11112nagen14tr123i7446@yahoo.com");
		System.out.println("STEP - Click on Create Account ");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		System.out.println("STEP - Verify Create An Account page Header is displayed");
		boolean isHeaderDisplayed=createAccountPage.isCreateAnAccountPageHeaderDislayed();
		Assert.assertTrue(isHeaderDisplayed);
		System.out.println("STEP -Enter Account  Details");
		CreateAccountDetailsPojo createAccountDetailsPojo = new CreateAccountDetailsPojo();
		createAccountDetailsPojo.setMail(true);
		createAccountDetailsPojo.setFirstName("automation");
		createAccountDetailsPojo.setLastName("automation");
		createAccountDetailsPojo.setPassword("123654");
		createAccountDetailsPojo.setDays("6");
		createAccountDetailsPojo.setMonth("January");
		createAccountDetailsPojo.setYears("1997");
		createAccountDetailsPojo.setCompany("PTC");
		createAccountDetailsPojo.setAddress("650 Grassmere park");
		createAccountDetailsPojo.setCity("nashville");
		createAccountDetailsPojo.setState("Tennessee");
		createAccountDetailsPojo.setPostCode("37211");
		createAccountDetailsPojo.setAdditionalInfo("NA");
		createAccountDetailsPojo.setPhone("8905714840");
		createAccountDetailsPojo.setmNumber("8905714840");
		createAccountPage.inputCreateAccountDetails(createAccountDetailsPojo);
		System.out.println("STEP - Click on Registration ");
		ProfilePage profilePage = createAccountPage.clickOnRegistration();
		System.out.println("STEP - Verify Header Text ");
		String actual = profilePage.getHeaderText();
		String expected = "automation automation";
		Assert.assertEquals(actual, expected, "Verification of headertext failed");
	}

	@Test
	public void newUserUIProfileCreationValidation() {
		HomePage homePage = new HomePage();
		System.out.println("STEP - Click on Signin");
		AuthenticationPage authenticationPage = homePage.clickOnSignIn();
		System.out.println("STEP - Verify Authentication page Header is displayed");
		boolean isauthenticationPageHeaderDisplayed = authenticationPage.isAuthenticationHeaderVisible();
		Assert.assertTrue(isauthenticationPageHeaderDisplayed);
		System.out.println("STEP -Enter Email Address");
		authenticationPage.enterEmailAddress("n12589agent05ri7446@yahoo.com");
		System.out.println("STEP - Click on Create Account ");
		CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccount();
		System.out.println("STEP - Verify Create An Account page Header is displayed");
		boolean isHeaderDisplayed=createAccountPage.isCreateAnAccountPageHeaderDislayed();
		Assert.assertTrue(isHeaderDisplayed);
		System.out.println("STEP - Click on Registration ");
		createAccountPage.clickOnRegistration();
		List<String> expectedErrorMessage = new ArrayList<String>();
		expectedErrorMessage.add("There are 8 errors");
		expectedErrorMessage.add("You must register at least one phone number.");
		expectedErrorMessage.add("lastname is required.");
		expectedErrorMessage.add("firstname is required.");
		expectedErrorMessage.add("passwd is required.");
		expectedErrorMessage.add("address1 is required.");
		expectedErrorMessage.add("city is required.");
		expectedErrorMessage.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		expectedErrorMessage.add("This country requires you to choose a State.");
		List<String> actualErrorMessage = createAccountPage.getErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
}
