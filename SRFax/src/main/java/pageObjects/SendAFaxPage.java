package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonMethods.WrapClass;

public class SendAFaxPage {

	public SendAFaxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// WebElements
	@FindBy(name = "sender")
	private WebElement senderFld;
	@FindBy(xpath = "//*[@value='single']")
	private WebElement singleFaxRadioBtn;
	@FindBy(xpath = "//*[@value='broadcast']")
	private WebElement broadcastFaxRadioBtn;
	@FindBy(id = "faxNumber")
	private WebElement enterDestinationFaxFld;
	@FindBy(id = "addressBookSingle")
	private WebElement addressBookBtn;
	@FindBy(name = "addToAddressBook")
	private WebElement saveToAddressBookChkBox;
	@FindBy(name = "reference")
	private WebElement referenceFld;
	@FindBy(name = "retries")
	private WebElement retriesFld;
	@FindBy(id = "addCoverPage")
	private WebElement includeCoverPageChkBox;
	@FindBy(id = "previewCheck")
	private WebElement previewFaxChkBox;
	@FindBy(id = "schedule")
	private WebElement scheduleChxBox;
	@FindBy(name = "qqfile")
	private WebElement selectFileBtn;
	@FindBy(id = "sendFaxSubmit")
	private WebElement sendFaxBtn;

	// Metodos
	public void sendSingleFaxNoCoverPage(String destinationFax, String reference, String filePath) {
		WrapClass.click(singleFaxRadioBtn);
		WrapClass.sendKeys(enterDestinationFaxFld, destinationFax);
		WrapClass.sendKeys(referenceFld, reference);
		WrapClass.click(selectFileBtn);
		selectFileBtn.sendKeys(filePath);
		WrapClass.click(sendFaxBtn);
	}

	public boolean verifySenderField() {
		return WrapClass.verifyElementDisplayed(senderFld);
	}

	public boolean verifyTypeOfFax() {
		if (WrapClass.verifyElementDisplayed(singleFaxRadioBtn)
				&& WrapClass.verifyElementDisplayed(broadcastFaxRadioBtn)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyEnterDestination() {
		return WrapClass.verifyElementDisplayed(enterDestinationFaxFld);
	}
	
	public boolean verifyAddToAddressBook() {
		return WrapClass.verifyElementDisplayed(addressBookBtn);
	}
	
	public boolean verifyReference() {
		return WrapClass.verifyElementDisplayed(referenceFld);
	}
	
	public boolean verifyRetries() {
		return WrapClass.verifyElementDisplayed(retriesFld);
	}
	
	public boolean verifyIncludeCoverPage() {
		return WrapClass.verifyElementDisplayed(includeCoverPageChkBox);
	}
	
	public boolean verifyScheduleFax() {
		return WrapClass.verifyElementDisplayed(scheduleChxBox);
	}
	
	public boolean verifyAttachmentSection() {
		return WrapClass.verifyElementDisplayed(selectFileBtn);
	}
	
	public boolean verifySendFaxBtn() {
		return WrapClass.verifyElementDisplayed(sendFaxBtn);
	}
	

}
