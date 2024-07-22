package ru.yandex.practicum;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.pageobject.MainPage;

import java.util.List;

public class QuestionsAboutMainTest {

    private WebDriver driver;

    @Test
    public void testMainQuestions() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToQuestionsAboutMain();
        List<WebElement> mainQuestions = mainPage.getMainQuestions();
        mainPage.clickCookieButton();
        mainQuestions.forEach(question -> {
            question.click();
            mainPage.checkOnlyOneMainQuestionActive();
        });
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}
