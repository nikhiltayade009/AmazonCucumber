package parallel;

import java.sql.Driver;

import com.pages.LoginPage;
import com.pages.SearchProduct;
import com.qa.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchBarSteps {

	LoginPage lp = new LoginPage(DriverFactory.getdriver());
	SearchProduct searchproduct;
	
	@Given("User should be already logged in with {string} and {string}")
	public void user_should_be_already_logged_in(String un , String pwd) {
	    DriverFactory.getdriver().get("https://www.amazon.in/");
	    searchproduct = lp.doLogin(un, pwd);
	}

	@When("User enters the text {string} and search")
	public void user_enters_the_text(String text) {
	  searchproduct.enterProduct(text);
	}

	@Then("Iphones list should get displayed")
	public void iphones_list_should_get_displayed() {
	    String titleofPage = searchproduct.titleofsearchpage();
	    
	    Object ispresent = titleofPage.contains("Iphone");
	}
	
	
}
