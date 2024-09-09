package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.LoginPage;
import setupDriver.DriverSetup;

public class TC_05_ErrorMessageBlankPassword {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_05() {
		loginPage.blankPassword(GlobalVariables.STANDARD_USER);
		Assert.assertTrue(loginPage.validateEnterCredentialsMsg());
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_05");
		driver.quit();
	}
}
