package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class StepLogger {
    public static void log(ExtentTest test, String step) {
        test.log(Status.INFO, step);
    }

    public static void pass(ExtentTest test, String step) {
        test.log(Status.PASS, step);
    }

    public static void fail(ExtentTest test, String step) {
        test.log(Status.FAIL, step);
    }
}
