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
public class testtow {
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
      

		@Test (priority=1, groups = {"Testcase_4"} ,description="Verify if the user can Add new Recipe Successfully")
		public void AddRecipe_TC4() throws InterruptedException {
		 long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		Actions action = new Actions(driver);
		//My account list
		driver.findElement(By.xpath("(//span[text()='My Account'])[1]")).click();
		
		//Add a Recipe Button
		driver.findElement(By.xpath("(//a[contains(.,'Add a Recipe')])[2]")).click();
		
		//Recipe title
		WebElement Title= driver.findElement(By.xpath("//input[@id='title' and @type='text']"));
		Title.sendKeys("Kabsa");
		Thread.sleep(2000);
		
		//Description
		WebElement Des= driver.findElement(By.id("description"));
		Des.sendKeys("The method used to disseminate the Kabsa recipe The saudi Kingdom's most popular cuisine is this one In terms of accessibility to ingredients, simplicity of preparation, and amazing, unforgettable flavor");
		Thread.sleep(2000);
		
		//Ingredients
		WebElement Ingredient_1= driver.findElement(By.xpath("//input[@placeholder='e.g. 2 cups flour, sifted']"));
		Ingredient_1.sendKeys("2 onions chopped , 1 crushed garlic");
		Thread.sleep(2000);
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
				
		WebElement Ingredient_2= driver.findElement(By.xpath("(//input[@class='formLayout__userInput elementForm__input elementFont__inputText'])[2]"));
	    Ingredient_2.sendKeys("chicken, chopped tomato, mixed spices");
		Thread.sleep(2000);
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		
		WebElement Ingredient_3= driver.findElement(By.xpath("(//input[@class='formLayout__userInput elementForm__input elementFont__inputText'])[3]"));
	    Ingredient_3.sendKeys("hot pepper, 2 cups washed rice");
		Thread.sleep(2000);
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		
		//Directions		
		WebElement Directions_1= driver.findElement(By.xpath("//textarea[@name='direction[1]']"));
		Directions_1.sendKeys("Add onions & oil ,Add chicken & hot pepper & garlic");
		Thread.sleep(2000);
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		
		WebElement Directions_2= driver.findElement(By.xpath("//textarea[@name='direction[2]']"));
		Directions_2.sendKeys("Mix together , add tomato and mixed spices");
		Thread.sleep(2000);
		
		
		//TAB to next field//nextField
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
				
		WebElement Directions_3= driver.findElement(By.xpath("//textarea[@name='direction[3]']"));
		Directions_3.sendKeys("Add water & salt, Add rice, then wait until done");
		Thread.sleep(2000);
				
		
		//servings
		WebElement servings= driver.findElement(By.xpath("//input[@id='servings']"));
		servings.sendKeys("6");
		Thread.sleep(2000);
		
		
		//prep_time
		WebElement prep_time= driver.findElement(By.xpath("//input[@id='prep_time']"));
		prep_time.sendKeys("40");
		Thread.sleep(2000);
		
		//submit recipe
		driver.findElement(By.xpath("//input[@class='formLayout__submit elementButton__big elementButton__contained']")).click();
		
		
		Thread.sleep(10000);
		
		}
		@AfterSuite
		public void closeBrowser() {
	    long id = Thread.currentThread().getId();
		System.out.println("@Test Create_account.Thread id is: "+ id);
		 
		//close the Browser
		driver.close();

		}
}
