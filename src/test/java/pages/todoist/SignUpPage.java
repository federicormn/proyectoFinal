package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SignUpPage
{
    public TextBox emailTextBox = new TextBox(By.id("element-0"), "[Email] textbox on Sign up page");
    public TextBox passwordTextbox = new TextBox(By.id("element-3"), "[Password] textbox on Sign up page");
    public Button signUpWithEmailButton = new Button(By.xpath("//button[@class=\"nFxHGeI S7Jh9YX a8af2163 _3d1243b2 _3991076f f9408a0e _8c75067a\"]"), "[Sign up with Email] button on Sign up page");

    public Label unknownErrorMsg = new Label(By.xpath("//div[@class=\"a83bd4e0 _266d6623 _8f5b5f2b f9408a0e\"]"), "[Unknown error] message");

    public void register(String testEmail, String testPassword)
    {
        emailTextBox.waitPresenceOfElement();

        emailTextBox.writeText(testEmail);
        passwordTextbox.writeText(testPassword);
        signUpWithEmailButton.click();
    }
}
