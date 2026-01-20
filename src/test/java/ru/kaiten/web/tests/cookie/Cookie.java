package ru.kaiten.web.tests.cookie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.web.tests.pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class Cookie extends WebTestBase {

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
