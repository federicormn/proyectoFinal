package cleanTest.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todo.Ly.*;
import pages.todoist.*;
import singletonSession.Session;

public class TestBaseTodoist
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



    @BeforeEach
    public void setup()
    {
        // todo --> create properties file
        Session.getInstance().getBrowser().get("https://todoist.com/");
    }

    @AfterEach
    public void cleanup()
    {
        Session.getInstance().closeBrowser();
    }
}
