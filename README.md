# Тестовое задание

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
  - `MathUtils.java`: В той же директории, этот класс включает метод для расчета чисел Фибоначчи.
  - `TransactionUtils.java`: В той же директории, этот класс содержит метод, записывающий сериализованные транзакции в файл csv

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

- **Page Objects**: Classes representing Page Objects for the tested application are located in `src/test/java/page`.

- **Data Classes**: The `Transaction.java` class, representing transaction data, is located in `src/test/java/pojo`.

- **Test Classes**:
  - `WorkTest.java` and the base test class `BaseTest.java` are located in `src/test/java/uiTests`.
  - The base test class `BaseTest.java` provides common methods for test setup and teardown.

- **Selenium Grid**: The file `selenium-server-standalone-4.0-alpha-2.jar` is located in `src/test/java/testUtils/seleniumGrid`.

- **Utilities**:
  - `BrowserInit.java`: Located in `src/test/java/testUtils/`, this class initializes the browser.
  - `ConfProperties.java`: Also in `src/test/java/testUtils/`, this class handles properties from the configuration file.
  - `MathUtils.java`: In the same directory, this class includes a method for calculating Fibonacci numbers.
  - `TransactionUtils.java`: In the same directory, this class contains a method for writing serialized transactions to a csv file.

- **Configuration**: The `conf.properties` file, containing test data and settings used in `BrowserInit.java`, is located in `src/test/resources`.

- **GitHub Actions Workflow**: The workflow configuration for GitHub Actions is located in `.github/workflows/`.

---

## Bug Report

#### Bug Details

- **Error**: Empty Transactions Table
- **Priority**: High
- **Severity**: Major
- **Environment**: Chrome 125.0.6422.142

#### Description

When quickly filling and submitting the Deposit/Withdrawal form at https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account, clicking the Transactions button opens a page with an empty table.

#### Steps to Reproduce

1. Log in
2. Go to the page https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account
3. Click the Deposit (or Withdrawal) button
4. Fill out the form with the amount placeholder
5. Click the "Deposit" (or Withdrawal) form submission button
6. Quickly click the Transactions button

#### Expected Result

A page with a table containing the transaction should open.

#### Actual Result

A page with an empty table opens.

#### Note

This bug can be reproduced manually.
</details>
