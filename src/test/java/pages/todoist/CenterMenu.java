package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

public class CenterMenu
{
    public Button archivedButton = new Button(By.id("archived"), "[Archived] button on Projects main menu (Center page)");
    public Button moreActionsButton = new Button(By.xpath("(//div[@class=\"view_header__actions f9408a0e _6e9db9aa _6cad1a19 _21b8bafa\"]//button)[last()]"), "[Open more project actions] button on the Project main page");
    public TextBox newSectionNameTextBox = new TextBox(By.xpath("//input[@class=\"name\"]"), "[New Section name] textbox on Project main page");
    public Button addSectionConfirmationButton = new Button(By.xpath("//button[@type=\"submit\"]"), "[Add section] button on Project main page");
    public Button unarchiveProjectButton = new Button(By.xpath("//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"]"), "[Unarchive project] button on Projects main menu (Center page)");
    public Button addTaskButton = new Button(By.xpath("//button[@class=\"plus_add_button\"]"));
    public TextBox taskNameTextBox = new TextBox(By.xpath("//div[@class=\"public-DraftStyleDefault-block public-DraftStyleDefault-ltr\"]"),"[Task name] textbox on Projects main menu (Center page)");
    public TextBox taskDescriptionTextBox = new TextBox(By.xpath("//textarea[@class=\"task_editor__description_field no-focus-marker\"]"), "[Task description] textbox on Projects main menu (Center page)");
    public Button dueDateButton = new Button(By.xpath("//span[@class=\"item_due_selector_text\"]"), "[Due date] button on Projects main menu (Center page)");
    /////////////// TAKE TO A SEPARATED PAGE CLASS
    public Button tomorrowDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_tomorrow\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Tomorrow] option on Calendar modal - Projects main menu (Center page)");
    public Button thisWeekendDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_thisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[This weekend] option on Calendar modal - Projects main menu (Center page)");
    public Button nextWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nextweek\"]//div[@class=\"scheduler-suggestions-item-label\"]"), "[Next week] option on Calendar modal - Projects main menu (Center page)");
    ///////////////
    public Button setPriorityButton = new Button(By.xpath("//button[@data-priority]/span"), "[Set the priority] button on Projects main menu (Center page)");

    public Button addTaskConfirmationButton = new Button(By.xpath("//button[@data-testid=\"task-editor-submit-button\"]"), "[Add task] confirmation button on Projects main menu (Center page)");

    public Label projectCreationMenu = new Label(By.xpath("//li[@class=\"manager indent_1\"]") , "[Task creation area] on Projects main menu (Center page)");

    public Button loadMoreElementsButton = new Button(By.xpath("//button[@class=\"load_more\"]"),"[Load more] button on Completed Tasks page");

    public Label tasksList = new Label(By.xpath("//div[@id=\"activity_app\"]/section"));


    public Button getLastTaskByName(String taskName)
    {
        Button selectedTask = new Button(By.xpath("(//ul[@class='items']//li//div[text()='"+taskName+"'])[last()]"), "["+taskName+"] button on Projects main menu (Center page)");

        return selectedTask;
    }

    public Button pickPriority(String priorityNumber) //VALUES = 1-2-3-4
    {
        return new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and contains(text(),'"+priorityNumber+"')]"),"[Priority "+priorityNumber+"] inside [Priority] Listbox, on Task Creation Area");
    }

    public Button getLastArchivatedByName(String archivatedProjectName)
    {
        return new Button(By.xpath("(//div[@class=\"a83bd4e0 e214ff2e f9408a0e\" and text()='"+archivatedProjectName+"'])[last()]"), "["+archivatedProjectName+"] button on Archivated Projects menu (Center page)");
    }

    public Button getSectionByName(String sectionName)
    {
        return new Button(By.xpath("//button[contains(@aria-label,'"+sectionName+"')]/span"), "["+sectionName+"] button on Project Sections list");
    }

    public Button getCheckButtonForTaskByName(String taskName)
    {
        return new Button(By.xpath("(//ul[@class='items']//div[text()='"+taskName+"'])[last()]/.././parent::div/../preceding-sibling::button//div"), "[Check task] button on Project main menu");
    }

    public Button getCompletedTaskByName(String completedTaskName)
    {
        return new Button(By.xpath("(//a[contains(@href,'task')]/div[text()='"+completedTaskName+"'])[last()]"), "["+completedTaskName+"] completed task on Activity List (Center Page)");
    }
}
