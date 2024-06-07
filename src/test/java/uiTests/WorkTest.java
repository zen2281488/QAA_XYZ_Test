package uiTests;

import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.XyzAccountPage;
import page.XyzLoginPage;
import utils.TransactionSerialize;

import static utils.ConfProperties.getCommonProperty;
import static utils.NotTestUtils.fibonacci;

@Epic("Тесты работоспособности элементов.")
public class WorkTest extends BaseTest {
    private XyzAccountPage accountPage;
    private XyzLoginPage loginPage;
    private TransactionSerialize transaction;
    @BeforeEach
    @Step("Инициализация страниц")
    public void before() {
        accountPage = new XyzAccountPage(driver);
        loginPage = new XyzLoginPage(driver);
        transaction = new TransactionSerialize(driver);
    }

    @Feature("Отправка транзакций")
    @Description("Тест проверяет возможность отправки и списания денег со счёта клиента, а так же отображение истории этих транзакций и корректность изменения баланса пользователя.")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    @Issue("XYZ-UI-Transaction")
    @DisplayName("Тест работоспособности отправки транзакций")
    public void transactionTest() {
        driver.get(getCommonProperty("loginPageUrl"));
        loginPage.clickCustomerLoginButton().selectTestUser(getCommonProperty("userName")).clickSubmitLoginButton();
        var fibonacci = fibonacci();
        accountPage.clickDepositButton()
                .fillAmountDepositInput(fibonacci)
                .clickSubmitDepositButton()
                .clickWithDrawlButton()
                .fillAmountWithDrawlInput(fibonacci)
                .clickSubmitWithdrawlButton();
        driver.navigate().refresh();
        Assertions.assertEquals("0",accountPage.getBalance());
        accountPage.clickTransactionsButton();
        Assertions.assertTrue(transaction.verifyTransaction(fibonacci, "Credit"));
        Assertions.assertTrue(transaction.verifyTransaction(fibonacci, "Debit"));
        transaction.writeTransactionsToCSV();


    }

}