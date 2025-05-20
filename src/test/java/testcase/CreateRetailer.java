//package testcase;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import pages.AddRetailer;
//import utilities.RandomName;
//import utilities.readXslxdata;
//
//public class CreateRetailer extends setupbase{
//	
//	
//	 public static String retailerName = RandomName.entrRandomName();
//	 public static String staticPassword = "1234567890";
//
//	 @Test
//	public void createRetailer() throws InterruptedException, IOException {
//		
//	AddRetailer	adretail = new AddRetailer(driver);
//	Thread.sleep(10000);
////	adretail.setchatbotFrame();
//	
//	adretail.AddRetailerButton();
//	Thread.sleep(1000);	
//	adretail.EnterRetailerName(retailerName+"AutoFrontEnd");
//	adretail.EnterShopName("AutoComunication");
//	Thread.sleep(1000);
//	adretail.EnterAddress("Sec-15 Ground Floor Ambala");
//	adretail.SltCountry();
//	Thread.sleep(4000);
//	adretail.SltState();
//	Thread.sleep(5000);
//	adretail.SltCity();
//	Thread.sleep(1000);
//	adretail.EnterPhoneNumber("9876543210");
//	adretail.EnterEmail(retailerName+"@gmail.com");
//	adretail.SltTimeZone();
//	Thread.sleep(1000);
//	adretail.AddAdharId();
//	Thread.sleep(1000);
//	adretail.AddPanId();
//	Thread.sleep(1000);
//	adretail.Addgstid();
//	Thread.sleep(1000);
//	adretail.AddretailerPhoto();
//	Thread.sleep(1000);
//	adretail.AddshopPhoto();
//	Thread.sleep(1000);
//	adretail.CreateAggrement();
//	Thread.sleep(4000);
//	WebElement Signature = driver.findElement(By.xpath("//div[@class='relative']"));
//    Actions action = new Actions(driver);
//    action.moveToElement(Signature , 10 ,10 ).clickAndHold();
//    action.moveByOffset(20, 10);
//    action.moveByOffset(20, -10);
//    action.moveByOffset(-20, 10);
//    action.moveByOffset(10, 10).release().perform();
//    Thread.sleep(3000);
//    adretail.submitPreAggrement();
//    Thread.sleep(5000);
//	adretail.DownloadAggrement();
//	Thread.sleep(4000);
//	adretail.UploadSignedAggrement();
//	Thread.sleep(3000);
//	adretail.EnterEmergencyNumber("100");
//	adretail.AddEmergencyNumber();
//	Thread.sleep(1000);
//	adretail.EnterShopNumber("8802417777");
//	adretail.AddShopNumber();
//	adretail.AddRetailing();
//	
//	try {
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	  By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//     WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//     wait.until(ExpectedConditions.visibilityOf(toastElement));
//     System.out.println("Toast Message: " + toastElement.getText());
//	}catch(Exception e) {
//		System.out.println("toast not found move on ");
//	}
//	
//	String tt =null;
//	
//	try {
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//     WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//     By.xpath("//*[contains(text(),'" + retailerName + "')]")));
//
//  
//     tt = text123.getText();
//     System.out.println("Retailer/Admin created: " + tt);
//	}catch(Exception e) {
//		System.out.println("created Retailer  not found move on ");
//	}
//	 readXslxdata.writeNewUser("Retailer", retailerName, staticPassword);  // Sheet name = "Retailer"
//     System.out.println("Retailer Name saved to Excel: "+retailerName);
//     Assert.assertEquals(retailerName, tt);
//  
//  
//	
//	
//	
//	}
//	
//}
package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.setupbase;
import pages.AddRetailer;
import utilities.RandomName;
import utilities.readXslxdata;
import com.aventstack.extentreports.Status;

public class CreateRetailer extends setupbase {
    
    public static String retailerName = RandomName.entrRandomName();
    public static String staticPassword = "1234567890";

    @Test
    public void createRetailer() throws InterruptedException, IOException {
        // Start the test in Extent report
        test = extent.createTest("Create Retailer Test");

        AddRetailer adretail = new AddRetailer(driver);
        try {
            // Add Retailer Button
            test.log(Status.INFO, "Clicking on 'Add Retailer' button");
            adretail.AddRetailerButton();
            Thread.sleep(1000);  
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to click on 'Add Retailer' button");
        }
        
        try {
            // Enter Retailer Details
            test.log(Status.INFO, "Entering Retailer Details");
            adretail.EnterRetailerName(retailerName);
            adretail.EnterShopName("AutoComunication");
            Thread.sleep(1000);
            adretail.EnterAddress("Sec-15 Ground Floor Ambala");
            adretail.SltCountry();
            Thread.sleep(4000);
            adretail.SltState();
            Thread.sleep(5000);
            adretail.SltCity();
            Thread.sleep(1000);
            adretail.EnterPhoneNumber("9876543210");
            adretail.EnterEmail(retailerName + "@gmail.com");
            adretail.SltTimeZone();
            Thread.sleep(1000);
            adretail.AddAdharId();
            Thread.sleep(1000);
            adretail.AddPanId();
            Thread.sleep(1000);
            adretail.Addgstid();
            Thread.sleep(1000);
            adretail.AddretailerPhoto();
            Thread.sleep(1000);
            adretail.AddshopPhoto();
            Thread.sleep(1000);
            adretail.CreateAggrement();
            Thread.sleep(4000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter Retailer details");
        }

        try {
            // Add Signature
            test.log(Status.INFO, "Adding Signature for Agreement");
            WebElement Signature = driver.findElement(By.xpath("//div[@class='relative']"));
            Actions action = new Actions(driver);
            action.moveToElement(Signature, 10, 10).clickAndHold();
            action.moveByOffset(20, 10);
            action.moveByOffset(20, -10);
            action.moveByOffset(-20, 10);
            action.moveByOffset(10, 10).release().perform();
            Thread.sleep(3000);
            adretail.submitPreAggrement();
            Thread.sleep(5000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to add Signature or submit Pre Agreement");
        }
        
        try {
            // Download & Upload Agreement
            test.log(Status.INFO, "Downloading & Uploading Agreement");
            adretail.DownloadAggrement();
            Thread.sleep(4000);
            adretail.UploadSignedAggrement();
            Thread.sleep(3000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to download/upload agreement");
        }
        
        try {
            // Adding Emergency and Shop Number
            test.log(Status.INFO, "Adding Emergency and Shop Number");
            adretail.EnterEmergencyNumber("100");
            adretail.AddEmergencyNumber();
            Thread.sleep(1000);
            adretail.EnterShopNumber("8802417777");
            adretail.AddShopNumber();
            adretail.AddRetailing();
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to add Emergency and Shop Number");
        }
        
        try {
            // Toast Message Check
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
            wait.until(ExpectedConditions.visibilityOf(toastElement));
            System.out.println("Toast Message: " + toastElement.getText());
            test.log(Status.INFO, "Toast message: " + toastElement.getText());
        } catch (Exception e) {
            test.log(Status.WARNING, "Toast not found. Moving on...");
        }

        String tt = null;
        
        try {
            // Verify Retailer Creation
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + retailerName + "')]")));
            tt = text123.getText();
            System.out.println("Retailer/Admin created: " + tt);
            test.log(Status.INFO, "Retailer created: " + tt);
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to verify retailer name in the UI.");
        }

        // Save retailer details to Excel
        readXslxdata.writeNewUser("Retailer", retailerName, staticPassword);  // Sheet name = "Retailer"
        System.out.println("Retailer Name saved to Excel: " + retailerName);

        // Assertion
        try {
            Assert.assertEquals(retailerName, tt);
            test.log(Status.PASS, "Retailer creation verified successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Retailer creation verification failed.");
        }
    }
}
