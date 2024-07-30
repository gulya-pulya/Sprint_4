package ru.yandex.practicum.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderCustomerInfoPage {

    private final WebDriver driver;

    private By name = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private By surname = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private By address = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private By metro = By.className("select-search__input");
    private By metroOptions = By.className("select-search__option");
    private By telephone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    public OrderCustomerInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String nameToSet) {
        setValue(name, nameToSet);
    }

    public void setSurname(String surnameToSet) {
        setValue(surname, surnameToSet);
    }

    public void setAddress(String addressToSet) {
        setValue(address, addressToSet);
    }

    public void setMetro(int metroIndex) {
        driver.findElement(metro).click();
        List<WebElement> elements = driver.findElements(metroOptions);
        elements.get(metroIndex).click();
    }

    public void setTelephone(String telephoneToSet) {
        setValue(telephone, telephoneToSet);
    }

    public void waitPageLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(name));
    }

    public void fillCustomerInfoPage(String name, String surname, String address, int metroIndex, String telephone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metroIndex);
        setTelephone(telephone);
        clickNextButton();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    private void setValue(By selector, String value) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(value);
    }
}
