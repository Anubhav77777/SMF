package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class loginPage1 extends setupbase{

	WebDriver driver ;
	
	public loginPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	 @FindBy(xpath="//input[@id='username']") 
	 WebElement usernameField;
	 
	 @FindBy(xpath="//input[@id='password']") 
	 WebElement passwordField;
	 
	 @FindBy(xpath="//button[text()='SIGN IN']") 
	 WebElement loginButton;
	 
	
	public void  setUsername(String user) {
		usernameField.sendKeys(user);
		
		}
	
	 	
	public void  setPassword(String pwd) {
		passwordField.sendKeys(pwd);
		
		}
	
	
	public void  setLoginButton() {
		loginButton.click();
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
