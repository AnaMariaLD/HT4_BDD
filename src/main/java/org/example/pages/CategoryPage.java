package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class CategoryPage extends BasePage {

    private SelenideElement brandsSection = $("#brandsRefinements");
    private String categoryCheckBoxLocator = ".a-icon.a-icon-checkbox";

    private String brandNameLocator = ".a-size-base.a-color-base.a-text-bold";

    private String brandName;

    private ElementsCollection resultsList = $$(By.xpath("//div[contains(@class, 's-title-instructions-style')]"));

    public void selectCategory() {
        brandsSection.find(categoryCheckBoxLocator).click();
        brandName = brandsSection.find(brandNameLocator).text();
    }

    public boolean checkAllResultsMatchBrand() {
        List<String> resultsTitles = resultsList.texts();
        return resultsTitles.stream().filter(this::isNotEmptyString).allMatch(result -> containsIgnoreCase(result, brandName));
    }

    private boolean isNotEmptyString(String string) {
        return !string.isEmpty();
    }
}
