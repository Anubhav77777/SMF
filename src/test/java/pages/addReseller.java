package pages;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.devtools.v133.network.model.RequestId;
import org.openqa.selenium.devtools.v133.network.model.Response;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.setupbase;

public class addReseller extends setupbase {

	
	
		
    WebDriver driver ;
	
	public  addReseller(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	 @FindBy(xpath="//iframe[@id='fc_widget']") 
	 WebElement chatbotFrame;
	 
	 @FindBy(xpath="//div[@class='d_hotline minimize  ']") 
	 WebElement chatbotClose;
	 
	 @FindBy(xpath="//button[@class='chakra-button css-11rnuhl']") 
	 WebElement addResellerButton;
  
	 @FindBy(xpath="//input[@id='resellerName']") 
	 WebElement resellername;
	 
	 @FindBy(xpath="//div[@class='select__input-container css-19bb58m']")
	 WebElement securityTags;
	 
		 
	 @FindBy(xpath="(//div[@class=' css-19bb58m'])[1]") 
	 WebElement provisionType;
	 
		 
	 @FindBy(xpath="//input[@type='number']") 
	 WebElement hardReleaseTime;
	 
	 @FindBy(xpath="(//div[@class=' css-19bb58m'])[2]") 
	 WebElement actorType;
	 
		 
	 @FindBy(xpath="(//div[@class=' css-19bb58m'])[3]") 
	 WebElement country;
	 
		 
	 @FindBy(xpath="(//div[@class=' css-19bb58m'])[4]") 
	 WebElement selectTimeZone;
	
	 @FindBy(xpath="//button[text() =  'Submit']") 
	 WebElement submitButton;
	
	 @FindBy(xpath="//div[@class='Toastify']") 
	 WebElement toast;
	
	
	 
	 
	 public void  setchatbotFrame() {
		 driver.switchTo().frame(chatbotFrame);
		 chatbotClose.click();
		 driver.switchTo().defaultContent();
		 
			}
	 
	 public void  addResellerBtn() {
		 addResellerButton.click();
			
			}
	 
	 
	 public void enterResellerName(String name) {
		    resellername.sendKeys(name);
		}

	 
	 
	 
	 public void  securityTag() {
		 
		    String[] optionsToSelect = {"FR", "FT", "HR","AD", "DM", "IU", "UF","DT","DF"};
	    	for (String optionText : optionsToSelect) {
		 	securityTags.click();
		 	WebElement option = driver.findElement(By.xpath("//div[contains(@class,'select__option') and text()='" + optionText + "']"));
		 	option.click(); 
		 		 	 	 }
			
			}
	 
	 public void  provsnTp() {
		 provisionType.click();
		 WebElement option = driver.findElement(By.xpath("//div[text()='ZT + QR']"));
		    option.click();
			
			}
	 
	 public void  hrdTime() {
		 hardReleaseTime.sendKeys("20");
	        }
	 
	 
	 
	 
	 public void  actrTp() throws Throwable {
		 actorType.click();
		 Thread.sleep(2000);
		  WebElement  option1 =driver.findElement(By.xpath("//div[contains(text(), 'Store Owner')]"));
		    option1.click();
		 }
	 
	 
	
	 
	 public void  contry() {
		 country.click();
		 WebElement option2=driver.findElement(By.xpath("//div[text()='India']"));    		 
		    option2.click();
		 }
	 
	 
	 public void  sltTzn() {
		 selectTimeZone.click();
		  WebElement option3=driver.findElement(By.xpath("//div[text()='Asia/Kolkata']"));
		    option3.click();
		 }
	 
	 public void  sBtn() {
		 submitButton.click();
		 }
	 
}
	 
	 
	 
	 

	
	
	
	
	
	

