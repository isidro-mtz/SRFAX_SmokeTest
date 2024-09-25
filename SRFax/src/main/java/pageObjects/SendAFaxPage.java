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
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[2]/div[2]/label[1]")
	private WebElement singleFaxRadioBtn;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[2]/div[2]/label[2]")
	private WebElement broadcastFaxRadioBtn;
	@FindBy(id = "faxNumber")
	private WebElement enterDestinationFaxFld;
	@FindBy(id = "addressBookSingle")
	private WebElement addressBookBtn;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[3]/div[2]/span[1]/label/div")
	private WebElement saveToAddressBookChkBox;
	@FindBy(name = "reference")
	private WebElement referenceFld;
	@FindBy(name = "retries")
	private WebElement retriesFld;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[6]/div[2]/label/div")
	private WebElement includeCoverPageChkBox;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[8]/div[2]/label/div")
	private WebElement previewFaxChkBox;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[1]/div[9]/div[2]/label/div")
	private WebElement scheduleChxBox;
	@FindBy(xpath = "/html/body/div[1]/div/div/main/div[2]/form/div/div/div[2]/div[3]/div/div/div[1]")
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

	public boolean verifySingleElement() {
		return WrapClass.verifyElementDisplayed(sendFaxBtn);
	}

	public boolean verifySendAFaxUI() {
		if (WrapClass.verifyElementDisplayed(senderFld) && 
			WrapClass.verifyElementDisplayed(singleFaxRadioBtn) &&
			WrapClass.verifyElementDisplayed(broadcastFaxRadioBtn) &&
			WrapClass.verifyElementDisplayed(enterDestinationFaxFld) &&
			WrapClass.verifyElementDisplayed(enterDestinationFaxFld) &&
			WrapClass.verifyElementDisplayed(saveToAddressBookChkBox) &&
			WrapClass.verifyElementDisplayed(referenceFld) &&
			WrapClass.verifyElementDisplayed(retriesFld) &&
			WrapClass.verifyElementDisplayed(includeCoverPageChkBox) &&
			WrapClass.verifyElementDisplayed(previewFaxChkBox) &&
			WrapClass.verifyElementDisplayed(scheduleChxBox) &&
			WrapClass.verifyElementDisplayed(selectFileBtn) &&
			WrapClass.verifyElementDisplayed(sendFaxBtn)
			) {
			
			return true;

		}else {
			System.out.println("Element not found");
			return false;
		}
	}

}
