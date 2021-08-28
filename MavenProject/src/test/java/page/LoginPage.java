package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
@FindBy(id="username") private WebElement untb;
@FindBy(name="pwd") private WebElement pwdtb;
@FindBy(xpath="//div[text()='Login ']") private WebElement loginbtn;
@FindBy(xpath="//span[contains(text(),'invalid')]") private WebElement errmsg;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setusername(String un) {
	untb.sendKeys(un);
}
public void setpassword(String pwd) {
	pwdtb.sendKeys(pwd);
}
public void clicklogin() {
	loginbtn.click();
}
public boolean verifyerrmsgDisplayed(WebDriverWait wait) {
	try {
	wait.until(ExpectedConditions.visibilityOf(errmsg));
	return true;
	}
	catch(Exception e) {
		return false;
	}
}
}