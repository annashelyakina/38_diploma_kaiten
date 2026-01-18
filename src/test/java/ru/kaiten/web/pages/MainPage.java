package ru.kaiten.web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.kaiten.api.Constants;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {

    private final SelenideElement

            cookiesOkButton = $("#kw-cookies-btn"),
            cookiesForm = $("aside.kw-cookies"),
            logoPic = $("a.kw-logo"),
            contentText = $(".kw-content"),
            phoneButtonInMenu = $(".kw-menu--btn._phone"),
            dialogCallBody = $("div.kw-dialog-call--body"),
            dialogCallClose = $(".kw-dialog-call--close"),
            menuArrowSvg = $("svg.kw-menu--arrow-svg"),
            tasksTitle = $("h1.kw-s1--title.wow.fadeInUp"),
            titleOnPage = $("h1.kw-s1--title"),
            footerMenu = $(byCssSelector("li.sm-none")),
            supportLink = $$(".kw-contacts--sale-link").get(3)
            ;

    @Step("Открытие сайта в браузере")
    public MainPage openPage(){
        open("");
        return this;
    }

    @Step("Нажатие кнопки 'Хорошо' на форме Cookie")
    public MainPage clickOkCookie(){
        cookiesOkButton.click();
        return this;
    }

    @Step("Проверка, что форма Cookie не отображается")
    public MainPage checkHiddenCookie(){
        cookiesForm.shouldBe(hidden);
        return this;
    }

    @Step("Проверка, что логотип отображается на странице")
    public MainPage checkLogoOnPage(){
        logoPic.shouldBe(visible);
        return this;
    }

    @Step("Проверка, что слоган отображается на странице")
    public MainPage checkSloganOnPage(){
        contentText.shouldHave(text(Constants.MAIN_SLOGAN));
        return this;
    }

    @Step("Проверка, что форма 'Оставить заявку' открыта")
    public MainPage clickLeaveRequestButton(){
        phoneButtonInMenu.shouldBe(visible).click();
        return this;
    }

    @Step("Проверка, что текст отображается на форме для заявки")
    public MainPage checkTextOnLeaveRequestDialog(){
        dialogCallBody.shouldHave(text(Constants.LEAVE_REQUEST_TITLE));
        return this;
    }

    @Step("Нажатие кнопки закрытия на форме для заявки")
    public MainPage closeLeaveRequestDialog(){
        dialogCallClose.click();
        return this;
    }

    @Step("Проверка, что форма для заявки закрыта")
    public MainPage checkHiddenLeaveRequestDialog(){
        dialogCallBody.shouldBe(hidden);
        return this;
    }

    @Step("Раскрытие подменю для пункта меню 'Продукт'")
    public MainPage clickMenuItemProduct(){
    menuArrowSvg.hover();
        return this;
    }

    @Step("Нажатие подпункта меню 'Задачи'")
    public MainPage clickSubMenuItemTasks(){
    $(byText(Constants.TASKS_TITLE)).click();
        return this;
    }

    @Step("Проверка, что информация о задачах отображается на странице")
    public MainPage checkTextTasksOnPage(){
    tasksTitle.shouldHave(text(Constants.TASKS_INFO));
        return this;
    }

    @Step("Нажатие пункта меню 'Тарифы'")
    public MainPage clickMenuItemTariff(){
        $(byText(Constants.TARIFFS_TITLE)).click();
        return this;
    }

    @Step("Проверка, что информация о тарифах отображается на странице")
    public MainPage checkTextTariffOnPage(){
        titleOnPage.shouldHave(text(Constants.TARIFF_INFO));
        return this;
    }

    @Step("Нажатие пункта меню 'Контакты'")
    public MainPage clickMenuItemContacts(){
        footerMenu.scrollTo();         // Прокручиваем страницу до нужного элемента
        $(byText(Constants.CONTACTS_TITLE)).click();
        return this;
    }

    @Step("Проверка, что текст 'Контакты' отображается на странице")
    public MainPage checkTextContactsOnPage(){
        titleOnPage.shouldHave(text(Constants.CONTACTS_TITLE));
        return this;
    }

    @Step("Прокручивание страницы до заголовка 'Бухгалтерия и закрывающие документы'")
    public MainPage scrollToAccountingTitle(){
        $(byText(Constants.ACCOUNT_TITLE)).scrollTo();       // Прокручиваем страницу до нужного элемента
        return this;
    }

    @Step("Проверка, что ссылка 'support@kaiten.ru' отображается на странице")
    public MainPage checkSupportLinkOnPage(){
        supportLink.shouldHave(text(Constants.SUPPORT_LINK));
        supportLink.shouldBe(visible);
        return this;
    }

    @Step("Проверка корректности e-mail адреса для связи с поддержкой")
    public MainPage checkSupportEmail(){
        String linkHref = $$("a").findBy(text(Constants.SUPPORT_LINK)).attr("href");
        assertEquals(Constants.SUPPORT_LINK_HREF, linkHref,Constants.MESSAGE);
        return this;
    }
}
