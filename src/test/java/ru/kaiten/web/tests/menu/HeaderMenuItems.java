package ru.kaiten.web.tests.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.web.tests.pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class HeaderMenuItems extends WebTestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Открытие страницы с описанием как собрать информацию по задачам в карточках")
    void clickMenuItemProduct() {

        mainPage.openPage()
                .clickMenuItemProduct()
                .clickSubMenuItemTasks()
                .checkTextTasksOnPage()
        ;
    }

    @Test
    @DisplayName("Открытие страницы с тарифами")
    void clickMenuItemTariff() {

        mainPage.openPage()
                .clickMenuItemTariff()
                .checkTextTariffOnPage()
        ;
    }
}
