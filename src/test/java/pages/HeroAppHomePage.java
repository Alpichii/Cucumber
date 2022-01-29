package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeroAppHomePage {
    public HeroAppHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul//a")
    public List<WebElement> links;

    public void clickOnLink(String linkText){
        for (WebElement link : links) {
            if(link.getText().equals(linkText)){
                link.click();
                break;
            }
        }
    }
}