package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ProductivityModal
{
    public Button viewAllCompletedTasks = new Button(By.xpath("//a[@data-track=\"karma|view_completed_tasks\"]"), "[View all completed tasks] button on [Open Productivity] modal");
}
