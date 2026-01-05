package ru.kaiten.web.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class FooterMenuItems extends WebTestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Открытие страницы с контактами")
    void clickMenuItemContacts() {

        mainPage.openPage()
                .clickMenuItemContacts()
                .checkTextContactsOnPage()
        ;
    }
}
