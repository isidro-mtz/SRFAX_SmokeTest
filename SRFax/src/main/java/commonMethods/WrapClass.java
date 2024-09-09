package commonMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WrapClass {
	
	public static void click(WebElement webElement) {
		webElement.click();
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

}
