package mainproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testone {
	public ChromeDriver driver;
	
      @BeforeSuite
        public void Setup() throws InterruptedException {
        long id = Thread.currentThread().getId();
        System.out.println("@BeforeSuite.Thread id is: "+ id);
      //invoke the chrome Browser
      	System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\chromedriver_win32\\chromedriver.exe");
      	driver =new ChromeDriver();
      //Maximize the window 
      	driver.manage().window().maximize();
      //navigate to the website
      	driver.navigate().to("https://www.allrecipes.com/");
      		Thread.sleep(2000);
      	//Login Page
    		driver.findElement(By.xpath("(//span[contains(.,'Login')])[1]")).click();
    		//create account using Email (xpath usinf Following
    		driver.findElement(By.xpath("//div[@class='loginRegistration__google']//following::div[2]")).click();
    		Thread.sleep(2000);
    		//enter Email (xpath id and type)
    		WebElement Email= driver.findElement(By.xpath("//input[@id='userSigninForm_email' and @type='email']"));
    		Email.sendKeys("luluatester@gmail.com");
    		Thread.sleep(2000);
    		
    		//enter Password 
    		WebElement password= driver.findElement(By.cssSelector("input[name='userSigninForm_password']"));
    		password.sendKeys("L@tester1234");
    		
    		//login button
    		driver.findElement(By.xpath("//button[@id='userSigninForm_btnSignup']")).click();
    		Thread.sleep(10000);
      }	
      
      
      
		@Test (priority=1, groups = {"Testcase_1"} ,description="Test if the user can get correct Result from the search function ")
		public void search_TC1() throws InterruptedException {
		 long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		Actions action = new Actions(driver);
		//search function
		WebElement search= driver.findElement(By.xpath("//input[@id='search-block']"));
		search.sendKeys("cheese cake");
		driver.findElement(By.xpath("//button[@aria-label='Search the site']")).click();
		
		Thread.sleep(2000);
		//scroll web page up and down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)"); //down
		Thread.sleep(3000);
		System.out.println("your search done successfully");
		
	
		//back to hame page
		driver.findElement(By.xpath("//div[@class='subcontainer']//a[@class='full-logo desktop-only']//span[@class='svg-logo']//*[name()='svg']//*[name()='path' and contains(@fill,'#F15025')]")).click();
		
		Thread.sleep(5000);
		}
 
		@Test (priority=2, groups = {"Testcase_2"} ,description="Test if the user can get correct Result from the search By INGREDIENTS.")
		public void search_TC2() throws InterruptedException {
		 long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		Actions action = new Actions(driver);
		//search function
		WebElement Ingredient_search= driver.findElement(By.xpath("//a[@class='modal-shortcut-link recipeSearchBlock__link elementButton__textButton--underlined']"));
		Ingredient_search.click();
		Thread.sleep(10000);
		
		//search function Recipe or keyword
		WebElement Recipe_keyword= driver.findElement(By.xpath("//div[@class='faceted-search-widget-element-container faceted-search-widget-text-container faceted-search-widget-text-container-search']//input"));
		Recipe_keyword.sendKeys("lasagna");
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		
		WebElement include_Recipe= driver.findElement(By.cssSelector("input[class='faceted-search-filters-available-item-filter-choices option include-option']"));
		include_Recipe.sendKeys("Onions");
		
		
		WebElement Not_include_Recipe= driver.findElement(By.cssSelector("input[class='faceted-search-filters-available-item-filter-choices option exclude-option']"));
		Not_include_Recipe.sendKeys("garlic");

		//search function
		WebElement search= driver.findElement(By.xpath("//button[@type='submit' and @class='faceted-search-widget-submit elementButton__standard elementButton__contained']"));
		search.click();
		Thread.sleep(3000);
		
		//scroll web page up and down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)"); //down
		Thread.sleep(3000);
		
		//back to hame page
		driver.findElement(By.xpath("//div[@class='subcontainer']//a[@class='full-logo desktop-only']//span[@class='svg-logo']//*[name()='svg']//*[name()='path' and contains(@fill,'#F15025')]")).click();
		
		Thread.sleep(5000);
		
		}
		@Test (priority=3, groups = {"Testcase_3"} ,description="Test if the user can get correct Result from the search By INGREDIENTS without Add the Preference.")
		public void search_TC3() throws InterruptedException {
		 long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		Actions action = new Actions(driver);
		//search function
		WebElement Ingredient_search= driver.findElement(By.xpath("//a[@class='modal-shortcut-link recipeSearchBlock__link elementButton__textButton--underlined']"));
		Ingredient_search.click();
		Thread.sleep(10000);
		
		//search function Recipe or keyword
		WebElement Recipe_keyword= driver.findElement(By.xpath("//div[@class='faceted-search-widget-element-container faceted-search-widget-text-container faceted-search-widget-text-container-search']//input"));
		Recipe_keyword.sendKeys("lasagna");
			
		//search function
		WebElement search= driver.findElement(By.xpath("//button[@type='submit' and @class='faceted-search-widget-submit elementButton__standard elementButton__contained']"));
		search.click();
		Thread.sleep(3000);
		
		//scroll web page up and down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)"); //down
		Thread.sleep(3000);
		
		}
		@AfterSuite
		public void closeBrowser() {
	    long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		 
		//close the Browser
		driver.close();
		

		}
		

}
