package Experiment4;

import java.util.Date;

public class Transaction {
    private static final char TYPE1 = 'W'; // 取款
    private static final char TYPE2 = 'D'; // 存款
    private Date date; // 交易日期
    private char type; // 交易类型
    private double amount; // 交易量
    private double balance; // 交易后的金额
    private String description; // 交易描述

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '}' + "\n";
    }
}
