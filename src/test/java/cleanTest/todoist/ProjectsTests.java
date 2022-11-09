package cleanTest.todoist;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Date;

public class ProjectsTests extends TestBaseTodoist
{
    @Test
    @DisplayName("Verify that a standard user can create a project.")
    @Description("this test case is to verify that a standard user can create a project on the home page.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Project Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create Project Story")
    @Tag("SmokeTest")
    public void createProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        System.out.println(testEmail);
        String testPassword = "todoistpassword123";
        String randomProjectName = "Project "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        //homePage.closeWelcomeWindowIfPresent();
        homePage.closeWelcomeModalButton.click();

        int projectCounter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        System.out.println("projects: " + projectCounter);
        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();
        Assertions.assertTrue(addProjectModal.addProjectLabel.isControlDisplayed(), "Add project window is not displayed.");

        addProjectModal.projectNameTextBox.setText(randomProjectName);
        addProjectModal.addProjectButton.click();
        addProjectModal.addProjectButton.waitInvisvilityofElement();

        int projectCounter2 = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        System.out.println("projects after: " + projectCounter2);

        leftSideMenu.projectList.waitAttributeToBe("childElementCount", String.valueOf((projectCounter2)));
        leftSideMenu.searchLastMatchingProject(randomProjectName).waitClickable();

        Assertions.assertTrue( leftSideMenu.searchLastMatchingProject(randomProjectName).isControlDisplayed() && (projectCounter != projectCounter2), "Error, project was NOT created.");
    }

    @Test
    @DisplayName("Verify that a standard user can edit a created  project.")
    @Description("this test case is to verify that a standard user can edit an already created project successfully.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Project Edition")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Edit Project Story")
    @Tag("SmokeTest")
    public void editProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String firstProjectName = "Project "+genericMethods.getAlphaNumericString(5);
        String editedProjectName = "EDIT "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.closeWelcomeModalButton.click();

        int projectCounter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(firstProjectName);
        addProjectModal.addProjectButton.click();

        leftSideMenu.projectList.waitAttributeToBe("childElementCount", String.valueOf((projectCounter+1)));
        leftSideMenu.lastProject.waitAttributeToBe("textContent", firstProjectName);
        leftSideMenu.lastProject.waitTextToBePresent(firstProjectName);

        leftSideMenu.lastProject.makeRightClickAction();
        projectActionsMenu.editProjectButton.click();

        editProjectModal.editProjectNameTextBox.setText(editedProjectName);
        editProjectModal.editProjectNameTextBox.waitAttributeToBe("defaultValue",editedProjectName);
        editProjectModal.saveEditButton.click();

        leftSideMenu.searchLastMatchingProject(editedProjectName).waitClickable();
        Assertions.assertTrue(leftSideMenu.searchLastMatchingProject(editedProjectName).isControlDisplayed(),"Error, project was NOT edited.");

    }

    @Test
    @DisplayName("Verify that a standard user can delete a created project.")
    @Description("this test case is to verify that a standard user can delete an already created project successfully.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Project Deletion")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete Project Story")
    @Tag("SmokeTest")
    public void deleteProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String testProjectName = "Project "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.closeWelcomeModalButton.click();

        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(testProjectName);
        addProjectModal.addProjectButton.click();
        int projectCounterBefore = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        //System.out.println("Projects before= "+ projectCounterBefore);

        leftSideMenu.searchLastMatchingProject(testProjectName).waitClickable();
        leftSideMenu.searchLastMatchingProject(testProjectName).makeRightClickAction();
        projectActionsMenu.deleteProjectButton.click();
        deleteProjectWindow.confirmDeleteButton.click();

        int projectCounterAfter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        //System.out.println("Projects after= "+ projectCounterAfter);

        Assertions.assertTrue(projectCounterBefore != projectCounterAfter, "Error, project was NOT deleted.");
    }

    @Test
    @DisplayName("Verify that a standard user can archive a created project.")
    @Description("this test case is to verify that a standard user can archive an already created project successfully.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Archive Project")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Archive Project Story")
    @Tag("SmokeTest")
    public void archiveProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String testProjectName = "Project "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.closeWelcomeModalButton.click();

        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(testProjectName);
        addProjectModal.addProjectButton.click();

        leftSideMenu.searchLastMatchingProject(testProjectName).waitClickable();
        leftSideMenu.searchLastMatchingProject(testProjectName).makeRightClickAction();

        projectActionsMenu.archiveProjectButton.click();
        deleteProjectWindow.confirmArchiveButton.click();
        leftSideMenu.searchLastMatchingProject(testProjectName).waitInvisvilityofElement();

        leftSideMenu.projectsButton.click();
        centerMenu.archivedButton.click();

        centerMenu.getLastArchivatedByName(testProjectName).waitClickable();
        Assertions.assertTrue(centerMenu.getLastArchivatedByName(testProjectName).isControlDisplayed());

    }

    @Test
    @DisplayName("Verify that a standard user can unarchive a previously archived project.")
    @Description("this test case is to verify that a standard user can unarchive an already created project successfully.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Unarchive Project")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Unarchive Project Story")
    @Tag("SmokeTest")
    public void unarchiveProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String testProjectName = "Project "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.closeWelcomeModalButton.click();

        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(testProjectName);
        addProjectModal.addProjectButton.click();

        leftSideMenu.searchLastMatchingProject(testProjectName).waitClickable();
        leftSideMenu.searchLastMatchingProject(testProjectName).makeRightClickAction();

        projectActionsMenu.archiveProjectButton.click();
        deleteProjectWindow.confirmArchiveButton.click();
        leftSideMenu.searchLastMatchingProject(testProjectName).waitInvisvilityofElement();

        leftSideMenu.projectsButton.click();
        centerMenu.archivedButton.click();

        centerMenu.getLastArchivatedByName(testProjectName).waitClickable();
        centerMenu.getLastArchivatedByName(testProjectName).click();
        centerMenu.unarchiveProjectButton.click();

        leftSideMenu.searchLastMatchingProject(testProjectName).waitClickable();
        Assertions.assertTrue(leftSideMenu.searchLastMatchingProject(testProjectName).isControlDisplayed());

    }

    @Test
    @DisplayName("Verify that a standard user can mark a normal project as favorite.")
    @Description("this test case is to verify that a standard user can mark a project as favorite and it is displayed on the Favorite Projects list.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("Favorite Project")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Favorite Project Story")
    @Tag("SmokeTest")
    public void favoriteProjectTest()
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String testProjectName = "Project "+genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        homePage.closeWelcomeModalButton.click();

        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(testProjectName);
        addProjectModal.addProjectButton.click();

        leftSideMenu.searchLastMatchingProject(testProjectName).waitClickable();
        leftSideMenu.searchLastMatchingProject(testProjectName).makeRightClickAction();

        projectActionsMenu.addToFavoritesButton.click();

        Assertions.assertTrue(leftSideMenu.searchLastMatchingFavorite(testProjectName).isControlDisplayed());
    }

    @Test
    @DisplayName("Verify that a standard user can create a new section inside a created project.")
    @Description("this test case is to verify that a standard user can create a new section and use it, inside an existing project.")
    @Owner("Federico Roman")
    @Epic("Projects Settings")
    @Feature("New Section Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create New Section Story")
    @Tag("SmokeTest")
    public void createNewSectionTest() throws InterruptedException
    {
        String testEmail = genericMethods.getAlphaNumericString(5) + "@mail.com";
        String testPassword = "todoistpassword123";
        String testProjectName = "Project "+genericMethods.getAlphaNumericString(5);
        String testSection = "Section " +genericMethods.getAlphaNumericString(5);

        mainPageTodoist.startFroFreeButton.waitClickable();
        mainPageTodoist.startFroFreeButton.click();

        signUpPage.register(testEmail,testPassword);

        customizationPage.skipButton.waitClickable();
        customizationPage.skipButton.click();

        //homePage.closeWelcomeModalButton.click();

        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitVisibilityOfElement();

        addProjectModal.projectNameTextBox.setText(testProjectName);
        addProjectModal.addProjectButton.click();

        centerMenu.moreActionsButton.click();
        moreProjectActionsMenu.addSectionButton.click();
        centerMenu.newSectionNameTextBox.writeText(testSection);
        centerMenu.addSectionConfirmationButton.click();

        Assertions.assertTrue(centerMenu.getSectionByName(testSection).isControlDisplayed());

        Thread.sleep(5000);

    }

}
