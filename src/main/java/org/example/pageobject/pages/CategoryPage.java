package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.example.utils.SupportMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;


public class CategoryPage extends BasePage {

    private final By brandCheckbox = By.cssSelector(".a-icon.a-icon-checkbox");
    private final By brandName = By.cssSelector(".a-size-base.a-color-base.a-text-bold");

    @FindBy(id = "brandsRefinements")
    private WebElement featuredBrands;
    @FindBy(xpath = "//div[contains(@class, 's-title-instructions-style')]")
    private List<WebElement> brandResultsList;
    private SupportMethods supportMethods = new SupportMethods();

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBrand() {
        featuredBrands.findElement(brandCheckbox).click();

    }


    public String getBrandTitle() {
        return this.featuredBrands.findElement(brandName).getText();
    }

    public boolean checkAllResultsTitlesMatchBrand(String brandName) {
        SupportMethods supportMethods = new SupportMethods();
        return this.brandResultsList
                .stream()
                .map(WebElement::getText)
                .filter(supportMethods::isNotEmptyString)
                .allMatch(result -> containsIgnoreCase(result, brandName));

    }

}
