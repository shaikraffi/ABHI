package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.TestBase;
import pageObjectClasses.Login;

public class LoginDef extends TestBase{
	public static Login login = new Login();
	
	@Given("^User is On Login Page$")
	public void user_is_On_Login_Page() throws Throwable {
		System.out.println("Title of the page is"+driver.getTitle());
	}
    
	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable {
		login = PageFactory.initElements(driver, Login.class);
        login.agentcode();       
        login.password();
	    
	}
    
	@Then("^Click on Login Button$")
	public void click_on_Login_Button() throws Throwable {
	    login.Clicklogin();
	    Thread.sleep(3000);
	  
	}

	@Then("^Validate User is on Home Page$")
	public void validate_User_is_on_Home_Page() throws Throwable {
		driver.findElement(By.xpath("//a[@id='navbarDropdownProfile']")).click();
		  driver.findElement(By.xpath("//a[text()='Log out']")).click();
	    
	}
	@When("^User enters invalid Username and Password$")
	public void user_enters_invalid_Username_and_Password() throws Throwable {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("ABH11055708980");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ABH11055708980");
		login.Clicklogin();
	    
	}

	@Then("^user to verify error message is displayed as invalid username and password$")
	public void user_to_verify_error_message_is_displayed_as_invalid_username_and_password() throws Throwable {
	    

}
}
