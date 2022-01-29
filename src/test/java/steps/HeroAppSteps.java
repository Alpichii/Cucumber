package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.AlertHandler;
import utilities.Driver;
import utilities.ElementUtils;

public class HeroAppSteps {
    WebDriver driver;
    HeroAppHomePage heroAppHomePage;
    HeroAppAddRemoveElementPage heroAppAddRemoveElementPage;
    HeroAppContextMenuPage heroAppContextMenuPage;
    HeroAppFormAuthenticationPage heroAppFormAuthenticationPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        heroAppHomePage = new HeroAppHomePage(driver);
        heroAppAddRemoveElementPage = new HeroAppAddRemoveElementPage(driver);
        heroAppContextMenuPage = new HeroAppContextMenuPage(driver);
        heroAppFormAuthenticationPage = new HeroAppFormAuthenticationPage(driver);
    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String linkText) {
        heroAppHomePage.clickOnLink(linkText);
    }

    @Then("user should see {string} heading")
    public void user_should_see_heading(String headingText) {
        Assert.assertEquals(headingText, heroAppAddRemoveElementPage.mainHeader.getText());
    }

    @Then("user should see {string} button")
    public void user_should_see_button(String buttonText) {
        WebElement element;
        switch (buttonText){
            case "Add Element":
                element = heroAppAddRemoveElementPage.addButton;
                break;
            case "Delete":
                element = heroAppAddRemoveElementPage.deleteButton;
                break;
            default:
                throw new NotFoundException(buttonText + " can not be found!!!");
        }

        Assert.assertTrue(element.isDisplayed());
        Assert.assertTrue(element.isEnabled());
        Assert.assertEquals(buttonText, element.getText());
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttonText) {
        switch (buttonText){
            case "Add Element":
                heroAppAddRemoveElementPage.addButton.click();
                break;
            case "Delete":
                heroAppAddRemoveElementPage.deleteButton.click();
                break;
            case "Login":
                heroAppFormAuthenticationPage.loginButton.click();
                break;
            default:
                throw new NotFoundException(buttonText + " can not be found!!!");
        }
    }

    @Then("user should not see {string} button")
    public void user_should_not_see_button(String buttonText) {
        Assert.assertFalse(ElementUtils.isElementDisplayed(heroAppAddRemoveElementPage.deleteButton));
    }

    @Then("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "Context menu items are custom additions that appear in the right-click menu.":
                Assert.assertEquals(text, heroAppContextMenuPage.getParagraph(0).getText());
                break;
            case "Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert.":
                Assert.assertEquals(text, heroAppContextMenuPage.getParagraph(1).getText());
                break;
            default:
                throw new NotFoundException(text + " can not be found!!!");
        }
    }

    @Then("user should see a rectangle box to right click")
    public void userShouldSeeARectangleBoxToRightClick() {
        Assert.assertTrue(heroAppContextMenuPage.box.isDisplayed());
    }

    @And("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        heroAppFormAuthenticationPage.usernameInputBox.sendKeys(username);
        heroAppFormAuthenticationPage.passwordInputBox.sendKeys(password);
    }

    @Then("user should see a message starts with {string}")
    public void userShouldSeeAMessageStartsWith(String message) {
        Assert.assertTrue(heroAppFormAuthenticationPage.message.getText().startsWith(message));
    }
}