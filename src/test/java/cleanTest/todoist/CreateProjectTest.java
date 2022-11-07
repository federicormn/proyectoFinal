package cleanTest.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateProjectTest extends TestBaseTodoist
{
    @Test
    @Order(1)
    public void createProject() throws InterruptedException {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");

        int projectCounter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        System.out.println("projects: " + projectCounter);
        homePage.addProjectButton.click();
        addProjectModal.addProjectLabel.waitAttributeToBe("textContent","Add project");
        Assertions.assertTrue(addProjectModal.addProjectLabel.isControlDisplayed(), "Add project window is not displayed.");


        String randomProjectName = "PROJECT " + new Date().getTime();
        addProjectModal.projectNameTextBox.setText(randomProjectName);
        addProjectModal.addProjectButton.click();

        int projectCounter2 = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        System.out.println("projects after: " + projectCounter2);

        leftSideMenu.projectList.waitAttributeToBe("childElementCount", String.valueOf((projectCounter+1)));
        leftSideMenu.lastProject.waitAttributeToBe("textContent", randomProjectName);
        leftSideMenu.lastProject.waitTextToBePresent(randomProjectName);
        Thread.sleep(1000);//
        Assertions.assertEquals(randomProjectName, leftSideMenu.lastProject.getAttribute("textContent"), "Error, project not created.");

        Thread.sleep(1000);
    }

    @Test
    @Order(2)
    public void editProjectTest() throws InterruptedException
    {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");

        leftSideMenu.lastProjectActionsButton.click();
        projectActionsMenu.editProjectButton.click();

        String randomProjectNameUpdate = "UPDATE " + new Date().getTime();
        editProjectModal.editProjectNameTextBox.setText(randomProjectNameUpdate);
        editProjectModal.editProjectNameTextBox.waitAttributeToBe("defaultValue",randomProjectNameUpdate);
        editProjectModal.saveEditButton.click();
        Thread.sleep(1000);//
        leftSideMenu.lastProject.waitTextToBePresent(randomProjectNameUpdate);
        Assertions.assertEquals(randomProjectNameUpdate, leftSideMenu.lastProject.getAttribute("textContent"), "Error, project name not updated.");

        Thread.sleep(1000);
    }

    @Test
    @Order(3)
    public void deleteProject() throws InterruptedException {
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");

        int projectCounterBefore = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));
        leftSideMenu.lastProjectActionsButton.click();
        projectActionsMenu.deleteProjectButton.click();
        deleteProjectWindow.confirmDeleteButton.click();
        Thread.sleep(1000);//
        leftSideMenu.lastProject.waitPresenceOfElement();
        int projectCounterAfter = Integer.parseInt(leftSideMenu.projectList.getAttribute("childElementCount"));

        Assertions.assertTrue(projectCounterBefore != projectCounterAfter, "Error, project NOT deleted.");
        Thread.sleep(1000);
    }
}
