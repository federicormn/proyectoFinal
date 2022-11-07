package cleanTest.testBaseWatcher;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import pages.todo.Ly.*;
import pages.todoist.AddProjectModal;
import singletonSession.Session;
import utils.GetProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;


public class TestBaseTodoLy implements TestWatcher, AfterTestExecutionCallback
{
    private List<TestResultStatus> testResultsStatus = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }


    @BeforeEach
    public void setup()
    {
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }
    @Attachment(value = "screenshot",type = "image/png")
    private byte[] attach()
    {
        //toma screenshot
        return ((TakesScreenshot)Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void testSuccessful(ExtensionContext context)
    {
        System.out.println("Test "+context.getDisplayName()+" passed.");
        testResultsStatus.add(TestResultStatus.SUCCESSFUL);

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

    }

    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LOG.info("Test result summary for {} {}");
    }

        @Override
        public void afterTestExecution(ExtensionContext context) throws Exception
        {
            Boolean testResult = context.getExecutionException().isPresent();
            if (testResult)
            {
                attach();
            }
            System.out.println(testResult); //false - SUCCESS, true - FAILED
        }
}
