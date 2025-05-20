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
import org.testng.Assert;

import java.io.IOException;
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
        
        try {
            test.log(Status.INFO, "Entering username");
            lgn.setUsername(prop.getProperty("user"));
            
            test.log(Status.INFO, "Entering password");
            lgn.setPassword(prop.getProperty("pwd"));

            test.log(Status.INFO, "Waiting for manual input (e.g., CAPTCHA)");
            new Scanner(System.in).nextLine();

            test.log(Status.INFO, "Clicking Login button");
            lgn.setLoginButton();

            Thread.sleep(15000);
            String actualurl = driver.getCurrentUrl();
            String expectedurl = "https://testsmartmobilefinance.wrtual.in/admin/actor/reseller";
            test.log(Status.INFO, "Current URL: " + actualurl);

            Assert.assertEquals(actualurl, "https://testsmartmobilefinance.wrtual.in/admin/actor/reseller");
            test.pass("Login successful. Navigated to expected URL.");

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
