package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class EditItemModal
{
    public Button editDueDateButton = new Button(By.xpath("//button[@class=\"PkhZiTa _9KUWmzz a8af2163 _98cd5c3f _45ffe137 f9408a0e _8c75067a\"]"));
    public Button nextWeekDueDateButton = new Button(By.xpath("//div[@class=\"scheduler-suggestions-item-label\" and text()=\"Next week\"]"));
    public Button selectNewPriority = new Button(By.xpath("//div[@aria-label=\"Priority\"]//span[@class=\"bbdb467b f9408a0e d745aa1e _473810b4 _8c75067a\"]"));

    public Button pickPriority1 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 1\"]"));
    public Button pickPriority2 = new Button(By.xpath("//span[text()=\"Priority 2\"]"));
    public Button pickPriority3 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 3\"]"));
    public Button pickPriority4 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 4\"]"));

    public Button moreActionsButton = new Button(By.xpath("//button[@aria-label=\"More actions\"]"));
    public Button deleteTask = new Button(By.xpath("//*[contains(text(),\"Delete task\")]"));
    public Button deleteConfirmationButton = new Button(By.xpath("//span[contains(text(),\"Delete\")]"));
    public Button closeModal = new Button(By.xpath("//button[@aria-label=\"Close modal\"]"));


    public Button choosePriority(String priorityNumber)
    {
        Button chosenPriority = new Button(By.xpath("//span[text()='Priority" +priorityNumber+"']"));

        return chosenPriority;
    }

}
