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
import pages.RetailerUserpage;
import utilities.RandomName;
import utilities.readXslxdata;
import com.aventstack.extentreports.Status;

public class RetailerUserTest extends setupbase {

    public static String retailerUserName = RandomName.entrRandomName();
    public static final String staticPassword = "1234567890";

    @Test
    public void RetailerUserCreate() throws InterruptedException, IOException {
    	
    	  String[] credentials = readXslxdata.getFirstUnusedUser("Retailer");
          String username = credentials[0];
          String password = credentials[1];

        // Initialize Extent Report test
        test = extent.createTest("Create Retailer User Test");

        RetailerUserpage adretaileruser = new RetailerUserpage(driver);

        try {
            Thread.sleep(10000);
            test.log(Status.INFO, "Retailer User page loaded.");

            adretaileruser.RetlUser();
            Thread.sleep(5000);
            test.log(Status.INFO, "Navigated to Retailer Users tab.");

            adretaileruser.createUserbutton();
            Thread.sleep(2000);
            test.log(Status.INFO, "Clicked on Create User button.");

            adretaileruser.enterResellerUser(retailerUserName);
            adretaileruser.EnterEmail(retailerUserName);
            adretaileruser.Password();
            adretaileruser.FirstName();
            adretaileruser.LastName();
            Thread.sleep(1000);
            adretaileruser.Language();
            adretaileruser.SltRetailer();
            Thread.sleep(2000);
            WebElement option1 = driver.findElement(By.xpath("//*[contains(text(),'" + username + "')]"));
            option1.click();
            Thread.sleep(2000);
            test.info("Selected retailer: " + username);
            adretaileruser.CreateUser();
            test.log(Status.INFO, "Filled all required fields and submitted user creation form.");

            // Toast Message Verification
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
                By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
                WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
                wait.until(ExpectedConditions.visibilityOf(toastElement));
                test.log(Status.INFO, "Toast Message: " + toastElement.getText());
            } catch (Exception e) {
                test.log(Status.WARNING, "Toast message not found.");
            }

            // Verification of created username in UI
            String tt = null;
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'" + retailerUserName + "')]")));

                tt = text123.getText();
                test.log(Status.PASS, "Retailer user created successfully: " + tt);
            } catch (Exception e) {
                test.log(Status.FAIL, "Created Retailer User not found in the UI.");
            }

            // Save to Excel and Final Assertion
            Thread.sleep(3000);
            readXslxdata.writeNewUser("EndUser", retailerUserName, staticPassword);
            test.log(Status.INFO, "EndUser saved to Excel: " + retailerUserName);

            Assert.assertEquals(retailerUserName, tt, "Retailer user creation verification failed.");
        } catch (Exception e) {
            test.log(Status.FAIL, "Exception during test execution: " + e.getMessage());
            throw e; // Ensure the test fails if there's a critical issue
        }
    }
}
