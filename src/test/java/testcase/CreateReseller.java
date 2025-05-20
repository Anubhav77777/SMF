
package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.setupbase;
import io.netty.handler.timeout.TimeoutException;
import pages.addReseller;
import utilities.RandomName;
import utilities.readXslxdata;

public class CreateReseller extends setupbase {

    public static String randomname2 = RandomName.entrRandomName();
    public static String staticPassword = "1234567890";   

    @Test(priority = 1)
    public void createReseller() throws Throwable {

        test = extent.createTest("Create Reseller - Validate creation flow with random username");

        addReseller adReseller = new addReseller(driver);

        try {
            Thread.sleep(3000);
            test.info("Clicking on Add Reseller button");
            adReseller.addResellerBtn();

            Thread.sleep(1000);
            test.info("Entering Reseller Name: " + randomname2);
            adReseller.enterResellerName("VZr7pIsr");

            test.info("Setting Security Tag");
            adReseller.securityTag();

            test.info("Selecting Provision Type");
            adReseller.provsnTp();

            test.info("Setting Hard Time");
            adReseller.hrdTime();

            Thread.sleep(1000);
            test.info("Selecting Actor Type");
            adReseller.actrTp();

            test.info("Selecting Country");
            adReseller.contry();

            test.info("Selecting Time Zone");
            adReseller.sltTzn();

            test.info("Clicking Submit Button");
            adReseller.sBtn();
        } catch (Exception e) {
            test.warning("Error during form fill: " + e.getMessage());
        }
        
     // First, wait up to 3 seconds for success toast
        WebDriverWait waitShort = new WebDriverWait(driver, Duration.ofSeconds(3));
        By successToastLocator = By.xpath("//div[contains(@class, 'Toastify')]");
        List<WebElement> successToasts = driver.findElements(successToastLocator);

        if (!successToasts.isEmpty()) {
            String successMsg = successToasts.get(0).getText();
            test.pass("✅ Success Toast Message: " + successMsg);
            System.out.println("Success Toast Message: " + successMsg);
        } else {
            // Then wait up to 5 seconds for failure toast
//            WebDriverWait waitLong = new WebDriverWait(driver, Duration.ofSeconds(5));
//            By failureToastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//            List<WebElement> failureToasts = driver.findElements(failureToastLocator);
//
//            if (!failureToasts.isEmpty()) {
//                String failureMsg = failureToasts.get(0).getText();
//                test.fail("❌ Failure Toast Message: " + failureMsg);
//                System.out.println("Failure Toast Message: " + failureMsg);
//            } else {
//                test.warning("⚠️ Neither Success nor Failure Toast appeared.");
//                System.out.println("No toast appeared.");
//            }
        }


//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//            
//            // Try waiting for success toast
//            By successToastLocator = By.xpath("//div[contains(@class, 'Toastify')]");
//            WebElement successToast = wait.until(ExpectedConditions.presenceOfElementLocated(successToastLocator));
//            
//            String successMsg = successToast.getText();
//            test.pass("✅ Success Toast Message: " + successMsg);
//            System.out.println("Success Toast Message: " + successMsg);
//            
//        } catch (TimeoutException successTimeout) {
//            try {
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//                
//                // Try waiting for failure toast if success toast not found
//                By failureToastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//                WebElement failureToast = wait.until(ExpectedConditions.presenceOfElementLocated(failureToastLocator));
//                
//                String failureMsg = failureToast.getText();
//                test.fail("❌ Failure Toast Message: " + failureMsg);
//                System.out.println("Failure Toast Message: " + failureMsg);
//                
//            } catch (TimeoutException failureTimeout) {
//                test.warning("⚠️ Neither Success nor Failure Toast appeared.");
//                System.out.println("No toast appeared.");
//            } catch (Exception e) {
//                test.warning("⚠️ Error while checking for failure toast: " + e.getMessage());
//                System.out.println("Error while waiting for failure toast: " + e.getMessage());
//            }
//        } catch (Exception e) {
//            test.warning("⚠️ Error while checking for success toast: " + e.getMessage());
//            System.out.println("Error while waiting for success toast: " + e.getMessage());
//        }

//
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//            wait.until(ExpectedConditions.visibilityOf(toastElement));
//
//            String toastMsg = toastElement.getText();
//            test.pass("Toast Message displayed: " + toastMsg);
//            System.out.println("Toast Message: " + toastMsg);
//        } catch (Exception e) {
//            test.warning("Toast message not found: " + e.getMessage());
//            System.out.println("Toast not found. Continuing test...");
//        }

        String tt = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + randomname2 + "')]")));

            tt = text123.getText();
            test.pass("Reseller name found in UI: " + tt);
            System.out.println("Reseller created: " + tt);
        } catch (Exception e) {
            test.warning("Failed to verify reseller name in the UI: " + e.getMessage());
            System.out.println("Failed to verify reseller name in the UI.");
        }

        try {
            readXslxdata.writeNewUser("Resellers", randomname2, staticPassword);
            test.pass("Reseller details written to Excel");
            System.out.println("Reseller Username saved to Excel: " + randomname2);
        } catch (Exception e) {
            test.warning("Failed to write to Excel: " + e.getMessage());
        }

        try {
            Assert.assertEquals(randomname2, tt);
            test.pass("Assertion Passed: Created reseller name matches");
        } catch (AssertionError ae) {
            test.fail("Assertion Failed: Reseller name mismatch");
            throw ae;
        }
    }
}


