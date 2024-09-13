package commonMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WrapClass {
	
	
	public static void click(WebElement webElement) {
		webElement.click();
	}
	
	public static WebElement reinitializeElement (WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			// Create an instance of WebDriverWait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			//Wait element to be visible
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			// Wait for the element to be clickable and return it
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Exception e) {
			System.out.println("Element could not be reinitialized: " + e.getMessage());
            return null;  
		}
	}
	
	public static void sendKeys(WebElement webElement, String textToSend) {
		webElement.sendKeys(textToSend);
	}
	
	public static boolean verifyElementDisplayed(WebElement webElement) {
		return webElement.isDisplayed();
	}
	
	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
		
		//toma el screenshot de la pagina sin formato
		File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		//Ruta para guardar el archivo
		String screenshotPath = "./test/output/ExecutionResults";
		
		try {
			FileHandler.createDir(new File(screenshotPath)); // Creamos el folder usando la ruta en screenshotPath
			FileHandler.copy(scrFile, new File(screenshotPath + File.separator + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Nuevo método para esperar a que un elemento sea clickeable
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	
	

}
