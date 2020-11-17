package Config1;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import functions.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjectClasses.TPDPage;



public class TPD extends TestBase {
	
	 static WebDriver driver;
	public  static String downloadPath = "C:\\Users\\raffi\\Downloads";	 
	
	static  TPDPage Login=new TPDPage(driver);
	 
	 
		
			public static void launch() throws InterruptedException {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();				
				driver.get("https://abhidev.azurewebsites.net/");
			
				driver.manage().window().maximize();
				
				Login=new TPDPage(driver);
				
				Login.enter("2100825");	
				
				
				driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("2100825");			
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
				driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click();
				Thread.sleep(3000);				
			}
			
			
			public static void download() throws InterruptedException {
				Thread.sleep(3000);
				WebElement element =driver.findElement(By.xpath("//div[@class='collapse navbar-collapse justify-content-end']/ul[1]"));		
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		         js.executeScript("arguments[0].scrollIntoView();", element);
		     	Thread.sleep(2000);				
				driver.findElement(By.xpath("//div[@class='download-state']/a")).click();
				Thread.sleep(2000);	
				//driver.findElement(By.xpath("//button[@class='download']")).click();
				Thread.sleep(2000);
				File getLatestFile = getLatestFilefromDir(downloadPath);
			    String fileName = getLatestFile.getName();
			    System.out.println(fileName);
			  
			  //driver.findElement(By.xpath("//i[@class='fa fa-close']")).click();
			}
			
			
			public static void selectAll() throws InterruptedException {				
				Thread.sleep(2000);		
				
		  WebElement SelectAll=driver.findElement(By.xpath("//div[@class='col-lg-4 col-sm-4']/div/label/span/span"));
		  
		  Boolean S=SelectAll.isSelected();
		  
		  if (S==true)
		  {				  

	  System.out.println( "SelectAll is enabled" );
  }

  else {
	  System.out.println("SelectAll is  not enabled " );
  
		  
		  SelectAll.click(); 
		  verifyCheckbox();
		  
		  }}
			public static void clearAll() throws InterruptedException {				
				Thread.sleep(2000);		
				
		  WebElement clear=driver.findElement(By.xpath("//button[@class='clear']"));
		  clear.click(); 
		  verifyCheckbox();
		  
		  }
			
			
			
			
			
			public static void verifyCheckbox() throws InterruptedException {
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
				}
				
			}
			
			
	public static void filters() throws InterruptedException {

		Select cycle = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[1]")));
		Select Months = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[2]")));
		Select year = new Select(driver.findElement(By.xpath(
				"//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/select[3]")));
		List<WebElement> lst = cycle.getOptions();
		// Looping through the options and

		System.out.println("The dropdown options are:");
		for (WebElement options : lst) {
			System.out.println(options.getText());}
		cycle.selectByValue("3");
		Months.selectByIndex(0);
		year.selectByIndex(1);

		driver.findElement(By.xpath("//form[@class='form-inline summary-period-label ng-untouched ng-pristine ng-valid']/button"))
				.click();
		
		Thread.sleep(2000);
		
		System.out.println("No of rows  :"+rows() );	
		
		
	}
	
	
	public static int rows() {
	
	List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dataTables_wrapper no-footer']/table/tbody/tr"));
	int p = rows.size();	
	return p;
	}
	
	public static void showHide() throws InterruptedException {
		System.out.println("Before Applying show hide filter rows are :" +rows());
				
		Thread.sleep(2000);
		
		WebElement show = driver.findElement(By.xpath("//button[@id='showtext']"));		
		if (rows() > 0) {
			System.out.println("commision is displayed");
			Boolean Display = show.isDisplayed(); // To print the value
			System.out.println("Show/Hide is displayed:" + Display);			
			show.click();			
			List<WebElement>select = driver.findElements(By.xpath("//ul[@id='filterDropdown1']/li"));
			select.get(1).click();
			driver.findElement(By.xpath("//div[@class='text-center sticky-btn']/button[2]")).click();
			rows();
			System.out.println("After applying Show/Hide filter  rows are :" +rows());			
		}
		

		else {
			System.out.println("NO commision is displayed");

		}

		
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
	
	
	
	public static void uiElements() throws InterruptedException {
		
		  List <WebElement> Col=driver.findElements(By.xpath("//table[@id='dtBasicExample']/thead/tr/th"));	 
		  System.out.println("Columns are");
			for (WebElement options : Col) {			
				
				System.out.println(options.getText());}
			
			
			WebElement Header=driver.findElement(By.xpath("//div[@class='proposal-review-header']/div[1]/div[1]/h4"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	         js.executeScript("arguments[0].scrollIntoView();", Header);
	     	Thread.sleep(2000);			
			System.out.println(Header.getText());			
			
			
			WebElement Download =driver.findElement(By.xpath("//div[@class='download-state']/a"));
			System.out.println(Download.getText());
			Assert.assertEquals("Download Statement",Download.getText());				
			
			
			WebElement Total =driver.findElement(By.xpath("//div[@class='grand-total']/div/div[2]/div/p"));
			System.out.println("Gross Total is : "+Total.getText());
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
	
	  launch();
	  
	  //uiElements();
	  
	  //filters();
	  
	 // showHide();
	 
	  download();
	  
	  //selectAll();
	  
	  clearAll();
	 
		
		
	
		
	
	

	}

}
