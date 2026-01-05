package ru.kaiten.web.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import ru.kaiten.web.WebTestBase;

@Tag("web_tests")
public class LeaveRequestDialog extends WebTestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка формы 'Оставить заявку'")
    void toLeaveRequestDialog() {

        mainPage.openPage()
                .clickLeaveRequestButton()
                .checkTextOnLeaveRequestDialog()
                .closeLeaveRequestDialog()
                .checkHiddenLeaveRequestDialog()
        ;
          }
}
