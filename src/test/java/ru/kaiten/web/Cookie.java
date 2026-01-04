package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("kaiten_tests")
public class Cookie extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Закрытие окна Cookie")
    void closeCookieMessage() {

        registrationPage.openPage()
                .clickOkCookie()
                .checkHiddenCookie()
        ;
     }
}
