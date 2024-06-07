# Simbir_Test
Тестовое задание для SimbirSoft

https://zen2281488.github.io/Simbir_Test/44/index.html -  ссылка на Allure отчет

## Структура проекта

- **Page Objects**: Классы, представляющие Page Object для тестируемого приложения, находятся в `src/test/java/page`.

- **Классы данных**: Класс `Transaction.java`, который представляет данные транзакций, находится в `src/test/java/pojo`.

- **Тестовые классы**:
  - `WorkTest.java` и базовый тестовый класс `BaseTest.java` находятся в `src/test/java/uiTests`.
  - Базовый тестовый класс `BaseTest.java` предоставляет общие методы для настройки и завершения тестов.

- **Selenium Grid**: Файл `selenium-server-standalone-4.0-alpha-2.jar` находится в `src/test/java/testUtils/seleniumGrid`.

- **Утилиты**:
  - `BrowserInit.java`: Находится в `src/test/java/testUtils/`, этот класс инициализирует браузер.
  - `ConfProperties.java`: Также в `src/test/java/testUtils/`, этот класс обрабатывает свойства из файла конфигурации.
  - `NotTestUtils.java`: В той же директории, этот класс включает метод для расчета чисел Фибоначчи.

- **Конфигурация**: Файл `conf.properties`, содержащий тестовые данные и настройки, используемые в `BrowserInit.java`, находится в `src/test/resources`.

- **Workflow GitHub Actions**: Конфигурация рабочего процесса для GitHub Actions находится в `.github/workflows/`.

---

## Отчет о баге

#### Детали бага

- **Ошибка**: Пустая таблица Transactions
- **Приоритет**: Высокий
- **Серьезность**: Major
- **Окружение**: Chrome 125.0.6422.142

#### Описание

При быстром заполнении и отправке формы Deposit/Withdrawl по адресу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account, при клике на кнопку Transactions открывается страница с пустой таблицей.

#### Шаги для воспроизведения

1. Провести авторизацию
2. Перейти на страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account
3. Нажать на кнопку Deposit(или Withdrawl)
4. Заполнить форму с плейсхолдером amount
5. Нажать на кнопку отправки формы "Deposit" (или Withdrawl)
6. Быстро нажать на кнопку Transactions

#### Ожидаемый результат

Открывается страница с таблицей, в которой находится проведенная транзакция.

#### Фактический результат

Открывается страница с пустой таблицей.

#### Примечание

Этот баг можно воспроизвести и вручную.




---
<details>
<summary>Project Structure(Eng)</summary>

## Project Structure

- **Page Objects**: Located in `src/test/java/page`, these classes represent the page objects for the application under test.

- **Data Classes**: The `Transaction.java` class, which represents transaction data, is located in `src/test/java/pojo`.

- **Test Classes**:
    - `WorkTest.java` and the base test class `BaseTest.java` are located in `src/test/java/uiTests`.
    - The base test class `BaseTest.java` provides common setup and teardown methods for the tests.

- **Selenium Grid**: The `selenium-server-standalone-4.0-alpha-2.jar` file is located in `src/test/java/testUtils/seleniumGrid`.

- **Utilities**:
    - `BrowserInit.java`: Located in `src/test/java/testUtils/`, this class initializes the browser.
    - `ConfProperties.java`: Also in `src/test/java/testUtils/`, this class handles the properties from the configuration file.
    - `NotTestUtils.java`: Found in the same directory, this class includes a method for calculating Fibonacci numbers.

- **Configuration**: The `conf.properties` file, containing test data and settings used by `BrowserInit.java`, is located in `src/test/resources`.

- **GitHub Actions Workflow**: The workflow configuration for GitHub Actions is located in `.github/workflows/`.

---

## Bug Report

#### Bug Details

- **Bug**: Empty Transactions Table
- **Priority**: High
- **Severity**: Major
- **Environment**: Chrome 125.0.6422.142

#### Description

When quickly filling and submitting the Deposit/Withdrawal form at https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account, and then clicking on the Transactions button, the resulting page displays an empty table.

#### Steps to Reproduce

1. Perform authentication
2. Navigate to https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account
3. Click the Deposit (or Withdrawal) button
4. Fill in the form with the placeholder amount
5. Click the form submission button "Deposit" (or "Withdrawal")
6. Quickly click on the Transactions button

#### Expected Result

The page should open with a table containing the conducted transaction.

#### Actual Result

The page opens with an empty table.

#### Note

This bug can also be reproduced manually.
</details>
