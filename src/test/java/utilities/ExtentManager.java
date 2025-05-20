package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("test-output/ExtentReport.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String filePath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Test Execution Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Tester", "Anubhav");

        return extent;
    }
}

