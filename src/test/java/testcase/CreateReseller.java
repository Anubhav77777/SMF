
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
            adReseller.enterResellerName(randomname2);

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
        
    

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
            wait.until(ExpectedConditions.visibilityOf(toastElement));

            String toastMsg = toastElement.getText();
            test.pass("Toast Message displayed: " + toastMsg);
            System.out.println("Toast Message: " + toastMsg);
        } catch (Exception e) {
//            test.warning("Toast message not found: " + e.getMessage());
            System.out.println("Toast not found. Continuing test...");
        }

        String tt = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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


