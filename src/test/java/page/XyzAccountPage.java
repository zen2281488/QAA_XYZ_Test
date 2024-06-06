package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class XyzAccountPage extends BasePage{
    public XyzAccountPage(WebDriver browser) {
        super(browser);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement depositButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement withDrawlButton;
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement transactionsButton;
    @FindBy(xpath = "//label[contains(text(), 'Deposited')]/following-sibling::input")
    private WebElement amountDepositInput;
    @FindBy(xpath = "//label[contains(text(), 'Withdrawn')]/following-sibling::input")
    private WebElement amountWithDrawInput;
    @FindBy(xpath = "//button[text()='Withdraw']")
    private WebElement submitWithdrawButton;
    @FindBy(xpath = "//button[text()='Deposit']")
    private WebElement submitDepositButton;
    @FindBy(css = ".center strong:nth-child(2)")
    private WebElement balance;

    @FindBy(css = "tbody")
    private WebElement transactionsTable;

    @Step("Клик по кнопке 'Deposit'")
    public XyzAccountPage clickDepositButton(){
        wait.until(visibilityOf(depositButton));
        depositButton.click();
        return this;
    }

    @Step("Клик по кнопке 'WithDrawl'")
    public XyzAccountPage clickWithDrawlButton(){
        wait.until(visibilityOf(withDrawlButton));
        withDrawlButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Transactions'")
    public XyzAccountPage clickTransactionsButton(){
        wait.until(visibilityOf(transactionsButton));
        transactionsButton.click();
        return this;
    }
    @Step("Клик по кнопке отправки транзакции 'Withdrawl'")
    public XyzAccountPage clickSubmitWithdrawlButton(){
        wait.until(visibilityOf(submitWithdrawButton));
        submitWithdrawButton.click();
        return this;
    }

    @Step("Клик по кнопке отправки транзакции 'Deposit'")
    public XyzAccountPage clickSubmitDepositButton(){
        wait.until(visibilityOf(submitDepositButton));
        submitDepositButton.click();
        return this;
    }

    @Step("Заполнение поля Deposit числом фибоначи: {num} ")
    public XyzAccountPage fillAmountDepositInput(int num){
        wait.until(visibilityOf(amountDepositInput));
        amountDepositInput.sendKeys(Integer.toString(num));
        return this;
    }
    @Step("Заполнение поля WithDrawl числом фибоначи: {num} ")
    public XyzAccountPage fillAmountWithDrawlInput(int num){
        wait.until(visibilityOf(amountWithDrawInput));
        amountWithDrawInput.sendKeys(Integer.toString(num));
        return this;
    }

    @Step("Получение баланса")
    public String getBalance() {
        return balance.getText();
    }

    @Step("Обновление страницы")
    public void refresh() {
        browser.get(browser.getCurrentUrl());
    }


}
