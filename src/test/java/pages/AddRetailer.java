package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class AddRetailer extends setupbase{
	
	WebDriver driver;
	
	public AddRetailer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	         @FindBy(xpath="//iframe[@id='fc_widget']") 
	          WebElement chatbotFrame;
	 
	         @FindBy(xpath="//div[@class='d_hotline minimize  ']") 
	          WebElement chatbotClose;

			@FindBy(xpath="//button[@class='chakra-button css-1cuspo6']") 
			 WebElement Addbutton;
			
			@FindBy(xpath="//input[@id='retailerName']") 
			 WebElement retailerName;
			
			
			@FindBy(xpath="//input[@id='shopName']") 
			 WebElement shopName;
			
			@FindBy(xpath="//input[@id='address']") 
			 WebElement address;
			
			@FindBy(xpath="(//div[@class=' css-hlgwow'])[1]") 
			 WebElement country;
			
			@FindBy(xpath="(//div[@class=' css-hlgwow'])[2]") 
			 WebElement state;
			
			@FindBy(xpath="(//div[@class=' css-hlgwow'])[3]") 
			 WebElement city;
			
			@FindBy(xpath="(//input[@class='form-control '])[1]") 
			 WebElement phoneNumber;
			
			@FindBy(xpath="(//input[@class='form-control '])[2]") 
			 WebElement alternate;
			
			@FindBy(xpath="//input[@id='email']") 
			 WebElement email;
			
			@FindBy(xpath="(//div[@class=' css-hlgwow'])[4]") 
			 WebElement timezone;
			
			@FindBy(xpath="//input[@id='emergencyNumber']") 
			 WebElement emergency;
			   		
			
			@FindBy(xpath="(//button[@class='chakra-button css-1tboim3'])[2]") 
			 WebElement addbutton1;
			
			@FindBy(xpath="//input [@name='searchRetailer']") 
			 WebElement searchretailler;
			
			@FindBy(xpath="//input[@id='supportNumber']") 
			 WebElement shopnumber;
			
			@FindBy(xpath="//div[@class='css-oaq4cw']") 
			 WebElement searctext;
			
			@FindBy(xpath="(//button[@class='chakra-button css-1tboim3'])[4]") 
			 WebElement addbutton2;
			
			@FindBy(xpath="//button[text() ='Submit']") 
			 WebElement submit;
			
			@FindBy(xpath=" //input[@id='fileInput']") 
			 WebElement brandlogo;
			 	
			
			@FindBy(xpath="//input[@name='aadharPhoto']")
			WebElement adharid;
			
			@FindBy(xpath="//input[@name='pan']")
			WebElement panid;
			
			@FindBy(xpath="//input[@name='gst']")
			WebElement gstid;
			
			@FindBy(xpath="//input[@name='retailerPhoto']")
			WebElement retailerPhoto;
			
			@FindBy(xpath="//input[@name='shopPhoto']")
			WebElement shopPhoto;
			
			@FindBy(xpath="//button[@class='chakra-button css-1mnt7hl']")
			WebElement generateAggrement;
			
			@FindBy(xpath="//button[normalize-space()='Capture Retailer Signature']")
			WebElement SubmitAggrement;
			
			@FindBy(xpath="//button[normalize-space()='Download Now!']")
			WebElement Download;
			
			
			@FindBy(xpath="//input[@name='signedAgreement']")
			WebElement signedAggrement;
			
			
			
			
			
			
			
		    
			public void CreateAggrement() {
				generateAggrement.click();
			}
			
			
			public void submitPreAggrement() {
				SubmitAggrement.click();
			}
			
			
			public void DownloadAggrement() {
				Download.click();
			}
			
			
			public void UploadSignedAggrement() {
				signedAggrement.sendKeys("/home/anubhav/Downloads/Signed-Retailer-Agreement (45).pdf");
			}
			
						
			public void AddAdharId() {
				adharid.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
			}
			
			public void AddPanId() {
				panid.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
			}
			
			public void Addgstid() {
				gstid.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
			}
			
			public void AddretailerPhoto() {
				retailerPhoto.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
			}
			
			public void AddshopPhoto() {
				shopPhoto.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
			}
			
			
			public void  setchatbotFrame() {
				 driver.switchTo().frame(chatbotFrame);
				 chatbotClose.click();
				 driver.switchTo().defaultContent();
				 
					}
			
			
		    
			public void AddRetailerButton() {
				Addbutton.click();
			}
		
			
			public void EnterRetailerName(String name) {
				retailerName.sendKeys(name);
			}
			
			
			public void EnterShopName(String name) {
				shopName.sendKeys(name);
			}
			
			public void EnterAddress(String name) {
				address.sendKeys(name);
			}
			
			public void SltCountry() throws InterruptedException {
				country.click();
				Thread.sleep(1000);
				 WebElement option1=driver.findElement(By.xpath("//div[text()='India']"));    		 
				    option1.click();
			}
			
			public void SltState() throws InterruptedException {
				state.click();
				Thread.sleep(1000);
				WebElement option2=driver.findElement(By.xpath("//div[text()='Haryana']"));    		 
			    option2.click();
			}
			
			public void SltCity() throws InterruptedException {
				city.click();
				Thread.sleep(1000);
				WebElement option3=driver.findElement(By.xpath("//div[text()='Faridabad']"));    		 
			    option3.click();
			}
			
			public void EnterPhoneNumber(String phone) {
				phoneNumber.sendKeys(phone);
			}
			
			public void EnterAlternateNumber(String phone) {
				alternate.sendKeys(phone);
			}
			
			public void EnterEmail(String name) {
				email.sendKeys(name);
			}
			
			public void SltTimeZone() throws InterruptedException {
				timezone.click();
				Thread.sleep(1000);
				WebElement option4=driver.findElement(By.xpath("//div[text()='Asia/Kolkata']"));    		 
			    option4.click();
			}
			
			public void EnterEmergencyNumber(String phone) {
				emergency.sendKeys(phone);
			}
			
			public void AddEmergencyNumber() {
				addbutton1.click();
			}
			
			public void EnterShopNumber(String phone) {
				shopnumber.sendKeys(phone);
			}
			
			
			public void AddShopNumber() {
				addbutton2.click();
			}
			
			public void AddRetailing() {
				submit.click();
			}
			
			
			
			
		}



	
	
	
	
	
	
	


