package cleanTest.todoist;

import cleanTest.testBaseWatcher.TestBaseTodoLy;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.todoist.*;
import singletonSession.Session;
import utils.GetProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

public class TestBaseTodoist implements TestWatcher, AfterTestExecutionCallback
{
    public MainPageTodoist mainPageTodoist = new MainPageTodoist();
    public LoginPage loginPage = new LoginPage();
    public HomePage homePage = new HomePage();
    public AddProjectModal addProjectModal = new AddProjectModal();
    public LeftSideMenu leftSideMenu = new LeftSideMenu();
    public ProjectActionsMenu projectActionsMenu = new ProjectActionsMenu();
    public EditProjectModal editProjectModal = new EditProjectModal();
    public DeleteProjectWindow deleteProjectWindow = new DeleteProjectWindow();
    public CenterMenu centerMenu = new CenterMenu();
    public EditItemModal editItemModal = new EditItemModal();


    private List<TestBaseTodoist.TestResultStatus> testResultsStatus = new ArrayList<>();

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
        testResultsStatus.add(TestBaseTodoist.TestResultStatus.SUCCESSFUL);

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause)
    {
        LOG.info("Test" +context.getDisplayName()+" was aborted because: "+cause.getCause());
        testResultsStatus.add(TestBaseTodoist.TestResultStatus.ABORTED);
    }
    @Override
    public void testFailed(ExtensionContext context, Throwable cause)
    {
        LOG.info("Test" +context.getDisplayName()+" failed because: "+cause.getCause());
        attach();
        testResultsStatus.add(TestBaseTodoist.TestResultStatus.FAILED);

    }

    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestBaseTodoist.TestResultStatus, Long> summary = testResultsStatus.stream()
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
