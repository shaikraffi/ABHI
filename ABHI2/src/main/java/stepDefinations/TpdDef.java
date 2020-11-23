package stepDefinations;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjectClasses.TPDPage;

@Listeners({TestAllureListener.class})

public class TpdDef extends TestBase {
	//static WebDriver driver;
	public  static String downloadPath = "C:\\Users\\raffi\\Downloads";	
	  static TPDPage TPD=new TPDPage(driver);
	
		
	@Given("^User is On TPD Login Page$")
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	
	public void user_is_On_TPD_Login_Page() throws Throwable {			
		initializeDriver();
		TPD =PageFactory.initElements(driver, TPDPage.class);	   
		driver.get("https://abhidev.azurewebsites.net/");	    
	}
	
	@When("^User enters Username and Password and clicks on log in$")
	@Test (priority=2)
	public void user_enters_Username_and_Password_and_clicks_on_log_in() throws Throwable {		
		TPD.enterUser("2100825");
		TPD.enterPassword("123456");
		TPD.ClickOnSubmit();
	}

	@Then("^Validate User is on TPD Page$")
	@Test (priority=3)
	public void validate_User_is_on_TPD_Page() throws Throwable {		
		waitforloadingDisable(driver);
		WebElement Search=driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/button"));
		waitTillElementVisible(Search);		
		Assert.assertEquals("Search",Search.getText());   
	}

	@Then("^select cycle,month,year in the dropdown and click on search$")
	@Test (priority=4)
	public void select_cycle_month_year_in_the_dropdown_and_click_on_search() throws Throwable {
		Select cycle = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[1]")));
		Select Months = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[2]")));
		Select year = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[3]")));		
		cycle.selectByValue("3");
		Months.selectByIndex(0);
		year.selectByIndex(0);
		TPD.SearchClick();
		waitforloadingDisable(driver);		
	    
	}

	@Then("^verify commission statements is displayed$")
	@Test (priority=5)
	public void verify_commission_statement_is_displayed() throws Throwable {			
		if (rows() > 0) {

			System.out.println("No of commission rows displaying :"+rows());
		}

		else {
			System.out.println("NO commissions are displayed");
		}

	}
	
	@Then("^user clicks on show/hide$")
	@Test (priority=6)
	public void user_clicks_on_show_hide() throws Throwable {      
              
        if (rows() > 0) {        	
        	System.out.println("Before Applying show hide filter rows are :" +rows());        	
        	WebElement show = driver.findElement(By.xpath("//button[@id='showtext']"));             
            Boolean Display = show.isDisplayed(); // To print the value
            System.out.println("Show/Hide is displayed:" + Display);            
            show.click();  
            Thread.sleep(200);
            WebElement Apply=driver.findElement(By.xpath("//div[@class='text-center sticky-btn']/button[2]"));
            waitTillElementVisible(Apply);
            List<WebElement>select = driver.findElements(By.xpath("//ul[@id='filterDropdown1']/li"));
            select.get(1).click();            
            Apply.click();            
            System.out.println("After applying Show/Hide filter  rows are :" +rows());            
        }
                else {
                	
                	 System.out.println("Show/Hide is not displayed" );
        } 
	}	
	
	//Scenario: Verify the GUI of TPD page.
	@Given("^user is on tpd page$")
	@Test (priority=7)
	public void user_is_on_tpd_page() throws Throwable {
		WebElement Header=driver.findElement(By.xpath("//div[@class='proposal-review-header']/div[1]/div[1]/h4"));       
         Thread.sleep(2000);           
        System.out.println("Header Text :" +Header.getText());  
	}

	@When("^cycle,month,year dropdown is displayed$")
	@Test (priority=8)
	public void cycle_month_year_dropdown_is_displayed() throws Throwable {
		WebElement  HeaderElements=driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']"));;
        Boolean Header=HeaderElements.isDisplayed();
        System.out.println("header is displayed:" + Header);  
		    
	}

	@Then("^verify columns of grid$")
	@Test (priority=9)
	public void verify_columns_of_grid() throws Throwable {
		List <WebElement> Col=driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));    
        System.out.println("Number of Columns in grid are :"+ Col.size());
        Assert.assertEquals(9,Col.size());         
	    
	}

	@Then("^verify gross total is displayed$")
	@Test (priority=10)
	public void verify_gross_total_is_displayed() throws Throwable {
		WebElement Total =driver.findElement(By.xpath("//div[@class='grand-total']/div/div[2]/div/p"));
        System.out.println("Gross Total is : "+Total.getText());
	    
	}

	@Then("^verify download statement is displayed$")
	@Test (priority=11)
	public void verify_download_statement_is_displayed() throws Throwable {
		WebElement Download =driver.findElement(By.xpath("//div[@class='download-state']/a"));
		scrollToElement(Download);        
        Assert.assertEquals("Download Statement",Download.getText()); 	    
	}		
	
	//Scenario: Verify the functionality of download statement    
	@Given("^user to click on download statement$")
	@Test (priority=12)
	public void user_to_click_on_download_statement() throws Throwable {
		WebElement element =driver.findElement(By.xpath("//div[@class='collapse navbar-collapse justify-content-end']/ul[1]"));		
		scrollToElement(element);
     	Thread.sleep(2000);	     	
			TPD.downloadStclick();
		waitforloadingDisable(driver);
		//Thread.sleep(2000);	
	    
	}

	@When("^download statement pop up is displayed$")
	@Test (priority=13)
	public void download_statement_pop_up_is_displayed() throws Throwable {
		String title=driver.findElement(By.xpath("//h5[normalize-space()='Download Statement']")).getText();
		System.out.println("Text in download Pop up: "+title);
	    
	}

	@Then("^user clicks on download$")
	@Test (priority=14)
	public void user_clicks_on_download() throws Throwable {		
		TPD.downloadclick();
		Thread.sleep(3000);
	    
	}

	@Then("^verify the file is downloaded$")
	@Test (priority=15)
	public void verify_the_file_is_downloaded() throws Throwable {
		File getLatestFile = getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();	    
	   Boolean Extent= isFileDownloadedExt(fileName,"xlsx");	  	
	   System.out.println("Downloaded file is with extension xlsx :  " +Extent );	    
	}

	
	
	//Scenario: Verify the functionality of Select all in download statement pop up

	@Given("^user to check whether select all is enabled$")
	@Test (priority=16)
	public void user_to_check_whether_select_all_is_enabled() throws Throwable {
		Thread.sleep(2000);         
        WebElement SelectAll=driver.findElement(By.xpath("//div[@class='col-lg-4 col-sm-4']/div/label/span/span"));        
        Boolean Selectalloption=SelectAll.isSelected();        
        if (Selectalloption==true)
        {                  
        	System.out.println( "SelectAll is enabled" );
        }
        else {
    System.out.println("SelectAll is  not enabled " );

	  }
	}
	@When("^user clicks on select all$")
	@Test (priority=17)
	public void user_clicks_on_select_all() throws Throwable {		
		TPD.SelectAll();
	   }

	@Then("^verify whether all the checkboxes are enabled$")
	@Test (priority=18)
	public void verify_whether_all_the_checkboxes_are_enabled() throws Throwable {
		List <WebElement> check=driver.findElements(By.xpath("//div[@class='checkboxes']/div/div/div/label/input"));
		int Totaloptions=check.size();
		System.out.println("Total number of check boxes are :" +Totaloptions);
		Thread.sleep(2000);			
			 int index = 0;
			 int enable=0;
			 for(WebElement options: check) { 
				 Boolean checkstatus=options.isSelected();
		            index++;					
				  if (checkstatus==true)
						  {				  
	enable++;
					 
				  }

				  else {
					  System.out.println("Option not enabled      " + index );
				  }
					
		}
			 System.out.println("Total no of options enabled are :" +enable);
			 
	}
	
	@Then("^user to click on clear all$")
	@Test (priority=19)
	public void user_to_click_on_clear_all() throws Throwable {		 
		TPD.Clearall();        
        TPD.Close();      
	    
	}
	
	@AfterClass
	public void afterClass() {	
	driver.quit();
	}
	


}
	
	
	
	
	
	
	
	
	
	





