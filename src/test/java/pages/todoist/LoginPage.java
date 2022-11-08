package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage
{
    public Button continueWithGoogleButton = new Button(By.xpath("//span[contains(text(),\"Google\")]"), "[Continue with Google] button on login page");
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@aria-describedby=\"element-1\"]"), "[Email] textbox on login page");
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@aria-describedby=\"element-4\"]"),"[Password] textbox on login page");
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"),"[Login] button on login page");

    public Label wrongEmailOrPasswordLabel = new Label(By.xpath("//div[@class=\"a83bd4e0 _266d6623 _8f5b5f2b f9408a0e\"]/text()"), "[Please enter a valid email address] message on Login page");

    public void login(String userName, String pwd)
    {
        emailTextBox.setText(userName);
        passwordTextBox.setText(pwd);
        loginButton.click();
    }
}
