package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.HomePage;
import org.example.pageobject.pages.SearchPage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.driver;

public class SearchTestSteps {
    @Given("User is on {string}")
    public void userIsOn(String pageName) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        PAGES_STORAGE.put(pageName, homePage);

    }

    @When("User enters search phrase as {string}")
    public void userEntersSearchPhraseAs(String searchInput) {
        SearchPage searchPage = (SearchPage) ((HomePage) PAGES_STORAGE.get("Home Page")).search(searchInput);
        PAGES_STORAGE.put("Search Page", searchPage);
    }

    @Then("User should see {string} message on {string}")
    public void userShouldSeeMessageOn(String expectedMessage, String pageName) {
        String actualMessage = ((SearchPage) PAGES_STORAGE.get(pageName)).getResultsForPhrase();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Results search phrase is not the same as input search phrase");
    }

    @Then("User should see {string} error message on {string}")
    public void userShouldSeeErrorMessageOn(String expectedErrorMessage, String pageName) {
        String actualErrorMessage = ((SearchPage) PAGES_STORAGE.get(pageName)).getNoResultsMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "No results message is not as expected");
    }

    @Then("User should see at least one result containing {string} keyword on {string}")
    public void userShouldSeeAtLeastOneResultContainingKeywordOn(String searchInput, String pageName) {
        Assert.assertTrue(((SearchPage) PAGES_STORAGE.get(pageName)).checkAnyMatchForResults(searchInput),
                "No results found containing searched text");
    }
}
