package cleanTest.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBaseTodoist
{
    @Test
    public void login()
    {
        mainPageTodoist.logInButton.click();

        loginPage.login("fhr@fhr.com","todoistpassword123");

        Assertions.assertTrue(homePage.homeButton.isControlDisplayed());

    }
}
