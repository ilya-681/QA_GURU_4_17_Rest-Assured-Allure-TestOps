package test;


import com.codeborne.selenide.Configuration;
import config.WebConfig;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static filters.CustomLogFilter.customLogFilter;
import static helpers.AttachmentsHelper.*;


public class TestBase {
    @BeforeAll
    static void setup() {
        final WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.startMaximized = true;
        browser = config.getWebDriverBrowser();
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        if (System.getProperty("remote_driver") != null || System.getProperty("env") != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            capabilities.setVersion(config.getWebDriverBrowserVersion());
            Configuration.browserCapabilities = capabilities;

            Configuration.remote = config.getWebDriverURL();
        }
        RestAssured.filters(customLogFilter().withCustomTemplates());
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
    }


    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if (System.getProperty("video_storage") != null)
            attachVideo();
        closeWebDriver();
    }
}
