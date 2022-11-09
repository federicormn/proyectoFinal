package pages.todoist.settingsModal;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class GeneralSettingsModal
{
    public TextBox languageListBox = new TextBox(By.xpath("//select[@name=\"language\"]"), "[Language] listbox on General Settings modal");

    public Button selectLanguage(String option, String language)
    {
        language = "[" + language + "]";
        return new Button(By.xpath("//option[@value='"+option+"']"), language+" option on the [Language] listbox");
    }

}
