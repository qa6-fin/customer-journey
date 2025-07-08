package utils;

import org.openqa.selenium.*;
import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {
    public static String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "screenshots/" + testName + "_" + timestamp + ".png";
        try {
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
