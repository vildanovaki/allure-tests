package vildanova.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static vildanova.tests.TestData.linkRepository;
import static vildanova.tests.TestData.searchRepository;

public class CheckTextOfIssueAnnotatedTests extends TestBase {

    WebSteps webSteps = new WebSteps();

    @Test
    @Owner("vildanovaki")
    @Link(name = "GitHub", url = "https://github.com")
    @Feature("Разделы в репозитории")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверить наличие раздела Issues на странице репозитория на GitHub")
    public void testGithubAnnotated() {
        webSteps.openPage();
        webSteps.searchForRepository(searchRepository);
        webSteps.goToRepository(linkRepository);
        webSteps.shouldSeeIssue();
    }
}
