package Experiment4;

import java.util.Arrays;
import java.util.Date;

import static java.lang.reflect.Array.*;

public class Account {
    private int id = 0;
    private String name;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    private Transaction[] transactions = new Transaction[1];

    public Account() {
        this.name = null;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.name = null;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        Transaction transaction = new Transaction('D', balance, this.balance+balance, name);
        this.transactions[0] = transaction;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return this.annualInterestRate/12;
    }

    public double getMonthlyInterest() {
        double monthlyInterestRate = this.annualInterestRate/12;
        return this.balance*monthlyInterestRate;
    }

    // 取款
    public void withDraw(double draw) {
        Transaction transaction = new Transaction('W', draw, this.balance - draw, this.name);
        this.transactions = Arrays.copyOf(this.transactions, this.transactions.length + 1);
        this.transactions[this.transactions.length - 1] = transaction;
        this.balance -= draw;
    }

    // 存款
    public void deposit(double deposit) {
        Transaction transaction = new Transaction('D', deposit, this.balance + deposit, this.name);
        this.transactions = Arrays.copyOf(this.transactions, this.transactions.length + 1);
        this.transactions[this.transactions.length - 1] = transaction;
        this.balance += deposit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }

    public static void main(String[] args) {
        Account George = new Account(1122, "George", 1000);
        George.setAnnualInterestRate(1.5/100);
        George.deposit(30);
        George.deposit(40);
        George.deposit(50);
        George.withDraw(5);
        George.withDraw(4);
        George.withDraw(2);
        System.out.println(George.toString());
    }
}
