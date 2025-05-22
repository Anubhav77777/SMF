//package testcase;
//
//import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
//
//import java.io.IOException;
//import java.util.Map;
//import java.util.Scanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//     
//import base.setupbase;
//import pages.loginPage1;
//import utilities.CredentialUtil;
//
//public class LoginTest extends setupbase{
//	
//	
//	@SuppressWarnings("resource")
//	@Test(priority = 1)
//	public  void LoginWithSuperAdmin() throws InterruptedException, IOException   {
////		setupDriver();
//		
//		
//		loginPage1 lgn = new loginPage1(driver);
//		lgn.setUsername(prop.getProperty("user"));
//	    lgn.setPassword(prop.getProperty("pwd"));
//	    new Scanner(System.in).nextLine();
//		lgn.setLoginButton();
//		Thread.sleep(10000);
//		String actualurl= driver.getCurrentUrl();
//		String expectedurl = "https://testsmartmobilefinance.wrtual.in/admin/actor/reseller" ;
//		System.out.println(actualurl);
//	    Thread.sleep(5000);
//		Assert.assertEquals(actualurl, expectedurl);
//		
//       
//	
//	}
//
//
//	
//	
//}
//




package testcase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import base.setupbase;
import pages.loginPage1;

public class LoginTest extends setupbase {

//    private static ExtentReports extent;
//    private static ExtentTest test;

//    @BeforeClass
//    public void setupExtentReport() {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport_LoginTest.html");
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//    }

    @SuppressWarnings("resource")
	@Test(priority = 1)
    public void LoginWithSuperAdmin() throws InterruptedException, IOException {
        test = extent.createTest("Login with Super Admin", "Validates login functionality with correct credentials");

        loginPage1 lgn = new loginPage1(driver);
        
        Thread.sleep(2000);
        String Url = driver.getCurrentUrl();
        String user = "";
        String pwd = "";

        if (Url.contains("uatsmartmobilefinance")) {
        	user = prop.getProperty("uat_user");
        	pwd = prop.getProperty("uat_pwd");
            test.log(Status.INFO, "Detected UAT environment. Using UAT credentials.");
        } else if (Url.contains("stagesmartmobilefinance")) {
        	user = prop.getProperty("stage_user");
        	pwd = prop.getProperty("stage_pwd");
            test.log(Status.INFO, "Detected Stage environment. Using Stage credentials.");
        } else if (Url.contains("testsmartmobilefinance")) {
        	user = prop.getProperty("test_user");
        	pwd = prop.getProperty("test_pwd");
            test.log(Status.INFO, "Detected Test environment. Using Test credentials.");
        } else {
            test.fail("Unknown environment detected from URL: " + Url);
            throw new RuntimeException("Unsupported environment: " + Url);
        }

        // Enter credentials
        test.log(Status.INFO, "Entering username");
        lgn.setUsername(user);

        test.log(Status.INFO, "Entering password");
        lgn.setPassword(pwd);
        
            test.log(Status.INFO, "Waiting for manual input (e.g., CAPTCHA)");
            new Scanner(System.in).nextLine();

            test.log(Status.INFO, "Clicking Login button");
            lgn.setLoginButton();
try {
            Thread.sleep(10000);
            String expectedUrl1 = "https://testsmartmobilefinance.wrtual.in/admin/actor/reseller";
            String expectedUrl2 = "https://stagesmartmobilefinance.1984.rocks/admin/actor/reseller";
            String expectedUrl3 = "https://uatsmartmobilefinance.wrtual.in/admin/actor/reseller";

            // Wait until one of the URLs is matched
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            boolean matched = wait.until(driver -> {
                String currentUrl = driver.getCurrentUrl();
                return currentUrl.equalsIgnoreCase(expectedUrl1) ||
                       currentUrl.equalsIgnoreCase(expectedUrl2) ||
                       currentUrl.equalsIgnoreCase(expectedUrl3);
            });
            
            
            

            String actualUrl = driver.getCurrentUrl();
            test.log(Status.INFO, "Current URL: " + actualUrl);

          
            if (matched) {
                test.pass("Login successful. Redirected to one of the expected URLs.");
            } else {
                test.fail("Login failed. URL did not match any expected values.");
            }

            // Final assertion
            Assert.assertTrue(
                actualUrl.equalsIgnoreCase(expectedUrl1) ||
                actualUrl.equalsIgnoreCase(expectedUrl2) ||
                actualUrl.equalsIgnoreCase(expectedUrl3),
                "Actual URL does not match any of the expected URLs."
            );

            
                   
        } catch (AssertionError ae) {
            test.fail("Assertion failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            throw e;
        }
    }

//    @AfterClass
//    public void tearDownExtentReport() {
//        extent.flush();
//    }
}
