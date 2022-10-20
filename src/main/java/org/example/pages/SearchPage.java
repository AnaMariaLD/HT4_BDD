package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage {
    private SelenideElement noResultsForMessage = $(By.xpath("//*[text()='No results for ']"));
    private SelenideElement resultsForInputMessage = $(By.xpath("//span[text()='\"laptop\"']"));
    private ElementsCollection resultsList = $$(By.className("a-size-medium"));

    public void checkNoResultsForMessage(String expectedErrorMessage) {
        noResultsForMessage.shouldHave(Condition.text(expectedErrorMessage));
    }

    public void checkResultsForInputMessage(String expectedResultsMessage) {
        resultsForInputMessage.shouldHave(Condition.text(expectedResultsMessage));
    }

    public List<String> getResultsList() {
        return resultsList.texts();
    }
}
