package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class CreateResellerUser extends setupbase {
	
	
	     WebDriver driver ;
		
		public  CreateResellerUser(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	
		@FindBy(xpath="(//p[contains(text(), 'User')])[1]") 
		 WebElement user;
		
		
		
		@FindBy(xpath="//button[@class='chakra-button css-1g4zy1p']") 
		 WebElement addUser;
		
		
		@FindBy(xpath="//input[@id='useremail']") 
		 WebElement email;
		
		
		
		@FindBy(xpath="//input[@id='password']") 
		 WebElement password;
		
		
		
		@FindBy(xpath="(//div[@class=' css-b62m3t-container'])[1]") 
		 WebElement language;
		
		
		@FindBy(xpath="(//div[@class=' css-b62m3t-container'])[2]") 
		 WebElement reseller;
		
		
		@FindBy(xpath="(//div[@class=' css-b62m3t-container'])[3]") 
		 WebElement retailer;
		
		
		@FindBy(xpath="//button[@class='chakra-button css-m1k2lv']") 
		 WebElement submit;
		
		
		
		@FindBy(xpath="//input[@placeholder ='Search Username']") 
		 WebElement SearchUserName;
		
		
		
		@FindBy(xpath="//table[@class='chakra-table css-1irxwye']") 
		 WebElement table;
		
		
		
		@FindBy(xpath="//input[@name='username']") 
		 WebElement userName;
		
		@FindBy(xpath="//input[@name='firstname']") 
		 WebElement firstName;
		
		
		@FindBy(xpath="//input[@name='lastname']") 
		 WebElement lastName;
		
		
		public void ReUser() {
		    user.click();
		}
		
		
		
		public void AdUser() {
		    addUser.click();
		}
		
		
		
		public void enterResellerUser(String name) {
		    userName.sendKeys(name);
		}
		
		
		public void EnterEmail(String name) {
		    email.sendKeys(name+"@gmail.com");
		}
		
		
		
		
		public void Password() {
		    password.sendKeys("1234567890");
		}
		
		
		
		public void FirstName() {
		    firstName.sendKeys("Reseller");
		}
		
		
		
		public void LastName() {
		    lastName.sendKeys("User");
		}
		
		
		
		 public void  Language() {
			 language.click();
			 WebElement option1=driver.findElement(By.xpath("//div[text()='English']"));    		 
			    option1.click();
			 }
		
		
		

		public void SltReseller() {
		    reseller.click();
		         
		}
		    
		public void SltRetailer() {
			    retailer.click();
			    
		}
		
		
		
		public void CreateUser() {
		    submit.click();
		   
		}
		
		
		public void SearchUser(String name) {
			SearchUserName.sendKeys(name);
		}
		
		
		

	}



	
	
	
	
	
	


