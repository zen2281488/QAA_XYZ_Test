package page;
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
    @FindBy(css = ".padT20 :nth-child(1) button")
    private WebElement customerLoginButton;
    @FindBy(id = "userSelect")
    private WebElement yourNameSelector;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLoginButton;

    public XyzLoginPage clickCustomerLoginButton(){
        wait.until(visibilityOf(customerLoginButton));
        customerLoginButton.click();
        return this;
    }

    public XyzLoginPage clickSubmitLoginButton(){
        wait.until(visibilityOf(submitLoginButton));
        submitLoginButton.click();
        return this;
    }

    public XyzLoginPage selectTestUser(){
        wait.until(visibilityOf(yourNameSelector));
        new Select(yourNameSelector).selectByVisibleText(getCommonProperty("userName"));
        return this;
    }
}
