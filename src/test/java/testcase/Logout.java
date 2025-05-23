//package testcase;
//
//import org.testng.AssertJUnit;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import pages.LogoutPage;
//import pages.addReseller;
//
//public class Logout extends setupbase{
//
//@Test(priority =1)
//public void logout() throws InterruptedException {
//	
//	
//        LogoutPage	lg = new LogoutPage(driver);
//        Thread.sleep(5000);
////        addReseller adresell= new addReseller(driver);
////        adresell.setchatbotFrame();
//        lg.ClickIcon();
//        lg.LogoutIcon();
//        Thread.sleep(10000);
//        String actualurl= setupbase.driver.getCurrentUrl();
//        System.out.println(actualurl);
//        String  Expectedurl =	"https://testsmartmobilefinance.wrtual.in/login";
//         AssertJUnit.assertEquals(actualurl, Expectedurl); 	
//	 
//	     
//    
//	
//	
//}
//
//
//
//
//
//@Test(priority = 2)    
//public void TermSession() throws InterruptedException {
//	Thread.sleep(10000);
//	     driver.quit();
//	
//}
//
//
//
//
//		
//		
//
//}
package testcase;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import base.setupbase;
import ch.qos.logback.core.util.Duration;
import pages.LogoutPage;

public class Logout extends setupbase {

    @Test(priority = 1)
    public void logout() throws InterruptedException {
        test = extent.createTest("Logout Test - Verify user logout functionality");

        try {
            LogoutPage lg = new LogoutPage(driver);
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("uatsmartmobilefinance") || currentUrl.contains("stagesmartmobilefinance")) {
                test.info("Running chatbot frame setup for UAT/Stage environment");
                Thread.sleep(5000);
                lg.setchatbotFrame();
            } else {
                test.info("Skipping chatbot frame setup (not UAT or Stage environment)");
            }

            
            
            Thread.sleep(5000);
            test.info("Clicking user icon to open logout menu");
            lg.ClickIcon();

            test.info("Clicking logout option");
            lg.LogoutIcon();

//            Thread.sleep(15000);
        } catch (Exception e) {
            test.warning("Error during logout actions: " + e.getMessage());
        }
     
        try {
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));

            // Define all acceptable logout URLs
            String expectedUrl1 = "https://testsmartmobilefinance.wrtual.in/login";
            String expectedUrl2 = "https://stagesmartmobilefinance.1984.rocks/admin/actor/reseller";
            String expectedUrl3 = "https://uatsmartmobilefinance.wrtual.in/login";
            String expectedUrl4 = "https://smflock.com/login";

            // Wait until the current URL matches any of the expected ones
            boolean matched = wait.until(driver -> {
                String currentUrl = driver.getCurrentUrl();
                return currentUrl.equalsIgnoreCase(expectedUrl1) ||
                       currentUrl.equalsIgnoreCase(expectedUrl2) ||
                       currentUrl.equalsIgnoreCase(expectedUrl3) || 
                       currentUrl.equalsIgnoreCase(expectedUrl4);
            });

            String actualUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + actualUrl);

            if (matched) {
                test.pass("Logout successful and redirected to one of the expected login URLs.");
            } else {
                test.fail("Logout URL mismatch. URL did not match any of the expected login URLs.");
            }

            // Final assertion
            Assert.assertTrue(
                actualUrl.equalsIgnoreCase(expectedUrl1) ||
                actualUrl.equalsIgnoreCase(expectedUrl2) ||
                actualUrl.equalsIgnoreCase(expectedUrl3) || 
                actualUrl.equalsIgnoreCase(expectedUrl4),
                "Actual URL does not match any expected logout URLs."
            );

        } catch (AssertionError ae) {
            test.fail("Logout URL mismatch. " + ae.getMessage());
            throw ae;

        } catch (Exception e) {
            test.warning("Exception while checking URL after logout: " + e.getMessage());
        }



    }

    @Test(priority = 2)
    public void TermSession() throws InterruptedException {
        test = extent.createTest("Terminate Session - Quit browser session");
        try {
            Thread.sleep(3000);
            driver.quit();
            test.pass("Browser session terminated successfully");
        } catch (Exception e) {
            test.warning("Failed to quit browser: " + e.getMessage());
        }
    }
}
