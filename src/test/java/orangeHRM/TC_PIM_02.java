package orangeHRM;

import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_PIM_02 extends BaseClass {
	

	  @Test
	  public void editing() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get
		("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement userName = driver.findElement
				(By.xpath("//*[@name='username']"));
		userName.sendKeys("Admin");
		String name = userName.getText();
		System.out.println("The given userName is : " + name);
		
		WebElement password = driver.findElement
				(By.xpath("//*[@name='password']"));
		password.sendKeys("admin123");
		
		String pass = password.getText();
		System.out.println("The given password is : " + pass);
		
		WebElement loginButton = driver.findElement
				(By.xpath("//*[@name='password']//following::button"));
		loginButton.click();
		
		Thread.sleep(2000);
		
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		
		Set<String>Handles = driver.getWindowHandles();
		
		for(String a : Handles) {
			System.out.println(a);
			
			if (parentWindow.equals(a)) {
			}
			else
				driver.switchTo().window(a);
				Thread.sleep(2000);
				
				
	WebElement edit = driver.findElement
				(By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space']//following::button)[1]"));
		edit.click();
		
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'SSN Number')]//following::input)[1]")).sendKeys("+9502");
	   
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'SIN Number')]//following::input)[1]")).sendKeys("+01954");
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
		WebElement nationality = driver.findElement(By.xpath("(//*[text()='-- Select --']//following::div)[1]"));

		Actions act = new Actions(driver);
		act.sendKeys(nationality , "I")
		.sendKeys(Keys.ARROW_DOWN, Keys.RETURN)
		.sendKeys(Keys.ARROW_DOWN, Keys.RETURN)
		.sendKeys(Keys.ENTER, Keys.RETURN).build().perform();
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
		WebElement marriedStatus = driver.findElement(By.xpath
	    		("(//*[text()='Marital Status']//following::i)[1]"));
	    
		Actions ac = new Actions(driver);
		ac.sendKeys(marriedStatus , "S")
		.sendKeys(Keys.ARROW_DOWN, Keys.RETURN)
		.sendKeys(Keys.ENTER, Keys.RETURN).build().perform();
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Gender')]//following::span)[1]")).click();
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Military Service')]//following::div)[1]")).sendKeys("Working");
		
		driver.findElement(By.xpath
				("(//*[text()=' * Required']//following::button)[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 WebElement BloodType = driver.findElement(By.xpath
				 ("(//*[starts-with(text(),'Blood Type')]//following::div)[1]"));
			Actions group = new Actions(driver);
			group.sendKeys(BloodType , "B+")
			.sendKeys(Keys.ARROW_DOWN, Keys.RETURN)
			.sendKeys(Keys.ARROW_DOWN, Keys.RETURN)
			.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath
				("(//div[@class='oxd-form-actions']//following::button)[2]")).click();
		System.out.println("Congratulation Successfully Completed");

		}
  }
 
}
