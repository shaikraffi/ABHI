package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.TestBase;
import pageObjectClasses.AgentCommPage;
import pageObjectClasses.TPDPage;

public class AgentComm  extends TestBase{
	//static WebDriver driver;
	
	 static AgentCommPage Agent=new AgentCommPage(driver);
	

	
	@Given("^user to Login into Portal$")
	@Test (priority=1)
	public void agent_to_Login_into_Portal() throws Throwable {
		initializeDriver();		
		Agent =PageFactory.initElements(driver, AgentCommPage.class);	
		driver.get("https://abhidev.azurewebsites.net/");		
		Agent.enterUser("ABH1100013");
		//driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("ABH1100013");	
		Agent.enterPassword("123456");
	//	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		Agent.loginclick();
		//driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click();
		
		
	}		
	
	//Scenario: To display the commission statement from main menu

	@Given("^Agent to click on My Commissions in main menu$")
	@Test (priority=2)
	public void agent_to_click_on_My_Commissions_in_main_menu() throws Throwable {
		waitforloadingDisable(driver);
	driver.findElement(By.xpath("//ul[@class='nav']/li[4]/a")).click();
	    
	}	

	@When("^commission statement page is displayed$")
	@Test (priority=3)
	public void commission_statement_page_is_displayed() throws Throwable {
		Thread.sleep(2000);
		
		try {
			String Amount=driver.findElement(By.xpath("//div[@class='statement-bottom']/div[2]/div[4]/h5")).getText();
			System.out.println(Amount);			
		}		
		catch(Exception e) {		
		String Comm=driver.findElement(By.xpath("//div[@class='commission-wrap']/div/div/p")).getText();
		System.out.println(Comm);		
		}
	    
	}

	@Then("^select cycle, month, year in the dropdowns$")
	@Test (priority=4)
	public void select_cycle_month_year_in_the_dropdowns() throws Throwable {
		WebElement month=driver.findElement(By.xpath("//form[@class='form-inline ng-untouched ng-pristine ng-valid']/select[2]"));
		Select selmonth=new Select(month);
		selmonth.selectByIndex(8);
	    
	}

	@Then("^click on search button$")
	@Test (priority=5)
	public void click_on_search_button() throws Throwable {
		//WebElement submit=driver.findElement(By.xpath("//button[@id='get_info']"));
		//submit.click();
		Agent.Search();
		waitforloadingDisable(driver);
		
	    
	}

	@Then("^click on download statement$")
	@Test (priority=6)
	public void click_on_download_statement() throws Throwable {
		//WebElement Download=driver.findElement(By.xpath("//div[@class='download-state']/a"));
		//waitTillElementToBeClickable(Download);
		//	Download.click();
		
		Agent.downloadStclick();
		
		//WebElement Statement =driver.findElement(By.xpath("//button[@class='download']"));
		driver.findElement(By.xpath("//div[@class='modal-body']/div[2]/div/div[1]/div/label/span/span")).click();		
		//waitTillElementToBeClickable(Statement);
		//Statement.click();
		Agent.downloadclick();
		waitforloadingDisable(driver);
		Agent.Close();
		WebElement Dashboard=driver.findElement(By.xpath("//ul[@class='nav']/li[1]/a"));
		scrollToElement(Dashboard);
		Dashboard.click();
	}
	
	
	
	@When("^user latest three commission cards are displayed$")
	@Test (priority=7)
	public void user_latest_three_commission_cards_are_displayed() throws Throwable {	
		System.out.println("ttt");
		waitforloadingDisable(driver);
		WebElement element =driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card"));
	   scrollToElement(element);
	     String CommissionText=element.getText();
	     System.out.println(CommissionText);
	    
	}
	    
	

	@Then("^mouseover onto the commission amount in commission card$")
	@Test (priority=8)
	public void mouseover_onto_the_commission_amount_in_commission_card() throws Throwable {
		Thread.sleep(5000);
		String Date=driver.findElement(By.xpath("//div[@class='period']/h3")).getText();
		System.out.println(Date);
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver); 
		Thread.sleep(5000);
		  WebElement ComHover =driver.findElement(By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
		 
		  action.moveToElement(ComHover).click().build().perform();	
	}
	
	
	
	
	
	@Then("^click on view in tool tip$")
	@Test (priority=9)
	public void click_on_view_in_tool_tip() throws Throwable {
		driver.findElement(By.xpath("//div[@class='latest-commission']//div[@class='row']//div[1]//div[1]//div[2]//div[1]//a[1]//p[1]")).click();
		System.out.println("Navigated to Commission page");
		
		
		
	}

	@Then("^Verify month in the commission statement page$")
	@Test (priority=10)
	public void verify_month_in_the_commission_statement_page() throws Throwable {
		WebElement month=driver.findElement(By.xpath("//form[@class='form-inline ng-untouched ng-pristine ng-valid']/select[2]"));
		Select s=new Select(month);
		System.out.println(s.getFirstSelectedOption().getText());
	    
	}
	
	
	
	
	
	
	
		public static boolean waitTillElementToBeClickable(WebElement element)  {
			
			try {
				
				WebDriverWait wait = new WebDriverWait(driver, 120);
				
				wait.until(ExpectedConditions.visibilityOf(element));
				return true;
			}catch(Exception e) {
				return false;
			}
		}
	    
	}
		
		
		




