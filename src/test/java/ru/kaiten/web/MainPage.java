package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("kaiten_tests")
public class MainPage extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Поиск логотипа компании на главной странице")
    void searchCompanyLogoOnPage() {

        registrationPage.openPage()
                .checkLogoOnPage()
        ;
    }

    @Test
    @DisplayName("Поиск лозунга компании на главной странице")
    void checkWelcomeTextOnPage() {

        registrationPage.openPage()
                .checkSloganOnPage()
        ;
    }
}
