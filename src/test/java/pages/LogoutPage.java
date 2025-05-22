package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class LogoutPage extends setupbase{
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	@FindBy(xpath="//button[@class='chakra-menu__menu-button w-8 h-8 border-2 rounded-full flex  bg-teal-300 pl-2 css-kjvu41']") 
	 WebElement icon;
	
	
	@FindBy(xpath="//p[@class='chakra-text text-2xl font-bold css-0']") 
	 WebElement switchcontrol ;
	
	
	@FindBy(xpath="//p[@class='chakra-text css-0']") 
	 WebElement logoutbutton ;
	
	
	
	 @FindBy(xpath="//iframe[@id='fc_widget']") 
	 WebElement chatbotFrame;
	 
	 @FindBy(xpath="//div[@class='d_hotline minimize  ']") 
	 WebElement chatbotClose;
	
	
	public void ClickIcon() {
		icon.click();
	}
	
	

	public void LogoutIcon() {
		logoutbutton.click();
	}
	
	
	 public void  setchatbotFrame() {
		 driver.switchTo().frame(chatbotFrame);
		 chatbotClose.click();
		 driver.switchTo().defaultContent();
		 
			}
	
	
	
	
//	public void Controlswitch() {
//		 driver.switchTo().frame(switchcontrol);
//		 logoutbutton.click();
		 
		
//	}
	
	
	
	
	
	
	
	
	
	
	

}
