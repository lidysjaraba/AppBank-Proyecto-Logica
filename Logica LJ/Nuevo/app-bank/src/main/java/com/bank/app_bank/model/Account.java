package com.bank.app_bank.model;
import java.util.ArrayList;
import java.util.List;

//de una clase abstracta con sus metodos abstracto se considera contrato y tiene que utilizarce

// clase abstracta
public abstract class Account {

    private String id; 
    private Customer owner;
    private Money balance;
    private List<Transactions> transactions;

    // los constructores tienen el mismo nombre de la clase
    public Account (){
        this.transactions = new ArrayList<>();
        this.balance = new Money(0.0, "COP");

    }

    public Account (String id, Customer owner, Money balance){
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    //método abstracto

    public abstract void applyInterest();


    public void deposit(Money amount){
        balance.setAmount(balance.getAmount() + amount.getAmount());
        transactions.add(new Transactions("Depositar", amount, this.id));
    }

    public boolean withdraw(Money amout){
        if ( balance.getAmount() >= amout.getAmount()){
            balance.setAmount(balance.getAmount() - amout.getAmount());
            transactions.add(new Transactions("WDR", amout, this.id));
            return true;
        }
        return false;

    }

    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    //getters 

    public String getId() {
        return id;
    }

    public Customer getOwner() {
        return owner;
    }

    public Money getBalance() {
        return balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

}
