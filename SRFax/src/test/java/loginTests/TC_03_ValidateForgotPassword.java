package loginTests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.LoginPage;
import setupDriver.DriverSetup;

public class TC_03_ValidateForgotPassword {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_03() {
		loginPage.forgotPassword(GlobalVariables.STANDARD_EMAIL, GlobalVariables.STANDARD_USER);
		Assert.assertTrue(loginPage.validateForgotPasswordRequest());
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_03");
		driver.quit();
	}
}
