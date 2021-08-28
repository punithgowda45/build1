package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Basetest;
import generic.Excel;
import page.ETTPage;
import page.LoginPage;

public class Validlogin extends Basetest {
	

	@Test(priority=1)
	public void testValidlogin() throws InterruptedException {
		String un=Excel.getdata(XL_path, "Validlogin", 1, 0);
		String pwd=Excel.getdata(XL_path, "Validlogin", 1, 1);
		String title=Excel.getdata(XL_path, "Validlogin", 1, 2);
		
	LoginPage login=new LoginPage(driver);
	login.setusername(un);
	Thread.sleep(1000);
	login.setpassword(pwd);
	Thread.sleep(1000);
	login.clicklogin();
	
	ETTPage ettpage=new ETTPage(driver);
	boolean result = ettpage.verifypageisdisplayed(wait,title);
	Assert.assertEquals(result, true);
	}
}
