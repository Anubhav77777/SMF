package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class RetailerUserpage {
	
	
	
	

	
	 WebDriver driver ;
		
		public   RetailerUserpage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	
	
	
	
	
	@FindBy(xpath="(//p[contains(text(), 'User')])[1]") 
	 WebElement clickuser;
	
	
	@FindBy(xpath="//button[@class='chakra-button css-1g4zy1p']") 
	 WebElement createUserButton;
	
	@FindBy(xpath="//input[@id='username']") 
	 WebElement username;
	
	@FindBy(xpath="//input[@name='useremail']") 
	 WebElement email;
	
	@FindBy(xpath="//input[@name='password']") 
	 WebElement password;
	
	
	@FindBy(xpath="(//div[@class=' css-hlgwow'])[1]") 
	 WebElement language;
	
	
	@FindBy(xpath="(//div[@class=' css-hlgwow'])[2]") 
	 WebElement retailer;
	
	
	@FindBy(xpath="//button[@class='chakra-button css-m1k2lv']") 
	 WebElement submit;

	
	
	@FindBy(xpath="//input[@id='firstname']") 
	 WebElement firstname;
	
	
	@FindBy(xpath="//input[@id='lastname']") 
	 WebElement lastname;
	
	
	public void RetlUser() {
		clickuser.click();
	}
	
	
	
	public void createUserbutton() {
		createUserButton.click();
	}
	
	
	
	public void enterResellerUser(String name) {
		username.sendKeys(name);
	}
	
	
	public void EnterEmail(String name) {
	    email.sendKeys(name+"@gmail.com");
	}
	
	
	
	
	public void Password() {
	    password.sendKeys("1234567890");
	}
	
	
	
	public void FirstName() {
	    firstname.sendKeys("Retailer");
	}
	
	
	
	public void LastName() {
	    lastname.sendKeys("User");
	}
	
	
	
	 public void  Language() throws InterruptedException {
		 language.click();
		 Thread.sleep(1000);
		 WebElement option1=driver.findElement(By.xpath("//div[text()='English']"));    		 
		    option1.click();
		 }
	
	
	

		         
	
	    
	public void SltRetailer() throws InterruptedException {
		    retailer.click();
//		    Thread.sleep(2000);
//		    WebElement option2=driver.findElement(By.xpath("//div[text()='Y_Smf']"));    		 
//		    option2.click();
		    
	}
	
	
	
	public void CreateUser() {
	    submit.click();
	   
	}
	
	
	
	
	
	

}











	
	
	

