package ru.kaiten.web.tests.brand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.web.tests.pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class Logo extends WebTestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Поиск логотипа компании на главной странице")
    void searchCompanyLogoOnPage() {

        mainPage.openPage()
                .checkLogoOnPage()
        ;
    }
}
