package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class XyzAccountPage extends BasePage {
    public XyzAccountPage(WebDriver browser) {
        super(browser);
    }

    @FindBy(css = "[ng-click^=deposit]")
    private WebElement depositButton;
    @FindBy(css = "[ng-click^=withdrawl]")
    private WebElement withDrawlButton;
    @FindBy(css = "[ng-click^=transactions]")
    private WebElement transactionsButton;
    @FindBy(css = "[ng-submit^=deposit] input")
    private WebElement amountDepositInput;
    @FindBy(css = "[ng-submit^=withdrawl] input")
    private WebElement amountWithDrawInput;
    @FindBy(css = "[ng-submit^=withdrawl] button")
    private WebElement submitWithdrawButton;
    @FindBy(css = "[ng-submit^=deposit] button")
    private WebElement submitDepositButton;
    @FindBy(css = ".center strong:nth-child(2)")
    private WebElement balance;
    @FindBy(css = ".error")
    private WebElement message;

    @Step("Клик по кнопке 'Deposit'")
    public XyzAccountPage clickDepositButton() {
        wait.until(visibilityOf(depositButton));
        depositButton.click();
        return this;
    }

    @Step("Клик по кнопке 'WithDrawl'")
    public XyzAccountPage clickWithDrawlButton() {
        wait.until(visibilityOf(withDrawlButton));
        withDrawlButton.click();
        return this;
    }

    @Step("Клик по кнопке 'Transactions'")
    public XyzAccountPage clickTransactionsButton() {
        wait.until(visibilityOf(transactionsButton));
        transactionsButton.click();
        return this;
    }

    @Step("Клик по кнопке отправки транзакции 'Withdrawl'")
    public XyzAccountPage clickSubmitWithdrawlButton() {
        wait.until(visibilityOf(submitWithdrawButton));
        submitWithdrawButton.click();
        wait.until(visibilityOf(message));
        return this;
    }

    @Step("Клик по кнопке отправки транзакции 'Deposit'")
    public XyzAccountPage clickSubmitDepositButton() {
        wait.until(visibilityOf(submitDepositButton));
        submitDepositButton.click();
        wait.until(visibilityOf(message));
        return this;
    }

    @Step("Заполнение поля Deposit числом фибоначи: {num} ")
    public XyzAccountPage fillAmountDepositInput(int num) {
        wait.until(visibilityOf(amountDepositInput));
        amountDepositInput.clear();
        amountDepositInput.sendKeys(Integer.toString(num));
        return this;
    }

    @Step("Заполнение поля WithDrawl числом фибоначи: {num} ")
    public XyzAccountPage fillAmountWithDrawlInput(int num) {
        wait.until(visibilityOf(amountWithDrawInput));
        amountWithDrawInput.clear();
        amountWithDrawInput.sendKeys(Integer.toString(num));
        return this;
    }

    @Step("Получение баланса")
    public String getBalance() {
        return balance.getText();
    }
}
