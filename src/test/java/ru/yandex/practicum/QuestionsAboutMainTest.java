package ru.yandex.practicum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.practicum.pageobject.MainPage;

import java.util.List;

@RunWith(Parameterized.class)
public class QuestionsAboutMainTest {

    private WebDriver driver = new SafariDriver();

    private final int index;
    private final String text;

    public QuestionsAboutMainTest(int index, String text) {
        this.index = index;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] getInfo() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
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
        WebElement mainAnswer = mainPage.getMainAnswers().get(index);
        Assert.assertEquals(text, mainAnswer.getText().trim());
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}
