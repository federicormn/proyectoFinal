package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

public class OAuthLoginPage
{
    public TextBox oAuthEmailTextBox = new TextBox(By.xpath("//input[@autocomplete=\"username\"]"), "[Google Email] textbox on OAuth Login page");
    public TextBox oAuthPasswordTextBox = new TextBox(By.xpath("//input[@name=\"password\"]"),"[Google Password] textbox on OAuth Login page");
    public Button nextButton = new Button(By.xpath("//span[text()=\"Siguiente\"]"), "[Next] button on OAuth Login page");
}
