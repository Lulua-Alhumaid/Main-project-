package mainproject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class testthree {
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
    
    @Test (priority=2, groups = {"Testcase_5"} ,description="Test if the user can get the magazine from home page")
	public void BrowseMagazine_TC5() throws InterruptedException {
	 long id = Thread.currentThread().getId();
	System.out.println("@Test Create_account.Thread id is: "+ id);
	Actions action = new Actions(driver);
	//My account list
	driver.findElement(By.cssSelector("a[class='elementFont__button elementFont__resetLink']")).click();
	
	Thread.sleep(10000);
	
	
    }
    @Test (priority=1, groups = {"Testcase_6"} ,description="Test if the user can get the magazine from Explore section")
  	public void BrowseMagazine_TC6() throws InterruptedException {
  	 long id = Thread.currentThread().getId();
  	System.out.println("@Test Create_account.Thread id is: "+ id);
  	Actions action = new Actions(driver);
  	//Explore
  	driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M3 6h18v2.')]")).click();
  	
  //magazine
  	driver.findElement(By.cssSelector("span[id='submenu-label-20']")).click();
	
  	Thread.sleep(10000);
	//back to hame page
	driver.findElement(By.xpath("//div[@class='subcontainer']//a[@class='full-logo desktop-only']//span[@class='svg-logo']//*[name()='svg']//*[name()='path' and contains(@fill,'#F15025')]")).click();
	
	Thread.sleep(5000);
	
    }
	@AfterSuite
	public void closeBrowser() {
    long id = Thread.currentThread().getId();
	System.out.println("@Test Create_account.Thread id is: "+ id);
	 
	//close the Browser
	driver.close();
	}
}
