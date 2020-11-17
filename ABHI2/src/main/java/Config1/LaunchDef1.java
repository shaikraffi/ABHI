package Config1;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LaunchDef1 extends SingletonDriver{
	@Given("^Launch the Browser$")
	@Test
	public void launch_the_Browser() throws Throwable {
		SingletonDriver.Initiallize();
		//SingletonClass.Initiallize();
	    
	}

	@When("^User enters URL of the portal$")
	@Test
	public void user_enters_URL_of_the_portal() throws Throwable {
		SingletonDriver.driver.get(prop.getProperty("url"));
		//SingletonClass.driver.get(prop.getProperty("url"));
		
		
	
		
		
	}

@Then("^Validate Login Page is displayed$")
@Test
	public void validate_Login_Page_is_displayed() throws Throwable {
	String pageTitle = SingletonDriver.driver.getTitle();
	Assert.assertEquals("Aditya Birla", pageTitle);  
	
	//String pageTitle = SingletonClass.driver.getTitle();
}

}
