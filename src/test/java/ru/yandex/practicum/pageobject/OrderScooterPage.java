package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderScooterPage {

    private final WebDriver driver;

    private By header = By.className("Order_Header__BZXOb");
    private By dateDelivery = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private By rentPeriod = By.className("Dropdown-root");
    private By rentPeriodOption = By.className("Dropdown-option");
    private By scooterColorBlack = By.id("black");
    private By scooterColorGrey = By.id("grey");
    private By comments = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private By orderButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");

    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setDateDelivery(String dateDeliveryToSet) {
        setValue(dateDelivery, dateDeliveryToSet);
        driver.findElement(header).click();
    }

    public void setRentPeriod(int rentPeriodToSet) {
        driver.findElement(rentPeriod).click();
        driver.findElements(rentPeriodOption).get(rentPeriodToSet).click();
    }

    public void setScooterColor(Boolean colorBlack) {
        if (colorBlack) {
            driver.findElement(scooterColorBlack).click();
        } else {
            driver.findElement(scooterColorGrey).click();
        }
    }

    public void setComments(String commentsToSet) {
        setValue(comments, commentsToSet);
    }

    public void fillScooterInfoPage(String dateDelivery, int rentPeriodIndex, Boolean scooterColorBlack, String comments) {
        setDateDelivery(dateDelivery);
        setRentPeriod(rentPeriodIndex);
        setScooterColor(scooterColorBlack);
        setComments(comments);
        clickOrderButton();
    }

    private void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    private void setValue(By selector, String value) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(value);
    }

    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(dateDelivery));
    }
}
