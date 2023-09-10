package Configuration.Tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("---Driver launched---");
	}

	@Test
	public void checkTheUrl()
	{
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"));
		System.out.println("---Browser URL validated---");
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("---Browser Closed---");
	}
}