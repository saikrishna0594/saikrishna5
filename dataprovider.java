package ABCD_SAI_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	WebDriver driver;
	
	 @DataProvider(name ="TC01_OrangeHRM")
	  public static Object[][] test3() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java00","Java desc0" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","java01","java Desc01" }, 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","java02","java Desc02" }
	        	};
	
	 }
  @Test(dataProvider="TC01_OrangeHRM")
  public void testdata(String TestURL,String Username,String Password,String Skillname,String Skilldesc) throws Exception {
	  
		dataprovider T1= new dataprovider();
		T1.OpenChromebrowser();
		T1.OrangeHRM(TestURL);
		T1.Login(Username,Password);
		T1.Addskills(Skillname,Skilldesc);
		
  }
  public  void  OpenChromebrowser() throws Exception {
	  
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	  }
  
  public  void  OrangeHRM(String TestURL) throws Exception {
	  driver.get(TestURL);
  }
  
  public  void  Login(String Username,String Password) throws Exception {
	    findElement(By.id("txtUsername")).sendKeys(Username);
		findElement(By.id("txtPassword")).sendKeys(Password);
	    findElement(By.id("btnLogin")).click();
  }
  
  public  void Addskills(String Skillname,String Skilldesc) throws Exception {
	    findElement(By.id("menu_admin_viewAdminModule")).click();
	    findElement(By.id("menu_admin_Qualifications")).click();
	    findElement(By.id("menu_admin_viewSkills")).click();
	    findElement(By.id("btnAdd")).click();
	    findElement(By.id("skill_name")).sendKeys(Skillname);
	    findElement(By.id("skill_description")).sendKeys(Skilldesc);
	    findElement(By.id("btnSave")).click();
	    
	
  }
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
	
  
} 

}