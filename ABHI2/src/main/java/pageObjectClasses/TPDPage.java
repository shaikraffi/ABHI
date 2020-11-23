package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import functions.TestBase;


public class TPDPage  extends TestBase{
	
	 static WebDriver driver;
	
	@FindBy(xpath="//input[@formcontrolname='agentCode']") // Get list in option
	static	WebElement UserName;
	
	
	@FindBy(xpath="//input[@type='password']") // Get list in option
		static WebElement Password;
	
	@FindBy(xpath="//button[@class='btn btn-login btn-default']") // Get list in option
	static	WebElement Submit;
	
	
	//div[@class='download-state']/a
	
	@FindBy(xpath="//div[@class='download-state']/a") // Get list in option
	static	WebElement downloadst;
	
	
	
	@FindBy(xpath="//button[@class='download']") // Get list in option
	static	WebElement download;
	
	
	
	@FindBy(xpath="//button[@class='clear']") // Get list in option
	static	WebElement Clearbutton;
	
	
	
	@FindBy(xpath="//button[@class='close']") // Get list in option
	static	WebElement Closebutton;
	
	
	
	@FindBy(xpath="//div[@class='col-lg-4 col-sm-4']/div/label/span/span") // Get list in option
	static	WebElement SelectAll;
	
	
	@FindBy(xpath="//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/button") // Get list in option
	static	WebElement Search;
	
	
	
	
	public  TPDPage(WebDriver driver) 
	{ 
		this.driver=driver; 
		
		PageFactory.initElements(driver, this);
		}
	
	
	 
	public void enterUser(String User) {
		UserName.sendKeys(User);
	}
	
	public void enterPassword(String Pass) {
		Password.sendKeys(Pass);
	}
	
	
	public void ClickOnSubmit() {
		Submit.click();
		
	}
	
	
	public void downloadStclick() {
		downloadst.click();
		
	}
	public void downloadclick() {
		download.click();
		
	}
	
	public void SelectAll() {
		SelectAll.click();
		
	}
	
	public void Clearall() {
		Clearbutton.click();
		
	}
	
	public void Close() {
		Closebutton.click();
		
	}

	
	public void SearchClick() {
		Search.click();
		
	}
}
