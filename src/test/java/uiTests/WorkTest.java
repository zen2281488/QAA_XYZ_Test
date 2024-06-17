package uiTests;

import io.qameta.allure.Step;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.XyzAccountPage;
import page.XyzLoginPage;
import page.XyzTransactionPage;

import static testUtils.ConfProperties.getProperty;
import static testUtils.MathUtils.fibonacci;
import static testUtils.TransactionUtils.writeTransactionsToCSV;

@Epic("Тесты работоспособности элементов.")
public class WorkTest extends BaseTest {
    private XyzAccountPage accountPage;
    private XyzLoginPage loginPage;
    private XyzTransactionPage transactionPage;

    @BeforeEach
    @Step("Инициализация страниц")
    public void before() {
        accountPage = new XyzAccountPage(driver);
        loginPage = new XyzLoginPage(driver);
        transactionPage = new XyzTransactionPage(driver);
    }

    @Feature("Отправка транзакций")
    @Description("Тест проверяет возможность отправки и списания денег со счёта клиента, а так же отображение истории этих транзакций и корректность изменения баланса пользователя.")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    @Issue("XYZ-UI-Transaction")
    @DisplayName("Тест работоспособности отправки транзакций")
    public void transactionTest() {
        driver.get(getProperty("loginPageUrl"));
        loginPage.clickCustomerLoginButton().selectTestUser(getProperty("userName")).clickSubmitLoginButton();
        var fibonacci = fibonacci();
        accountPage.clickDepositButton().fillAmountDepositInput(fibonacci).clickSubmitDepositButton().clickWithDrawlButton().fillAmountWithDrawlInput(fibonacci).clickSubmitWithdrawlButton();
        driver.navigate().refresh();
        Assertions.assertEquals("0", accountPage.getBalance());
        accountPage.clickTransactionsButton();
        var transactions = transactionPage.getTransactions();
        writeTransactionsToCSV(transactions);
        Assertions.assertEquals(fibonacci, transactions.get(0).amount);
        Assertions.assertEquals(fibonacci, transactions.get(1).amount);
        Assertions.assertEquals("Credit", transactions.get(0).transactionType);
        Assertions.assertEquals("Debit", transactions.get(1).transactionType);
    }
}