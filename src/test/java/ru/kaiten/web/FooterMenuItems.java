package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("kaiten_tests")
public class FooterMenuItems extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Открытие страницы с контактами")
    void clickMenuItemContacts() {

        registrationPage.openPage()
                .clickMenuItemContacts()
                .checkTextContactsOnPage()
        ;
    }
}
