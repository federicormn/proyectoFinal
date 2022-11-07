package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import singletonSession.Session;

public class TestAllureListeners implements ITestListener
{

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("The test case " +result.getName()+ " passed.");
        saveScreenshotOnFailure(Session.getInstance().getBrowser());

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("The test case " +result.getName()+ " failed.");
        saveScreenshotOnFailure(Session.getInstance().getBrowser());
        saveLogs(result.getMethod().getConstructorOrMethod().getName());

    }

    @Attachment(value = "screenshot",type = "image/png")
    public byte[] saveScreenshotOnFailure(WebDriver driver)
    {
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value ="Stacktrace", type = "text/plain")
    public static String saveLogs(String message)
    {
        return message;
    }



}
