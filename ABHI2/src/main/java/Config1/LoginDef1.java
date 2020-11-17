package Config1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectClasses.Login;

public class LoginDef1 extends SingletonDriver{
	public static Login1 login = new Login1();
	
	@Given("^User is On Login Page$")
	@Test(priority=1)
	public void user_is_On_Login_Page() throws Throwable {
		SingletonDriver.Initiallize();
		SingletonDriver.driver.get(prop.getProperty("url"));
		
		System.out.println("Title of the page is" +driver.getTitle());
	}
	
	@When("^User enters Username and Password$")
	@Test(priority=2)
	public void user_enters_Username_and_Password() throws Throwable {
		
		login =PageFactory.initElements(driver, Login1.class);
		login.agentcode();
		login.password();
	}  
	
	@Then("^Click on Login Button$")
	@Test(priority=3)
	public void click_on_Login_Button() throws Throwable {
	   login.Clicklogin();
	}
	    
	@Then("^Validate User is on Home Page$")
	@Test(priority=4)
	public void validate_User_is_on_Home_Page() throws Throwable {
	 System.out.println(SingletonDriver.driver.getTitle());
	 Thread.sleep(300);
	 //WebDriverWait wait = new WebDriverWait(driver, 100);
	 // element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='navbarDropdownProfile']")));
	 //driver.findElement(By.xpath("//a[@id='navbarDropdownProfile']")).click();
	 //String Profile=driver.findElement(By.xpath("//a[@id='navbarDropdownProfile']")).getText();
	 //System.out.println(Profile);
	 
	 
	}
		

}
