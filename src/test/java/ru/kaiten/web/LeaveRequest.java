package ru.kaiten.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

@Tag("kaiten_tests")
public class LeaveRequest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Проверка формы 'Оставить заявку'")
    void toLeaveRequestDialog() {

        registrationPage.openPage()
                .clickLeaveRequestButton()
                .checkTextOnLeaveRequestDialog()
                .closeLeaveRequestDialog()
                .checkHiddenLeaveRequestDialog()
        ;
          }
}
