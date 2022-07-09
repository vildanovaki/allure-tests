package vildanova.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;
import static vildanova.tests.TestData.linkRepository;
import static vildanova.tests.TestData.searchRepository;

public class CheckTextOfIssueLambdaTest extends TestBase {

    @Test
    @Owner("vildanovaki")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия раздела Issues на странице репозитория на GitHub")
    public void testGithubLambda() {

        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
            takeScreenshot();
            takePageSource();
        });

        step("Ищем репозиторий " + searchRepository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(searchRepository);
            $(".header-search-input").submit();
            takeScreenshot();
            takePageSource();
        });

        step("Переходим в репозиторий " + linkRepository, () -> {
            $(By.linkText(linkRepository)).click();
            takeScreenshot();
            takePageSource();
        });

        step("Проверяем наличие вкладки Issue", () -> {
            $(id("issues-tab")).should(Condition.visible);
            takeScreenshot();
            takePageSource();
        });
    }

    @Attachment(value = "Странице", type = "text/html")
    public byte[] takePageSource() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
