package functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectClasses.Login;

public class TestBase {
	public static  WebDriver driver;
	public Properties prop;
	public static Login login;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();	
	
public WebDriver initializeDriver() throws IOException
{prop= new Properties();
FileInputStream fis=new FileInputStream(".\\Configurationfile\\data.properties");
prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);
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
tdriver.set(driver);
return getDriver();
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

}