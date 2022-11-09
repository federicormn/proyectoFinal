package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

import javax.swing.plaf.PanelUI;

public class HomePage
{
    public Button homeButton = new Button(By.xpath("//button[@class=\"top_bar_btn home_btn\"]"));

    public Button acceptWelcomePopUp = new Button(By.xpath("//span[@class=\"bbdb467b f9408a0e _31cf99c5 _473810b4\"and text()]"), "[Got it] button on welcome pop up window, on Home page");
    public Button closeWelcomeModalButton = new Button(By.xpath("//button[@aria-label=\"Close modal\"]"), "[Close modal] button on welcome pop up window, on Home page");
    public Label welcomePopUpHeader = new Label(By.id("web_archived_projects_access-heading"), "[Welcome Pop up Header] on Welcome pop up window");

    public Button profileSettingsButton = new Button(By.xpath("//button[@class=\"reactist_menubutton top_bar_btn settings_btn\"]"), "[Profile settings] button on home page");
    public Button openProductivityButton = new Button(By.id("top_completed_holder"), "[Open Productivity] button on Home page");
    public Button addProjectButton = new Button(By.xpath("//a[@href=\"/app/projects\"]/following-sibling::button[@class=\"a8af2163 _98cd5c3f _45ffe137 ef4c88db f9408a0e\"]"), "[Add project] button on the Home page Left Side");

    public Button undoButton = new Button(By.xpath("//button[text()='Deshacer' or text()='Undo']"), "[Undo] pop-up button on bottom center page");

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

    public void closeWelcomeWindowIfPresent()
    {

        if(acceptWelcomePopUp.isControlDisplayed() && closeWelcomeModalButton.isControlDisplayed() && welcomePopUpHeader.isControlDisplayed())
        {
            System.out.println(" ------ IF DEL WELCOME POP UP");
            acceptWelcomePopUp.waitClickable();
            acceptWelcomePopUp.click();
        }
        acceptWelcomePopUp.waitInvisvilityofElement();
    }
}
