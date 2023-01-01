package orangeHRM;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
WebDriver driver;

@BeforeMethod	
public void browserLaunch() {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@AfterMethod
public void close() {
	driver.quit();
}

}
