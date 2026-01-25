package ru.kaiten.web.tests.brand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.web.pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class Slogan extends WebTestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Поиск лозунга компании на главной странице")
    void checkWelcomeTextOnPage() {

        mainPage.openPage()
                .checkSloganOnPage()
        ;
    }
}
