package controlSelenium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control
{
    protected By locator;
    protected WebElement control;
    protected String controlName; // reflection

    public Control(By locator)
    {
        this.locator = locator;
    }

    public Control (By locator, String controlName)
    {
        this.locator=locator;
        this.controlName=controlName;
    }

    protected void findControl()
    {
        control = Session.getInstance().getBrowser().findElement(this.locator);
        //explicit wait/s (clickable/visible/isDisplayed)
    }

    @Step("{0}")
    public void step(String action)
    {

    }

    public void click()
    {
        this.findControl();
        control.click();
    }

    public boolean isControlDisplayed()
    {
        try {
            this.findControl();
            this.step("Check the "+controlName+" is displayed: true");
            return control.isDisplayed();
        }catch(Exception e)
        {
            this.step("Check the "+controlName+" is displayed: false");
            return false;
        }
    }

    public String getText()
    {
        this.findControl();
        this.step("Get Text from "+controlName+", the value is: "+control.getText());
        return control.getText();
    }

    public String getAttribute(String attribute)
    {
        this.findControl();
        return this.control.getAttribute(attribute);
    }

    public void waitClickable()
    {
        // todo --> factory para instanciar el wait una sola vez
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }

    public void waitControl(By locator, int timeOut) throws InterruptedException {
        Label test = new Label(this.locator);
        int i = 0;
        do
        {
            Thread.sleep(1000);
            i++;
            this.control.click();

        }while (!test.isControlDisplayed() || i<= timeOut);
    }

    public void waitPresenceOfElement()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(this.locator));
    }

    public void waitTextToBePresent(String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(this.locator, value));
    }

    public void waitTextToDissapear(String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(this.locator, value)));
    }

    public void waitAttributeToBe(String attribute, String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(this.locator, attribute, value));
    }

    public void waitAttributeNotToBe(String attribute, String value)
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(this.locator, attribute, value)));
    }

    public void waitVisibilityOfElement()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void waitInvisvilityofElement()
    {
        WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
    }

    public void clickAndWaitResponse(boolean condition) throws InterruptedException {
        do
        {
            this.control.click();
            Thread.sleep(500);

        }while(!condition);

    }

    public void makeRightClickAction()
    {
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.contextClick(this.control).perform();
    }

    public void hoverAction()
    {
        this.findControl();
        Actions action = new Actions(Session.getInstance().getBrowser());
        action.moveToElement(this.control).perform();
    }


}
