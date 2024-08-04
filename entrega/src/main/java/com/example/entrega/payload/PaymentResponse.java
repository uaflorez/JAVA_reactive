package com.example.entrega.payload;

public class PaymentResponse {

    private boolean approved;
    private String transactionId;
    private String message;
    private String errorCode; // Opcional, en caso de que el servicio de pagos devuelva códigos de error
    private Double processedAmount; // Opcional, en caso de que el servicio de pagos devuelva el monto procesado

    // Constructor sin parámetros
    public PaymentResponse() {}

    // Constructor con parámetros
    public PaymentResponse(boolean approved, String transactionId, String message, String errorCode, Double processedAmount) {
        this.approved = approved;
        this.transactionId = transactionId;
        this.message = message;
        this.errorCode = errorCode;
        this.processedAmount = processedAmount;
    }

    // Getters y Setters
    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Double getProcessedAmount() {
        return processedAmount;
    }

    public void setProcessedAmount(Double processedAmount) {
        this.processedAmount = processedAmount;
    }

    // toString() para facilitar la depuración
    @Override
    public String toString() {
        return "PaymentResponse{" +
                "approved=" + approved +
                ", transactionId='" + transactionId + '\'' +
                ", message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", processedAmount=" + processedAmount +
                '}';
    }
}
