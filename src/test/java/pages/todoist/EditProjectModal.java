package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal
{
    public TextBox editProjectNameTextBox = new TextBox(By.xpath("//input[@id=\"edit_project_modal_field_name\"]"), "[Edit project name] textbox on [Edit project] modal");
    public Button saveEditButton = new Button(By.xpath("//button[@type=\"submit\"]"), "[Save] button on [Edit project] modal");
}
