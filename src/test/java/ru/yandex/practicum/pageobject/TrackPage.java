package ru.yandex.practicum.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackPage {

    private final WebDriver driver;

    private By name = By.xpath("//div[@class='Track_Title__1XfhB'][contains(text(), 'Имя')]/following-sibling::div[@class='Track_Value__15eEX']");
    private By surname = By.xpath("//div[@class='Track_Title__1XfhB'][contains(text(), 'Фамилия')]/following-sibling::div[@class='Track_Value__15eEX']");
    private By address = By.xpath("//div[@class='Track_Title__1XfhB'][contains(text(), 'Адрес')]/following-sibling::div[@class='Track_Value__15eEX']");
    private By telephone = By.xpath("//div[@class='Track_Title__1XfhB'][contains(text(), 'Телефон')]/following-sibling::div[@class='Track_Value__15eEX']");
    private By comments = By.xpath("//div[@class='Track_Title__1XfhB'][contains(text(), 'Комментарий')]/following-sibling::div[@class='Track_Value__15eEX']");

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
