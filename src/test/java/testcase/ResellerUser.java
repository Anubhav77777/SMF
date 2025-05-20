//package testcase;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import io.qameta.allure.Step;
//import pages.CreateResellerUser;
//import utilities.RandomName;
//import utilities.readXslxdata;  // ✅ Import Excel utility
//
//public class ResellerUser extends setupbase {
//
//    public static final String staticPassword = "1234567890";   // Common password
//
//    @Test(priority = 1)
//    public  void Reseleruser() throws InterruptedException, IOException {
//
//        CreateResellerUser createreselluser = new CreateResellerUser(driver);
//
//        Thread.sleep(4000);
//        createreselluser.ReUser();
//        Thread.sleep(5000);
//        createreselluser.AdUser();
//        Thread.sleep(5000);
//
//        // ✅ Generate random user name
//        String randomUserName = RandomName.entrRandomName();
//        createreselluser.enterResellerUser(randomUserName);
//        createreselluser.EnterEmail(randomUserName);  // Assuming Email needs username
//        createreselluser.Password();
//        Thread.sleep(1000);
//        createreselluser.FirstName();
//        createreselluser.LastName();
//        Thread.sleep(1000);
//        createreselluser.Language();
//        Thread.sleep(1000);
//        createreselluser.SltReseller();
//        Thread.sleep(1000);
//
//        // ✅ Select the newly created Reseller (coming from CreateReseller)
//        
//    	String[] credentials = readXslxdata.getFirstUnusedUser("Resellers");
//		String username = credentials[0];
//		String password = credentials[1];
//
//        WebElement option1 = driver.findElement(By.xpath("//div[text()='"+username+"']"));
//        Thread.sleep(1000);
//        option1.click();
//        Thread.sleep(1000);
//
//        // ✅ Select retailer created automatically
//        String retailerName = username+"_retailer";
//        System.out.println("Selecting Retailer: " + retailerName);
//        Thread.sleep(2000);
//        createreselluser.SltRetailer();
//        WebElement option2 = driver.findElement(By.xpath("//*[contains(text(),'" + retailerName + "')]"));
//        option2.click();
//        Thread.sleep(1000);
//        
//         
//        createreselluser.CreateUser();		
////        Thread.sleep(10000);
//        try {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//  	    By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//        WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//        wait.until(ExpectedConditions.visibilityOf(toastElement));
//        System.out.println("Toast Message: " + toastElement.getText());
//        }catch(Exception e) {
//        	 System.out.println("Toast not found move on ");
//        }
//        
//        String tt =null;
//        try {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//        By.xpath("//*[contains(text(),'" + randomUserName + "')]")));
//         tt = text123.getText();
//        System.out.println("ResellerUser created: " + tt);
//        }catch(Exception e) {
//        	 System.out.println("Created Reseller user not found move on ");
//        }
////       Thread.sleep(2000);
//
////        // ✅ Validate that user created
////        WebElement createdUserText = driver.findElement(By.xpath("//*[contains(text(),'" + randomUserName + "')]"));
////        String createdUserName = createdUserText.getText();
////        System.out.println("ResellerUser created: " + createdUserName);
//
//
////         ✅ Save newly created user to Excel
//        readXslxdata.writeNewUser("User", randomUserName, staticPassword);   // Sheet name is "User"
//        System.out.println("ResellerUser Saved to Excel: " + randomUserName);
//        Assert.assertEquals(randomUserName, tt);
//    
//      
//    
//         
//    
//    
//    }
//   
//    
////       @Test(priority = 2)    
////       public void TermSession() {
////    	driver.quit();
////    	
////    }
//}
//
//



//package testcase;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import base.setupbase;
//import io.qameta.allure.*;
//import pages.CreateResellerUser;
//import utilities.RandomName;
//import utilities.readXslxdata;
//
//@Epic("Reseller Management")
//@Feature("Create Reseller User")
//public class ResellerUser extends setupbase {
//
//    public static final String staticPassword = "1234567890";
//
//    @Test(priority = 1, description = "Create a reseller user under an existing reseller and validate it.")
//    @Story("User Creation")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("This test creates a reseller user using random username and associates it with an existing reseller and retailer.")
//    public void Reseleruser() throws InterruptedException, IOException {
//
//        CreateResellerUser createreselluser = new CreateResellerUser(driver);
//        String randomUserName = RandomName.entrRandomName();
//
//        openUserCreationScreen(createreselluser);
//        fillUserDetails(createreselluser, randomUserName);
//
//        String[] credentials = readXslxdata.getFirstUnusedUser("Resellers");
//        String username = credentials[0];
//
//        selectReseller(username);
//        selectRetailer(username + "_retailer");
//
//        createreselluser.CreateUser();
//        handleToastMessage();
//
//        String foundUser = validateUserCreation(randomUserName);
//        readXslxdata.writeNewUser("User", randomUserName, staticPassword);
//
//        System.out.println("ResellerUser Saved to Excel: " + randomUserName);
//        Assert.assertEquals(randomUserName, foundUser);
//    }
//
//    @Step("Open user creation screen")
//    public void openUserCreationScreen(CreateResellerUser page) throws InterruptedException {
//        Thread.sleep(4000);
//        page.ReUser();
//        Thread.sleep(5000);
//        page.AdUser();
//        Thread.sleep(5000);
//    }
//
//    @Step("Fill user details for {username}")
//    public void fillUserDetails(CreateResellerUser page, String username) throws InterruptedException {
//        page.enterResellerUser(username);
//        page.EnterEmail(username);
//        page.Password();
//        Thread.sleep(1000);
//        page.FirstName();
//        page.LastName();
//        Thread.sleep(1000);
//        page.Language();
//        Thread.sleep(1000);
//        page.SltReseller();
//        Thread.sleep(1000);
//    }
//
//    @Step("Select reseller: {reseller}")
//    public void selectReseller(String reseller) throws InterruptedException {
//        WebElement option1 = driver.findElement(By.xpath("//div[text()='" + reseller + "']"));
//        Thread.sleep(1000);
//        option1.click();
//        Thread.sleep(1000);
//    }
//
//    @Step("Select retailer: {retailer}")
//    public void selectRetailer(String retailer) throws InterruptedException {
//        System.out.println("Selecting Retailer: " + retailer);
//        Thread.sleep(2000);
//        CreateResellerUser page = new CreateResellerUser(driver);
//        page.SltRetailer();
//        WebElement option2 = driver.findElement(By.xpath("//*[contains(text(),'" + retailer + "')]"));
//        option2.click();
//        Thread.sleep(1000);
//    }
//
//    @Step("Handle toast message after user creation")
//    public void handleToastMessage() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
//            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
//            wait.until(ExpectedConditions.visibilityOf(toastElement));
//            System.out.println("Toast Message: " + toastElement.getText());
//        } catch (Exception e) {
//            System.out.println("Toast not found, move on");
//        }
//    }
//
//    @Step("Validate if user {username} is displayed on UI")
//    public String validateUserCreation(String username) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.xpath("//*[contains(text(),'" + username + "')]")));
//            String foundUser = text123.getText();
//            System.out.println("ResellerUser created: " + foundUser);
//            return foundUser;
//        } catch (Exception e) {
//            System.out.println("Created Reseller user not found, move on");
//            return null;
//        }
//    }
//}
//
//
//package testcase;
package testcase;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import base.setupbase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.*;
import pages.CreateResellerUser;
import utilities.RandomName;
import utilities.readXslxdata;

@Epic("Reseller Management")
@Feature("Create Reseller User")
public class ResellerUser extends setupbase {

    public static final String staticPassword = "1234567890";
//    private static ExtentReports extent;
//    private static ExtentTest test;

    // Initialize ExtentReports
//    static {
//        extent = new ExtentReports();
//    }

    @Test(priority = 1, description = "Create a reseller user under an existing reseller and validate it.")
    @Story("User Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test creates a reseller user using random username and associates it with an existing reseller and retailer.")
    public void Reseleruser() throws InterruptedException, IOException {

        test = extent.createTest("Reseller User Creation Test", "This test creates and validates a reseller user.");
        
        CreateResellerUser createreselluser = new CreateResellerUser(driver);
        String randomUserName = RandomName.entrRandomName();

        openUserCreationScreen(createreselluser);
        fillUserDetails(createreselluser, randomUserName);

        String[] credentials = readXslxdata.getFirstUnusedUser("Resellers");
        String username = credentials[0];

        selectReseller(username);
        selectRetailer(username + "_retailer");

        createreselluser.CreateUser();
        handleToastMessage();

        String foundUser = validateUserCreation(randomUserName);
        readXslxdata.writeNewUser("User", randomUserName, staticPassword);

        System.out.println("ResellerUser Saved to Excel: " + randomUserName);
        Assert.assertEquals(randomUserName, foundUser);

        // Logging the test result
        test.pass("Reseller User created successfully with username: " + randomUserName);
    }

    @Step("Open user creation screen")
    public void openUserCreationScreen(CreateResellerUser page) throws InterruptedException {
        Thread.sleep(4000);
        page.ReUser();
        Thread.sleep(5000);
        page.AdUser();
        Thread.sleep(5000);
        test.info("User creation screen opened");
    }

    @Step("Fill user details for {username}")
    public void fillUserDetails(CreateResellerUser page, String username) throws InterruptedException {
        page.enterResellerUser(username);
        page.EnterEmail(username);
        page.Password();
        Thread.sleep(1000);
        page.FirstName();
        page.LastName();
        Thread.sleep(1000);
        page.Language();
        Thread.sleep(1000);
        page.SltReseller();
        Thread.sleep(1000);
        test.info("Filled user details for: " + username);
    }

    @Step("Select reseller: {reseller}")
    public void selectReseller(String reseller) throws InterruptedException {
        WebElement option1 = driver.findElement(By.xpath("//div[text()='" + reseller + "']"));
        Thread.sleep(1000);
        option1.click();
        Thread.sleep(1000);
        test.info("Selected reseller: " + reseller);
    }

    @Step("Select retailer: {retailer}")
    public void selectRetailer(String retailer) throws InterruptedException {
        System.out.println("Selecting Retailer: " + retailer);
        Thread.sleep(2000);
        CreateResellerUser page = new CreateResellerUser(driver);
        page.SltRetailer();
        WebElement option2 = driver.findElement(By.xpath("//*[contains(text(),'" + retailer + "')]"));
        option2.click();
        Thread.sleep(1000);
        test.info("Selected retailer: " + retailer);
    }

    @Step("Handle toast message after user creation")
    public void handleToastMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By toastLocator = By.xpath("//div[contains(@class, 'Toastify__toast-body')]");
            WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(toastLocator));
            wait.until(ExpectedConditions.visibilityOf(toastElement));
            String toastMessage = toastElement.getText();
            System.out.println("Toast Message: " + toastMessage);
            test.info("Toast message: " + toastMessage);
        } catch (Exception e) {
            System.out.println("Toast not found, move on");
            test.warning("Toast not found during user creation");
        }
    }

    @Step("Validate if user {username} is displayed on UI")
    public String validateUserCreation(String username) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            WebElement text123 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'" + username + "')]")));
            String foundUser = text123.getText();
            System.out.println("ResellerUser created: " + foundUser);
            test.pass("Reseller user created: " + foundUser);
            return foundUser;
        } catch (Exception e) {
            System.out.println("Created Reseller user not found, move on");
            test.fail("Reseller user creation failed");
            return null;
        }
    }

    // Finalize report
//    @AfterSuite
//    public void tearDown() {
//        extent.flush();
    }


