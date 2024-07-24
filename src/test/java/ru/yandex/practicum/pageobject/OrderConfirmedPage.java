package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class OrderConfirmedPage {

    private final WebDriver driver;

    private By seeStatusButton = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button");
    private By orderText = By.className("Order_Text__2broi");

    public OrderConfirmedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSeeStatusButton() {
        driver.findElement(seeStatusButton).click();
    }

    public void waitPageLoad() throws InterruptedException {
        new WebDriverWait(driver, 3)
                .until((val) -> driver.findElement(orderText).getText().length() == 73);
    }
}
