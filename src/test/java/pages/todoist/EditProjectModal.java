package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditProjectModal
{
    public TextBox editProjectNameTextBox = new TextBox(By.xpath("//input[@id=\"edit_project_modal_field_name\"]"));
    public Button saveEditButton = new Button(By.xpath("//button[@type=\"submit\"]"));
}
