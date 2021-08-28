package scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.Basetest;
import generic.Excel;
import page.ETTPage;
import page.LoginPage;

public class Invalidlogin extends Basetest {
	

	@Test(priority=2)
	public void testValidlogin() throws InterruptedException {
		String un=Excel.getdata(XL_path, "Invalidlogin", 1, 0);
		String pwd=Excel.getdata(XL_path, "Invalidlogin", 1, 1);
		String title=Excel.getdata(XL_path, "Invalidlogin", 1, 2);
		
	LoginPage login=new LoginPage(driver);
	login.setusername(un);
	Thread.sleep(1000);
	login.setpassword(pwd);
	Thread.sleep(1000);
	login.clicklogin();
	
	boolean result = login.verifyerrmsgDisplayed(wait);
	Assert.assertEquals(result, true, title);
	Reporter.log(title,true);
	}
}

