package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class CenterMenu
{
    public Button archivedButton = new Button(By.id("archived"), "[Archived] button on Projects main menu (Center page)");
    public Button addTaskButton = new Button(By.xpath("//button[@class=\"plus_add_button\"]"));
    public TextBox taskNameTextBox = new TextBox(By.xpath("//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
    //public TextBox taskNameTextBox2 = new TextBox(By.xpath("//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"));
    public TextBox taskDescriptionTextBox = new TextBox(By.xpath("//textarea[@class=\"task_editor__description_field no-focus-marker\"]"));
    public Button dueDateButton = new Button(By.xpath("//span[@class=\"item_due_selector_text\"]"));
    public Button tomorrowDueDateButton = new Button(By.xpath("//div[@class=\"scheduler-suggestions-item-label\" and text()=\"Tomorrow\"]"));
    public Button nextWeekDueDateButton = new Button(By.xpath("//div[@class=\"scheduler-suggestions-item-label\" and text()=\"Next week\"]"));
    public Button setPriorityButton = new Button(By.xpath("//button[@aria-label=\"Set the priority\"]"));

    public Button pickPriority1 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 1\"]"));
    public Button pickPriority2 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 2\"]"));
    public Button pickPriority3 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 3\"]"));
    public Button pickPriority4 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 4\"]"));

    public Button addTaskConfirmationButton = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"));

    public Label projectCreationMenu = new Label(By.xpath("//li[@class=\"manager indent_1\"]"));


    public Button getLastTaskByName(String taskName)
    {
        Button selectedTask = new Button(By.xpath("//ul//li[last()]//li[@aria-selected=\"false\"][last()]//div[@class='markdown_content task_content' and text()='"+taskName+"']"));

        return selectedTask;
    }

    public Button getLastArchivatedByName(String archivatedProjectName)
    {
        return new Button(By.xpath("(//div[@class=\"a83bd4e0 e214ff2e f9408a0e\" and text()='"+archivatedProjectName+"'])[last()]"));
    }
}
