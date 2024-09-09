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

public class TC_06_InvalidEmailAndPassword {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_06() {
		loginPage.invalidEmailAndPassword(GlobalVariables.INVALID_USER, GlobalVariables.INVALID_PSW);
		Assert.assertTrue(loginPage.validateEnterCredentialsMsg());
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_06");
		driver.quit();
	}
}
