package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("kaiten_tests")
public class MenuItems extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Открытие страницы с описанием как собрать информацию по задачам в карточках")
    void clickMenuItemProduct() {

        registrationPage.openPage()
                .clickMenuItemProduct()
                .clickSubMenuItemTasks()
                .checkTextTasksOnPage()
        ;
    }

    @Test
    @DisplayName("Открытие страницы с тарифами")
    void clickMenuItemTariff() {

        registrationPage.openPage()
                .clickMenuItemTariff()
                .checkTextTariffOnPage()
        ;
    }
}
