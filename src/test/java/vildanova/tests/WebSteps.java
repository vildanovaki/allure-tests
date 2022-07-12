package vildanova.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

public class WebSteps {

    @Step("Открыть главную страницу GitHub")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Перейти в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Проверить наличие вкладки Issue")
    public void shouldSeeIssue() {
        $(id("issues-tab")).should(Condition.visible);
    }
}
