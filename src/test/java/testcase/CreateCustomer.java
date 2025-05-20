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
//import pages.EndUserPage;
//import utilities.RandomName;
//import utilities.readXslxdata;
//
//public class CreateCustomer extends setupbase{
//	
//	
//	
//	 public static String CustomerName = RandomName.entrRandomName();
//	 public static String staticPassword = "1234567890";  
//
//	 @Test
//	public void endUserTest() throws InterruptedException, IOException {
//		
//	EndUserPage	endUser = new EndUserPage(driver);
//	Thread.sleep(10000);
////	adretail.setchatbotFrame();
//	
//	endUser.SltCustomer();
//	Thread.sleep(1000);
//	endUser.Viewcustomer();
//	Thread.sleep(3000);
//	endUser.AddCustomerButton();
//	Thread.sleep(2000);
//	endUser.EnterFirstName(CustomerName);
//	endUser.EnterLastName();
//	endUser.EnterAddress1();
//	endUser.SltCountry();
//	Thread.sleep(2000);
//	endUser.SltState();
//	Thread.sleep(2000);
//	endUser.SltCity();
//	endUser.EnterDob(); 
//	Thread.sleep(1000);
//	endUser.EnterPhoneNumber();
//	endUser.EnterZipCode();
//	endUser.EnterNationalIdNumber();
//	Thread.sleep(1000);
//	endUser.UploadNationalIdphoto();
//	Thread.sleep(1000);
//	endUser.UploadOtherDocuments();
//	endUser.GenerateAggrement();
//	Thread.sleep(4000);
//	WebElement Signature1 = driver.findElement(By.xpath("(//div[@class='relative'])[1]"));
//    Actions action = new Actions(driver);
//    action.moveToElement(Signature1 , 10 ,10 ).clickAndHold();
//    action.moveByOffset(20, 10);
//    action.moveByOffset(20, -10);
//    action.moveByOffset(-20, 10);
//    action.moveByOffset(10, 10).release().perform();
//    Thread.sleep(2000);
//	endUser.SubmitCustomerSignature();
//	Thread.sleep(4000);
//	WebElement Signature2 = driver.findElement(By.xpath("//canvas[@class='sigCanvas']"));
//    action.moveToElement(Signature2 , 10 ,10 ).clickAndHold();
//    action.moveByOffset(20, 10);
//    action.moveByOffset(20, -10);
//    action.moveByOffset(-20, 10);
//    action.moveByOffset(10, 10).release().perform();
//    Thread.sleep(2000);
//	endUser.SubmitRetailerSignature();
//	Thread.sleep(5000);
//	endUser.DownloadTheAggrement();
//	Thread.sleep(4000);
//	endUser.UploadAggrement();
//	Thread.sleep(2000);
// 	endUser.SubmitTheForm();
// 	try {
//	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	  By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//      WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//      wait.until(ExpectedConditions.visibilityOf(toastElement));
//      System.out.println("Toast Message: " + toastElement.getText());
// 	}catch(Exception e) {
// 		System.out.println("Toast Not found Continue testing ");
// 		
// 	}
// 	
// 	String tt=null;
// 	try {
// 	
// 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//      By.xpath("//*[contains(text(),'" + CustomerName + "')]")));
//
//   
//       tt = text123.getText();
//      System.out.println("Customer created: " + tt);
// 	}catch(Exception e) {
// 		System.out.println("Customer Name does not verified Move on ..... ");
// 		
// 	}
//
//   
//      readXslxdata.writeNewUser("Customer", CustomerName, staticPassword);  // Sheet name = "Customer"
//      System.out.println("Customer name saved to Excel: " + CustomerName);
//      Assert.assertEquals(CustomerName, tt);
//  
//
//
//	
//}
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
import org.testng.annotations.*;

import base.setupbase;
import pages.EndUserPage;
import utilities.RandomName;
import utilities.readXslxdata;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateCustomer extends setupbase {

    public static String CustomerName = RandomName.entrRandomName();
    public static String staticPassword = "1234567890";

//    ExtentReports extent;
//    ExtentTest test;

//    @BeforeClass
//    public void setupReport() {
//        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
//        spark.config().setDocumentTitle("Customer Automation Report");
//        spark.config().setReportName("Create Customer Flow");

//        extent = new ExtentReports();
//        extent.attachReporter(spark);
//        extent.setSystemInfo("Tester", "QA Team");
//    }

//    @AfterClass
//    public void flushReport() {
//        extent.flush();
//    }

    @Test
    public void endUserTest() throws InterruptedException, IOException {
        test = extent.createTest("Create Customer Test");

        EndUserPage endUser = new EndUserPage(driver);
        Thread.sleep(10000);

        try {
            endUser.SltCustomer();
            test.pass("Customer option selected.");
            endUser.Viewcustomer();
            test.pass("View customer clicked.");
            endUser.AddCustomerButton();
            test.pass("Add customer button clicked.");
            endUser.EnterFirstName(CustomerName);
            endUser.EnterLastName();
            endUser.EnterAddress1();
            endUser.SltCountry();
            Thread.sleep(1000);
            endUser.SltState();
            Thread.sleep(1000);
            endUser.SltCity();
            endUser.EnterDob();
            endUser.EnterPhoneNumber();
            endUser.EnterZipCode();
            Thread.sleep(1000);
            endUser.EnterNationalIdNumber();
            endUser.UploadNationalIdphoto();
            Thread.sleep(10000);
            endUser.UploadOtherDocuments();
            test.pass("All form fields filled and files uploaded.");
            Thread.sleep(1000);    
            endUser.GenerateAggrement();
            test.pass("Agreement generated.");
            Thread.sleep(4000);

            Actions action = new Actions(driver);
            WebElement Signature1 = driver.findElement(By.xpath("(//div[@class='relative'])[1]"));
            action.moveToElement(Signature1, 10, 10).clickAndHold()
                  .moveByOffset(20, 10).moveByOffset(20, -10)
                  .moveByOffset(-20, 10).moveByOffset(10, 10).release().perform();
            Thread.sleep(1000);
            endUser.SubmitCustomerSignature();
            test.pass("Customer signature submitted.");
            Thread.sleep(1000);
            WebElement Signature2 = driver.findElement(By.xpath("//canvas[@class='sigCanvas']"));
            action.moveToElement(Signature2, 10, 10).clickAndHold()
                  .moveByOffset(20, 10).moveByOffset(20, -10)
                  .moveByOffset(-20, 10).moveByOffset(10, 10).release().perform();
            Thread.sleep(1000);
            endUser.SubmitRetailerSignature();
            test.pass("Retailer signature submitted.");
            Thread.sleep(5000);
            endUser.DownloadTheAggrement();
            Thread.sleep(5000);
            endUser.UploadAggrement();
            Thread.sleep(3000);
            endUser.SubmitTheForm();
            test.pass("Agreement downloaded, uploaded, and form submitted.");

        } catch (Exception e) {
            test.fail("Exception during form submission: " + e.getMessage());
        }

        // Toast Message
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
            wait.until(ExpectedConditions.visibilityOf(toastElement));
            String toastMsg = toastElement.getText();
            test.pass("Toast Message: " + toastMsg);
        } catch (Exception e) {
            test.warning("Toast not found. Continuing test.");
        }

        // Verify Created Customer
        String verifiedName = null;
        String expectedName = CustomerName + " Customer";
        
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + CustomerName + "')]")));
            verifiedName = nameElement.getText();
            Thread.sleep(1000);
           
            test.pass("Customer verified on UI: " + verifiedName);
        } catch (Exception e) {
            test.warning("Customer name not verified in UI.");
        }

        // Write to Excel
        try {
            readXslxdata.writeNewUser("Customer", expectedName, staticPassword);
            test.pass("Customer data written to Excel: " + expectedName);
        } catch (Exception e) {
            test.fail("Failed to write customer to Excel: " + e.getMessage());
        }

        try {
            Assert.assertEquals(expectedName, verifiedName);
            test.pass("Assertion passed. Customer name matches.");
        } catch (AssertionError ae) {
            test.fail("Assertion failed. Expected: " + expectedName + ", Found: " + verifiedName);
        }
    }
}
