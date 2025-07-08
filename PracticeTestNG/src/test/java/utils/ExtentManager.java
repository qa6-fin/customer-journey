package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/ExtentReport.html");
            htmlReporter.config().setReportName("Automation Test Report");
            htmlReporter.config().setDocumentTitle("Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "QA Engineer");
        }
        return extent;
    }
}
