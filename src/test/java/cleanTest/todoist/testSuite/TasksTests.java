package cleanTest.todoist.testSuite;

import cleanTest.todoist.TestBaseTodoist;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import singletonSession.Session;
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
    public void createTaskTest()
    {
        String taskDescription = "description";
        String taskName = "task name";

        //LOGIN AND SELECT LAST CREATED PROJECT (EXISTING)
        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        loginPage.loginButton.waitInvisvilityofElement();

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

        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName).isControlDisplayed(), "Error, task was not created with name"+ taskName);
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
        String editedTaskName = taskName + genericMethods.getAlphaNumericString(5);

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
//        editItemModal.taskNameButton.click();
//        editItemModal.taskNameTextBox.writeText(editedTaskName);
//        editItemModal.saveTaskNameButton.click();
        editItemModal.editDueDateButton.click();
        editItemModal.nextWeekDueDateButton.click();

        editItemModal.selectNewPriority.click();
        editItemModal.choosePriority("2").waitClickable();
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

    @Test
    @DisplayName("Verify that a standard user can create a sub-task inside a task.")
    @Description("this test case is to verify that a standard user can create a new sub-task inside a created task successfully.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Sub-Task Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create Sub-Task Story")
    @Tag("SmokeTest")
    public void createSubTaskTest()
    {
        String taskDescription = "Description " + genericMethods.getAlphaNumericString(3);
        String taskName = "Task name " + genericMethods.getAlphaNumericString(3);
        String subTaskName = "Sub-Task name " + genericMethods.getAlphaNumericString(3);
        String subTaskDescription = "Sub-task Description " + genericMethods.getAlphaNumericString(3);;

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

        //CREATE SUB-TASK
        centerMenu.getLastTaskByName(taskName).click();
        editItemModal.addSubTaskButton.click();
        editItemModal.subTaskNameTextBox.writeText(subTaskName);
        editItemModal.subTaskDescriptionTextBox.writeText(subTaskDescription);
        editItemModal.addSubTaskConfirmationButton.click();

        Assertions.assertTrue(editItemModal.getSubTaskByName(subTaskName).isControlDisplayed() && editItemModal.subTasksListButton.isControlDisplayed(), "Error, task was NOT created.");

    }

    @Test
    @DisplayName("Verify that a standard user can create a comment inside a task.")
    @Description("this test case is to verify that a standard user can create a new comment inside a created task successfully.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Comment Creation")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Create comment Story")
    @Tag("SmokeTest")
    public void addComentToTaskTest()
    {
        String taskDescription = "Description " + genericMethods.getAlphaNumericString(3);
        String taskName = "Task name " + genericMethods.getAlphaNumericString(3);
        String testComment = "Test comment " + genericMethods.getAlphaNumericString(5);


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

        //ADD COMMENT
        centerMenu.getLastTaskByName(taskName).click();
        editItemModal.commentButton.click();
        editItemModal.commentTextBox.writeText(testComment);
        editItemModal.addCommentConfirmationButton.click();

        Assertions.assertTrue(editItemModal.searchLastMatchingCommentByContent(testComment) && editItemModal.commentsSectionButton.isControlDisplayed());
    }

    @Test
    @DisplayName("Verify that a standard user can mark a task as completed.")
    @Description("this test case is to verify that a standard user can mark a task as done and it is displayed on [Completed Tasks] section.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Complete Task")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Complete Task Story")
    @Tag("SmokeTest")
    public void markTaskAsCompletedTest()
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

        //MARK TASK AS COMPLETED AND ASSERT IN COMPLETED TASKS SECTION
        centerMenu.getCheckButtonForTaskByName(taskName).click();

        homePage.openProductivityButton.click();
        productivityModal.viewAllCompletedTasks.click();

        Assertions.assertTrue(centerMenu.getCompletedTaskByName(taskName).isControlDisplayed());

    }

    @Test
    @DisplayName("Verify that the completed tasks list DOES NOT keep loading history after displaying all elements.")
    @Description("This test case is to verify that the control [Load more history] for completed tasks is no longer clickable/visible once all the completed tasks are displayed on the list..")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Complete Task")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-430")
    @Story("Complete Task Story")
    @Tag("SmokeTest")
    @Tag("Bug")
    public void verifyCompletedTasksStopLoadingTest()
    {
        //LOGIN AND SELECT LAST CREATED PROJECT (EXISTING)
        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());

        //ENTER COMPLETED TASKS SECTION
        homePage.openProductivityButton.click();
        productivityModal.viewAllCompletedTasks.click();

        int taskCounterBefore = Integer.parseInt(centerMenu.tasksList.getAttribute("childElementCount"));

        centerMenu.loadMoreElementsButton.click();
        centerMenu.loadMoreElementsButton.click();

        int taskCounterAfter = Integer.parseInt(centerMenu.tasksList.getAttribute("childElementCount"));

        System.out.println("tasks before / after = "+taskCounterBefore + " / " + taskCounterAfter);
        Assertions.assertFalse(taskCounterBefore == taskCounterAfter && centerMenu.loadMoreElementsButton.isControlDisplayed(), "Error, [Load more] button is still available after all tasks are displayed.");
    }

    @Test
    @DisplayName("Verify that multiple tasks marked as completed can be recovered at once.")
    @Description("This test case is to verify that two or more tasks marked as completed on a quick succession can be recovered by using the [Undo] button that pops up after marking them as completed.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Undo Completed Tasks")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-429")
    @Story("Undo multiple completed tasks Story")
    @Tag("SmokeTest")
    @Tag("Bug")
    public void undoMultipleCompletedTaskTest()
    {
        String taskName1 = "task name 1 -" +genericMethods.getAlphaNumericString(3);
        String taskDescription1 = "task description 1";
        String taskName2 = "task name 2 - "+genericMethods.getAlphaNumericString(3);;
        String taskDescription2 = "task description 2";

        //LOGIN AND SELECT LAST CREATED PROJECT (EXISTING)
        mainPageTodoist.logInButton.click();
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        leftSideMenu.lastProject.click();

        //CREATE FIRST TASKS
        centerMenu.addTaskButton.waitClickable();
        centerMenu.addTaskButton.click();

        centerMenu.projectCreationMenu.waitPresenceOfElement();
        centerMenu.projectCreationMenu.waitClickable();
        centerMenu.projectCreationMenu.waitVisibilityOfElement();

        centerMenu.taskNameTextBox.writeText(taskName1);

        centerMenu.taskDescriptionTextBox.writeText(taskDescription1);

        centerMenu.dueDateButton.click();
        centerMenu.tomorrowDueDateButton.click();

        centerMenu.setPriorityButton.click();

        centerMenu.pickPriority("1").click();

        centerMenu.addTaskConfirmationButton.waitClickable();
        centerMenu.addTaskConfirmationButton.click();

        centerMenu.getLastTaskByName(taskName1).waitPresenceOfElement();

        //CREATE SECOND TASKS
        centerMenu.projectCreationMenu.waitPresenceOfElement();
        centerMenu.projectCreationMenu.waitClickable();
        centerMenu.projectCreationMenu.waitVisibilityOfElement();

        centerMenu.taskNameTextBox.writeText(taskName2);

        centerMenu.taskDescriptionTextBox.writeText(taskDescription2);

        centerMenu.dueDateButton.click();
        centerMenu.tomorrowDueDateButton.click();

        centerMenu.setPriorityButton.click();

        centerMenu.pickPriority("1").click();

        centerMenu.addTaskConfirmationButton.waitClickable();
        centerMenu.addTaskConfirmationButton.click();

        centerMenu.getLastTaskByName(taskName2).waitPresenceOfElement();

        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName1).isControlDisplayed(),"Error, first task was NOT created.");
        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName2).isControlDisplayed(),"Error, second task was NOT created.");

        //MARK BOTH TASKS AS COMPLETED
        centerMenu.getCheckButtonForTaskByName(taskName1).click();
        centerMenu.getCheckButtonForTaskByName(taskName2).click();

        homePage.undoButton.waitClickable();
        homePage.undoButton.click();

        //ASSERT BOTH TASK WERE RECOVERED AND DISPLAYED IN FOCUSED PROJECT
        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName1).isControlDisplayed(),"Error, first task was NOT recovered.");
        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName2).isControlDisplayed(),"Error, second task was NOT recovered.");
    }

    @Test
    @DisplayName("Verify that a created task can be moved to [Inbox] folder.")
    @Description("This test case is to verify that a task created on any project can be moved into [Inbox] folder.")
    @Owner("Federico Roman")
    @Epic("Tasks management")
    @Feature("Move task to [Inbox]")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Move task Story")
    @Tag("SmokeTest")
    public void moveCreatedTaskToInbox()
    {
        String taskDescription = "Description" + genericMethods.getAlphaNumericString(5);
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

        //MOVE TASK TO INBOX AND ASSERT IS DISPLAYED THERE
        centerMenu.getLastTaskByName(taskName).click();
        editItemModal.editFolderButton.click();
        editItemModal.inboxFolderButton.click();
        editItemModal.closeModal.click();

        leftSideMenu.inboxButton.click();

        Assertions.assertTrue(centerMenu.getLastTaskByName(taskName).isControlDisplayed());

        Session.getInstance().getBrowser().switchTo().alert().getText();

    }

}
