package singletonSession;

import controlSelenium.Control;
import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import utils.GetProperties;

import java.util.ArrayList;

public class Session
{
    private static Session session = null;
    private WebDriver browser;

    private Session()
    {
        //SE LLAMA UNA UNICA VEZ -- TO-DO CREATE PROPERTIES FILE (browser) - NO USAR VALORES QUEMADOS (CHECKED)
        browser = FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
    }

    public static Session getInstance() //SIN SYNCHRONIZED PARA EJECUCIONES PARALELAS
    {
        if( session == null)
        {
            session = new Session();
        }
        return session;
    }

    public void closeBrowser()
    {
        browser.quit();
        session = null; //MATA EL SINGLETON Y CIERRA LA SESION
    }

    public WebDriver getBrowser() {
        return browser;
    }

    //TODO --> tabs /windows /iframes/alerts

    //Implementation of iFrames
    public void switchIFrame(String iFrameId)
    {
        getInstance().getBrowser().switchTo().frame(iFrameId);
    }
    public void switchIFrameByIndex(int index)
    {
        getInstance().getBrowser().switchTo().frame(0);
    }

    public void switchToDefault()
    {
        getInstance().getBrowser().switchTo().defaultContent();
    }


    public void moveToTab(String tabURL)
    {
        browser.navigate().to(tabURL);
        browser.switchTo().window(browser.getWindowHandle());
    }

    public void testTabs()
    {
        //browser.get("https://business.twitter.com/start-advertising"); --> IS EXECUTED ON BEFOREEACH METHOD
        //assertStartAdvertising();

        // considering that there is only one tab opened in that point.
        String oldTab = browser.getWindowHandle();
        //browser.findElement(By.linkText("Twitter Advertising Blog")).click(); -->
        ArrayList<String> newTab = new ArrayList<String>(browser.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        browser.switchTo().window(newTab.get(0));
        //assertAdvertisingBlog();

        // Do what you want here, you are in the new tab

        browser.close();
        // change focus back to old tab
        browser.switchTo().window(oldTab);
        //assertStartAdvertising(); -->

        // Do what you want here, you are in the old tab
    }

    public void switchTab(String currentTab)
    {
        for (String tab : browser.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                browser.switchTo().window(tab);
            }
        }
    }
    public void closeTabAndReturnToCurrent(String currentTab)
    {
        browser.close();
        browser.switchTo().window(currentTab);
    }
}


