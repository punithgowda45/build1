package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ETTPage {
public ETTPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public boolean verifypageisdisplayed(WebDriver driver,String etitle) {
	String atitle=driver.getTitle();
	return atitle.equals(etitle);
}
public boolean verifypageisdisplayed(WebDriverWait wait,String etitle) {
	try{
		wait.until(ExpectedConditions.titleContains(etitle));
		return true;
		}
	catch(Exception e){
		return false;
		}
		
	}
}