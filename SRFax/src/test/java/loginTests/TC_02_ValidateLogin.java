package loginTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import pageObjects.AccountSummaryPage;
import pageObjects.LoginPage;
import setupDriver.DriverSetup;

public class TC_02_ValidateLogin {

	// Declarar webdriver
	WebDriver driver = DriverSetup.setupDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Inicializar page objects y metodos
	LoginPage loginPage = new LoginPage(driver);
	AccountSummaryPage accountMain = new AccountSummaryPage(driver);
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables.HOME_PAGE);
	}

	@Test
	public void TC_02() {
		// mandar usuario y contrasena
		loginPage.login(GlobalVariables.STANDARD_USER, GlobalVariables.ALL_USER_PWD);
		wait.until(ExpectedConditions.urlToBe("https://qasecure.srfax.com/client/AccountMain.php"));
		// Verificar main page
		Assert.assertTrue(driver.getCurrentUrl().equals("https://qasecure.srfax.com/client/AccountMain.php"));
	}

	@AfterTest
	public void closeDriver() {
		WrapClass.takeScreenshot(driver, "TC_02");
		driver.quit();
	}
}
