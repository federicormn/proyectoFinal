package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditItemModal
{
    public Button editFolderButton = new Button(By.xpath("//span[@class=\"z3lsAU6\"]"), "[Project folder] listbox button on [Edit task] modal");
    public Button inboxFolderButton = new Button(By.xpath("//div[contains(text(),'Bandeja') or contains(text(),'Inbox')]"), "[Inbox folder] option inside [Project folder] listbox");
    public Button taskNameButton = new Button(By.xpath("//div[@class=\"task-overview-main\"]//div[@class=\"markdown_content task_content\"]"),"[Task name] button on [Edit task] modal");
    public TextBox taskNameTextBox = new TextBox(By.xpath("//div[@class=\"DraftEditor-editorContainer\"]"),"[Task name] editable textbox on [Edit task] modal");
    public Button saveTaskNameButton = new Button(By.xpath("//span[text()='Guardar' or text()='Save']"),"[Save] button on Task name editing area, on [Edit task] modal");
    public Button editDueDateButton = new Button(By.xpath("//button[@class=\"PkhZiTa _9KUWmzz a8af2163 _98cd5c3f _45ffe137 f9408a0e _8c75067a\"]"), "[Edit due date] button on [Edit task] modal");
    //////////////////////
    public Button todayDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_today\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Today] button on [Due date] listbox");
    public Button tomorrowDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_tomorrow\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Tomorrow] button on [Due date] listbox");
    public Button laterThisWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_laterthisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Later this week] button on [Due date] listbox");
    public Button thisWeekendDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_thisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[This weekend] button on [Due date] listbox");
    public Button nextWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nextweek\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Next week] button on [Due date] listbox");
    public Button noDateDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nodate\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[No date] button on [Due date] listbox");

    ///////////////
    public Button selectNewPriority = new Button(By.xpath("//div[contains(@aria-label,'Pri')]//button"), "[Priority] button on [Edit task] modal");

    public Button moreActionsButton = new Button(By.xpath("//div[@class=\"f9408a0e _6e9db9aa _6cad1a19\"]//button[@class=\"a8af2163 _98cd5c3f _352995bd ef4c88db f9408a0e\" and contains(@aria-label,'ac')]"),"[More Actions] button on [Edit Task] modal");
    public Button deleteTask = new Button(By.xpath("(//div[@class=\"a83bd4e0 a8d37c6e f9408a0e\"])[last()]"),"[Delete task] button inside [More actions] button on [Edit task] modal");
    public Button deleteConfirmationButton = new Button(By.xpath("//span[contains(text(),\"Delete\")]"));

    public Button subTasksListButton = new Button(By.xpath("//span[contains(text(),'Sub')]"), "[Sub-tasks] button inside [Edit task] modal");
    public Button addSubTaskButton = new Button(By.xpath("//span[contains(text(),'sub')]"), "[Add subtask] button inside [Edit task] modal");
    public TextBox subTaskNameTextBox = new TextBox(By.xpath("(//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"])[last()]"), "[Subtask name] textbox inside [Edit task] modal");
    public TextBox subTaskDescriptionTextBox = new TextBox(By.xpath("(//textarea[@class=\"task_editor__description_field no-focus-marker\"])[last()]"), "[Subtask description] textbox inside [Edit task] modal");

    public Button commentsSectionButton = new Button(By.xpath("(//span[@class=\"a83bd4e0 a8d37c6e _7be5c531 f9408a0e\"])[last()]"), "[Comments] list button inside [Edit task] modal");
    public Button commentButton = new Button(By.xpath("//button[@data-testid=\"open-comment-editor-button\"]"), "[Comment] button inside [Edit task] modal");
    public TextBox commentTextBox = new TextBox(By.xpath("//p[@class=\"is-empty is-editor-empty\"]"), "[Comment] textbox inside [Edit task] modal");
    public Button addCommentConfirmationButton = new Button(By.xpath("(//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"])[last()]"), "[Comment] confirmation button inside [Edit task] modal");
    public Button addSubTaskConfirmationButton = new Button(By.xpath("(//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"])[last()]"), "[Add subtask] button inside [Edit task] modal");
    public Button closeModal = new Button(By.xpath("(//button[@class=\"a8af2163 _98cd5c3f _352995bd ef4c88db f9408a0e\"])[last()]"), "[Close modal] button on [Edit task] modal");


    public Button choosePriority(String priorityNumber)
    {

        return new Button(By.xpath("(//span[contains(text(),'"+priorityNumber+"')])[last()]"), "[Priority "+priorityNumber+"] option on [Priority] listbox");
    }

    public Button getSubTaskByName(String subTaskName)
    {
        return new Button(By.xpath("(//ul[@class='items']//div[text()='"+subTaskName+"'])[last()]"),"["+subTaskName+"] button inside [Edit task] modal");
    }

    public boolean searchLastMatchingCommentByContent(String content)
    {
        Label commentContent = new Label(By.xpath("(//div[@class='comments_meta note_meta']//following-sibling::div//p[text()='"+content+"'])[last()]"), "["+content+"] comment on [Edit task] modal");
        if(commentContent.isControlDisplayed())
        {
            return true;
        }else
        {
            return false;
        }
    }


}
