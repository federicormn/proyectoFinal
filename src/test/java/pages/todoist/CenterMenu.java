package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class CenterMenu
{
    public Button archivedButton = new Button(By.id("archived"), "[Archived] button on Projects main menu (Center page)");
    public Button unarchiveProjectButton = new Button(By.xpath("//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"]"), "[Unarchive project] button on Projects main menu (Center page)");
    public Button addTaskButton = new Button(By.xpath("//button[@class=\"plus_add_button\"]"));
    public TextBox taskNameTextBox = new TextBox(By.xpath("//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
    //public TextBox taskNameTextBox2 = new TextBox(By.xpath("//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
    public TextBox taskDescriptionTextBox = new TextBox(By.xpath("//textarea[@class=\"task_editor__description_field no-focus-marker\"]"));
    public Button dueDateButton = new Button(By.xpath("//span[@class=\"item_due_selector_text\"]"));
    /////////////// TAKE TO A SEPARATED PAGE CLASS
    public Button tomorrowDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_tomorrow\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button thisWeekendDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_thisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button nextWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nextweek\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    ///////////////
    public Button setPriorityButton = new Button(By.xpath("//button[@data-priority]/span"));

    public Button pickPriority1 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'1')]"));
    public Button pickPriority2 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'2')]"));
    public Button pickPriority3 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'3')]"));
    public Button pickPriority4 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'4')]"));

    public Button addTaskConfirmationButton = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));

    public Label projectCreationMenu = new Label(By.xpath("//li[@class=\"manager indent_1\"]"));


    public Button getLastTaskByName(String taskName)
    {
        Button selectedTask = new Button(By.xpath("//ul//li[last()]//li[@aria-selected=\"false\"][last()]//div[@class='markdown_content task_content' and text()='"+taskName+"']"));

        return selectedTask;
    }

    public Button pickPriority(String priorityNumber) //VALUES = 1-2-3-4
    {
        return new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'"+priorityNumber+"')]"),"[Priority "+priorityNumber+"] inside [Priority] Listbox, on Task Creation Area");
    }

    public Button getLastArchivatedByName(String archivatedProjectName)
    {
        return new Button(By.xpath("(//div[@class=\"a83bd4e0 e214ff2e f9408a0e\" and text()='"+archivatedProjectName+"'])[last()]"));
    }
}
