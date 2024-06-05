package pojo;

import lombok.Data;

@Data
public class Transaction {
    private String date;
    private int amount;
    private String transactionType;
}