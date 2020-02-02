package utility;

import io.qameta.allure.Attachment;
import managers.AppManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test  " + iTestResult.getName() + " Start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test  " + iTestResult.getName() + " Success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test  " + iTestResult.getName() + " Failure");
        Object currentClass =iTestResult.getInstance();
        WebDriver driver = AppManager.getWebDriver();
        byte[] srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test  " + iTestResult.getName() + " Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test  " + iTestResult.getName() + " Failed But Within Success Percentage");
        Object currentClass =iTestResult.getInstance();
        WebDriver driver = AppManager.getWebDriver();
        byte[] srcFile =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test  " + iTestContext.getName() + " Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test  " + iTestContext.getName() + " Finish");
    }
}
