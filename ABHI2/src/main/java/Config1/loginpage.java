package Config1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage extends SingletonClass{
	public void LoginPage() {
	     PageFactory.initElements(driver, this);
		}

		//Agent code  field
		@FindBy(xpath="//input[@type='text']")
		WebElement Agentcode;

		//Password  field
		@FindBy(xpath="//input[@type='password']")
		WebElement Password;

		//Login Button
		@FindBy(xpath="//button[@class='btn btn-login']")
		WebElement login;
		
		public void agentcode(){
	    Agentcode.sendKeys("ABH1105570"); 
		}
		
		public void password(){
			Password.sendKeys("123456"); 
			}
		
		public void Clicklogin(){
			login.click(); 
			}
		
		
		
	}



