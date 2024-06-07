# Simbir_Test
Тестовое задание для SimbirSoft

https://zen2281488.github.io/Simbir_Test/44/index.html -  ссылка на Allure отчет

## Структура проекта

- **Page Objects**: Классы, представляющие Page Object для тестируемого приложения, находятся в `src/test/java/page`.

- **Классы данных**: Класс `Transaction.java`, который представляет данные транзакций, находится в `src/test/java/pojo`.

- **Тестовые классы**:
  - `WorkTest.java` и базовый тестовый класс `BaseTest.java` находятся в `src/test/java/uiTests`.
  - Базовый тестовый класс `BaseTest.java` предоставляет общие методы для настройки и завершения тестов.

- **Selenium Grid**: Файл `selenium-server-standalone-4.0-alpha-2.jar` находится в `src/test/java/utils/seleniumGrid`.

- **Утилиты**:
  - `BrowserInit.java`: Находится в `src/test/java/utils/`, этот класс инициализирует браузер.
  - `ConfProperties.java`: Также в `src/test/java/utils/`, этот класс обрабатывает свойства из файла конфигурации.
  - `NotTestUtils.java`: В той же директории, этот класс включает метод для расчета чисел Фибоначчи.

- **Конфигурация**: Файл `conf.properties`, содержащий тестовые данные и настройки, используемые в `BrowserInit.java`, находится в `src/test/resources`.

- **Workflow GitHub Actions**: Конфигурация рабочего процесса для GitHub Actions находится в `.github/workflows/`.

---
<details>
<summary>Project Structure(Eng)</summary>
## Project Structure

- **Page Objects**: Located in `src/test/java/page`, these classes represent the page objects for the application under test.

- **Data Classes**: The `Transaction.java` class, which represents transaction data, is located in `src/test/java/pojo`.

- **Test Classes**:
    - `WorkTest.java` and the base test class `BaseTest.java` are located in `src/test/java/uiTests`.
    - The base test class `BaseTest.java` provides common setup and teardown methods for the tests.

- **Selenium Grid**: The `selenium-server-standalone-4.0-alpha-2.jar` file is located in `src/test/java/utils/seleniumGrid`.

- **Utilities**:
    - `BrowserInit.java`: Located in `src/test/java/utils/`, this class initializes the browser.
    - `ConfProperties.java`: Also in `src/test/java/utils/`, this class handles the properties from the configuration file.
    - `NotTestUtils.java`: Found in the same directory, this class includes a method for calculating Fibonacci numbers.

- **Configuration**: The `conf.properties` file, containing test data and settings used by `BrowserInit.java`, is located in `src/test/resources`.

- **GitHub Actions Workflow**: The workflow configuration for GitHub Actions is located in `.github/workflows/`.
</details>
