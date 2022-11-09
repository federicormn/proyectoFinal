package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MoreProjectActionsMenu
{
    public Button addSectionButton = new Button(By.xpath("//div[@class=\"icon_menu_item__content\" and contains(text(),'se')]"), "[Add section] button on [Open more project actions] menu");
}
