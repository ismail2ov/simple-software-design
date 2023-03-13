package com.paradigmadigital.dry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Account {

    private final ArrayList<Transaction> transactionList;
    private double balance;
    private Date lastTransactionDate;

    public Account() {
        this.balance = 0;
        this.lastTransactionDate = null;
        this.transactionList = new ArrayList<>();
    }

    public void credit(double amount) {
        transaction(-amount);
    }

    public void debit(double amount) {
        transaction(amount);
    }

    private void transaction(double amount) {
        balance += amount;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        transactionList.add(new Transaction(date, amount));
        lastTransactionDate = date;
    }

    public double getBalance() {
        return balance;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public double getTransactionsTotal() {
        return transactionList.stream().mapToDouble(Transaction::getAmount).sum();
    }
}
