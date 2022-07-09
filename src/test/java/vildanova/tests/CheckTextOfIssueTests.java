package vildanova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vildanova.pages.CheckIssue;

import static vildanova.tests.TestData.searchRepository;

public class CheckTextOfIssueTests extends TestBase {

    CheckIssue checkIssue = new CheckIssue();

    @Test
    @Owner("vildanovaki")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка наличия раздела Issues на странице репозитория на GitHub")
    void checkIssue() {

        checkIssue.openPage()
                .searchForRepository(searchRepository)
                .goToRepository()
                .shouldSeeIssue();
    }
}
