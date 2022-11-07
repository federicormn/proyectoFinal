package cleanTest.todo.Ly;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.todo.Ly.*;
import singletonSession.Session;
import utils.GetProperties;
import utils.TestAllureListeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;


public class TestBaseTodoLy implements TestWatcher, AfterTestExecutionCallback
{
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();

    private int testStatus = 0;


    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    //////////
    public MainPage mainPage = new MainPage();
    public LoginModal loginModal = new LoginModal();
    public MenuSection menuSection = new MenuSection();
    public SettingsMenu settingsMenu = new SettingsMenu();

    public SignUpModal signUpModal = new SignUpModal();
    public  ProjectsList projectsList = new ProjectsList();


    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void cleanup()
    {

        //Session.getInstance().closeBrowser();
    }
    @Attachment(value = "screenshot",type = "image/png")
    private byte[] attach()
    {
        //todo --> Ej1
        //toma screenshot
        return ((TakesScreenshot)Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void testSuccessful(ExtensionContext context)
    {
        System.out.println("Test "+context.getDisplayName()+" passed.");
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);

        Session.getInstance().closeBrowser();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause)
    {
        LOG.info("Test" +context.getDisplayName()+" was aborted because: "+cause.getCause());
        testResultsStatus.add(TestResultStatus.ABORTED);
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause)
    {
        LOG.info("Test" +context.getDisplayName()+" failed because: "+cause.getCause());
        attach();
        testResultsStatus.add(TestResultStatus.FAILED);

        Session.getInstance().closeBrowser();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception
    {
        System.out.println("after exec call back " + testStatus);

    }

    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LOG.info("Test result summary for {} {}");
    }
}
