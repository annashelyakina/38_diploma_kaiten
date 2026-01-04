package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("kaiten_tests")
public class Cookie extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Закрытие окна Cookie")
    void closeCookieMessage() {

        mainPage.openPage()
                .clickOkCookie()
                .checkHiddenCookie()
        ;
     }
}
