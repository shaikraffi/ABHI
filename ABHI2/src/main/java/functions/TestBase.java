package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectClasses.TPDPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	public static  WebDriver driver;
	public static Properties prop;
	public static TPDPage TPDPage;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();	
	
public static WebDriver initializeDriver() throws IOException
{prop= new Properties();
FileInputStream fis=new FileInputStream(".\\Configurationfile\\data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
//System.out.println(browserName);
//String path = System.getProperty("user.dir");
if(browserName.equals("chrome"))
{
	WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver	
}
else if (browserName.equals("firefox"))
{ driver= new FirefoxDriver();
	//firefox code
}
else if (browserName.equals("IE"))
{
//	IE code
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
//tdriver.set(driver);
//return getDriver();
return driver;
}
public static synchronized WebDriver getDriver() {
	return tdriver.get();
}

public String getScreenshot() {
	File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
		System.out.println("Capture Failed " + e.getMessage());
	}
	return path;
}



public static void scrolltoElement(WebElement Elenent) {

	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Elenent);
	
}


public static void waitForVisible(WebElement locator) throws Exception {
	Thread.sleep(1000);
	for (int i = 0; i <= 40; i++) {
		try {
			locator.isDisplayed();
			break;

		} catch (Exception e) {
			if (i == 40) {
				throw e;

			} else {
				Thread.sleep(1000);
			}
		}
	}
}

public static WebElement waitTillElementVisible(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 40);
	WebElement elementloaded = wait.until(ExpectedConditions.visibilityOf(element));
	return elementloaded;
}

public static void Scroll(String scrollType) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	if(scrollType.equalsIgnoreCase("down")) {
		js.executeScript("window.scrollBy(0,1000)");
	}else  if(scrollType.equalsIgnoreCase("up")){
		js.executeScript("window.scrollBy(500,0)");
	}

}

public static void scrollToElement(WebElement Element) {		
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", Element);	
	
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


public static void waitforloadingDisable(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("sk-ball-spin-clockwise")));

}	

public static int rows() {
    
    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='dataTables_wrapper no-footer']/table/tbody/tr"));
    int p = (rows.size()-1);    
    return p;
    }

protected boolean isFileDownloaded_Ext(String dirPath, String ext){
	boolean flag=false;
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        flag = false;
    }
    
    for (int i = 1; i < files.length; i++) {
    	if(files[i].getName().contains(ext)) {
    		flag=true;
    	}
    }
    return flag;
}

protected boolean isFileDownloadedExt(String fileName, String ext){
	boolean flag=false;    
    
    	if(fileName.contains(ext)); {
    		flag=true;
    	}
    
    return flag;
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


}