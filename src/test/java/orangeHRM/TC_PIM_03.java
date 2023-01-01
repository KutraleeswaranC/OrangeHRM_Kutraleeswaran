package orangeHRM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_PIM_03 extends BaseClass{
	
	@Test
	public void delete() throws Exception {
		
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
		
		}
		driver.findElement(By.xpath("(//*[@class='oxd-icon-button oxd-table-cell-action-space']//preceding::button)[6]")).click();
		driver.findElement(By.xpath("//*[text()=' Yes, Delete ']")).click();
		
		System.out.println("DELETED SUCCESSFULLY COMPLETED");
		
	}	
}
