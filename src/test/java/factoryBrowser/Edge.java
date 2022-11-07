package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Edge implements IBrowser
{
    @Override
    public WebDriver create()
    {
        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver.exe");

        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }
}
