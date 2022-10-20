package org.example.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.SearchPage;
import org.testng.Assert;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;
import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class SearchTestSteps {
    @Given("User types incorrect search phrase {string} on {string}")
    public void userTypesIncorrectSearchPhraseOn(String searchInput, String pageName) {
        HomePage homePage = new HomePage();
        homePage.typeSearchText(searchInput);
        PAGES_STORAGE.put(pageName, homePage);
    }

    @When("User clicks search button on {string}")
    public void userClicksSearchButtonOn(String pageName) {
        SearchPage searchPage = ((HomePage) PAGES_STORAGE.get(pageName)).pressSearchButton();
        PAGES_STORAGE.put("Search Page", searchPage);
    }

    @Then("User should see {string} error message on {string}")
    public void userShouldSeeErrorMessageOn(String expectedErrorMessage, String pageName) {
        ((SearchPage) PAGES_STORAGE.get(pageName)).checkNoResultsForMessage(expectedErrorMessage);
    }

    @Given("User types correct search phrase as {string} on {string}")
    public void userTypesCorrectSearchPhraseAsOn(String searchInput, String pageName) {
        HomePage homePage = new HomePage();
        homePage.typeSearchText(searchInput);
        PAGES_STORAGE.put(pageName, homePage);
    }

    @Then("User should see number of results for {string} message on {string}")
    public void userShouldSeeNumberOfResultsForLaptopMessageOn(String expectedResultsMessage, String pageName) {
        ((SearchPage) PAGES_STORAGE.get(pageName)).checkResultsForInputMessage(expectedResultsMessage);
    }

    @Then("User should see at least one result containing {string} keyword on {string}")
    public void userShouldSeeAtLeastOneResultContainingKeywordOn(String searchInput, String pageName) {
        List<String> resultsList = ((SearchPage) PAGES_STORAGE.get(pageName)).getResultsList();
        Assert.assertTrue(resultsList.stream().anyMatch(text -> containsIgnoreCase(text, searchInput)),
                "No result contains searched phrase");
    }
}
