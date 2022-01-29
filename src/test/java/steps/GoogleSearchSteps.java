package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;
import utilities.Driver;
import utilities.Waiter;

public class GoogleSearchSteps{
    public WebDriver driver;
    public GoogleSearchPage googleSearchPage;
    public GoogleSearchResultPage googleSearchResultPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
    }

    @When("user searches for {string}")
    public void userSearchesFor(String key) {
        googleSearchPage.searchInputBox.sendKeys(key + Keys.ENTER);
        Waiter.pause(2);
    }

    @Then("user should see {string} in the url")
    public void userShouldSeeInTheUrl(String key) {
        Assert.assertTrue(driver.getCurrentUrl().contains(key));
    }

    @And("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }

    @Then("user should see results are more than {int}")
    public void userShouldSeeResultsAreMoreThan(int results) {
        String resultText = googleSearchResultPage.searchResults.getText();
        long actualIntResult = Long.parseLong(resultText.substring(resultText.indexOf(" ")+1, resultText.indexOf("results")-1).replace(",", ""));
        Assert.assertTrue(actualIntResult > results);
    }
}