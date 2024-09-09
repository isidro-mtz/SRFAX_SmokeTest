package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// LoginPage WebElements
	@FindBy(name = "user")
	private WebElement userNameTxt;
	@FindBy(name = "password")
	private WebElement pwdxt;
	@FindBy(id = "reCaptchaSubmit")
	private WebElement signInBtn;
	@FindBy(xpath = "//div[@class='alert alert-danger' and @role='alert']")
	private WebElement errorTxt;
	@FindBy(xpath = "//*[@href='/client/forgotPassword.php']")
	private WebElement forgotPasswordBtn;
	@FindBy(name = "email")
	private WebElement emailTxt;
	@FindBy(name = "account_number")
	private WebElement accountNumberTxt;
	@FindBy(name = "resetPassword")
	private WebElement resetPasswordBtn;
	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement resetPasswordRequest;
	@FindBy(xpath = "//*[@class='alert alert-danger']")
	private WebElement enterCredentialsTxt;
	@FindBy(xpath = "//*[@class='control control--checkbox']")
	private WebElement rememberMeCheckbox;
	@FindBy(xpath = "//*[@title='Click here to show/hide password']")
	private WebElement pswEyeBtn;
	@FindBy(xpath = "//*[@id=\"clientLogin\"]/label[2]/div/input[1]")
	private WebElement unhiddenPassword;

	// Metodos
	public void login(String user, String pwd) {
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.sendKeys(pwdxt, pwd);
		WrapClass.click(signInBtn);
	}
	
	public void loginAndRemember(String user, String pwd) {
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.sendKeys(pwdxt, pwd);
		WrapClass.click(rememberMeCheckbox);
		WrapClass.click(signInBtn);
	}

	public boolean verifyRememberEmail() {
		String email = userNameTxt.getAttribute("value");
		if(email.contentEquals(GlobalVariables.STANDARD_EMAIL)) {
			return true;
		}
		return false;
	}
	
	public boolean verifyPasswordUnhidden() {
		return WrapClass.verifyElementDisplayed(unhiddenPassword);
	}
	
	public void clickEyeBtn(String psw) {
		WrapClass.sendKeys(pwdxt, psw);
		WrapClass.click(pswEyeBtn);
	}
	
	public boolean validateEnterCredentialsMsg() {
		return WrapClass.verifyElementDisplayed(enterCredentialsTxt);
	}

	public void blankEmail(String pwd) {
		WrapClass.sendKeys(pwdxt, pwd);
		WrapClass.click(signInBtn);
	}
	
	public void blankPassword(String user) {
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.click(signInBtn);
	}

	public void forgotPassword(String email, String accountNumber) {
		WrapClass.click(forgotPasswordBtn);
		WrapClass.sendKeys(emailTxt, email);
		WrapClass.sendKeys(accountNumberTxt, accountNumber);
		WrapClass.click(resetPasswordBtn);
	}
	
	public void invalidEmailAndPassword(String email, String password) {
		WrapClass.sendKeys(userNameTxt, email);
		WrapClass.sendKeys(pwdxt, password);
		WrapClass.click(signInBtn);
		WrapClass.verifyElementDisplayed(enterCredentialsTxt);
	}

	public boolean validateForgotPasswordRequest() {
		return WrapClass.verifyElementDisplayed(resetPasswordRequest);
	}

	public boolean validateLockedError() {
		// System.out.println(errorTxt.getText());
		boolean errorDisplayed = errorTxt.getText().contains("Invalid Login");
		return errorDisplayed;
	}

	public boolean validateUserNameField() {
		return WrapClass.verifyElementDisplayed(userNameTxt);
	}

	public boolean validatePasswordField() {
		return WrapClass.verifyElementDisplayed(pwdxt);
	}

	public boolean validateForgotPasswordBtn() {
		return WrapClass.verifyElementDisplayed(forgotPasswordBtn);
	}

	public boolean validateSignupBtn() {
		return WrapClass.verifyElementDisplayed(signInBtn);
	}

}
