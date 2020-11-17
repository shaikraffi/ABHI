package Config1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SingletonClass {
	public static WebDriver driver ;
	public static String  browserName=null; 
	 public static String  URL=null; 
	 
	public static void Initiallize() throws IOException {
	ConfigRead.getproperties();
	if(driver == null)
	{
		if(browserName.equals("chrome")) {			  
			  
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe"); 
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			
	
	}
	}
	driver.get(URL);
	}
	
	public static void close()
	{
	driver.close();
	}
	public static void quit()
	{
	driver.quit();

}
}