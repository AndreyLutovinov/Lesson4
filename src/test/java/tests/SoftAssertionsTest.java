package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SoftAssertionsTest {
    @BeforeAll
    static void beforeAllSetup() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEachTest() {
        Selenide.closeWebDriver();
    }


    @Test
    void gitHubSelenideTest() {
        // открыть страницу Selenide в Github
        open("/selenide/selenide");
           //переход, поиск и проверка в wiki
              $("#wiki-tab").click();
              $("#wiki-pages-filter").setValue("SoftAssertions");
              $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
              $("#wiki-pages-box").$(byText("SoftAssertions")).click();
              //проверка кода
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) \n" +
                        "class Tests { \n" +
                        "@Test \n" +
                        "void test() { \n" +
                        "Configuration.assertionMode = SOFT; \n" +
                        "open(\"page.html\"); \n" +
                        " \n" +
                        "$(\"#first\").should(visible).click(); \n" +
                        "$(\"#second\").should(visible).click(); \n" +
                        "} \n" +
                        "} \n"));
    }


}
