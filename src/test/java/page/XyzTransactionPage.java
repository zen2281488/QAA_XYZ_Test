package page;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pojo.Transaction;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class XyzTransactionPage extends BasePage {

    private By tableRowsLocator = By.cssSelector("tr.ng-scope");
    private SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);
    private SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);

    public XyzTransactionPage(WebDriver browser) {
        super(browser);
    }

    private Transaction parseTransactionFromRow(WebElement row) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if (cells.size() == 3) {
            try {
                Transaction transaction = new Transaction();
                transaction.setDate(outputFormat.format(inputFormat.parse(cells.get(0).getText())));
                transaction.setAmount(Integer.parseInt(cells.get(1).getText()));
                transaction.setTransactionType(cells.get(2).getText());
                return transaction;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public List<Transaction> getTransactions() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tableRowsLocator));
        List<WebElement> rows = browser.findElements(tableRowsLocator);

        return rows.stream()
                .map(this::parseTransactionFromRow)
                .filter(transaction -> transaction != null)
                .collect(Collectors.toList());
    }

    public void writeTransactionsToCSV() {
        String filePath = null;
        try {
            List<Transaction> transactions = getTransactions();
            File directory = new File("output");
            if (!directory.exists()) {
                directory.mkdir();
            }
            filePath = directory.getAbsolutePath() + File.separator + "transactions.csv";
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.append("Date,Amount,Transaction Type\n");
                transactions.forEach(transaction -> {
                    try {
                        writer.append(transaction.getDate()).append(',')
                                .append(String.valueOf(transaction.getAmount())).append(',')
                                .append(transaction.getTransactionType()).append('\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (InputStream is = new FileInputStream(filePath)) {
            Allure.addAttachment("Transactions CSV", "text/csv", is, ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyTransaction(int amount, String type) {
        return getTransactions().stream()
                .anyMatch(transaction -> transaction.getAmount() == amount && transaction.getTransactionType().equals(type));
    }
}