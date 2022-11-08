package cleanTest.todoist;

import cleanTest.testBaseWatcher.TestBaseTodoLy;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.todoist.*;
import pages.todoist.settingsModal.AccountSettingsModal;
import pages.todoist.settingsModal.SettingsMainModal;
import singletonSession.Session;
import utils.GenericMethods;
import utils.GetProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.openqa.selenium.remote.http.DumpHttpExchangeFilter.LOG;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@ExtendWith(TestResultExtension.class)
public class TestBaseTodoist implements TestWatcher
{
    GenericMethods genericMethods = new GenericMethods();
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
    public SignUpPage signUpPage = new SignUpPage();
    public CustomizationPage customizationPage = new CustomizationPage();
    public OAuthLoginPage oAuthLoginPage = new OAuthLoginPage();
    public ProfileSettingsMenu profileSettingsMenu = new ProfileSettingsMenu();
    public SettingsMainModal settingsMainModal = new SettingsMainModal();
    public AccountSettingsModal accountSettingsModal = new AccountSettingsModal();
    public AccountDeletedPage accountDeletedPage = new AccountDeletedPage();


    private List<TestBaseTodoist.TestResultStatus> testResultsStatus = new ArrayList<>();

    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

@BeforeEach
    public void setup(){
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", GetProperties.getInstance().getBrowser())
                        .put("URL", GetProperties.getInstance().getHost())
                        .put("User", GetProperties.getInstance().getUser())
                        .put("Pwd", GetProperties.getInstance().getPwd())
                        .build(), System.getProperty("user.dir")
                        + "/build/allure-results/");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
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
        testResultsStatus.add(TestBaseTodoist.TestResultStatus.FAILED);

    }

    public void afterAll(ExtensionContext context) throws Exception {
        Map<TestBaseTodoist.TestResultStatus, Long> summary = testResultsStatus.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LOG.info("Test result summary for {} {}");
    }

}
