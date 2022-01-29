package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeroAppBasePage {

    @FindBy(tagName = "h3")
    public WebElement mainHeader;

    @FindBy(tagName = "p")
    public List<WebElement> paragraphs;

    public WebElement getParagraph(int index){
        return paragraphs.get(index);
    }
}