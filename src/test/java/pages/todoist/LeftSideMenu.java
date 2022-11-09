package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class LeftSideMenu
{
    public Button projectsButton = new Button(By.xpath("//a[@href=\"/app/projects\"]/div"),"[Projects] button on Home page Left Side menu");
    public Button lastProject = new Button(By.xpath("//ul[@id=\"projects_list\"]//li[last()]//span[last() and @class=\"FnFY2YlPR10DcnOkjvMMmA==\"]"),"[Last Project] button on Home page Left Side menu");
    public Button lastProjectActionsButton = new Button(By.xpath("//li[last()]//div[@class=\"fgALZGUA6SZg9blSarq2hg== _7DCqR7o3BYjme7edphDp8A== f9408a0e _0e4ff085\" and last()]"));
    public Label projectList = new Label(By.xpath("//ul[@id=\"projects_list\"]"));

    public Button searchLastMatchingProject(String projectName)
    {
        return new Button(By.xpath("(//ul//li//span[text()='"+projectName+"'])[last()]"),"["+projectName+"] button on the Home page Left Side menu");
    }

    public Button searchLastMatchingFavorite(String favoriteProjectToSearch)
    {
        return new Button(By.xpath("(//ul[contains(@aria-label,'Fav')]//span[text()='"+favoriteProjectToSearch+"'])[last()]"), "["+favoriteProjectToSearch+"] button on the Home page Left Side Favorites list");
    }
}

