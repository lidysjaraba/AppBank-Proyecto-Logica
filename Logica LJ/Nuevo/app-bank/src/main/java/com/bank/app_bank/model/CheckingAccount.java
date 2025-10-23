package com.bank.app_bank.model;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(){
        super(); 
    }

    public CheckingAccount (String id, Customer owner, Money balance, double overdraftLimit){
        super(id, owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void applyInterest(){
        //en cuentas corrientes no se aplica interes
    }

    public boolean withdraw(Money amount){
        double available = getBalance().getAmount() + overdraftLimit;
        if(available >= amount.getAmount()){
            getBalance().setAmount(getBalance().getAmount() - amount.getAmount());
            getTransactions().add(new Transactions("WDR", amount, getId()));
            return true;
        }
        return false;
    }

    public double getOverdraftLimit(){ return overdraftLimit;}
    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

}
