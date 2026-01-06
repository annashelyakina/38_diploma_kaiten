<p align="center"> 
<img width="30%" title="Kaiten" src="media/logo/logo.png">
</p>

  [Kaiten](https://kaiten.ru/) — платформа для управления проектами и задачами, которая помогает командам работать быстрее и продуктивнее. 
В отличие от зарубежных сервисов управления задачами и их российских аналогов, программа для управления проектами и задачами Kaiten способствует детальной визуализации всего рабочего процесса компании. Благодаря уникальной возможности расположить несколько канбан‑досок на одном рабочем пространстве, менеджеры могут одновременно управлять разными процессами и командами на одном экране.

#### В данном проекте использованы UI-тесты и API-тесты. 

## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure Report](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

## :computer: Используемый стек

<p align="center"> 
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"></a> 
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/logo/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="media/logo/Jira.svg"></a>
</p>

#### Для работы с тестами в данном проекте используются: 
* язык - <code>Java</code>;
* фреймворк для тестирования - <code>Selenide</code>;
* сборщик - <code>Gradle</code>; 
* фреймворк модульного тестирования - <code>JUnit 5</code>;
* запуск браузеров с помошью <code>Selenoid</code>;
* джоба для удалённого запуска в - <code>Jenkins</code>;
* отчёт в <code>Allure Report</code>;
* отправка результатов при помощи бота в - <code>Telegram</code>;
* интеграция с - <code>Allure TestOps</code>;
* регистрация задач и дефектов в <code>Jira</code>.

#### Содержание Allure-отчёта для ui теста:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

#### Содержание Allure-отчёта для api теста:
* Request api запроса;
* Response api запроса;
* Результат проверки response.

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Запуск автотестов

### Запуск ui тестов из терминала
```
gradle clean web_tests
```
При выполнении данной команды в терминале IDE тесты запустятся удалённо в <code>Selenoid</code>. 

### Запуск api тестов из терминала
```
gradle clean api_tests
```

### Запуск всех тестов из терминала
```
gradle clean test
```

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> Сборка в Jenkins

[Ссылка на сборку в Jenkins](https://jenkins.autotests.cloud/job/038-Anna_Shelyakina-diploma_kaiten/)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code>, выбрать значение для таких параметров как: ENVIRONMENT, COMMENT, TASK, BROWSER, BROWSER_VERSION, BROWSER_SIZE, REMOTE. Далее нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screens/Jenkins.png">
</p>
После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure Report</code> и <code>Allure TestOps</code>, при клике на которые откроется страница с сформированным html-отчетом и тестовой документацией соответственно.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> Пример Allure отчета
### Overview

[Ссылка на Allure отчёт](https://jenkins.autotests.cloud/job/038-Anna_Shelyakina-diploma_kaiten/allure/)

<p align="center">
<img title="Allure Report" src="media/screens/Allure.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/AllureTestOps.svg"> Интеграция с Allure TestOps

[Ссылка на проект в Allure TestOps](https://allure.autotests.cloud/project/5006/dashboards)

На *Dashboard* в <code>Allure TestOps</code> видна статистика по тестам: сколько ручных и автоматизированных тестов, результаты прогона при каждом запуске сборки.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screens/AllureTestOps.png">
</p>

### Результат выполнения автотеста

<p align="center">
<img title="Test Results in Alure TestOps" src="media/screens/AllureResults.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/logo/Jira.svg"> Интеграция с Jira

[Ссылка на задачу в Jira](https://jira.autotests.cloud/browse/HOMEWORK-1538)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были связаны с задачей и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screens/Jira.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Bot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/video/Video.gif">
</p>
