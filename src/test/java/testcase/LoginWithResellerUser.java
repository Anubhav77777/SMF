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

import java.util.Scanner;
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
            
            // Wait for login to complete
            Thread.sleep(15000);
            test.log(Status.INFO, "Waited for login to complete.");

            // Verify login by checking the URL
            String actualurl = setupbase.driver.getCurrentUrl();
            String expectedurl = "https://testsmartmobilefinance.wrtual.in/admin/customise/retailer";
            System.out.println(actualurl);

            // Log the result of the URL verification
            if (actualurl.equals(expectedurl)) {
                test.log(Status.PASS, "Login successful. Redirected to the dashboard.");
            } else {
                test.log(Status.FAIL, "Login failed. Redirected to a different URL.");
            }
            Assert.assertEquals(actualurl, expectedurl);
        } catch (Exception e) {
            test.log(Status.FAIL, "An error occurred during login: " + e.getMessage());
            throw e; // Rethrow the exception to fail the test
        }
    }
}
