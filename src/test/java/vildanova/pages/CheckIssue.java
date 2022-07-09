package vildanova.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;
import static vildanova.tests.TestData.linkRepository;
import static vildanova.tests.TestData.nameWebsite;

public class CheckIssue {

    private SelenideElement
            searchBox = $(".header-search-input"),
            textRepository= $(By.linkText("vildanovaki/java-basic-two")),
//            textRepository= $x("//a[@href='" + linkRepository + "']"),
            issueTab= $(id("issues-tab"));

    public CheckIssue openPage() {
        open(nameWebsite);
        return this;
    }

    public CheckIssue searchForRepository(String searchRepository) {
        searchBox.click();
        searchBox.sendKeys(searchRepository);
        searchBox.submit();
        return this;
    }

    public CheckIssue goToRepository() {
        textRepository.click();
        return this;
    }

    public void shouldSeeIssue() {
        issueTab.should(Condition.visible);
    }
}
