package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functions.TestBase;

public class AgentCommPage extends TestBase {

	static WebDriver driver;
	
	
	public  AgentCommPage(WebDriver driver) 
	{ 
		this.driver=driver; 
		
		PageFactory.initElements(driver, this);
		}
	
	
	
	
	
	
	
	
	
	@FindBy(xpath="//input[@formcontrolname='agentCode']") // Get list in option
	static	WebElement UserName;
	
	
	@FindBy(xpath="//input[@type='password']") // Get list in option
		static WebElement Password;
	
	@FindBy(xpath="//button[@class='btn btn-login btn-default']") // Get list in option
	static	WebElement login;
	
	
	@FindBy(xpath="//button[@class='close']") // Get list in option
	static	WebElement Closebutton;
	
	@FindBy(xpath="//ul[@class='nav']/li[4]/a") // Get list in option
	static	WebElement MyCommission;
	
	@FindBy(xpath="//ul[@class='nav']/li[1]/a") // Get list in option
	static	WebElement Dash;
	
	
	
	
	@FindBy(xpath="//button[@id='get_info']") // Get list in option
	static	WebElement Search;
	
	@FindBy(xpath="//div[@class='download-state']/a") // Get list in option
	static	WebElement downloadst;
	
	
	
	@FindBy(xpath="//button[@class='download']") // Get list in option
	static	WebElement download;
	
	
	public void enterUser(String User) {
		UserName.sendKeys(User);
	}
	
	public void enterPassword(String Pass) {
		Password.sendKeys(Pass);
	}
	
	
	public void loginclick() {
		login.click();
		
	}
	
	public void Close() {
		Closebutton.click();
		
	}
	public void Search() {
		Search.click();
		
	}
	
	public void downloadStclick() {
		downloadst.click();
		
	}
	public void downloadclick() {
		download.click();
		
	}
	
	public void MyComm() {
		MyCommission.click();
		
	}
	
	public void Dashboard() {
		Dash.click();
		
	}
	
	
	
}
