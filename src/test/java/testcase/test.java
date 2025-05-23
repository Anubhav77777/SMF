package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.setupbase;
import pages.loginPage1;

public class test extends setupbase {

    @SuppressWarnings("resource")
    @Test
    public void Logintest() throws InterruptedException {
        // Start logging in the report
        test = extent.createTest("Login Test - Verify successful login");

        try {
            loginPage1 lgn = new loginPage1(driver);
            test.info("Entering username");
            lgn.setUsername(prop.getProperty("user"));

            test.info("Entering password");
            lgn.setPassword(prop.getProperty("pwd"));

            test.info("Waiting for manual captcha input");
            new Scanner(System.in).nextLine(); // Wait for manual captcha input

            test.info("Clicking login button");
            lgn.setLoginButton();
            Thread.sleep(20000);

            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://stagesmartmobilefinance.1984.rocks/admin/actor/reseller";

            test.info("Validating URL after login");
            AssertJUnit.assertEquals(actualUrl, expectedUrl);
            Thread.sleep(1000);
            test.pass("Login test passed. Navigated to: " + actualUrl);
        } catch (AssertionError ae) {
            test.fail("Assertion failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            test.fail("Test encountered an exception: " + e.getMessage());
            throw e;
        }
    }
}

		
		

//			    
//			    JavascriptExecutor js = (JavascriptExecutor) driver;
//	            String toastText = (String) js.executeScript(
//	                "return document.querySelector('.Toastify__toast-body')?.innerText;"
//	            );
//
//	            // Output the result
//	            if (toastText != null) {
//	                System.out.println("✅ Toast Message: " + toastText);
//	            } else {
//	                System.out.println(" No toast message found.");
//	            }

//		https://testsmartmobilefinance.wrtual.in/admin/actor/reseller
			    
			    
			  
	     
	    
	
	


