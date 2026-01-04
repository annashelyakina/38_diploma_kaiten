package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("kaiten_tests")
public class LeaveRequest extends TestBase {

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
