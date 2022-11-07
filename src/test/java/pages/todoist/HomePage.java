package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class HomePage
{
    public Button homeButton = new Button(By.xpath("//button[@class=\"top_bar_btn home_btn\"]"));
    public Button addProjectButton = new Button(By.xpath("//button[@aria-label=\"Add project\"]"));
}
