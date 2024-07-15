package com.example.bancodigital.model;

public class TransferRequest {
    private String fromAccount;
    private String toAccount;
    private Double amount;

    public TransferRequest(String fromAccount, String toAccount, Double ammount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = ammount;
    }

    public TransferRequest() {

    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
