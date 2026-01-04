package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("kaiten_tests")
public class Slogan extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Поиск лозунга компании на главной странице")
    void checkWelcomeTextOnPage() {

        mainPage.openPage()
                .checkSloganOnPage()
        ;
    }
}
