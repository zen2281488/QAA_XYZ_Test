package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.ConfProperties.getCommonBoolProperty;
import static utils.ConfProperties.getCommonProperty;

public class BrowserInit {
    private static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    static RemoteWebDriver driver;

    public static WebDriver getWebdriver() {
        if (webdriver.get() == null) {
            switch (getCommonProperty("browserMode")) {
                case "grid":
                    switch (getCommonProperty("browserName")) {
                        case "chrome":
                            driver = setUpRemoteDriver(new ChromeOptions());
                            break;
                        default:
                            throw new RuntimeException("Некорректное имя браузера");
                    }
                    break;

                case "localwork":
                    switch (getCommonProperty("browserName")) {
                        case "chromeActions":
                            WebDriverManager.chromedriver().setup();
                            System.setProperty("webdriver.http.factory", "jdk-http-client");
                            ChromeOptions chromeOptions = new ChromeOptions().addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880");
                            if (getCommonBoolProperty("headlessMode")) {
                                chromeOptions.setHeadless(true);
                            }
                            driver = new ChromeDriver(chromeOptions);
                            break;
                        default:
                            throw new RuntimeException("Некорректное имя браузера");
                    }
                    break;

                default:
                    throw new RuntimeException("Некорректный режим работы веб-драйвера");
            }
            webdriver.set(driver);
        }
        return webdriver.get();
    }

    public static synchronized void closeWebdriver() {
        if (webdriver.get() != null) {
            webdriver.get().quit();
            webdriver.remove();
        }
    }

    private static RemoteWebDriver setUpRemoteDriver(MutableCapabilities options) {
        try {
            return new RemoteWebDriver(new URL(getCommonProperty("hubUrl")), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}