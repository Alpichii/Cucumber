package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroAppAddRemoveElementPage extends HeroAppBasePage{
    public HeroAppAddRemoveElementPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3")
    public WebElement mainHeading;

    @FindBy(xpath = "//button[@onclick='addElement()']")
    public WebElement addButton;

    @FindBy(xpath = "//button[@onclick='deleteElement()']")
    public WebElement deleteButton;
}