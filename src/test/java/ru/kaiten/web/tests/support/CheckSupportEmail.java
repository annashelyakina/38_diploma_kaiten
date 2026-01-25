package ru.kaiten.web.tests.support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.kaiten.web.WebTestBase;
import ru.kaiten.web.pages.MainPage;

@Tag("web_tests")
public class CheckSupportEmail extends WebTestBase {

        MainPage mainPage = new MainPage();

        @Test
        @DisplayName("Проверка ссылки для связи с поддержкой")
        void checkSupportEmail() {

            mainPage.openPage()
                    .clickMenuItemContacts()
                    .scrollToAccountingTitle()
                    .checkSupportLinkOnPage()
                    .checkSupportEmail()
             ;
        }
    }
