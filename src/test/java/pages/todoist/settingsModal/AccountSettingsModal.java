package pages.todoist.settingsModal;

import controlSelenium.Button;
import controlSelenium.Label;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class AccountSettingsModal
{
    public TextBox nameTextBox = new TextBox(By.xpath("//input[@name='name']"), "[Name] textbox on Account Settings modal");
    public Label currentEmailLabel = new Label(By.xpath("//div[@class=\"a83bd4e0 f9408a0e\"]"),"[Email] label on Account Settings modal");
    public Button changeEmailButton = new Button(By.xpath("//a[@href=\"/app/settings/account/email\"]/span"),"[Change email] button on Account Settings modal");
    public TextBox newEmailTextBox = new TextBox(By.xpath("//div[@class=\"_5641699f f9408a0e\"]/following-sibling::div//input[@type=\"email\"]/parent::div/parent::div/parent::div/preceding-sibling::div[@class=\"_5641699f f9408a0e\"]//input"), "[New email] textbox on Change email modal");
    public TextBox confirmNewEmailTextBox = new TextBox(By.xpath("//div[@class=\"_5641699f f9408a0e\"]/following-sibling::div//input[@type=\"email\"]"), "[New email] textbox on Change email modal");
    public TextBox todoistPasswordForEmail = new TextBox(By.xpath("//input[@autocomplete=\"off\" and @type=\"password\"]"), "[New email] textbox on Change email modal");


    public Button changePasswordButton = new Button(By.xpath("//a[@href=\"/app/settings/account/password\"]"), "[Change password] button on Account Settings modal");
    public TextBox currentPasswordTextBox = new TextBox(By.xpath("//input[@autocomplete=\"off\" and @type=\"password\"]"), "[Current password] textbox on Change Password modal");

    //Se utilizó este locator porque de otra manera no se logró identificar al elemento.
    public TextBox newPasswordTextBox = new TextBox(By.xpath("//form/div/div/div/div[2]/div/div/input"),"[New password] textbox on Change Password modal");
    public TextBox newPasswordTextBox2 = new TextBox(By.xpath("//span[contains(text(),'New') or contains(text(),'Nueva')]/../../..//input"),"[New password] textbox on Change Password modal");
    public TextBox confirmNewPasswordTextBox = new TextBox(By.xpath("//*[@class=\"_5641699f f9408a0e\"][last()]//input[@autocomplete=\"new-password\"]"),"[Confirm new password] textbox on Change Password modal");
    public Button confirmChangePasswordButton = new Button(By.xpath("//button[@type=\"submit\"]/span"),"[Change password] button on Change Password modal");
    public Label unknownErrorLabel = new Label(By.xpath("//div[@class=\"a83bd4e0 _8f5b5f2b f9408a0e\"]"));
    public Button deleteAccountButton = new Button(By.xpath("//a[@href=\"/app/settings/account/delete\"]//span"), "[Delete account] button on Account Settings modal");

    public TextBox todoistPasswordTextBox = new TextBox(By.xpath("//input[@name=\"password\"]"), "[Todoist password] textbox on Delete account modal");

}
