package ru.yandex.practicum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.practicum.pageobject.MainPage;

import java.util.List;

@RunWith(Parameterized.class)
public class QuestionsAboutMainTest {

    private WebDriver driver = new SafariDriver();

    private final int index;

    public QuestionsAboutMainTest(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getInfo() {
        return new Object[][]{
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7},
        };
    }

    @Test
    public void testMainQuestions() {
        driver.get("https://qa-scooter.praktikum-services.ru");
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToQuestionsAboutMain();
        List<WebElement> mainQuestions = mainPage.getMainQuestions();
        WebElement question = mainQuestions.get(index);
        mainPage.clickCookieButton();
        question.click();
        mainPage.checkOnlyOneMainQuestionActive();
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}
