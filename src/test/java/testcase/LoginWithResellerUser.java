//package testcase;
//
//import java.util.Scanner;
//
//import org.testng.Assert;
//
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import pages.loginPage1;
//import utilities.readXslxdata;
//
//public class LoginWithResellerUser extends setupbase{
//
//	
//	@SuppressWarnings("resource")
//	@Test
//    public static void LoginWithDynamic() throws Exception {
//        // Reading from Excel
//		
//		String[] credentials = readXslxdata.getFirstUnusedUser("User");
//		String username = credentials[0];
//		String password = credentials[1];
//
//
//        loginPage1 lgn = new loginPage1(driver);
//        Thread.sleep(5000);
//
//        lgn.setUsername(username);
//        lgn.setPassword(password);
//        new Scanner(System.in).nextLine();
//        lgn.setLoginButton();
//        
//        Thread.sleep(10000);
//
//        String actualurl = setupbase.driver.getCurrentUrl();
//        String expectedurl = "https://testsmartmobilefinance.wrtual.in/admin/dashboard"; 
//        System.out.println(actualurl);
//        Assert.assertEquals(actualurl, expectedurl);
//    }
//}
//
//	
//	
//
package testcase;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.setupbase;
import pages.loginPage1;
import utilities.readXslxdata;
import com.aventstack.extentreports.Status;

public class LoginWithResellerUser extends setupbase {

    @SuppressWarnings("resource")
    @Test
    public void LoginWithDynamic() throws Exception {
        // Start the test in Extent report
        test = extent.createTest("Login with Reseller User Test");

        // Reading from Excel for dynamic user credentials
        String[] credentials = readXslxdata.getFirstUnusedUser("User");
        String username = credentials[0];
        String password = credentials[1];
        
        loginPage1 lgn = new loginPage1(driver);
        try {
            // Wait for page load
            Thread.sleep(5000);
            test.log(Status.INFO, "Page loaded successfully.");

            // Set username and password
            lgn.setUsername(username);
            lgn.setPassword(password);
            test.log(Status.INFO, "Entered username and password.");

            // Wait for user input before clicking login button
            new Scanner(System.in).nextLine();

            // Click on login button
            lgn.setLoginButton();
            test.log(Status.INFO, "Clicked on Login button.");
            
            Thread.sleep(10000);
            
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                // Define all expected URLs
                String expectedUrl1 = "https://testsmartmobilefinance.wrtual.in/admin/customise/retailer";
                String expectedUrl2 = "https://stagesmartmobilefinance.wrtual.in/admin/customise/retailer";
                String expectedUrl3 = "https://uatsmartmobilefinance.wrtual.in/admin/customise/retailer";

                // Wait until any one of the expected URLs is loaded
                wait.until(driver -> {
                    String currentUrl = driver.getCurrentUrl();
                    return currentUrl.equals(expectedUrl1) ||
                           currentUrl.equals(expectedUrl2) ||
                           currentUrl.equals(expectedUrl3);
                });

                String actualUrl = driver.getCurrentUrl();
                test.log(Status.INFO, "Current URL: " + actualUrl);

                // Log the result of the URL verification
                if (actualUrl.equals(expectedUrl1) || actualUrl.equals(expectedUrl2) || actualUrl.equals(expectedUrl3)) {
                    test.log(Status.PASS, "Login successful. Redirected to the expected dashboard.");
                } else {
                    test.log(Status.FAIL, "Login failed. Redirected to a different URL.");
                }

                // Assert that one of the expected URLs matches
                Assert.assertTrue(
                    actualUrl.equals(expectedUrl1) || actualUrl.equals(expectedUrl2) || actualUrl.equals(expectedUrl3),
                    "Actual URL did not match any of the expected URLs."
                );
                
            } catch (Exception e) {
                test.log(Status.FAIL, "An error occurred during login: " + e.getMessage());
                throw e; // Rethrow the exception to fail the test
            }
    }
}
