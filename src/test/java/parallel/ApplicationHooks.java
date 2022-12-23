package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.ConfigReader;
import com.qa.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	Properties prop;
	ConfigReader conred;
	DriverFactory driverfact;
	WebDriver driver;
	
	
	
	@Before(order=0)
	public void getProperty()
	{
		 conred = new ConfigReader();
		prop = conred.readconfig();
	}
	
	
	@Before(order=1)
	public void launchBrowser()
	{
	String browsername = prop.getProperty("browser");
	
	 driverfact = new DriverFactory();
	 driver =driverfact.inItBrowser(browsername);

	}

	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After
	public void tearDown(Scenario sc)
	{
	
		if(sc.isFailed())
		{
			String nameofscenerio = sc.getName();
			
			String scrname = nameofscenerio.replaceAll(" ", "_");
			
			TakesScreenshot scrshot = (TakesScreenshot)driver;
			 
			byte[] source = scrshot.getScreenshotAs(OutputType.BYTES);
			
		 sc.attach(source,"image/png", scrname);
		}
		
	}
	
	
}
