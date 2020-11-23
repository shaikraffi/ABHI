package Config1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyCommAgent {
	
	
	
	 static WebDriver driver;
	
	
	public static void launch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();				
		driver.get("https://abhidev.azurewebsites.net/");
		driver.manage().window().maximize();
		
	
		driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("ABH1100013");			
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click();
		Thread.sleep(3000);				
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
	
public static void waitSearch() throws InterruptedException 
{
	Thread.sleep(50000);
}


public static boolean waitTillSpinnerDisable(WebDriver driver, By by)
{
  FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
  fWait.withTimeout(120, TimeUnit.SECONDS);
  fWait.pollingEvery(250, TimeUnit.MILLISECONDS);
  fWait.ignoring(NoSuchElementException.class);

  Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() 
   {
     @Override
     public Boolean apply(WebDriver driver) {
    WebElement element = driver.findElement(by);
   // System.out.println(element.getCssValue("display"));         
    if(element.getCssValue("display").equalsIgnoreCase("none")){
    return true;
       }
        return false;
     }
   };

   return fWait.until(func);
}


public static void navigateFromMenu() throws InterruptedException {
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//ul[@class='nav']/li[5]/a")).click();
	Thread.sleep(2000);
	
	
	try {
		String Amount=driver.findElement(By.xpath("//div[@class='statement-bottom']/div[2]/div[4]/h5")).getText();
		System.out.println(Amount);
		
	}
	
	catch(Exception e) {
	
	
	String Comm=driver.findElement(By.xpath("//div[@class='commission-wrap']/div/div/p")).getText();
	System.out.println(Comm);
	
	}
	
	
	WebElement month=driver.findElement(By.xpath("//form[@class='form-inline ng-untouched ng-pristine ng-valid']/select[2]"));
	
	Select selmonth=new Select(month);
	selmonth.selectByIndex(8);
	WebElement submit=driver.findElement(By.xpath("//button[@id='get_info']"));
	submit.click();
	
	//Thread.sleep(50000);
	waitSearch();
	//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	//waitTillSpinnerDisable(driver,By.xpath("//div[@class='sk-ball-spin-clockwise']"));	
	
	
	System.out.println("clickable");
	
	
	WebElement Download=driver.findElement(By.xpath("//div[@class='download-state']/a"));
	waitTillElementToBeClickable(Download);
	Download.click();
	
	
	
	driver.findElement(By.xpath("//div[@class='modal-body']/div[2]/div/div[1]/div/label/span/span")).click();
	
	WebElement Statement =driver.findElement(By.xpath("//button[@class='download']"));
	
	waitTillElementToBeClickable(Statement);
	Statement.click();
	
}
public static void  scroll(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", element);
	
}


public static void navigateFromCards() throws InterruptedException {
	WebElement element =driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card"));
	scroll(element);
   // JavascriptExecutor js = (JavascriptExecutor) driver;
   //  js.executeScript("arguments[0].scrollIntoView();", element);
	System.out.println("1");
	Thread.sleep(3000);
	String Date=driver.findElement(By.xpath("//div[@class='period']/h3")).getText();
	System.out.println(Date);
	System.out.println("2");
	Actions action = new Actions(driver);
	WebElement ComHover = driver.findElement(
			By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
	Thread.sleep(2000);
	WebElement ComHoverview = driver.findElement(
			By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]/div/a/p"));
	action.moveToElement(ComHover).moveToElement(ComHoverview).click().build().perform();
	System.out.println("3");
	System.out.println("Navigated to Commission page");
	Thread.sleep(2000);
	WebElement month=driver.findElement(By.xpath("//form[@class='form-inline ng-untouched ng-pristine ng-valid']/select[2]"));
	Select s=new Select(month);
	System.out.println(s.getFirstSelectedOption().getText());
}
   
   	
	
	public static  void main (String[] args) throws InterruptedException{
		
		
		
		launch();
		navigateFromMenu();
		//navigateFromCards();
		
		
		
		
		
	}
	
}

