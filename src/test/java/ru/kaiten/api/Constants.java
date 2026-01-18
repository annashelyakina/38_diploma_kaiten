package ru.kaiten.api;

public class Constants {
    private Constants() {}
    public static final String VALID_TOKEN = "e24c2a9b-72fc-4c9f-baee-ec7f5c78ad27";
    public static final String INVALID_TOKEN = "555c2a9b-72fc-4c9f-baee-ec7f5c78ad27";
    public static final String USER_ROLE = TestData.getUserRoleFaker();
    public static final String UPDATING_USER_ROLE = TestData.getUserRoleFaker();
    public static final String NON_UNIQUE_USER_ROLE = "testRole7";
    public static final String EXISTING_ROLE_ID = "24386";
    public static final String UPDATING_ROLE_ID = "24395";
    public static final String MAIN_SLOGAN = "Российский сервис для управления рабочими процессами";
    public static final String CONTACTS_TITLE = "Контакты";
    public static final String SUPPORT_LINK = "support@kaiten.ru";
    public static final String SUPPORT_LINK_HREF = "mailto:support@kaiten.ru";
    public static final String MESSAGE ="Ссылка должна вести на правильный email.";
    public static final String ACCOUNT_TITLE = "Бухгалтерия и закрывающие документы";
    public static final String LEAVE_REQUEST_TITLE = "Оставить заявку";
    public static final String TASKS_TITLE ="Задачи";
    public static final String TARIFFS_TITLE = "Тарифы";
    public static final String TASKS_INFO = "Соберите всю информацию по задачам в карточках";
    public static final String TARIFF_INFO = "Соберите свой идеальный тариф и платите только за то, чем пользуетесь";
 }
