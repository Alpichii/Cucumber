package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroAppFormAuthenticationPage extends HeroAppBasePage{
    public HeroAppFormAuthenticationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(className = "radius")
    public WebElement loginButton;

    @FindBy(id = "flash")
    public WebElement message;
}