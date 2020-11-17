package Config1;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
	public static WebDriver driver ;
	public static Properties prop;
	public static void Initiallize() throws IOException
	{
		prop= new Properties();
		FileInputStream fis=new FileInputStream(".\\Configurationfile\\data.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		String path = System.getProperty("user.dir");
	if(driver == null)
	{
	//System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	

	
	}
	
	}
	public static void close()
	{
	driver.close();
	}
	public static void quit()
	{
	driver.quit();
	driver=null;
	}

}
