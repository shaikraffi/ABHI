package pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import functions.TestBase;

public class OverviewPage extends TestBase{
	public OverviewPage() {
	     PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//button[@id='dropdownMenuButton']")
     WebElement dropdown;
	
	
	
	

	public void period()

    {

        Select sel = new  Select(dropdown);

        sel.selectByVisibleText("Last 45 Days");
    }

	public void getTitle() throws InterruptedException {
		
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Aditya Birla", pageTitle);
		System.out.println(pageTitle);
		Thread.sleep(3000);
		
	}
			 
	
}

