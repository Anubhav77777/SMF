//package testcase;
//
//import java.util.Map;
//import java.util.Scanner;
//
//import org.testng.Assert;
//import org.testng.AssertJUnit;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import pages.loginPage1;
//import utilities.CredentialUtil;
//import utilities.readXslxdata;
//
//public class LoginWithRetailerUser extends setupbase{
//
//	@SuppressWarnings("resource")
//	@Test
//    public static void LoginWithRetaileruser() throws Exception {
//        // Reading from Excel
//		
//		String[] credentials = readXslxdata.getFirstUnusedUser("EndUser");
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
//	
//	
//	}
//	
//	
//	
//}
//
package testcase;

import java.time.Duration;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.setupbase;
import pages.loginPage1;
import utilities.readXslxdata;
import com.aventstack.extentreports.Status;

public class LoginWithRetailerUser extends setupbase {

    @SuppressWarnings("resource")
    @Test
    public void LoginWithRetaileruser() throws Exception {
        // Start the test in Extent report
        test = extent.createTest("Login with Retailer User Test");

        // Reading from Excel for dynamic user credentials
        String[] credentials = readXslxdata.getFirstUnusedUser("EndUser");
        String username = credentials[0];
        String password = credentials[1];

        loginPage1 lgn = new loginPage1(driver);
        
        try {
            // Wait for the page to load
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
            
                // Define all expected URLs
                String expectedUrl1 = "https://testsmartmobilefinance.wrtual.in/admin/home/view";
                String expectedUrl2 = "https://stagesmartmobilefinance.wrtual.in/admin/home/view";
                String expectedUrl3 = "https://uatsmartmobilefinance.wrtual.in/admin/home/view";

                // Wait until any one of the expected URLs is loaded
                WebDriverWait wait = new WebDriverWait(setupbase.driver, Duration.ofSeconds(15));
                wait.until(driver -> {
                    String currentUrl = driver.getCurrentUrl();
                    return currentUrl.equals(expectedUrl1) ||
                           currentUrl.equals(expectedUrl2) ||
                           currentUrl.equals(expectedUrl3);
                });

                test.log(Status.INFO, "Waited for login to complete.");

                // Verify login by checking the URL
                String actualUrl = setupbase.driver.getCurrentUrl();
                System.out.println(actualUrl);

                // Log the result of the URL verification
                if (actualUrl.equals(expectedUrl1) || actualUrl.equals(expectedUrl2) || actualUrl.equals(expectedUrl3)) {
                    test.log(Status.PASS, "Login successful. Redirected to the dashboard.");
                } else {
                    test.log(Status.FAIL, "Login failed. Redirected to a different URL.");
                }

                // Final assertion
                Assert.assertTrue(
                    actualUrl.equals(expectedUrl1) || actualUrl.equals(expectedUrl2) || actualUrl.equals(expectedUrl3),
                    "Actual URL did not match any of the expected dashboard URLs."
                );

            } catch (Exception e) {
                test.log(Status.FAIL, "An error occurred during login: " + e.getMessage());
                throw e; // Rethrow the exception to fail the test
            }
        }
        }
