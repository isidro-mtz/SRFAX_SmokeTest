package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class AccountMainPage {
	
	//Inicializar elementos
	public AccountMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Webelements
	@FindBy(xpath = "//h2[@class='primary-heading' and text()='Account Summary']")
	private WebElement accountSummaryTxt;
	@FindBy(xpath = "//*[@href='logout.php']")
	private WebElement logoutBtn;
	
	//Metodos
	public boolean validateAccountSummaryText(){
		return WrapClass.verifyElementDisplayed(accountSummaryTxt);
	}
	
	public void logout() {
		WrapClass.click(logoutBtn);
	}

}
