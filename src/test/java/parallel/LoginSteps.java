package parallel;

import com.pages.LoginPage;
import com.qa.DriverFactory;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


	LoginPage lp = new LoginPage(DriverFactory.getdriver());
	String title;
	
	@Given("User is on the landing page")
	public void user_is_on_the_landing_page() 
	{
    
		DriverFactory.getdriver().navigate().to("https://www.amazon.in/");
		
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() 
	{
    
		 title = lp.getLoginPageTitle();
		
		System.out.println("Title of page is "+title);
		
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title)
	{
    
	 boolean value = title.contains("India");
	 org.junit.Assert.assertTrue(value);
		
	}

	@Then("orders section should in displayed on webpage")
	public void orders_section_should_in_displayed_on_webpage()
	{
      boolean isorderdisplayed = lp.isOrderDisplayed();
      org.junit.Assert.assertTrue(isorderdisplayed);
      
	}

	@When("User enters the username {string}")
	public void user_enters_the_username(String string)
	{
          lp.enterusername();
      
	}

	@When("User enters the password {string}")
	public void user_enters_the_password(String string) 
	{
       lp.enterpassword(); 
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button()
	{
     lp.finalsignin();
	}


}
