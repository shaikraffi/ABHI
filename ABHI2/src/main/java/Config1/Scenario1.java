package Config1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {
	static WebDriver driver;

	public static void Logo() {
		WebElement ImageFile = driver.findElement(By.xpath("//a[@class='simple-text logo-normal']/img"));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				ImageFile);
		if (!ImagePresent) {
			System.out.println("Logo not displayed.");
		} else {
			System.out.println("Logo displayed.");
		}
	}
	
	
	
	

	public static void sideMenu() {
		// WebElement ul= driver.findElement(By.xpath("//ul[@class='nav']"));
		List<WebElement> Menu = driver.findElements(By.xpath("//ul[@class='nav']//li/a/p"));
		System.out.println("Number of Side Menu available" + Menu.size());
		for (WebElement webElement : Menu) {
			String name = webElement.getText();
			System.out.println("Menu options are " + name);
		}
	}

	public static void validate_Status() {
		List<WebElement> status = driver
				.findElements(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div/div/div[1]"));

		for (WebElement webElement : status) {
			String name = webElement.getText();
			System.out.println("Status are " + name);
		}

	}

	public static void launch1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		long start = System.currentTimeMillis();
		driver.get("https://abhidev.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@formcontrolname='agentCode']")).sendKeys("2100825");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn btn-login btn-default']")).click();
		

		
		/*
		 * Thread.sleep(3000); WebElement ele =
		 * driver.findElement(By.xpath("//h1[starts-with(text(),'Proposal Status')]"));
		 * System.out.println(ele.getText()); long finish = System.currentTimeMillis();
		 * long totalTime = finish - start;
		 * System.out.println("Total Time for page load - "+totalTime);
		 * driver.manage().window().maximize();
		 */

	}
	
	
	
	
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
	
	

	public static void validate_CommissionCards() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> DateselectorCommission = driver
				.findElements(By.xpath("//div[@class='latest-commission']//app-commission-card/div/div"));
		System.out.println("No of commision cards are :" + DateselectorCommission.size());
	}

	public static void dateSelector() {
		//div[@class='daterangepicker ltr show-ranges opensright show-calendar']/div/ul/li
		driver.findElement(By.xpath("//div[@id='reportrange1']")).click();
		WebElement date = driver.findElement(By.xpath("//div[@class='ranges']/ul"));
		List<WebElement> Dateselector = date.findElements(By.tagName("li"));
		// System.out.println(Dateselector.size());
		for (WebElement webElement : Dateselector) {
			String name = webElement.getText();
			if (name.equals("Last 45 Days")) {
				webElement.click();
				break;
			}
		}
		System.out.println("Selected 45 days");
	}

	public static void logOut() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='fa fa-angle-down']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-right show']/a[3]")).click();

	}

	public static void ProposalToolTip() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement Hover = driver
				.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]"));
		action.moveToElement(Hover).click().build().perform();
		System.out.println("Tool tip is displayed");

		WebElement HoverElements = driver
				.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]/div"));
		List<WebElement> s = HoverElements.findElements(By.tagName("p"));
		System.out.println("No of Proposal status" + s.size());
		for (WebElement webElement : s) {
			String name = webElement.getText();
			System.out.println("Proposal status are " + name);
		}

	}

	public static void navigateToProposalFromToolTip() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		WebElement Hover = driver
				.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]"));
		WebElement Hoverview = driver
				.findElement(By.xpath("//div[@class='content']//div[1]/app-status-card/div/div[2]/div/div[2]/div/a/p"));
		action.moveToElement(Hover).moveToElement(Hoverview).click().build().perform();
		System.out.println("navigated to Proposal Page");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		// Thread.sleep(2000);

		/*
		 * Boolean checkstatus
		 * =driver.findElement(By.xpath("//ul[@id='filterDropdown1']/li[3]/a/input")).
		 * isEnabled(); if (checkstatus==true){
		 * System.out.println("Inprocess  is already checked"); } else {
		 * 
		 * System.out.println("Inprocess is unchecked"); }
		 */

		List<WebElement> Status = driver.findElements(By.xpath("//ul[@id='filterDropdown1']/li/a/input"));
		List<WebElement> Status1 = driver.findElements(By.xpath("//ul[@id='filterDropdown1']/li"));
		System.out.println("No of Proposal status" + Status.size());

		int index = 0;
		for (WebElement webelement : Status) {

			Boolean checkstatus = webelement.isSelected();
			index++;
			if (checkstatus == true) {
				String checked = Status1.get(index).getText();
				System.out.println("The checked status is :" + checked);

			}

			else {
				String Unchecked = Status1.get(index).getText();
				System.out.println("The status is unchecked for  :" + Unchecked);
			}
		}

	}

	public static void commissionTooltip() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);		
		WebElement ComHover = driver.findElement(
				By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
		action.moveToElement(ComHover).click().build().perform();
		WebElement ComHoverElements = driver.findElement(
				By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]/div"));
		List<WebElement> s = ComHoverElements.findElements(By.tagName("p"));
		System.out.println("No of Proposal status" + s.size());
		for (WebElement webElement : s) {
			String name = webElement.getText();
			System.out.println("Proposal status are " + name);
		}

	}

	public static void defaultperiod() {
		String Default = driver.findElement(By.xpath("//div[@id='reportrange1']/span")).getText();
		System.out.println(Default);

	}

	public static void navigateCommissionpage() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement ComHover = driver.findElement(
				By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
		Thread.sleep(2000);
		WebElement ComHoverview = driver.findElement(
				By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]/div/a/p"));
		action.moveToElement(ComHover).moveToElement(ComHoverview).click().build().perform();
		System.out.println("Navigated to Commission page");
	}

	public static void menuNaviagation() throws Exception {

		WebElement Overview = driver.findElement(By.xpath("//ul[@class='nav']//li[1]/a"));
		WebElement Proposal = driver.findElement(By.xpath("//ul[@class='nav']//li[2]/a"));
		WebElement Commission = driver.findElement(By.xpath("//ul[@class='nav']//li[3]/a"));
		System.out.println("1");
		//waitForVisible(Proposal);
		Thread.sleep(4000);
		clickBy(Proposal);
		
		//Thread.sleep(3000);
		//Proposal.click();
		System.out.println("2");
		Thread.sleep(2000);
		WebElement  Proposalheader = driver.findElement(By.xpath("//div[@class='my-proposal']/h4"));
		waitForVisible(Proposalheader);
		System.out.println(Proposalheader.getText());
		
		
		//System.out.println("Text in Myproposal  page : " + Proposalheader);
		System.out.println("3");
		Overview.click();
		WebElement Viewinfo = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		if (Viewinfo.isDisplayed()) {
			System.out.println("view info is  displayed.");
		} else {
			System.out.println("viewinfo not displayed.");
		}
		Thread.sleep(2000);
		Commission.click();
		Thread.sleep(2000);
		String MyCommission = driver.findElement(By.xpath("//div[@class='details']/p")).getText();
		System.out.println("Header text in MyCommission page :" + MyCommission);
		Overview.click();

	}

	public static String waitForAngular() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
			js.executeAsyncScript("var callback=arguments[arguments.length-1];"
					+ " if (!window.angular) { throw new Error('angular could not be found on the window');}if (angular.getTestability) {angular.getTestability(angular.element(document.body)).whenStable(callback); } else { if (!angular.element(angular.element(document.body)).injector()) { throw new Error('root element (' + 'body' + ') has no injector.' +' this may mean it is not inside ng-app.'); }}"
					+ "angular.element(document.body).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);");
			return "Pass:";
		} catch (Throwable e) {
			System.err.println(e.getMessage());
			return "Fail:" + e.getMessage();
		}
	}
	
	
	
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
	
	
	public static void clickBy(WebElement element) {
		
		Actions action = new Actions(driver);
		//WebElement ComHover = driver.findElement(By.xpath("//div[@class='latest-commission']/div/app-commission-card/div/div[1]/div/div[2]"));
		
		
		action.moveToElement(element).click().build().perform();
		
	}
	
	

	public static void main(String[] args) throws Exception {

		
		launch();		
		dateSelector();
		
		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * //Thread.sleep(3000);
		 * 
		 * driver.findElement(By.xpath("//ul[@class='nav']//li[2]/a/div")).click();
		 * 
		 * WebElement
		 * Search=driver.findElement(By.xpath("//input[@id='myInputSearch']"));
		 * 
		 * WebElement Proposalheader =
		 * driver.findElement(By.xpath("//div[@class='my-proposal']/h4"));
		 * System.out.println(Proposalheader.getText()); WebElement Viewinfo =
		 * driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		 * 
		 * if (Viewinfo.isDisplayed()) { System.out.println("view info is  displayed.");
		 * } else { System.out.println("viewinfo not displayed."); }
		 * 
		 * WebElement
		 * Period=driver.findElement(By.xpath("//input[@id='reportrange2']")); //String
		 * p=Period.getAttribute("value");
		 * System.out.println(Period.getAttribute("value"));
		 * 
		 * 
		 * driver.findElement(By.xpath("//div[@class='dropdown cq-dropdown']/button")).
		 * click();
		 * 
		 * 
		 * 
		 * List <WebElement>
		 * Col=driver.findElements(By.xpath("//tr[@role='row']/th/div/button"));
		 * 
		 * for (WebElement var : Col) { System.out.println(var.getText()); }
		 */
		
		
		
		
		
		
		
		
		//menuNaviagation();
		/*
		 * dateSelector(); menuNaviagation(); sideMenu(); Logo(); validate_Status();
		 * validate_CommissionCards(); ProposalToolTip();
		 * navigateToProposalFromToolTip(); commissionTooltip();
		 * navigateCommissionpage(); logOut();
		 */

	}

}
