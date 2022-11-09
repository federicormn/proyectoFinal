package cleanTest.todoist;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class RegisterAndLoginTests extends TestBaseTodoist
{
    @Test
    @DisplayName("Verify that a new account can be registered.")
    @Description("this test case is to verify that a new account can be successfully created.")
    @Owner("Federico Roman")
    @Epic("Registration")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Registration Story")
    @Tag("SmokeTest")
    public void registerNewAccountTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.profileSettingsButton.click();

        Assertions.assertTrue(homePage.confirmMatchingEmail(testEmail));

    }

    @Test
    @DisplayName("Verify that a new account can login successfully.")
    @Description("this test case is to verify that a user can login with an existing account.")
    @Owner("Federico Roman")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login Story")
    @Tag("SmokeTest")
    public void loginExistingAccountTest()
    {
        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

        homePage.profileSettingsButton.click();

        Assertions.assertTrue(homePage.confirmMatchingEmail(GetProperties.getInstance().getUser()));

    }

    @Test
    @DisplayName("Verify that a new account can login via Google OAuth successfully.")
    @Description("this test case is to verify that a user can login with Google OAuth.")
    @Owner("Federico Roman")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("OAuth Login Story")
    @Tag("SmokeTest")
    public void loginViaGoogleOAuthTest()
    {
        String oAuthGoogleEmail = "federico.roman.nybble@gmail.com";
        String password = "nybblegroupqa";

        mainPageTodoist.logInButton.click();
        loginPage.continueWithGoogleButton.click();

        oAuthLoginPage.oAuthEmailTextBox.waitPresenceOfElement();
        oAuthLoginPage.oAuthEmailTextBox.writeText(oAuthGoogleEmail);

        oAuthLoginPage.nextButton.waitClickable();
        oAuthLoginPage.nextButton.click();

        oAuthLoginPage.oAuthPasswordTextBox.waitPresenceOfElement();
        oAuthLoginPage.oAuthPasswordTextBox.writeText(password);

        oAuthLoginPage.nextButton.waitClickable();
        oAuthLoginPage.nextButton.click();

        oAuthLoginPage.nextButton.waitInvisvilityofElement();

        homePage.profileSettingsButton.waitClickable();
        homePage.profileSettingsButton.click();

        Assertions.assertTrue(homePage.confirmMatchingEmail(oAuthGoogleEmail));

    }

    @Test
    @DisplayName("Verify that a logged in account can be logged out.")
    @Description("this test case is to verify that a logged in user can log out succesfully from the page.")
    @Owner("Federico Roman")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Story("OAuth Login Story")
    @Tag("SmokeTest")
    public void logOutTest() throws InterruptedException
    {
        mainPageTodoist.logInButton.click();
        Thread.sleep(4000);
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

        homePage.profileSettingsButton.click();

        profileSettingsMenu.logOutButton.click();

        Assertions.assertTrue(mainPageTodoist.logInButton.isControlDisplayed());

    }

}
