package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AddProjectModal
{
    public Label addProjectLabel = new Label(By.xpath("//header[@class=\"reactist_modal_box__header\"]"));
    public TextBox projectNameTextBox = new TextBox(By.xpath("//input[@id=\"edit_project_modal_field_name\"]"));
    public Button addProjectButton = new Button(By.xpath("//button[@type=\"submit\"]"));

}
