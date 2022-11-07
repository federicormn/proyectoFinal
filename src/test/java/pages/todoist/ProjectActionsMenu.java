package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ProjectActionsMenu
{
    public Button editProjectButton = new Button(By.xpath("//div[@class=\"icon_menu_item__content\" and text()=\"Edit project\"]"));
    public Button deleteProjectButton = new Button(By.xpath("//div[@class=\"icon_menu_item__content\" and text()=\"Delete project\"]"));

}
