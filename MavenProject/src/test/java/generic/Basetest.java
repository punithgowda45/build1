package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest implements IConst {
	public WebDriver driver;
	public WebDriverWait wait;

	@Parameters({"huburl","browser"})
	@BeforeMethod
public void openapp(@Optional(durl)String huburl,@Optional(dbrowser)String browser) throws MalformedURLException {
//	WebDriverManager.chromedriver().setup();
//	driver=new ChromeDriver();
		URL remoteurl=new URL(huburl);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver=new RemoteWebDriver(remoteurl,dc);
	driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,ETO);
	driver.manage().window().maximize();
	driver.get(appURL);
}
@AfterMethod
public void closeapp() {
	driver.quit();
}

}
