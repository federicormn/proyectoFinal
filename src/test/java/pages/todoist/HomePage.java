package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class HomePage
{
    public Button homeButton = new Button(By.xpath("//button[@class=\"top_bar_btn home_btn\"]"));

    public Button acceptWelcomePopUp = new Button(By.xpath("//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"and text()]"), "[Got it] button on welcome window, on Home page");
    public Button profileSettingsButton = new Button(By.xpath("//button[@class=\"reactist_menubutton top_bar_btn settings_btn\"]"), "[Profile settings] button on home page");
    public Button addProjectButton = new Button(By.xpath("//button[@aria-label=\"Add project\"]"));

    public boolean confirmMatchingEmail(String email)
    {
        Label registeredEmail = new Label(By.xpath("//p[@class='user_menu_email' and text() = '" +email+ "']"));
        if(registeredEmail.isControlDisplayed())
        {
            return true;
        }else
        {
            return false;
        }

    }
}
