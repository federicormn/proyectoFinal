package controlSelenium;

import org.openqa.selenium.By;

public class Checkbox extends Control
{

    public Checkbox(By locator)
    {
        super(locator);
    }

    public Checkbox(By locator, String controlName) {
        super(locator, controlName);
    }

    public void check()
    {
        this.findControl();

        if(!this.control.isSelected())
        {
            this.step("Check the control "+this.controlName);
            control.click();
        }
    }

    public void uncheck()
    {
        this.findControl();
        if(this.control.isSelected())
        {
            this.step("Uncheck the control "+this.controlName);
            control.click();
        }
    }

}
