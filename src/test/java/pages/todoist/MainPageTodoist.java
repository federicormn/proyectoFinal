package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MainPageTodoist
{
    public Button logInButton = new Button(By.xpath("//ul[@class=\"mFaV87MJWaQZl7X1C1h7 E0P5UcSTEIil0sB3ZHqw\"]//a[@class=\"Z2j5FoeQ_umI7vX0SmxF Y5eL4cjJHcHaCQ8EbL7V\"]"));

    public Button startFroFreeButton = new Button(By.xpath("//ul//a[@href=\"/auth/signup\"]"),"[Start for free] button on the main page");

    public Button startForFree2 = new Button(By.xpath("//h2[@class=\"Z2j5FoeQ_umI7vX0SmxF VB6LgUAmqv1DrUQhn1Tq\"]/following-sibling::a[text()=\"Start for free\"][last()]"), "[Start for free] button on the main page");

}
