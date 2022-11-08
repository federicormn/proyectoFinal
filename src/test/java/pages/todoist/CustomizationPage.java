package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class CustomizationPage
{
    public Button skipButton = new Button(By.xpath("//nav[@class=\"focus-marker-enabled-within f9408a0e _6e9db9aa _6cad1a19 d8eaf780 _26f87bb8\"]//button"), "[Skip] button on Customization (for new account) page");
}
