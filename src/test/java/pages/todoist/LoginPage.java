package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage
{
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@aria-describedby=\"element-1\"]"));
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@aria-describedby=\"element-4\"]"));
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"));

    public void login(String userName, String pwd)
    {
        emailTextBox.setText(userName);
        passwordTextBox.setText(pwd);
        loginButton.click();
    }
}
