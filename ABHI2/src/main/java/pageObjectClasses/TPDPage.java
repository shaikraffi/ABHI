package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TPDPage {
	
	 WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='agentCode']") // Get list in option
	static	WebElement UserName;
	
	public  TPDPage(WebDriver driver) 
	{ 
		//this.driver=driver; 
		
		PageFactory.initElements(driver, this);	}
	
	
	 
	public void enter(String User) {
		UserName.sendKeys(User);
	}
	

}
