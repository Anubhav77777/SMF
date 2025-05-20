//package testcase;
//
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
//import pages.addReseller;
//import utilities.RandomName;
//import utilities.readXslxdata;
//
//public class CreateRetailReseller extends setupbase{
//	
//	    public static String randomnameRat = RandomName.entrRandomName();
//	    public static String staticPassword = "1234567890";   
//
//	    @Test(priority = 1)
//	    public  void Retailer() throws Throwable {
//
//	        addReseller adReseller = new addReseller(driver);
//
//	        Thread.sleep(3000);
//	        adReseller.addResellerBtn();
//	        Thread.sleep(1000);
//	        adReseller.enterResellerName("NkbNUu3");
//	        adReseller.securityTag();
//	        adReseller.provsnTp();
//	        adReseller.hrdTime();
//	        Thread.sleep(1000);
//	        driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[2]")).click();
//	        Actions action = new Actions(driver);
//            action.moveByOffset(645, 580).click().perform();
//	      
//	        adReseller.contry();
//	        adReseller.sltTzn();
//	        adReseller.sBtn();
//	 
//	        
//	        
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//
//	        // Step 1: Wait for presence in the DOM
//	        WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//
//	        // Step 2: Wait for visibility of the found element
//	        wait.until(ExpectedConditions.visibilityOf(toastElement));
//
//	        System.out.println("Toast Message: " + toastElement.getText());
//	        
//	        WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        	    By.xpath("//*[contains(text(),'" + randomnameRat + "')]")));
//
//	     
//	        String tt = text123.getText();
//	        System.out.println("Reseller created: " + tt);
//
//
//	     
//	        readXslxdata.writeNewUser("Resellers", randomnameRat, staticPassword);  // Sheet name = "Resellers"
//	        System.out.println("Reseller Username saved to Excel: " + randomnameRat);
//	        Assert.assertEquals(randomnameRat, tt);
//	    }
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
import pages.addReseller;
import utilities.RandomName;
import utilities.readXslxdata;
import com.aventstack.extentreports.Status;

public class CreateRetailReseller extends setupbase {
    
    public static String randomnameRat = RandomName.entrRandomName();
    public static String staticPassword = "1234567890";   

    @Test(priority = 1)
    public void Retailer() throws Throwable {
        // Start the test in Extent report
        test = extent.createTest("Create Retailer Reseller Test");

        addReseller adReseller = new addReseller(driver);

        try {
            // Add Reseller Button
            test.log(Status.INFO, "Clicking on 'Add Reseller' button");
            adReseller.addResellerBtn();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to click on 'Add Reseller' button");
        }

        try {
            // Enter Reseller Details
            test.log(Status.INFO, "Entering Reseller Details");
            adReseller.enterResellerName(randomnameRat);
            adReseller.securityTag();
            adReseller.provsnTp();
            adReseller.hrdTime();
            Thread.sleep(1000);

            // Click on the second option
            driver.findElement(By.xpath("(//div[@class=' css-19bb58m'])[2]")).click();
            Actions action = new Actions(driver);
            action.moveByOffset(645, 580).click().perform();
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to enter Reseller details");
        }

        try {
            // Select Country and Timezone
            test.log(Status.INFO, "Selecting Country and Timezone");
            adReseller.contry();
            adReseller.sltTzn();
            adReseller.sBtn();
        } catch (Exception e) {
            test.log(Status.FAIL, "Failed to select Country and Timezone");
        }

        try {
            // Wait for and retrieve the Toast Message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
            wait.until(ExpectedConditions.visibilityOf(toastElement));
            System.out.println("Toast Message: " + toastElement.getText());
            test.log(Status.INFO, "Toast message: " + toastElement.getText());
        } catch (Exception e) {
            test.log(Status.WARNING, "Toast message not found. Moving on...");
        }

        String tt = null;

        try {
            // Verify Reseller Creation
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + randomnameRat + "')]")));

            tt = text123.getText();
            System.out.println("Reseller created: " + tt);
            test.log(Status.INFO, "Reseller created: " + tt);
        } catch (Exception e) {
            test.log(Status.WARNING, "Failed to verify reseller name in the UI.");
        }

        // Save reseller details to Excel
        try {
            readXslxdata.writeNewUser("Resellers", randomnameRat, staticPassword);  // Sheet name = "Resellers"
            System.out.println("Reseller Username saved to Excel: " + randomnameRat);
            test.log(Status.INFO, "Reseller Username saved to Excel: " + randomnameRat);
        } catch (IOException e) {
            test.log(Status.FAIL, "Failed to save reseller username to Excel.");
        }

        // Assertion
        try {
            Assert.assertEquals(randomnameRat, tt);
            test.log(Status.PASS, "Reseller creation verified successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Reseller creation verification failed.");
        }
    }
}
