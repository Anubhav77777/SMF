//package base;	
//	import java.io.FileReader;
//	import java.io.IOException;
//	import java.time.Duration;
//	import java.util.Properties;
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.testng.annotations.BeforeTest;
//	import io.github.bonigarcia.wdm.WebDriverManager;
//
//	public class setupbase {
//
//		public static WebDriver driver ;
//		public static Properties prop = new Properties();
//		public static FileReader fr;
//		
//		
//		
//		
//		@BeforeTest		
//		
//		public void setup() throws IOException  {
//		FileReader fr = new FileReader(System.getProperty("user.dir")+"//src//test//resources//config.properties");	
//		prop.load(fr);
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();		
//		driver.get(prop.getProperty("testurl"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));		
//			
//	
//		}
//	
//		
//		
//		
//		
//}
	package base;

	import java.io.FileReader;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;

	import io.github.bonigarcia.wdm.WebDriverManager;
	import utilities.ExtentManager;

	public class setupbase {

	    public static WebDriver driver;
	    public static Properties prop = new Properties();
	    public static ExtentReports extent;
	    public static ExtentTest test;
	    
	    @BeforeSuite
	    public void report() {
	 // Set up Extent Report
        extent = ExtentManager.getInstance();
	    }
	  
	    
	    @BeforeTest
	    public void setup() throws IOException {
	        // Load configuration
	        FileReader fr = new FileReader(System.getProperty("user.dir") + "//src//test//resources//config.properties");
	        prop.load(fr);

	        

	        // Set up WebDriver
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get(prop.getProperty("uaturl"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	    
	    }
	    @AfterSuite
	    public void flush() {
//	       
	    
	        // Finalize Extent Report
	         {
	            extent.flush();
	        }
	    }
	}
