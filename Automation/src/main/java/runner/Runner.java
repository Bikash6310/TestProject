package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.IMDB;
import pages.Wikipedia;

public class Runner {

	String driverpath = "C:\\Users\\bikas\\Downloads\\chromedriver_win32\\chromedriver.exe";
    public WebDriver driver;
	SoftAssert sassert = new SoftAssert();
	
	@BeforeTest
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	}
	@Test
	public void test() {
		Wikipedia wiki= PageFactory.initElements(driver, Wikipedia.class);
		IMDB im= PageFactory.initElements(driver, IMDB.class);
		
		Wikipedia.Googlesearch("Pushpa", driver);
		String str1= Wikipedia.GetCon_details();
		String str2= Wikipedia.GetRel_details();
		driver.navigate().back();
		
		IMDB.imdbsearch(driver);
		String str3 =IMDB.GetCon_details();
		String str4= IMDB.GetRel_details();
		sassert.assertEquals(str1, str3, "Country Passed");
		sassert.assertEquals(str2, str4, "Release Date Passed");
	}
	
	@AfterTest
	public void Close() {
		driver.quit();
	}
	
}
