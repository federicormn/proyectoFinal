package cleanTest.todoist.testSuite;

import cleanTest.todoist.TestBaseTodoist;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.GetProperties;

public class AccountSettingsTests extends TestBaseTodoist
{

    @ParameterizedTest
    @CsvSource(
            {
                    "3",
                    "5",
                    "7",
                    "10"
            }
    )
    @DisplayName("Verify that a standard user can change the account's name.")
    @Description("this test case is to verify that a standard user can modify the account's current name.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Name Change")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Account Settings Story")
    @Tag("SmokeTest")
    public void changeNameTest(int characters)
    {
        String newRandomName = genericMethods.getAlphaNumericString(characters);

        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

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

        homePage.closeWelcomeModalButton.click();

        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        accountSettingsModal.changePasswordButton.click();

        accountSettingsModal.currentPasswordTextBox.writeText(firstPassword);
        accountSettingsModal.newPasswordTextBox.writeText(newPassowrd);
        accountSettingsModal.confirmNewPasswordTextBox.writeText(newPassowrd);

        settingsMainModal.updateButton.waitClickable();
        settingsMainModal.updateButton.click();
        settingsMainModal.updateButton.waitInvisvilityofElement();

        if(!caducatedSessionPopUp.closePopUpIfCaducatedSession())
        {
            settingsMainModal.closeModalButton.waitClickable();
            settingsMainModal.closeModalButton.click();

            homePage.profileSettingsButton.click();
            profileSettingsMenu.logOutButton.click();
            mainPageTodoist.logInButton.click();
        }

        loginPage.emailTextBox.writeText(testEmail);
        loginPage.passwordTextBox.writeText(newPassowrd);
        loginPage.loginButton.click();

        homePage.profileSettingsButton.click();
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
    public void deleteAccountTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";


        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        //homePage.closeWelcomeWindowIfPresent();
        homePage.closeWelcomeModalButton.click();

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
    @DisplayName("Verify that a standard user can change the current mail linked to the account.")
    @Description("this test case is to verify that the current mail linked to an account can be modified successfully.")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Email Change")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Email Change Story")
    @Tag("SmokeTest")
    public void changeEmailTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String newTestEmail = "UPDATE"+testEmail;
        String testPassword = "todoistpassword123";

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();
        //homePage.closeWelcomeWindowIfPresent();
        homePage.closeWelcomeModalButton.click();

        homePage.profileSettingsButton.waitClickable();
        homePage.profileSettingsButton.click();
        profileSettingsMenu.settingsButton.click();

        accountSettingsModal.changeEmailButton.click();

        accountSettingsModal.newEmailTextBox.writeText(newTestEmail);
        accountSettingsModal.confirmNewEmailTextBox.writeText(newTestEmail);
        accountSettingsModal.todoistPasswordForEmail.writeText(testPassword);

        settingsMainModal.updateButton.waitClickable();
        settingsMainModal.updateButton.click();

        accountSettingsModal.currentEmailLabel.waitTextToBePresent(newTestEmail);
        Assertions.assertEquals(accountSettingsModal.currentEmailLabel.getText(), newTestEmail);

    }

    @Test
    @DisplayName("Verify that the language for the app can be changed.")
    @Description("this test case is to verify that the language can be modified and gets applied at [Account Settings].")
    @Owner("Federico Roman")
    @Epic("Account Settings")
    @Feature("Language Change")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Language Change Story")
    @Tag("SmokeTest")
    public void changeLanguageTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();
        //homePage.closeWelcomeWindowIfPresent();
        homePage.closeWelcomeModalButton.click();

        homePage.profileSettingsButton.waitClickable();
        homePage.profileSettingsButton.click();

        profileSettingsMenu.settingsButton.waitClickable();
        profileSettingsMenu.settingsButton.click();

        settingsMainModal.settingsLeftHeader.waitVisibilityOfElement();
        String firstSettingsHeader = settingsMainModal.settingsLeftHeader.getText();

        settingsMainModal.generalButton.click();
        generalSettingsModal.languageListBox.click();
        generalSettingsModal.selectLanguage("en", "English").click();
        settingsMainModal.updateButton.click();
        settingsMainModal.updateButton.waitInvisvilityofElement();

        settingsMainModal.settingsLeftHeader.waitTextToDissapear(firstSettingsHeader);
        String changedSettingsHeader = settingsMainModal.settingsLeftHeader.getText();

        Assertions.assertNotEquals(firstSettingsHeader, changedSettingsHeader);

    }


}
