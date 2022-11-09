package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Control;
import org.openqa.selenium.By;
import singletonSession.Session;

public class CaducatedSessionPopUp
{
    public Control iFramePopUp = new Control(By.xpath("//iframe[@name=\"__privateStripeMetricsController1600\"]"), "[Caducated Session] Pop Up IFrame");
    public Button caducatedSessionOkButton = new Button(By.xpath("//a[@href=\"#\"]"),"[OK] button on Caducated Session Pop up");

    public void closePopUpIfCaducatedSession()
    {
        if(iFramePopUp.isControlDisplayed())
        {
            Session.getInstance().switchIFrame("__privateStripeMetricsController1600");
            caducatedSessionOkButton.waitClickable();
            caducatedSessionOkButton.click();
            Session.getInstance().switchToDefault();
        }
    }
}
