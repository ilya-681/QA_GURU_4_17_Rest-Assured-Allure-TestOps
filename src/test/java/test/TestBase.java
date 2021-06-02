package test;


import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static filters.CustomLogFilter.customLogFilter;


public class TestBase {
    @BeforeAll
    static void setup() {

        RestAssured.filters(customLogFilter().withCustomTemplates());
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
