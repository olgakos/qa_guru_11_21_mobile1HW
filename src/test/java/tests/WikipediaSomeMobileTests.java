package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

        import com.codeborne.selenide.Condition;
        //import io.appium.java_client.AppiumBy;
        import io.appium.java_client.MobileBy;
        import io.qameta.allure.Feature;
        import io.qameta.allure.Owner;
        import io.qameta.allure.Severity;
        import io.qameta.allure.SeverityLevel;
        import org.junit.jupiter.api.DisplayName;
        import org.junit.jupiter.api.Tag;
        import org.junit.jupiter.api.Tags;
        import org.junit.jupiter.api.Test;

        import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
        import static com.codeborne.selenide.Selectors.byClassName;
        import static com.codeborne.selenide.Selenide.*;
        import static io.qameta.allure.Allure.step;

@Owner("olgakos")
@Feature("Mobile smoke tests")
@DisplayName("Проверка мобильной Wikipedia")
@Tag("selenide")
public class WikipediaSomeMobileTests extends TestBase {

    @Test
    @DisplayName("Поиск статьи по запросу Java")
    @Tags({@Tag("api"), @Tag("001")})
    @Severity(SeverityLevel.NORMAL)
    void wikiSearchTest() {
        //step("Skip first onboarding page", () -> back());
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click(); //? или

        step("Type search", () -> {
            //$(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            //$(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("Java");
        });

        step("Verify content found", () ->
                $$(byClassName("android.widget.TextView"))
                //$$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}