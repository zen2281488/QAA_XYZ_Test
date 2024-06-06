package pojo;

import lombok.Data;
import lombok.Getter;

@Data
public class Transaction {
    public String date;
    public int amount;
    public String transactionType;
}