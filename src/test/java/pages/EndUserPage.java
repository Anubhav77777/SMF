package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class EndUserPage extends setupbase{

	
	
	
	
    WebDriver driver ;
	
	public  EndUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	 @FindBy(xpath="//span[contains(text(), 'Customer')]") 
	 WebElement customer;

	
	 
	 @FindBy(xpath="//p[contains(text(), 'View')]") 
	 WebElement ViewCustomer;

	 
	 @FindBy(xpath="//button[@class='chakra-button css-19uaez0']") 
	 WebElement AddCustomer;
	 
	 
	 
	 @FindBy(xpath="//input[@name='firstName']") 
	 WebElement firstName;
	 

	 
	 @FindBy(xpath="//input[@name='lastName']") 
	 WebElement lastName;

	 
	 @FindBy(xpath="//input[@name='address1']") 
	 WebElement Address1;

	 @FindBy(xpath="(//div[@class=' css-hlgwow'])[1]") 
	 WebElement selectCountry;

	 @FindBy(xpath="(//div[@class=' css-hlgwow'])[2]") 
	 WebElement selectState;

	 @FindBy(xpath="(//div[@class=' css-hlgwow'])[3]") 
	 WebElement city;

	 @FindBy(xpath="(//input[@class='chakra-input css-1cjy4zv'])[5]") 
	 WebElement Dob;

	 @FindBy(xpath="(//input[@class='form-control '])[1]") 
	 WebElement phoneNumber;

	 @FindBy(xpath="//input[@name='pinCode']") 
	 WebElement Zipcode;

	 @FindBy(xpath="//input[@name='aadharNumber']") 
	 WebElement NationalId;

	 @FindBy(xpath="//input[@name='aadharPhoto']") 
	 WebElement NationalIdPhoto;

	 @FindBy(xpath="//input[@name='otherDocumentPhoto']") 
	 WebElement OtherDocuments;

	 @FindBy(xpath="//button[@class='chakra-button css-1mnt7hl']") 
	 WebElement GenerateCustomerAggrement;

	 @FindBy(xpath="(//div[@class='relative'])[1]") 
	 WebElement CustomerSiogn;

	 @FindBy(xpath="//canvas[@class='sigCanvas']") 
	 WebElement RetailerSign;

	 @FindBy(xpath="//button[normalize-space()='Capture Retailer Signature']") 
	 WebElement submitRetailerSign;

	 @FindBy(xpath="//button[normalize-space()='Capture Customer Signature']") 
	 WebElement submitCustomerSign;

	 @FindBy(xpath="//a[@download='Signed-Customer-Agreement.pdf']") 
	 WebElement DownloadAggrement;

	 @FindBy(xpath="//input[@name='signedAgreement']") 
	 WebElement uploadSignesAggrement;
	 
	 @FindBy(xpath="//button[text() ='Submit']") 
	 WebElement submit;


		 
	 public void SltCustomer() {
		 customer.click();
		}
		
	 public void Viewcustomer() {
		 ViewCustomer.click();
		}
		
	 public void AddCustomerButton() {
		 AddCustomer.click();
		}
		
	 public void EnterFirstName(String name) {
			firstName.sendKeys(name);
		}
	 
	 
	 public void EnterLastName() {
			lastName.sendKeys("Customer");
		}
	 
	 
	 public void EnterAddress1() {
			Address1.sendKeys("House No- 159 sec-17 Gurugram");
	 
	 }
	 
	 public void SltCountry() throws InterruptedException {
		 selectCountry.click();
			Thread.sleep(7000);
			 WebElement option1=driver.findElement(By.xpath("//div[text()='India']"));    		 
			    option1.click();
		}
	 
	 
		public void SltState() throws InterruptedException {
			selectState.click();
			Thread.sleep(4000);
			WebElement option2=driver.findElement(By.xpath("//div[text()='Haryana']"));    		 
		    option2.click();
		}
		
		public void SltCity() throws InterruptedException {
			city.click();
			Thread.sleep(4000);
			WebElement option3=driver.findElement(By.xpath("//div[text()='Faridabad']"));    		 
		    option3.click();
		}
	
	
		
		public void EnterDob() {
			Dob.sendKeys("28011992");
	
		}
		
		public void EnterPhoneNumber() {
			phoneNumber.sendKeys("8802417777");
		}
		
		public void EnterZipCode() {
			Zipcode.sendKeys("121004");
		}
		
		public void EnterNationalIdNumber() {
			NationalId.sendKeys("12345678901");
		}
		
		
		
		public void UploadNationalIdphoto() {
			NationalIdPhoto.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
		}
		
		
		public void UploadOtherDocuments() {
			OtherDocuments.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
		}
		
		
		public void GenerateAggrement() {
			GenerateCustomerAggrement.click();
		}
		
		
		
		 public void SubmitRetailerSignature() {
			 submitRetailerSign.click();
			}
		
	
		 public void SubmitCustomerSignature() {
			 submitCustomerSign.click();
			}
	
		 
		 
		 public void DownloadTheAggrement() {
			 DownloadAggrement.click();
			}
		
		
		 public void UploadAggrement() {
			 uploadSignesAggrement.sendKeys("/home/anubhav/Downloads/Signed-Retailer-Agreement (45).pdf");
			}
		
		 public void SubmitTheForm() {
			 submit.click();
			}
		
		

}
