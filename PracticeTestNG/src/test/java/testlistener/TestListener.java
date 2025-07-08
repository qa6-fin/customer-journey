package testlistener;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import org.testng.*;
import utils.Screenshots;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = Screenshots.takeScreenshot(getDriver(), result.getName());
        test.fail("Test failed: " + result.getThrowable().getMessage(),
		          MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
}
