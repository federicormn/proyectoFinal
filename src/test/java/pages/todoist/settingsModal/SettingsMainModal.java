package pages.todoist.settingsModal;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class SettingsMainModal
{
    public Label settingsLeftHeader = new Label(By.xpath("//h1[@class=\"_71a1610c eb373739 f9408a0e\"]"), "[Settings] header label on the Settings modal");
    public Button accountButton = new Button(By.xpath("//a[@href=\"/app/settings/account\"]"),"[Account] button on Settings modal");
    public Button generalButton = new Button(By.xpath("//a[@href=\"/app/settings/general\"]"), "[General] button on Settings modal");
    public Button updateButton = new Button(By.xpath("//button[@type=\"submit\"]"),"[Update] button on Settings modal");
    public Button closeModalButton = new Button(By.xpath("//header[@class=\"f9408a0e _6e9db9aa _4e9ab24b ad0ccf15 _9510d053 _078feb3c _6cad1a19 _21b8bafa be6deb6a\"]//div[@class=\"_91e05f0f f9408a0e _68ab48ca f8344e0f _867d251e\"][last()]"), "[Close modal] button on Settings modal");


}
