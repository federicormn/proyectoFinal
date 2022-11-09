package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class EditItemModal
{
    public Button editDueDateButton = new Button(By.xpath("//button[@class=\"PkhZiTa _9KUWmzz a8af2163 _98cd5c3f _45ffe137 f9408a0e _8c75067a\"]"));
    //////////////////////
    public Button todayDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_today\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button tomorrowDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_tomorrow\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button laterThisWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_laterthisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button thisWeekendDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_thisweekend\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button nextWeekDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nextweek\"]//div[@class=\"scheduler-suggestions-item-label\"]"));
    public Button noDateDueDateButton = new Button(By.xpath("//button[@data-track=\"scheduler|date_shortcut_nodate\"]//div[@class=\"scheduler-suggestions-item-label\"]"));

    ///////////////
    public Button selectNewPriority = new Button(By.xpath("//div[contains(@aria-label,'Pri')]//button"));

    public Button pickPriority1 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 1\"]"));
    public Button pickPriority2 = new Button(By.xpath("//span[text()=\"Priority 2\"]"));
    public Button pickPriority3 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 3\"]"));
    public Button pickPriority4 = new Button(By.xpath("//span[@class=\"priority_picker_item_name\" and text()=\"Priority 4\"]"));

    public Button moreActionsButton = new Button(By.xpath("//button[@aria-label=\"More actions\"]"));
    public Button deleteTask = new Button(By.xpath("//*[contains(text(),\"Delete task\")]"));
    public Button deleteConfirmationButton = new Button(By.xpath("//span[contains(text(),\"Delete\")]"));
    public Button closeModal = new Button(By.xpath("(//button[@class=\"a8af2163 _98cd5c3f _352995bd ef4c88db f9408a0e\"])[last()]"));


    public Button choosePriority(String priorityNumber)
    {

        return new Button(By.xpath("//span[contains(text(),'"+priorityNumber+"')]"));
    }

}
