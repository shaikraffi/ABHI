package Config1;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep extends loginpage {
public static loginpage lp = new loginpage();
	
	@Given("^User is On Login Page$")
	@Test(priority=1)
	public void user_is_On_Login_Page() throws Throwable {
		SingletonClass.Initiallize();
		
		
		System.out.println(SingletonClass.driver.getTitle());
		
	}
	
	@When("^User enters Username and Password$")
	@Test(priority=2)
	public void user_enters_Username_and_Password() throws Throwable {
		lp=PageFactory.initElements(driver, loginpage.class);
		lp.agentcode();
		lp.password();
	
	}  
	
	@Then("^Click on Login Button$")
	@Test(priority=3)
	public void click_on_Login_Button() throws Throwable {
		lp.Clicklogin();
	}
	  
	
	    
	@Then("^Validate User is on Home Page$")
	@Test(priority=4)
	public void validate_User_is_on_Home_Page() throws Throwable {
	 System.out.println(SingletonClass.driver.getTitle());
	 Thread.sleep(300);

}
}
