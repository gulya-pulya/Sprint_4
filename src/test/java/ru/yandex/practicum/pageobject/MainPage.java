package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private final WebDriver driver;

    public By cookieButton = By.id("rcc-confirm-button");

    public By orderButton = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]");

    public By howItWorks = By.xpath("//*[@id='root']/div/div/div[4]/div[1]");

    public By howItWorksOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");

    public By questionsAboutMain = By.className("Home_FourPart__1uthg");

    public By mainQuestions = By.className("accordion__heading");

    public By mainAnswers = By.cssSelector(".accordion__panel > p");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickToHowItWorksOrderButton() {
        scrollToHowItWorks();
        driver.findElement(howItWorksOrderButton).click();
    }

    public List<WebElement> getMainQuestions() {
        return driver.findElements(mainQuestions);
    }

    public void scrollToQuestionsAboutMain() {
        scroll(questionsAboutMain);
    }

    public void scrollToHowItWorks() {
        scroll(howItWorks);
    }

    private void scroll(By selector) {
        WebElement element = driver.findElement(selector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<WebElement> getMainAnswers() {
        return driver.findElements(mainAnswers);
    }
}
