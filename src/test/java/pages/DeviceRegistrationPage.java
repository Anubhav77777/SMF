package pages;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.setupbase;

public class DeviceRegistrationPage extends setupbase {
	
	WebDriver driver;
	
	public DeviceRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	         @FindBy(xpath="(//button[@class='chakra-button css-tn900l'])[2]") 
	          WebElement Device;
	 
	         @FindBy(xpath="//iframe[@id='fc_widget']") 
	          WebElement chatbotFrame;
	 

	         @FindBy(xpath="//button[@class='chakra-button css-11ryff9']") 
	          WebElement DeviceRegistration;
	 
	         
	         @FindBy(xpath="//button[@class='chakra-button css-19uaez0']") 
	          WebElement AddDevice;
	         
	         
	         @FindBy(xpath="(//div[@class=' css-hlgwow'])[1]") 
	          WebElement SelectCustomer;
	         
	         @FindBy(xpath="//input[@name='IMEI1']") 
	          WebElement Imei1;
	         
	         @FindBy(xpath="(//div[@class=' css-hlgwow'])[2]") 
	          WebElement SelectBrand;
	         
	         @FindBy(xpath="//input[@name='model']") 
	          WebElement Model;

	         
	         @FindBy(xpath="(//div[@class=' css-hlgwow'])[3]") 
	          WebElement Loan;
	 
	         @FindBy(xpath="//input[@name='totalPrice']") 
	          WebElement TotalPrice;
	         
	         @FindBy(xpath="//input[@name='downPayment']") 
	          WebElement DownPayment;
	         
	         @FindBy(xpath="//input[@name='loanAmount']") 
	          WebElement LoanAmount;
	         
	         @FindBy(xpath="//input[@name='loanTenure']") 
	          WebElement LoanTenure;
	         
	         @FindBy(xpath="//input[@name='emiAmount']") 
	          WebElement EmiAmount;
	         
	         @FindBy(xpath="//input[@name='firstDueDate']") 
	          WebElement DueDate;
	         
	         @FindBy(xpath="(//div[@class=' css-hlgwow'])[4]") 
	          WebElement PaymentMethod;
	
	         @FindBy(xpath="//input[@name='customerPhoto']") 
	          WebElement customerPhoto;
	
	         
	         @FindBy(xpath="//button[@class='chakra-button css-1mnt7hl']") 
	          WebElement GeneratedeviceAggrement;
	
	         
	         @FindBy(xpath="//div[@class='relative']") 
	          WebElement canvas;
	
	       
	         @FindBy(xpath="//button[normalize-space()='Generate Signed Pdf']") 
	          WebElement GenerateSignedPdf;
	 
	         @FindBy(xpath="//a[@download='Signed-Device-Agreement.pdf']") 
	          WebElement Download;
	         
	         @FindBy(xpath="//input[@name='deviceAgreement']") 
	          WebElement UploadSignedAggrement;
	         
	         @FindBy(xpath="//button[@class='chakra-button css-m1k2lv']") 
	          WebElement Submit;
	         
	       
	         public void SltDevice() {
	        	 Device.click();
	    		}
	    	
	         
	         public void DCRegistration() {
	        	 DeviceRegistration.click();
	    		}
	    	
	         
	         public void AddNewDevice() {
	        	 AddDevice.click();
	    		}
	    	
	         
	         public void  SltCustomer( ) throws InterruptedException {
	        	 SelectCustomer.click();
	        	 Thread.sleep(2000);
//				 WebElement option1=driver.findElement(By.xpath("//div[normalize-space()='Device123']"));    		 
//				    option1.click();
				 }
			
	         public String deviceid;
//	         @SuppressWarnings("resource")
//			public void EnterImei() {
//	        	 System.out.println("Enter The IMEI1 ");
//	          deviceid	= new Scanner(System.in).nextLine();
//	        	 Imei1.sendKeys(deviceid);
//	        	 
//	         }
//	        	 public String getDeviceId() {
//	        	        return deviceid;
//	        	    } 
//	        	 
	        	
	       	 public void EnterImei() {
	         deviceid = "35" + String.valueOf((long)(Math.random() * 1_000_000_000_000_00L)).substring(0, 13); // Generates 15-digit IMEI
	         System.out.println("Auto-generated IMEI: " + deviceid);
	         Imei1.sendKeys(deviceid);
	        		}
	        
	    	 public String getDeviceId() {
     	        return deviceid;
     	    } 
      
	       	 
	       	 
	       	 
	       	 
	       	 
	       	 
	       	 
	         public void  SltBrand() throws InterruptedException {
	        	 SelectBrand.click();
	        	 Thread.sleep(1000);
				 WebElement option2=driver.findElement(By.xpath("//div[text()='ACER']"));    		 
				    option2.click();
				 }
			 
	         
	         public void  SltModel() {
	        	 Model.sendKeys("CPH12165");
				 }
			 
	         public void  SltLoanOfferdBy() throws InterruptedException {
	        	 Loan.click();
	        	 Thread.sleep(1000);
				 WebElement option3=driver.findElement(By.xpath("//div[text()='Retailer']"));    		 
				    option3.click();
				 }
			 
	         
	         public void  EnterTotalPrice() {
	        	 TotalPrice.sendKeys("13000");
				 }
	         
	         
	         public void  EnterDownPayment() {
	        	 DownPayment.sendKeys("1000");
				 }
	         
	         
	         public void  EnterLoanAmount() {
	        	 LoanAmount.sendKeys("12000");
				 }
	         
	         
	         public void  EnterTeneure() {
	        	 LoanTenure.sendKeys("12");
				 }
	         
	         
	         public void  EnterEmi() {
	        	 EmiAmount.sendKeys("1000");
				 }
	         
	         
	         public void  EnterFirstDueDate() {
	        	 DueDate.sendKeys("25062025");
				 }
	         
	         
	         public void  SltPaymentMethod() throws InterruptedException {
	        	 PaymentMethod.click();
	        	 Thread.sleep(1000);
				 WebElement option4=driver.findElement(By.xpath("//div[text()='Cash']"));    		 
				    option4.click();
				 }
			
	         
	         
	         public void  CustomerPhotoWithdevice() {
	        	 customerPhoto.sendKeys("/home/anubhav/Pictures/Screenshot from 2025-01-02 15-21-30.png");
				 }
	        
	         
	         
	         public void CreateDeviceAggrement() {
	        	 GeneratedeviceAggrement.click();
	    		}
	    	
	         public void  SignatureAction() {
	        	
	        	
	        	    Actions action = new Actions(driver);
	        	    action.moveToElement(canvas , 10 ,10 ).clickAndHold();
	        	    action.moveByOffset(20, 10);
	        	    action.moveByOffset(20, -10);
	        	    action.moveByOffset(-20, 10);
	        	    action.moveByOffset(10, 10).release().perform();
	        	    		 
				
				 }
	         
	         
	         public void GenerateSignPdf() {
	        	 GenerateSignedPdf.click();
	    		}
	    	
	         public void DownloadAggrement() {
	        	 Download.click();
	    		}
	    	
	         
	         public void  UploadDeviceAggrement() {
	        	 UploadSignedAggrement.sendKeys("/home/anubhav/Downloads/Signed-Retailer-Agreement (45).pdf");
				 }
	        
	         
	         public void SubmitDeviceRegistrationForm() {
	        	 Submit.click();
	    		}
	    	
	         
	         
	         
	         
	         
}  
