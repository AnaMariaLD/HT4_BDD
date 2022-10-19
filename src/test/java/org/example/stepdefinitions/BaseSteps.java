package org.example.stepdefinitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {

    public static final Map<String, BasePage> PAGES_STORAGE = new HashMap<>();
    @Before
    public void openAmazonSite() {
        Selenide.open("https://www.amazon.com/");
    }

    @After
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }


}
