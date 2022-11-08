package cleanTest.todoist;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AccountSettings extends TestBaseTodoist
{

    @Test
    @DisplayName("Verify that a standard user can change the account's name.")
    @Description("this test case is to verify that a standard user can modify the account's current name.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Name Change")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Account Settings Story")
    @Tag("SmokeTest")
    public void changeNameTest() throws InterruptedException
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String newRandomName = genericMethods.getAlphaNumericString(4);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        String oldName = accountSettingsModal.nameTextBox.getAttribute("value");

        accountSettingsModal.nameTextBox.setText(newRandomName);
        settingsMainModal.updateButton.click();

        String newName = accountSettingsModal.nameTextBox.getAttribute("value");

        Assertions.assertNotEquals(oldName, newName);

    }

    @Test
    @DisplayName("Verify that a standard user can change the account's name.")
    @Description("this test case is to verify that a standard user can modify the account's current name.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Password Change")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Account Settings Story")
    @Tag("SmokeTest")
    public void changePasswordTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String firstPassword = "todoistpassword123";
        String newPassowrd = "todoistpassword123" +genericMethods.getAlphaNumericString(3);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,firstPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.acceptWelcomePopUp.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        accountSettingsModal.changePasswordButton.click();
        accountSettingsModal.currentPasswordTextBox.writeText(firstPassword);


        accountSettingsModal.confirmNewPasswordTextBox.writeText(newPassowrd);
        /////
        accountSettingsModal.newPasswordTextBox.hoverAction();
        accountSettingsModal.newPasswordTextBox.click();
        accountSettingsModal.newPasswordTextBox.waitPresenceOfElement();
        accountSettingsModal.newPasswordTextBox.waitVisibilityOfElement();
        accountSettingsModal.newPasswordTextBox.writeText(newPassowrd);
        ///////
        settingsMainModal.updateButton.click();
        settingsMainModal.closeModalButton.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.logOutButton.click();

        mainPageTodoist.logInButton.click();
        loginPage.emailTextBox.writeText(testEmail);
        loginPage.passwordTextBox.writeText(newPassowrd);
        loginPage.loginButton.click();

        Assertions.assertTrue(homePage.confirmMatchingEmail(testEmail));

    }

    @Test
    @DisplayName("Verify that a created account can be deleted")
    @Description("this test case is to verify that created account can be deleted by the user successfully.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Account delete")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Account Deletion Story")
    @Tag("SmokeTest")
    public void deleteAccountTest() throws InterruptedException {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";


        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        accountSettingsModal.deleteAccountButton.click();
        accountSettingsModal.todoistPasswordTextBox.writeText(testPassword);
        settingsMainModal.updateButton.click();

        accountDeletedPage.todoistHomePageButton.click();

        loginPage.emailTextBox.writeText(testEmail);
        loginPage.passwordTextBox.writeText(testPassword);
        loginPage.loginButton.click();

        Assertions.assertFalse(homePage.confirmMatchingEmail(testEmail));
    }

    @Test
    @DisplayName("Verify that a created account can be deleted")
    @Description("this test case is to verify that created account can be deleted by the user successfully.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Account delete")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Account Deletion Story")
    @Tag("SmokeTest")
    public void changeEmailTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        accountSettingsModal.changeEmailButton.click();

    }
}
