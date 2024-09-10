package faxesTests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.LoginPage;
import pageObjects.NavigationBar;
import pageObjects.SendAFaxPage;
import setupDriver.DriverSetup;

public class TC_09_ValidateUI {

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
	public void TC_09() {
		loginPage.login(GlobalVariables.STANDARD_USER, GlobalVariables.ALL_USER_PWD);
		navigationBar.faxes();
		navigationBar.sendAFax();
		Assert.assertTrue(sendAFaxPage.verifySenderField());
		Assert.assertTrue(sendAFaxPage.verifyTypeOfFax());
		Assert.assertTrue(sendAFaxPage.verifyEnterDestination());
		Assert.assertTrue(sendAFaxPage.verifyAddToAddressBook());
		Assert.assertTrue(sendAFaxPage.verifyReference());
		Assert.assertTrue(sendAFaxPage.verifyRetries());
		Assert.assertTrue(sendAFaxPage.verifyIncludeCoverPage());
		Assert.assertTrue(sendAFaxPage.verifyScheduleFax());
		Assert.assertTrue(sendAFaxPage.verifyAttachmentSection());
		Assert.assertTrue(sendAFaxPage.verifySendFaxBtn());
	}
	
	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_09");
		driver.quit();
	}
	
}