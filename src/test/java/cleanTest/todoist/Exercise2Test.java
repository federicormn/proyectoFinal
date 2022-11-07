package cleanTest.todoist;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise2Test extends TestBaseTodoist
{
    @Test
    public void exercise2Test() throws InterruptedException
    {
        String taskDescription = "description";
        String taskName = "task name";

        //LOGIN AND SELECT LAST CREATED PROJECT (EXISTING)
        mainPageTodoist.logInButton.click();
        loginPage.login("fhr@fhr.com","todoistpassword123");
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
        centerMenu.pickPriority1.click();

        centerMenu.addTaskConfirmationButton.click();

        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName).isControlDisplayed());

        //EDIT TASK
        centerMenu.getLastTaskByName(taskName).click();
        String firstDueDate = editItemModal.editDueDateButton.getAttribute("textContent");
        String firstPriority = editItemModal.selectNewPriority.getAttribute("textContent");
        editItemModal.editDueDateButton.click();
        editItemModal.nextWeekDueDateButton.click();

        editItemModal.selectNewPriority.click();
        //editItemModal.choosePriority("2");
        editItemModal.pickPriority2.click();
        editItemModal.closeModal.click();

        //Assertions for edition
        centerMenu.getLastTaskByName(taskName).click();
        String editedDueDate = editItemModal.editDueDateButton.getAttribute("textContent");
        String editedPriority = editItemModal.selectNewPriority.getAttribute("textContent");
        System.out.println("prioridades = "+ firstPriority + editedPriority);

        Assertions.assertNotEquals(firstDueDate, editedDueDate);
        Assertions.assertNotEquals(firstPriority,editedPriority);

        //DELETING TASK
        editItemModal.moreActionsButton.click();
        editItemModal.deleteTask.click();
        editItemModal.deleteConfirmationButton.click();

        centerMenu.getLastTaskByName(taskName).waitInvisvilityofElement();
        Assertions.assertFalse(centerMenu.getLastTaskByName(taskName).isControlDisplayed());

    }
}
