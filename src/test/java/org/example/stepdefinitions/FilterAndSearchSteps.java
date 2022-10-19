package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CategoryPage;
import org.example.pages.HomePage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class FilterAndSearchSteps {
    private static String brandName;

    @Given("User travels to {string}")
    public void userTravelsTo(String pageName) {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = homePage.goToCategoryPage();
        PAGES_STORAGE.put("Category Page", categoryPage);
    }

    @When("User selects a brand on {string}")
    public void userSelectsABrandOn(String pageName) {
        ((CategoryPage) PAGES_STORAGE.get(pageName)).selectCategory();
    }


    @Then("A search result list containing only that brand items should load on {string}")
    public void aSearchResultListContainingOnlyThatBrandItemsShouldLoadOn(String pageName) {
        Assert.assertTrue(((CategoryPage) PAGES_STORAGE.get(pageName)).checkAllResultsMatchBrand(),
                "Results did not all match the brand selected");
    }
}
