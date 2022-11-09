package cleanTest.todoist;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.GetProperties;

public class TasksTests extends TestBaseTodoist
{

    @Test
    @DisplayName("Verify that a standard user can create a task inside an existing project.")
    @Description("this test case is to verify that a standard user can create a new task inside an existing project successfully.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Task Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create a Task Story")
    @Tag("SmokeTest")
    public void createTaskTest() throws InterruptedException {
        String taskDescription = "description";
        String taskName = "task name";

        //LOGIN AND SELECT LAST CREATED PROJECT (EXISTING)
        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        leftSideMenu.lastProject.click();

        //CREATE TASK
        centerMenu.addTaskButton.waitClickable();
        centerMenu.addTaskButton.click();

        centerMenu.projectCreationMenu.waitPresenceOfElement();
        centerMenu.projectCreationMenu.waitClickable();
        centerMenu.projectCreationMenu.waitVisibilityOfElement();

        centerMenu.taskNameTextBox.writeText(taskName);

        centerMenu.taskDescriptionTextBox.writeText(taskDescription);

        centerMenu.dueDateButton.click();
        centerMenu.tomorrowDueDateButton.click();

        centerMenu.setPriorityButton.click();

        centerMenu.pickPriority("1").click();

        centerMenu.addTaskConfirmationButton.waitClickable();
        centerMenu.addTaskConfirmationButton.click();

        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName).isControlDisplayed());
    }
}
