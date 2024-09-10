package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class NavigationBar {
	
	private WebDriver driver;
	
	public NavigationBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath = "//*[@href='logout.php']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//a[@href='#Faxes']")
	private WebElement faxesBtn;
	@FindBy(xpath = "//a[@href='sendFax.php']")
	private WebElement sendAFaxBtn;
	@FindBy(xpath = "//a[@href='faxesReceived.php']")
	private WebElement faxesReceivedBtn;
	@FindBy(xpath = "//a[@href='faxesSent.php']")
	private WebElement faxesSentBtn;
	@FindBy(xpath = "//a[@href='faxOutbox.php']")
	private WebElement faxesQueuedBtn;
	@FindBy(xpath = "//a[@href='junkInbox.php']")
	private WebElement junkFaxesBtn;
	@FindBy(xpath = "//a[@href='editAddressBook.php']")
	private WebElement editAddressBookBtn;
	@FindBy(xpath = "//a[@href='callLog.php']")
	private WebElement callLogBtn;
	
	@FindBy(xpath = "//a[@href='#Settings']")
	private WebElement settingsBtn;
	@FindBy(xpath = "//a[@href='#MyAccount']")
	private WebElement myAccountBtn;
	@FindBy(xpath = "//a[@href='#Users']")
	private WebElement usersBtn;
	@FindBy(xpath = "//a[@href='#AdvancedSecurity']")
	private WebElement advancedSecurityBtn;
	@FindBy(xpath = "//a[@href='#Support']")
	private WebElement supportBtn;
	
	//Metodos
	public void logout() {
		WrapClass.click(logoutBtn);
	}
	
	public void faxes() {
		WrapClass.click(faxesBtn);
	}
	
	public void sendAFax() {
	    if (driver == null) {
	        throw new RuntimeException("WebDriver is not initialized");
	    }
	    System.out.println("Attempting to wait for sendAFaxBtn to be clickable.");
	    WebElement element = WrapClass.waitForElementToBeClickable(driver, sendAFaxBtn, 10);
	    if (element == null) {
	        throw new RuntimeException("Failed to locate the sendAFaxBtn element");
	    }
	    WrapClass.click(element);
	}
	
	public void faxesReceived() {
		WrapClass.click(faxesReceivedBtn);
	}
	
	public void faxesSent() {
		WrapClass.click(faxesSentBtn);
	}
	
	public void faxesQueued() {
		WrapClass.click(faxesQueuedBtn);
	}
	
	public void junkFaxes() {
		WrapClass.click(junkFaxesBtn);
	}
	
	public void callLogReports() {
		WrapClass.click(callLogBtn);
	}
	
	public void editAddressBook() {
		WrapClass.click(editAddressBookBtn);
	}
	
	public void settings() {
		WrapClass.click(settingsBtn);
	}
	
	public void myAccount() {
		WrapClass.click(myAccountBtn);
	}
	
	public void users() {
		WrapClass.click(usersBtn);
	}
	
	public void advancedSecurity() {
		WrapClass.click(advancedSecurityBtn);
	}
	
	public void support() {
		WrapClass.click(supportBtn);
	}
	

}
