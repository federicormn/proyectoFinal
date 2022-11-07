package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserDocker implements IBrowser
{
    String virtualMachineURL = "http://192.168.100.26:4444/wd/hub";

    @Override
    public WebDriver create()
    {
        WebDriver driver;
        //Capabilities capabilities = new DesiredCapabilities();
        ChromeOptions capabilities = new ChromeOptions();
        try {
                driver = new RemoteWebDriver(new URL(virtualMachineURL), capabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            } catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
