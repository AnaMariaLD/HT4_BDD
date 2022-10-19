package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.CategoryPage;
import org.example.pageobject.pages.HomePage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.*;

public class FilterAndSearchTestSteps {

    private static String brandName;

    @Given("User travels to {string}")
    public void userTravelsTo(String pageName) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        CategoryPage categoryPage = homePage.goToCategory();
        PAGES_STORAGE.put("Category Page", categoryPage);
    }

    @When("User selects a brand")
    public void userSelectsABrand() {
        ((CategoryPage) PAGES_STORAGE.get("Category Page")).clickOnBrand();
        brandName = ((CategoryPage) PAGES_STORAGE.get("Category Page")).getBrandTitle();
    }

    @Then("A search result list containing only that brand items should load on {string}")
    public void aSearchResultListContainingOnlyThatBrandItemsShouldLoadOn(String pageName) {
        Assert.assertTrue(((CategoryPage) PAGES_STORAGE.get(pageName)).checkAllResultsTitlesMatchBrand(brandName),
                "Results did not all match the brand selected");
    }
}
