package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class DeleteProjectWindow
{
    public Button confirmDeleteButton = new Button(By.xpath("//button[@class=\"a8af2163 _3d1243b2 _352995bd f9408a0e _56a651f6\"]"),"[Delete] button on Delete Project window");
    public Button confirmArchiveButton = new Button(By.xpath("//button[@class=\"a8af2163 _3d1243b2 _352995bd f9408a0e _56a651f6\"]"),"[Archive] button on Delete Project window");

}
