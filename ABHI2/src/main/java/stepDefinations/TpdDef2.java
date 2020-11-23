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

public class TpdDef2 extends TestBase {
	//static WebDriver driver;
	public  static String downloadPath = "C:\\Users\\raffi\\Downloads";	
	static  TPDPage TPD=new TPDPage(driver);;
	
	
	
	public static WebElement waitTillElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
		return elementloaded;
	}
	
	
	public static void waitforloadingDisable(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("sk-ball-spin-clockwise")));
	
	}
	
	public static void scrollToElement(WebElement Element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Element);

		
		
	}
	
	
	
	
	
	@Given("^User is On TPD Login Page$")
	@Test(priority=1)
	@Severity(SeverityLevel.CRITICAL)
	
	public void user_is_On_TPD_Login_Page() throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://abhidev.azurewebsites.net/");
		driver.manage().window().maximize();
	    
	}
	@When("^User enters Username and Password and clicks on log in$")
	@Test (priority=2)
	public void user_enters_Username_and_Password_and_clicks_on_log_in() throws Throwable {
		
		
		
		
		driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("2100825");			
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click(); 
	}

	@Then("^Validate User is on TPD Page$")
	@Test (priority=3)
	public void validate_User_is_on_TPD_Page() throws Throwable {
		
		waitforloadingDisable(driver);
		//WebElement Search=driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/button"));
		//waitTillElementVisible(Search);		
		String Title=driver.getTitle();
        System.out.println("Title of page is :"+ Title);
	    
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
		List<WebElement> lst = cycle.getOptions();
		// Looping through the options and

		System.out.println("The dropdown options are--------------");
		for (WebElement options : lst) {
			System.out.println(options.getText());}
		cycle.selectByValue("3");
		Months.selectByIndex(0);
		year.selectByIndex(0);
TPD.SearchClick();

//driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/button")).click();
		waitforloadingDisable(driver);
		
	    
	}

	@Then("^verify commission statement is displayed$")
	@Test (priority=5)
	public void verify_commission_statement_is_displayed() throws Throwable {
		//List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dataTables_wrapper no-footer']/table/tbody/tr"));
		//int p = rows.size();
		System.out.println("No of rows  :"+rows());	
		if (rows() > 0) {
			
			System.out.println("commision is displayed");
		}
		
					 else {
		            System.out.println("NO commision is displayed");

		 

		        }

		//Thread.sleep(2000);
		

	}
	@Then("^user clicks on show/hide$")
	@Test (priority=6)
	public void user_clicks_on_show_hide() throws Throwable {
		
        
        //Thread.sleep(2000);
        
              
        if (rows() > 0) {
        	
        	System.out.println("Before Applying show hide filter rows are :" +rows());
        	
        	WebElement show = driver.findElement(By.xpath("//button[@id='showtext']"));  
            
            Boolean Display = show.isDisplayed(); // To print the value
            System.out.println("Show/Hide is displayed:" + Display);            
            show.click();  
         //   Thread.sleep(200);
            WebElement Apply=driver.findElement(By.xpath("//div[@class='text-center sticky-btn']/button[2]"));
            waitTillElementVisible(Apply);
            List<WebElement>select = driver.findElements(By.xpath("//ul[@id='filterDropdown1']/li"));
            select.get(1).click();
            
            Apply.click();
            rows();
            System.out.println("After applying Show/Hide filter  rows are :" +rows());            
        }
                else {
                	 System.out.println("Show/Hide is not displayed" );

 

        }

 
	}
	public static int rows() {
	    
	    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dataTables_wrapper no-footer']/table/tbody/tr"));
	    int p = (rows.size()-1);    
	    return p;
	    }
	
	//Scenario: Verify the functionality of download statement    
	@Given("^user to click on download statement$")
	@Test (priority=7)
	public void user_to_click_on_download_statement() throws Throwable {
		WebElement element =driver.findElement(By.xpath("//div[@class='collapse navbar-collapse justify-content-end']/ul[1]"));		
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView();", element);
		
		scrollToElement(element);
     	Thread.sleep(2000);				
		driver.findElement(By.xpath("//div[@class='download-state']/a")).click();
		waitforloadingDisable(driver);
		//Thread.sleep(2000);	
	    
	}

	@When("^download statement pop up is displayed$")
	@Test (priority=8)
	public void download_statement_pop_up_is_displayed() throws Throwable {
		String title=driver.findElement(By.xpath("//h5[normalize-space()='Download Statement']")).getText();
		System.out.println(title);
	    
	}

	@Then("^user clicks on download$")
	@Test (priority=9)
	public void user_clicks_on_download() throws Throwable {
		//driver.findElement(By.xpath("//button[@class='download']")).click();
		TPD.downloadclick();
		Thread.sleep(3000);
	    
	}

	@Then("^verify the file is downloaded$")
	@Test (priority=10)
	public void verify_the_file_is_downloaded() throws Throwable {
		File getLatestFile = getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    System.out.println(fileName);
	    
	    
	}

	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	//Scenario: Verify the functionality of Select all in download statement pop up

	@Given("^user to check whether select all is enabled$")
	@Test (priority=11)
	public void user_to_check_whether_select_all_is_enabled() throws Throwable {
		Thread.sleep(2000);        
        
        WebElement SelectAll=driver.findElement(By.xpath("//div[@class='col-lg-4 col-sm-4']/div/label/span/span"));
        
        Boolean S=SelectAll.isSelected();
        
        if (S==true)
        {                  
        	System.out.println( "SelectAll is enabled" );
        }
        else {
    System.out.println("SelectAll is  not enabled " );

	  }
	}
	@When("^user clicks on select all$")
	@Test (priority=12)
	public void user_clicks_on_select_all() throws Throwable {
		//driver.findElement(By.xpath("//div[@class='col-lg-4 col-sm-4']/div/label/span/span")).click();
		TPD.SelectAll();
	   }

	@Then("^verify whether all the checkboxes are enabled$")
	@Test (priority=13)
	public void verify_whether_all_the_checkboxes_are_enabled() throws Throwable {
		List <WebElement> check=driver.findElements(By.xpath("//div[@class='checkboxes']/div/div/div/label/input"));
		int s=check.size();
		System.out.println(s);
		Thread.sleep(2000);	

	 
	 
			 System.out.println("The dropdown options are:");
			 int index = 0;
			 for(WebElement options: check) { 
				 Boolean checkstatus=options.isSelected();
		            index++;					
				  if (checkstatus==true)
						  {				  
	
					  System.out.println( "Option "+index  + " is enabled  "  );
				  }

				  else {
					  System.out.println("Option not enabled      " + index );
				  }
					//driver.findElement(By.xpath("//div[@class='col-lg-3 col-sm-3']/button")).click();
		}}
	
	@Then("^user to click on clear all$")
	@Test (priority=14)
	public void user_to_click_on_clear_all() throws Throwable {
	//	Thread.sleep(200);
		WebElement clear=driver.findElement(By.xpath("//button[@class='clear']"));
        clear.click(); 
        driver.findElement(By.xpath("//button[@class='close']")).click();
        
	    
	}
	
	@Given("^user is on tpd page$")
	@Test (priority=15)
	public void user_is_on_tpd_page() throws Throwable {
		WebElement Header=driver.findElement(By.xpath("//div[@class='proposal-review-header']/div[1]/div[1]/h4"));
        //JavascriptExecutor js = (JavascriptExecutor) driver;
         //js.executeScript("arguments[0].scrollIntoView();", Header);
         Thread.sleep(2000);           
        System.out.println(Header.getText());  
	}

	@When("^cycle,month,year dropdown is displayed$")
	@Test (priority=16)
	public void cycle_month_year_dropdown_is_displayed() throws Throwable {
		String text=driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']")).getText();
        System.out.println(text);
	    
	}

	@Then("^verify table grid is dispalyed$")
	@Test (priority=17)
	public void verify_table_grid_is_dispalyed() throws Throwable {
		List <WebElement> Col=driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));    
        System.out.println("Columns are");
          for (WebElement options : Col) {           
             
              System.out.println(options.getText());}
	    
	}

	@Then("^verify gross total is displayed$")
	@Test (priority=18)
	public void verify_gross_total_is_displayed() throws Throwable {
		WebElement Total =driver.findElement(By.xpath("//div[@class='grand-total']/div/div[2]/div/p"));
        System.out.println("Gross Total is : "+Total.getText());
	    
	}

	@Then("^verify download statement is displayed$")
	@Test (priority=19)
	public void verify_download_statement_is_displayed() throws Throwable {
		WebElement Download =driver.findElement(By.xpath("//div[@class='download-state']/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Download);
        
        Assert.assertEquals("Download Statement",Download.getText());  
	    
	}


}
	
	
	
	
	
	
	
	
	
	





