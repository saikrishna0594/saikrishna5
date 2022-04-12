package ABCD_SAI_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class nonstatic {
	
	static WebDriver driver;
  @Test
  public void  methods() throws Exception {
	  
	  
	  nonstatic.OpenChromebrowser();
	  nonstatic.OpenOrangeHRM();
	  nonstatic.Login();
	  nonstatic.AddSkills();
	 
	  
  }
public static void  OpenChromebrowser() throws Exception {
	  
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize() ;
  }
  
  
  public static void  OpenOrangeHRM() throws Exception {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/"); 
  }
  
  public static void Login() throws Exception {
	  
	    findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
	    findElement(By.id("btnLogin")).click();
  }
  
public static void AddSkills() throws Exception {
	  
	findElement(By.id("menu_admin_viewAdminModule")).click();
	findElement(By.id("menu_admin_nationality")).click();
	findElement(By.id("btnAdd")).click();
    findElement(By.id("nationality_name")).sendKeys("Bheemla Nayak1");
	findElement(By.id("btnSave")).click();
	  
  }
  
  

  public static WebElement findElement(By by) throws Exception 
 	{

 		WebElement elem = driver.findElement(by);  
 		
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
 	 
 		}
 		return elem;
  
}
  
  
  
}
