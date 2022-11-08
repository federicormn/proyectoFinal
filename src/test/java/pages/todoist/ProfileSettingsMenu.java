package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class ProfileSettingsMenu
{
    public Button settingsButton = new Button(By.xpath("//div/span[@class=\"user_menu_label\"]"), "[Settings] button on Profile Settings Menu");
    public Button logOutButton = new Button(By.xpath("//div[@aria-label=\"Settings menu\"]/button[last()]"), "[Log out] button on Profile Settings Menu");
}
