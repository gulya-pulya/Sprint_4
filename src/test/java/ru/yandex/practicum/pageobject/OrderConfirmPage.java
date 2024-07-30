package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmPage {

    private final WebDriver driver;

    private By confirmedButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    public OrderConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConfirmedPage() {
        driver.findElement(confirmedButton).click();
    }

    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmedButton));
    }
}
