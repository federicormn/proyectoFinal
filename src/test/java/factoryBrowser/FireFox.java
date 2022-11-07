package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFox implements IBrowser
{

    @Override
    public WebDriver create()
    {
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }

}

