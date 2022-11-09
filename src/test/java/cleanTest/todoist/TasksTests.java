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

    @Test
    @DisplayName("Verify that a standard user can edit a task created inside an existing project.")
    @Description("this test case is to verify that a standard user can edit a created task inside an existing project successfully.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Task Edition")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Edit a Task Story")
    @Tag("SmokeTest")
    public void editTaskTest()
    {
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

        //EDIT TASK
        centerMenu.getLastTaskByName(taskName).click();
        String firstDueDate = editItemModal.editDueDateButton.getAttribute("textContent");
        String firstPriority = editItemModal.selectNewPriority.getAttribute("textContent");
        editItemModal.editDueDateButton.click();
        editItemModal.nextWeekDueDateButton.click();

        editItemModal.selectNewPriority.click();
        editItemModal.choosePriority("2").click();
        editItemModal.closeModal.click();

        //Assertions for edition
        centerMenu.getLastTaskByName(taskName).click();
        String editedDueDate = editItemModal.editDueDateButton.getAttribute("textContent");
        String editedPriority = editItemModal.selectNewPriority.getAttribute("textContent");
        System.out.println("prioridades = "+ firstPriority + editedPriority);

        Assertions.assertNotEquals(firstDueDate, editedDueDate);
        Assertions.assertNotEquals(firstPriority,editedPriority);
    }

    @Test
    @DisplayName("Verify that a standard user can delete a task created inside an existing project.")
    @Description("this test case is to verify that a standard user can delete a created task inside an existing project successfully.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Task Deletion")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Delete a Task Story")
    @Tag("SmokeTest")
    public void deleteTask()
    {
        String taskDescription = "Description " + genericMethods.getAlphaNumericString(3);
        String taskName = "Task name " + genericMethods.getAlphaNumericString(3);;

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

        //DELETING TASK
        centerMenu.getLastTaskByName(taskName).click();
        editItemModal.moreActionsButton.click();
        editItemModal.deleteTask.click();
        deleteProjectWindow.confirmDeleteButton.click();

        centerMenu.getLastTaskByName(taskName).waitInvisvilityofElement();
        Assertions.assertFalse(centerMenu.getLastTaskByName(taskName).isControlDisplayed());
    }



}
