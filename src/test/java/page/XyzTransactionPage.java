package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pojo.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class XyzTransactionPage extends BasePage {

    private By tableRowsLocator = By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr");
    private SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ENGLISH);
    private SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);

    public XyzTransactionPage(WebDriver browser) {
        super(browser);
    }

    public List<Transaction> getTransactions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowsLocator));
        List<WebElement> rows = browser.findElements(tableRowsLocator);
        List<Transaction> transactions = new ArrayList<>();

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() == 3) {
                Transaction transaction = new Transaction();
                try {
                    transaction.setDate(outputFormat.format(inputFormat.parse(cells.get(0).getText())));
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }
                transaction.setAmount(Integer.parseInt(cells.get(1).getText()));
                transaction.setTransactionType(cells.get(2).getText());
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public void writeTransactionsToCSV() {
        try {
            List<Transaction> transactions = getTransactions();
            File directory = new File("output");
            if (!directory.exists()) {
                directory.mkdir();
            }
            String filePath = directory.getAbsolutePath() + File.separator + "transactions.csv";
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.append("Date,Amount,Transaction Type\n");
                for (Transaction transaction : transactions) {
                    writer.append(transaction.getDate()).append(',').append(String.valueOf(transaction.getAmount())).append(',').append(transaction.getTransactionType()).append('\n');
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}