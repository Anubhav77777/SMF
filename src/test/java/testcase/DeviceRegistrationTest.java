//package testcase;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import pages.DeviceRegistrationPage;
//import utilities.RandomName;
//import utilities.readXslxdata;
//
//public class DeviceRegistrationTest extends setupbase {
//	
//	
//	
//	 public static String CustomerName = RandomName.entrRandomName();
//
//	 @Test
//	public void deviceRegistration() throws InterruptedException, IOException {
//		
//		 DeviceRegistrationPage	DeviceReg = new DeviceRegistrationPage(driver);
//	    
//		  String[] credentials = readXslxdata.getFirstUnusedUser("Customer");
//          String username = credentials[0];
//		 
//		 Thread.sleep(10000);
//     //	adretail.setchatbotFrame();
//	
//	     DeviceReg.SltDevice();
//	     Thread.sleep(1000);
//	     DeviceReg.DCRegistration();
//	     Thread.sleep(5000);
//	     DeviceReg.AddNewDevice();
//	     Thread.sleep(1000);
//	     DeviceReg.SltCustomer();
//	     WebElement option1 = driver.findElement(By.xpath("//*[contains(text(),'" + username + "')]"));
//         option1.click();
//	     DeviceReg.EnterImei();
//	     DeviceReg.SltBrand();
//	     DeviceReg.SltModel();
//	     Thread.sleep(1000);
//
//	     DeviceReg.EnterTotalPrice();
//	     Thread.sleep(1000);
//	     DeviceReg.EnterDownPayment();
//
//	     Thread.sleep(1000);
//	     DeviceReg.EnterTeneure();
//	     DeviceReg.EnterEmi();
//	     Thread.sleep(1000);
//	     DeviceReg.EnterFirstDueDate();
//	     Thread.sleep(1000);
//	     DeviceReg.SltPaymentMethod();
//	     Thread.sleep(1000);
//	     DeviceReg.CustomerPhotoWithdevice();
//	     Thread.sleep(1000);
//	     DeviceReg.CreateDeviceAggrement();
//	     Thread.sleep(3000);
//	     DeviceReg.SignatureAction();
//	     DeviceReg.GenerateSignPdf();
//	     Thread.sleep(3000);
//	     DeviceReg.DownloadAggrement();
//	     Thread.sleep(3000);
//	     DeviceReg.UploadDeviceAggrement();
//	     Thread.sleep(1000);
//	     DeviceReg.SubmitDeviceRegistrationForm();
//	    
//	     // First, wait up to 3 seconds for success toast
//	        WebDriverWait waitShort = new WebDriverWait(driver, Duration.ofSeconds(3));
//	        By successToastLocator = By.xpath("//div[contains(@class, 'Toastify')]");
//	        List<WebElement> successToasts = driver.findElements(successToastLocator);
//
//	        if (!successToasts.isEmpty()) {
//	            String successMsg = successToasts.get(0).getText();
//	            test.pass("✅ Success Toast Message: " + successMsg);
//	            System.out.println("Success Toast Message: " + successMsg);
//	        } else {
////	             Then wait up to 5 seconds for failure toast
//	            WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(5));
//	            By failureToastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//	            List<WebElement> failureToasts = driver.findElements(failureToastLocator);
//	
//	            if (!failureToasts.isEmpty()) {
//	                String failureMsg = failureToasts.get(0).getText();
//	                test.fail("❌ Failure Toast Message: " + failureMsg);
//	                System.out.println("Failure Toast Message: " + failureMsg);
//	            } else {
//	                test.warning("⚠️ Neither Success nor Failure Toast appeared.");
//	                System.out.println("No toast appeared.");
//	            }
//	        }
//
//	     
//	 }
//	 }
package testcase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.setupbase;
import pages.DeviceRegistrationPage;
import utilities.RandomName;
import utilities.readXslxdata;

public class DeviceRegistrationTest extends setupbase {

    public static String CustomerName = RandomName.entrRandomName();
    public static String staticPassword = "1234567890";
    
    @Test
    public void deviceRegistration() throws InterruptedException, IOException {
        test = extent.createTest("Device Registration Test");

        DeviceRegistrationPage DeviceReg = new DeviceRegistrationPage(driver);
        String[] credentials = readXslxdata.getFirstUnusedUser("Customer");
        String username = credentials[0];

        try {
            Thread.sleep(10000);

            test.info("🔹 Selecting Device Tab");
            try {
                DeviceReg.SltDevice();
                test.pass("✅ Device tab selected");
            } catch (Exception e) {
                test.fail("❌ Failed to select device tab: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Opening DC Registration");
            try {
                DeviceReg.DCRegistration();
                test.pass("✅ DC Registration opened");
            } catch (Exception e) {
                test.fail("❌ Failed to open DC Registration: " + e.getMessage());
            }

            Thread.sleep(5000);

            test.info("🔹 Clicking on Add New Device");
            try {
                DeviceReg.AddNewDevice();
                test.pass("✅ Add New Device clicked");
            } catch (Exception e) {
                test.fail("❌ Failed to click Add New Device: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Selecting Customer: " + username);
            try {
                DeviceReg.SltCustomer();
                WebElement option1 = driver.findElement(By.xpath("//*[contains(text(),'" + username + "')]"));
                option1.click();
                test.pass("✅ Customer selected: " + username);
            } catch (Exception e) {
                test.fail("❌ Failed to select customer: " + e.getMessage());
            }

            test.info("🔹 Entering IMEI, Brand, and Model");
            try {
                DeviceReg.EnterImei();
                DeviceReg.SltBrand();
                DeviceReg.SltModel();
                test.pass("✅ IMEI, Brand, and Model entered");
            } catch (Exception e) {
                test.fail("❌ Failed to enter IMEI/Brand/Model: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Entering Pricing and Tenure Details");
            try {
                DeviceReg.EnterTotalPrice();
                DeviceReg.EnterDownPayment();
                DeviceReg.EnterTeneure();
                DeviceReg.EnterEmi();
                DeviceReg.EnterFirstDueDate();
                test.pass("✅ Pricing and tenure details entered");
            } catch (Exception e) {
                test.fail("⚠️ Issue while entering pricing/tenure: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Selecting Payment Method");
            try {
                DeviceReg.SltPaymentMethod();
                test.pass("✅ Payment method selected");
            } catch (Exception e) {
                test.fail("❌ Failed to select payment method: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Uploading Customer Photo with Device");
            try {
                DeviceReg.CustomerPhotoWithdevice();
                test.pass("✅ Customer photo uploaded");
            } catch (Exception e) {
                test.fail("❌ Failed to upload customer photo: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Creating Device Agreement");
            try {
                DeviceReg.CreateDeviceAggrement();
                test.pass("✅ Device agreement created");
            } catch (Exception e) {
                test.fail("❌ Failed to create device agreement: " + e.getMessage());
            }

            Thread.sleep(3000);

            test.info("🔹 Performing Signature and Generating PDF");
            try {
                DeviceReg.SignatureAction();
                DeviceReg.GenerateSignPdf();
                test.pass("✅ Signature and PDF generation successful");
            } catch (Exception e) {
                test.fail("❌ Failed to generate signature or PDF: " + e.getMessage());
            }

            Thread.sleep(3000);

            test.info("🔹 Downloading Agreement");
            try {
                DeviceReg.DownloadAggrement();
                test.pass("✅ Agreement downloaded");
            } catch (Exception e) {
                test.fail("❌ Failed to download agreement: " + e.getMessage());
            }

            Thread.sleep(3000);

            test.info("🔹 Uploading Signed Agreement");
            try {
                DeviceReg.UploadDeviceAggrement();
                test.pass("✅ Signed agreement uploaded");
            } catch (Exception e) {
                test.fail("❌ Failed to upload signed agreement: " + e.getMessage());
            }

            Thread.sleep(1000);

            test.info("🔹 Submitting Device Registration Form");
            try {
                DeviceReg.SubmitDeviceRegistrationForm();
                test.pass("✅ Device registration form submitted");
            } catch (Exception e) {
                test.fail("❌ Failed to submit registration form: " + e.getMessage());
            }

            

        } catch (Exception e) {
            test.fail("❌ Unexpected error during device registration: " + e.getMessage());
        }

        // Validation of device id in UI
        String tt = null;
        String deviceid = DeviceReg.getDeviceId();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + deviceid + "')]")));
            tt = text123.getText();

            test.pass("✅ Registered Device ID found in UI: " + tt);
            System.out.println("Device ID Registered: " + tt);
        } catch (Exception e) {
            test.warning("⚠️ Failed to verify Device ID in the UI: " + e.getMessage());
            System.out.println("Failed to verify Device ID in the UI.");
        }

        // Save Device ID to Excel
        try {
            readXslxdata.writeNewUser("Device", deviceid, staticPassword);
            test.pass("✅ Device ID written to Excel");
            System.out.println("Device ID saved to Excel: " + deviceid);
        } catch (Exception e) {
            test.warning("⚠️ Failed to write Device ID to Excel: " + e.getMessage());
        }

        // Assert the device id matches
        try {
            Assert.assertEquals(deviceid, tt);
            test.pass("✅ Assertion Passed: Registered Device ID matches");
        } catch (AssertionError ae) {
            test.fail("❌ Assertion Failed: Registered Device ID mismatch");
            throw ae;
        }
    }
}
    
    
    
    
    
    
    
    
   
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	