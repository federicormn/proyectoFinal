package factoryBrowser;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Cloud implements IBrowser
{

//    Credentials for BrowserStack
//    setx BROWSERSTACK_USERNAME "federicoroman_hIf4Wm"
//    setx BROWSERSTACK_ACCESS_KEY "XCkfEndpQV1dAxpsBPxt"
//    set BROWSERSTACK_USERNAME=federicoroman_hIf4Wm
//    set BROWSERSTACK_ACCESS_KEY=XCkfEndpQV1dAxpsBPxt

    @Override
    public WebDriver create() {
        WebDriver driver;
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, String> bstackOptionsMap = new HashMap<String, String>();
        bstackOptionsMap.put("userName", "federicoroman_hIf4Wm");
        bstackOptionsMap.put("accessKey", "XCkfEndpQV1dAxpsBPxt");
        bstackOptionsMap.put("os", "Windows");
        bstackOptionsMap.put("osVersion", "10");
        bstackOptionsMap.put("browserName", "Chrome");
        bstackOptionsMap.put("browserVersion", "latest");
        capabilities.setCapability("bstack:options", bstackOptionsMap);
        try {
            driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}

