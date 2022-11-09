package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ProjectActionsMenu
{
    public Button editProjectButton = new Button(By.xpath("//div[@class=\"icon_menu_item__content\" and contains(text(),'Edit')]"),"[Edit project] button on More Project Actions menu");
    public Button archiveProjectButton = new Button(By.xpath("//div[@class=\"icon_menu_item__content\" and contains(text(),'Arch')]"), "[Archive project] button on More Project Actions menu");
    public Button deleteProjectButton = new Button(By.xpath("//li[@role=\"menuitem\"][last()]//div[@class=\"icon_menu_item__content\"]"),"[Delete project] button on More Project Actions menu");

}
