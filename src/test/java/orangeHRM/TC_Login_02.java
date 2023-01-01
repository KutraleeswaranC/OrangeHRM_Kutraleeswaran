package orangeHRM;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_Login_02 extends BaseClass{
	
	@Test (priority = 2)
	public void invalidLogin() {
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
			password.sendKeys("Invalid password");
			
			String pass = password.getText();
			System.out.println("The given password is : " + pass);
			
			WebElement loginButton = driver.findElement
					(By.xpath("//*[@name='password']//following::button"));
			loginButton.click();
			
			WebElement invalid = driver.findElement(By.xpath("//*[@class='oxd-alert oxd-alert--error']"));
			
			String errorMessage = invalid.getText();
			System.out.println("The error message is : " + errorMessage);
		
		}

}
