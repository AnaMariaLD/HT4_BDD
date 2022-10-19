package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private SelenideElement searchBox = $(By.id("twotabsearchtextbox"));
    private SelenideElement searchButton = $(By.id("nav-search-submit-button"));

    private SelenideElement category = $("[aria-label='Headsets']");


    public void typeSearchText(String searchInput) {
        searchBox.shouldBe(Condition.visible).val(searchInput);
    }

    public SearchPage pressSearchButton() {
        searchButton.click();
        return new SearchPage();
    }

    public CategoryPage goToCategoryPage(){
        category.click();
        return new CategoryPage();
    }


}
