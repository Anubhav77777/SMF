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

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import base.setupbase;
import pages.LogoutPage;

public class Logout extends setupbase {

    @Test(priority = 1)
    public void logout() throws InterruptedException {
        test = extent.createTest("Logout Test - Verify user logout functionality");

        try {
            LogoutPage lg = new LogoutPage(driver);
            Thread.sleep(5000);
            test.info("Clicking user icon to open logout menu");
            lg.ClickIcon();

            test.info("Clicking logout option");
            lg.LogoutIcon();

            Thread.sleep(8000);
        } catch (Exception e) {
            test.warning("Error during logout actions: " + e.getMessage());
        }

        try {
            String actualurl = driver.getCurrentUrl();
            String expectedurl = "https://testsmartmobilefinance.wrtual.in/login";
            System.out.println("Current URL: " + actualurl);

            AssertJUnit.assertEquals(actualurl, expectedurl);
            test.pass("Logout successful and redirected to login page");
        } catch (AssertionError ae) {
            test.fail("Logout URL mismatch. Expected: https://testsmartmobilefinance.wrtual.in/login");
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
