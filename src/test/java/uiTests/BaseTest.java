package uiTests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.BrowserInit;

public class BaseTest {
    protected WebDriver driver;

    @AfterEach
    @Step("Очиска данных")
    public void baseAfter() {
        BrowserInit.closeWebdriver();
    }

    @BeforeEach
    @Step("Инициализация Драйвера")
    public void baseBefore() {
        driver = BrowserInit.getWebdriver();
    }
}