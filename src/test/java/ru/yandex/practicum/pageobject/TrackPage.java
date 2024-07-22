package ru.yandex.practicum.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackPage {

    private final WebDriver driver;

    private By name = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div[2]");
    private By surname = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[2]/div[2]");
    private By address = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[3]/div[2]");
    private By telephone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[5]/div[2]");
    private By comments = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[11]/div[2]");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(name));
    }

    public void checkOrderInfo(String nameValue, String surnameValue, String addressValue, String telephoneValue, String commentsValue) {
        Assert.assertEquals(nameValue, driver.findElement(name).getText());
        Assert.assertEquals(surnameValue, driver.findElement(surname).getText());
        Assert.assertEquals(addressValue, driver.findElement(address).getText());
        Assert.assertEquals(telephoneValue, driver.findElement(telephone).getText());
        Assert.assertEquals(commentsValue, driver.findElement(comments).getText());
    }
}
