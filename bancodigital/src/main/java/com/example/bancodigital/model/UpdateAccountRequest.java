package com.example.bancodigital.model;

import java.security.PrivateKey;

public class UpdateAccountRequest {
    private String accountId;
    private String newData;

    public UpdateAccountRequest(String accountId, String newData) {
        this.accountId = accountId;
        this.newData = newData;
    }

    public UpdateAccountRequest() {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }
}
