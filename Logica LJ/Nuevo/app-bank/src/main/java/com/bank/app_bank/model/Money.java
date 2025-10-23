package com.bank.app_bank.model;

public class Money {
    private double amount;
    private String currency;

    //constructor vacio
    public Money() {
    }

    //constructor con parametros
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    //getters y setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
