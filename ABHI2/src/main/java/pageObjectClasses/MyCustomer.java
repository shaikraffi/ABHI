package pageObjectClasses;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyCustomer {
	 static WebDriver driver;
		 	 
			
				public static void launch() throws InterruptedException {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();				
					driver.get("https://abhidev.azurewebsites.net/");
				
					driver.manage().window().maximize();
					driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("ABH1118426");			
					driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
					driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click();
					Thread.sleep(3000);				
				}
				
				public static void main(String[] args) throws InterruptedException {
					
					launch();
					
					driver.findElement(By.xpath("//ul[@class='nav']/li[3]/a")).click();
					
					
					List <WebElement> Col=driver.findElements(By.xpath("//div[@class='wrapper center-block']/div/div[1]/div"));
					System.out.println(Col.size());
					
					for (WebElement options : Col) {
						
						System.out.println("Columns are");
						System.out.println(options.getText());}
					
					//div[@class='wrapper center-block']/div/div[2]/div
					
					
				
					List <WebElement> Tab=driver.findElements(By.xpath("//div[@class='wrapper center-block']/div/div[2]/div"));
					System.out.println(Tab.size());
					
					for (WebElement options : Tab) {
						options.click();
						
						}			
				
				
				
				
				
				
				
				
				
				
				}
				

}
