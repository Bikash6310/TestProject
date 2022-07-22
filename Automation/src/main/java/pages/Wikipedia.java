package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Wikipedia {
    WebDriver driver;
    
    @FindBy (xpath= "//*[@class='gLFyf gsfi']")
    static WebElement input;
    
    @FindBy (xpath ="//*[text() ='Pushpa: The Rise - Wikipedia']")
    static WebElement Movie;
    
    @FindBy (xpath ="//*[text() ='Release date']/following::td[1]")
    static WebElement ReleaseDate;
    
    @FindBy (xpath = "//*[text() ='Country']/following::td[1]")
    static WebElement Country;
    

	public Wikipedia(WebDriver driver) {
    	this.driver=driver;
    }
 
    public static void Googlesearch(String moviename, WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	input.click();
    	input.sendKeys(moviename);
    	input.sendKeys(Keys.ENTER);
    	Movie.click();
    }
    public static String GetRel_details() {
    	String Wiki_Date= ReleaseDate.getText();
    	System.out.println("Wiki Date:- "+Wiki_Date);
    	return Wiki_Date;
    }
    public static String GetCon_details() {
    	String Wiki_Country = Country.getText();
    	System.out.println("Wiki Country:- "+Wiki_Country);
    	return Wiki_Country;
    }
    

	}

