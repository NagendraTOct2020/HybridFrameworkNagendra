package automationScript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import seleniumFunctions.CommonMethods;

public class TestBase {

	@BeforeMethod
	public void setUp(){
		System.out.println("STEP -Open the driver");
		CommonMethods.start();

	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("STEP -Close the driver");
		CommonMethods.close();
	}
}
