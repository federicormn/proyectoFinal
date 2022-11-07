package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends Control
{

    public TextBox(By locator)
    {
        super(locator);
    }

    public TextBox(By locator, String controlName)
    {
        super(locator, controlName);
    }

    public void setText(String value){
        this.findControl();
        this.step("Set on control: "+controlName+" the value: ["+value+"]");
        this.control.clear();
        this.control.sendKeys(value);
    }

    public void setTextWithEnter(String value)
    {
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value + Keys.ENTER);
    }

    public void writeText(String value)
    {
        this.findControl();
        this.step("Write on control: "+controlName+" the value: ["+value+"]");
        this.control.sendKeys(value);
    }

    public void clearTextBox()
    {
        this.findControl();
        this.control.clear();
    }
    //IMPLEMENT "clearAll" for an array of textboxes

}
