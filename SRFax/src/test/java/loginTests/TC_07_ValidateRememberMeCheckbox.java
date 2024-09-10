package loginTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.AccountSummaryPage;
import pageObjects.LoginPage;
import pageObjects.NavigationBar;
import setupDriver.DriverSetup;

public class TC_07_ValidateRememberMeCheckbox {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);
	NavigationBar navigationBar = new NavigationBar(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_07() {
		loginPage.loginAndRemember(GlobalVariables.STANDARD_EMAIL, GlobalVariables.ALL_USER_PWD);
		navigationBar.logout();
		Assert.assertTrue(loginPage.verifyRememberEmail());
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_07");
		driver.quit();
	}
}
