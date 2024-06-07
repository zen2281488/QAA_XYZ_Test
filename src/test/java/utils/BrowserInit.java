package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.ConfProperties.getCommonBoolProperty;
import static utils.ConfProperties.getCommonProperty;

public class BrowserInit {
    private static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    static RemoteWebDriver driver;
    private static ChromeOptions chromeOptions;

    public static WebDriver getWebdriver() {
        if (webdriver.get() == null) {
            switch (getCommonProperty("browserMode")) {
                case "grid":
                    switch (getCommonProperty("browserName")) {
                        case "chrome":
                            driver = setUpRemoteDriver(new ChromeOptions());
                            break;
                        case "firefox":
                            driver = setUpRemoteDriver(new FirefoxOptions());
                            break;
                        case "edge":
                            driver = setUpRemoteDriver(new EdgeOptions());
                            break;
                        default:
                            throw new RuntimeException("Некорректное имя браузера");
                    }
                    break;

                case "local":
                    switch (getCommonProperty("browserName")) {
                        case "chrome":
                            System.setProperty("webdriver.chrome.driver", getCommonProperty("chromedriverLocal"));
                            driver = new ChromeDriver(new ChromeOptions().addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880").setHeadless(ConfProperties.getCommonBoolProperty("headlessMode")));
                            break;
                        case "firefox":
                            System.setProperty("webdriver.gecko.driver", getCommonProperty("geckodriverLocal"));
                            driver = new FirefoxDriver(new FirefoxOptions().addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880").setHeadless(ConfProperties.getCommonBoolProperty("headlessMode")));
                            break;
                        case "edge":
                            System.setProperty("webdriver.edge.driver", getCommonProperty("edgedriverLocal"));
                            driver = new EdgeDriver(new EdgeOptions().addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880").setHeadless(ConfProperties.getCommonBoolProperty("headlessMode")));
                            break;
                        default:
                            throw new RuntimeException("Некорректное имя браузера");
                    }
                    break;

                case "localwork":
                    switch (getCommonProperty("browserName")) {
                        case "chromeActions":
                            WebDriverManager.chromedriver().driverVersion("125").browserVersion("125").setup();
                            chromeOptions = new ChromeOptions()
                                    .addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880");
                            if (getCommonBoolProperty("headlessMode")) {
                                chromeOptions.setHeadless(true);
                            }
                            driver = new ChromeDriver(chromeOptions);
                            break;
                        case "chromeDocker":
                            System.setProperty("webdriver.chrome.driver", "/src/test/resources/drivers/chromedriver");
                            chromeOptions = new ChromeOptions()
                                    .addArguments("--no-sandbox", "--disable-dev-shm-usage", "window-size=1220,880");
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