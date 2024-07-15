package com.example.bancodigital.model;

public class CreateAccountRequest {
    private String accountId;
    private Double initialBalance;

    public CreateAccountRequest(String accountId, Double initialBalance) {
        this.accountId = accountId;
        this.initialBalance = initialBalance;
    }

    public CreateAccountRequest() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }
}
