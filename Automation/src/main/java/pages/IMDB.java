package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

	public class IMDB {
	    final WebDriver driver;
	    public IMDB(WebDriver driver) {
	    	this.driver=driver;
	    }
	    @FindBy (xpath ="//*[text()= 'IMDb']")
	    static WebElement imdb;
	    
	    @FindBy (xpath ="//*[text()='Release date']")
	    static WebElement Releases;
	    
	    @FindBy (xpath ="//*/a/following::td[17]")
	    static WebElement Date;
	    
	    @FindBy (xpath = "//*[text()= 'Country of origin']/following::div[@class= 'ipc-metadata-list-item__content-container'][1]")
	    static WebElement Country;
	    
	    public static void imdbsearch(WebDriver driver) {
	    	
	    	imdb.click();
	    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    }
	    public static String GetRel_details() {
	    	Releases.click();
	    	String IMDB_Date =Date.getText();
	    	System.out.println("IMDB Date:- "+IMDB_Date);
			return IMDB_Date;
	    	
	    	
	    }
	    public static String GetCon_details() {
	    	String IMDB_Country = Country.getText();
	    	System.out.println("IMDB Country:- "+IMDB_Country);
			return IMDB_Country;
	    	
	    }

		}

