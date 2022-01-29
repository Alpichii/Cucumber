package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroAppContextMenuPage extends HeroAppBasePage {
    public HeroAppContextMenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "hot-spot")
    public WebElement box;
}