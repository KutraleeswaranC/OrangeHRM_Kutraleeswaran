package orangeHRM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_PIM_01 extends BaseClass {
	
@Test
public void pim_01() throws Exception {
	
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get
		("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement userName = driver.findElement
				(By.xpath("//*[@name='username']"));
		userName.sendKeys("Admin");
		
		driver.findElement
				(By.xpath("//*[@name='password']")).sendKeys("admin123");
		
		driver.findElement
				(By.xpath("//*[@name='password']//following::button")).click();
		
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
				Thread.sleep(200);
		}
		
		driver.findElement
		(By.xpath("(//hr[@role='separator']//preceding::button)[5]")).click();
		
		driver.findElement
				(By.xpath("//form[@class='oxd-form']//input[@name='firstName']")).sendKeys("firstName");
		
		driver.findElement
				(By.xpath("//form[@class='oxd-form']//input[@name='middleName']")).sendKeys("middleName");
		
		driver.findElement
				(By.xpath("//form[@class='oxd-form']//input[@name='lastName']")).sendKeys("LastName");
		
		driver.findElement
				(By.xpath("(//form[@class='oxd-form']//following::input)[5]")).sendKeys("12345");
		
		driver.findElement
				(By.xpath("(//*[@class='oxd-form-row user-form-header']//following::div)[1]")).click();
		
		driver.findElement
				(By.xpath("(//*[@class='oxd-form-row']//following::input)[6]")).sendKeys("names_69");

		driver.findElement
				(By.xpath("(//*[@class='oxd-form-row']//following::input)[9]")).sendKeys("Admin@123");

		driver.findElement
				(By.xpath("(//*[@class='oxd-form-row']//following::input)[10]")).sendKeys("Admin@123");
							
		driver.findElement
				(By.xpath("(//*[@class='oxd-form-actions']//following::button)[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath
				("(//*[text()='Other Id']//following::input)[1]")).sendKeys("98765");
        
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Driver')]//following::div)[1]")).sendKeys("IND_TN-01");
        
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'License Expiry Date')]//following::input)[1]"))
				.sendKeys("2022-12-22");
	    
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
		.sendKeys(Keys.ENTER).build().perform();
	    
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Date of Birth')]//following::input)[1]")).sendKeys("1994-02-04");
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Gender')]//following::span)[1]")).click();
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Military Service')]//following::input)[1]")).sendKeys("Working");
		
		driver.findElement(By.xpath
				("(//*[starts-with(text(),'Smoker')]//following::span)[1]")).click();
		
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
