package ru.yandex.practicum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import ru.yandex.practicum.pageobject.MainPage;
import ru.yandex.practicum.pageobject.OrderConfirmPage;
import ru.yandex.practicum.pageobject.OrderConfirmedPage;
import ru.yandex.practicum.pageobject.OrderCustomerInfoPage;
import ru.yandex.practicum.pageobject.OrderScooterPage;
import ru.yandex.practicum.pageobject.TrackPage;

@RunWith(Parameterized.class)
public class ScooterOrderTest {

    private boolean topButton;
    private String name;
    private String surname;
    private String address;
    private int metroIndex;
    private String telephone;
    private String dateDelivery;
    private int rentPeriodIndex;
    private boolean scooterColorBlack;
    private String comments;

    public ScooterOrderTest(boolean topButton, String name, String surname, String address, int metroIndex, String telephone, String dateDelivery, int rentPeriodIndex, boolean scooterColorBlack, String comments) {
        this.topButton = topButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroIndex = metroIndex;
        this.telephone = telephone;
        this.dateDelivery = dateDelivery;
        this.rentPeriodIndex = rentPeriodIndex;
        this.scooterColorBlack = scooterColorBlack;
        this.comments = comments;
    }

    @Parameterized.Parameters
    public static Object[][] getInfo() {
        return new Object[][] {
                { true, "Иван", "Васильев", "119021, Москва, ул. Льва Толстого, 16", 1, "89172342421", "02.07.2024", 1, false, "comment"},
                { false, "Иван", "Васильев", "119021, Москва, ул. Льва Толстого, 16", 3, "89172342421", "11.07.2024", 3, true, "comment 10"},
        };
    }

    @Test
    public void testScooterOrder() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
        driver.manage().window().fullscreen();

        MainPage mainPage = new MainPage(driver);
        if (topButton) {
            mainPage.clickToOrderButton();
        } else {
            mainPage.scrollToHowItWorks();
            mainPage.clickToHowItWorksOrderButton();
        }

        OrderCustomerInfoPage orderCustomerInfoPage = new OrderCustomerInfoPage(driver);
        orderCustomerInfoPage.waitPageLoad();
        orderCustomerInfoPage.fillCustomerInfoPage(name, surname, address, metroIndex, telephone);

        Thread.sleep(500);

        OrderScooterPage orderScooterPage = new OrderScooterPage(driver);
        orderScooterPage.waitPageLoad();
        orderScooterPage.fillScooterInfoPage(dateDelivery, rentPeriodIndex, scooterColorBlack, comments);

        Thread.sleep(500);

        OrderConfirmPage orderConfirmPage = new OrderConfirmPage(driver);
        orderConfirmPage.waitPageLoad();
        orderConfirmPage.clickConfirmedPage();

        Thread.sleep(500);

        OrderConfirmedPage orderConfirmedPage = new OrderConfirmedPage(driver);
        orderConfirmedPage.waitPageLoad();
        orderConfirmedPage.clickSeeStatusButton();

        Thread.sleep(500);

        TrackPage trackPage = new TrackPage(driver);
        trackPage.waitPageLoad();
        trackPage.checkOrderInfo(name, surname, address, telephone, comments);

        driver.quit();
    }
}
