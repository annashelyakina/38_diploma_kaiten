package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    @Step("Открытие сайта в браузере")
    public RegistrationPage openPage(){
        open("");
        return this;
    }

    @Step("Нажатие кнопки 'Хорошо' на форме Cookie")
    public RegistrationPage clickOkCookie(){
        $("#kw-cookies-btn").click();
        return this;
    }

    @Step("Проверка, что форма Cookie не отображается")
    public RegistrationPage checkHiddenCookie(){
        $("aside.kw-cookies").shouldBe(hidden);
        return this;
    }

    @Step("Проверка, что логотип отображается на странице")
    public RegistrationPage checkLogoOnPage(){
        $("a.kw-logo").shouldBe(visible);
        return this;
    }

    @Step("Проверка, что слоган отображается на странице")
    public RegistrationPage checkSloganOnPage(){
        $(".kw-content").shouldHave(text("Российский сервис для управления рабочими процессами"));
        return this;
    }

    @Step("Проверка, что форма 'Оставить заявку' открыта")
    public RegistrationPage clickLeaveRequestButton(){
        $(".kw-menu--btn._phone").shouldBe(visible).click();
        return this;
    }

    @Step("Проверка, что текст отображается на форме для заявки")
    public RegistrationPage checkTextOnLeaveRequestDialog(){
        $("div.kw-dialog-call--body").shouldHave(text("Оставить заявку"));
        return this;
    }

    @Step("Нажатие кнопки закрытия на форме для заявки")
    public RegistrationPage closeLeaveRequestDialog(){
        $(".kw-dialog-call--close").click();
        return this;
    }

    @Step("Проверка, что форма для заявки закрыта")
    public RegistrationPage checkHiddenLeaveRequestDialog(){
        $("div.kw-dialog-call--body").shouldBe(hidden);
        return this;
    }

    @Step("Раскрытие подменю для пункта меню 'Продукт'")
    public RegistrationPage clickMenuItemProduct(){
    $("svg.kw-menu--arrow-svg").hover();
        return this;
    }

    @Step("Нажатие подпункта меню 'Задачи'")
    public RegistrationPage clickSubMenuItemTasks(){
    $(byText("Задачи")).click();
        return this;
    }

    @Step("Проверка, что текст о задачах отображается на странице")
    public RegistrationPage checkTextTasksOnPage(){
    $("h1.kw-s1--title.wow.fadeInUp").shouldHave(text("Соберите всю информацию по задачам в карточках"));
        return this;
    }

    @Step("Нажатие пункта меню 'Тарифы'")
    public RegistrationPage clickMenuItemTariff(){
        $(byText("Тарифы")).click();
        return this;
    }

    @Step("Проверка, что текст о тарифах отображается на странице")
    public RegistrationPage checkTextTariffOnPage(){
        $("h1.kw-s1--title").shouldHave(text("Соберите свой идеальный тариф и платите только за то, чем пользуетесь"));
        return this;
    }

    @Step("Нажатие пункта меню 'Контакты'")
    public RegistrationPage clickMenuItemContacts(){
        // Локатор пункта меню внизу страницы
        SelenideElement menuItem = $(byCssSelector("li.sm-none"));

        // Прокручиваем страницу до нужного элемента
        menuItem.scrollTo();

        $(byText("Контакты")).click();
        return this;
    }

    @Step("Проверка, что текст 'Контакты' отображается на странице")
    public RegistrationPage checkTextContactsOnPage(){
        $("h1.kw-s1--title").shouldHave(text("Контакты"));
        return this;
    }
}
