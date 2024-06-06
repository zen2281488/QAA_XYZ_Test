package page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static utils.ConfProperties.getCommonProperty;

public class XyzLoginPage extends BasePage{
    public XyzLoginPage(WebDriver browser) {
        super(browser);
    }

    //todo Wrong selector
    @FindBy(css = ".padT20 :nth-child(1) button")
    private WebElement customerLoginButton;
    @FindBy(id = "userSelect")
    private WebElement yourNameSelector;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    @Step("Клик по кнопке 'Customer Login'")
    public XyzLoginPage clickCustomerLoginButton(){
        wait.until(visibilityOf(customerLoginButton));
        customerLoginButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Login'")
    public XyzLoginPage clickSubmitLoginButton(){
        wait.until(visibilityOf(submitLoginButton));
        submitLoginButton.click();
        return this;
    }

    @Step("Выбор Имени: {userName} в селекторе")
    public XyzLoginPage selectTestUser(String userName) {
        wait.until(visibilityOf(yourNameSelector));
        new Select(yourNameSelector).selectByVisibleText(userName);
        return this;
    }

}
