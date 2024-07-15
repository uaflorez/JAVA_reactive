package com.example.bancodigital.model;

public class Transaction {
    private String transactionId;
    private String accountId;
    private Double amount;

    public Transaction(String transactionId, String accountId, Double ammount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = ammount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

