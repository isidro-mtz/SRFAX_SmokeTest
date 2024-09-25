package faxesTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.LoginPage;
import pageObjects.NavigationBar;
import pageObjects.SendAFaxPage;
import setupDriver.DriverSetup;

public class TC_10_SendFax {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);
	NavigationBar navigationBar = new NavigationBar(driver);
	SendAFaxPage sendAFaxPage = new SendAFaxPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_10() {
		// Step 1 login
		loginPage.login(GlobalVariables.STANDARD_USER, GlobalVariables.ALL_USER_PWD);
		// Step 2 Go to send a fax
		navigationBar.sendAFax();
		// Send
		sendAFaxPage.sendSingleFaxNoCoverPage(GlobalVariables.DESTINATION_TEST, GlobalVariables.REFERENCE_TEST,
				GlobalVariables.FILE_PATH);
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_10");
		driver.quit();
	}
}
