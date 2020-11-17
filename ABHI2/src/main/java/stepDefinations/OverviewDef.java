package stepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functions.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;


public class OverviewDef extends TestBase{
	
	
	
public static boolean waitTillElementToBeClickable(WebElement element)  {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);			
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	public static void waitForVisible(WebElement locator) throws Exception {
		
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
	
	
	
	
	//To verify GUI of Overview page
	
	@Given("^user is on the overview page$")
	public void user_is_on_the_overview_page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.get("http://abhidev.azurewebsites.net");
		driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("ABH1118426");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn btn-login']")).click();		
		driver.manage().window().maximize();
		String Title=driver.getTitle();
        System.out.println(Title);       
        String url=driver.getCurrentUrl();
        System.out.println(url);
	   
	    
	}

	@When("^ABHI logo is displayed$")
	public void abhi_logo_is_displayed() throws Throwable {
		//Thread.sleep(2000);
		WebElement ImageFile=driver.findElement(By.xpath("//a[@class='simple-text logo-normal']/img"));	
		waitForVisible(ImageFile);
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
             System.out.println("Logo not displayed.");
        }
        else
        {
            System.out.println("Logo displayed.");
        }
	    
	}

	@Then("^verify main menu options are displayed$")
	public void verify_main_menu_options_are_displayed() throws Throwable {
		List<WebElement> Menu = driver.findElements(By.xpath("//ul[@class='nav']//li/a/p"));
        System.out.println(Menu.size());
        for (WebElement webElement : Menu) {
            String name = webElement.getText();
            System.out.println("Menu options are "  +name);
        }
	    
	}

	@Then("^verify default period is displayed$")
	public void verify_default_period_is_displayed() throws Throwable {
		String Default=driver.findElement(By.xpath("//div[@id='reportrange1']/span")).getText();
        System.out.println(Default);
	    
	}
	
	
	@Then("^verify proposal status section is displayed$")
	public void verify_proposal_status_section_is_displayed() throws Throwable {
		//Thread.sleep(2000);
		
		WebElement proposal= driver.findElement(By.xpath("//app-status-card//div[@class='row']"));
		waitForVisible(proposal);
		System.out.println(proposal.getText());
          
	}
	

	@Then("^verify Latest commissions cards are displayed\\.$")
	public void verify_Latest_commissions_cards_are_displayed() throws Throwable {
		String commission= driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card")).getText();
		System.out.println(commission);
		}
	
	//To verify the proposal status and latest commissions within the selected period
	@Given("^user clicks on the period dropdown$")
	public void user_clicks_on_the_period_dropdown() throws Throwable {
		Thread.sleep(2000);
		
		
		WebElement Period =driver.findElement(By.id("reportrange1"));
				waitForVisible(Period);
				Period.click();
		
	    
	    
	}

	@When("^user selects the period in the calender$")
	public void user_selects_the_period_in_the_calender() throws Throwable {
		//driver.findElement(By.xpath("//div[@id='reportrange1']//i[2]")).click();
		WebElement date = driver.findElement(By.xpath("//div[@class='ranges']/ul"));
		List<WebElement> Dateselector = date.findElements(By.tagName("li"));
		// System.out.println(Dateselector.size());
		for (WebElement webElement : Dateselector)
		{
			String name = webElement.getText();
			if (name.equals("Last 45 Days")) {
				webElement.click();
				break;
			}}		
		System.out.println("Selected 45 days");
		}
	    
	

	@Then("^verify proposal status is displayed within the selected range of period$")
	public void verify_proposal_status_is_displayed_within_the_selected_range_of_period() throws Throwable {
		Thread.sleep(3000);
	String proposal= driver.findElement(By.xpath("//app-status-card//div[@class='row']")).getText();
	System.out.println(proposal);
	    
	}

	@Then("^verify  latest commissions is displayed within the selected range of period$")
	public void verify_latest_commissions_is_displayed_within_the_selected_range_of_period() throws Throwable {
		String commission= driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card")).getText();
		System.out.println(commission);
	}

	//Scenario: To verify mousehovering onto proposal status section
	
	@Given("^User to mouseover onto premium amount in proposal bucket$")
	public void user_to_mouseover_onto_premium_amount_in_proposal_bucket() throws Throwable {
		Thread.sleep(3000);
		Actions action = new Actions(driver);		
		WebElement Hover = driver.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]"));
		waitForVisible(Hover);
		action.moveToElement(Hover).click().build().perform();	
		
	    
	}

	@When("^Tool tip is displayed with subcounts of proposals$")
	public void tool_tip_is_displayed_with_subcounts_of_proposals() throws Throwable {
        System.out.println("Tool tip is displayed");
		
		WebElement HoverElements = driver.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]/div"));
		List<WebElement> s = HoverElements.findElements(By.tagName("p"));
		 System.out.println("Proposal sub counts" + s.size());		 
		 for (WebElement webElement : s) {
				String name = webElement.getText();
				System.out.println("Proposal sub status are " + name);
			}	
	}

	@Then("^Verify click on view in tool tip$")
	public void verify_click_on_view_in_tool_tip() throws Throwable {
		Thread.sleep(2000);
		
		WebElement view =driver.findElement(By.xpath("//app-status-card//div[2]//div[1]//div[2]//div[1]//a[1]//p[1]"));
		waitForVisible(view);
		view.click();
		System.out.println("Clicked on view");
	}

	@Then("^Verify user is redirected to proposal list page$")
	public void verify_user_is_redirected_to_proposal_list_page() throws Throwable {
		String Proposalheader=driver.findElement(By.xpath("//div[@class='my-proposal']/h4")).getText();
        System.out.println("Text in Myproposal  page : " +Proposalheader);
		System.out.println("Proposal Page displayed");
	    
	}

	@Then("^Verify proposals are displayed based on the selected proposal bucket$")
	public void verify_proposals_are_displayed_based_on_the_selected_proposal_bucket() throws Throwable {
		//Thread.sleep(4000);
		//String row=driver.findElement(By.xpath("//body[1]/app-root[1]/div[1]/div[1]/app-my-proposals[1]/div[2]/table[1]/tbody[1]/tr[1]")).getText();
		//System.out.println(row);
	}
	
		

	@Then("^Click on back button$")
	public void click_on_back_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='../assets/img/left-arrow.png']")).click();
	}

	
	//Scenario: To verify mousehovering onto Latest commissions section
	@Given("^User to mouseover onto commission amount in commission card$")
	public void user_to_mouseover_onto_commission_amount_in_commission_card() throws Throwable {
		Thread.sleep(5000);
		WebElement element =driver.findElement(By.xpath("//div[@class='container-fluid']//app-commission-card"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView();", element);
		Actions action = new Actions(driver); 
		Thread.sleep(5000);
		  WebElement ComHover =driver.findElement(By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
		 
		  action.moveToElement(ComHover).click().build().perform();	
	    
	}

	@When("^Tool tip is displayed with Commission amount , Paid amount, NOP$")
	public void tool_tip_is_displayed_with_Commission_amount_Paid_amount_NOP() throws Throwable {
		WebElement ComHoverElements = driver.findElement(By.xpath(
				  "//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]/div"
				  )) ; List<WebElement> s = ComHoverElements.findElements(By.tagName("p"));
				  System.out.println("commission data" + s.size()); for (WebElement
				  webElement : s) { String name = webElement.getText();
				  System.out.println( name); }
		
	    
	}

	@Then("^Verify click on view in commission tool tip$")
	public void verify_click_on_view_in_commission_tool_tip() throws Throwable {
		driver.findElement(By.xpath("//div[@class='latest-commission']//div[@class='row']//div[1]//div[1]//div[2]//div[1]//a[1]//p[1]")).click();
		
	    
	}

	@Then("^Verify user is redirected to commission statement page$")
	public void verify_user_is_redirected_to_commission_statement_page() throws Throwable {
		
        String MyCommission =driver.findElement(By.xpath("//div[@class='details']/p")).getText();           
        System.out.println("Header text in MyCommission page :"+ MyCommission);
	    
	}

	@Then("^Click on overview in main menu$")
	public void click_on_overview_in_main_menu() throws Throwable {
		Thread.sleep(2000);
		WebElement Overview=driver.findElement(By.xpath("//ul[@class='nav']//li[1]/a"));
		Overview.click();
		Thread.sleep(2000);
	}
	
	//Scenario: To verify the functionality of Menu navigation

   @Given("^User to click on My Proposals in main menu$")
   public void user_to_click_on_My_Proposals_in_main_menu() throws Throwable {
	   Thread.sleep(4000);
	   driver.findElement(By.xpath("//a[@href='/myproposals']//p")).click();
	   //WebElement Proposal=driver.findElement(By.xpath("//ul[@class='nav']//li[2]/a"));
	   //Proposal.click();
    
}

   @When("^My proposals page is displayed$")
   public void my_proposals_page_is_displayed() throws Throwable {
	   String Proposalheader=driver.findElement(By.xpath("//div[@class='my-proposal']/h4")).getText();
       System.out.println("Text in Myproposal  page : " +Proposalheader);
       Thread.sleep(3000);   
    
}

   @Then("^click on overview option and verify if view info is displayed$")
   public void click_on_overview_option_and_verify_if_view_info_is_displayed() throws Throwable {
	  
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//a[@href='/overview']//p")).click();
	   //WebElement Overview=driver.findElement(By.xpath("//ul[@class='nav']//li[1]/a"));
	   //Overview.click();
	   
	   WebElement Viewinfo = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
       
       if (Viewinfo.isDisplayed()) {
           System.out.println("view info is  displayed.");
       } else {
           System.out.println("viewinfo not displayed.");
       }
        Thread.sleep(2000);
}

   @Then("^User clicks on My Commissions in main menu$")
   public void user_clicks_on_My_Commissions_in_main_menu() throws Throwable {
	   Thread.sleep(3000);
	   driver.findElement(By.xpath("//a[@href='/mycommissions']//p")).click();
       Thread.sleep(2000);
    
}

   @Then("^verify Commission Statement page is displayed$")
   public void verify_Commission_Statement_page_is_displayed() throws Throwable {
	   String MyCommission =driver.findElement(By.xpath("//div[@class='details']/p")).getText();           
       System.out.println("Header text in MyCommission page :"+ MyCommission);           
       
    
}

   @Then("^click on overview option$")
   public void click_on_overview_option() throws Throwable {
	   
	   driver.findElement(By.xpath("//a[@href='/overview']//p")).click();
	   
    
}


	 

    
}



