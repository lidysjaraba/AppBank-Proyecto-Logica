package com.bank.app_bank.model;

//clase
public class SavingsAccount extends Account{
    private double interestRate;
    
    //metodo constructor
    public SavingsAccount(){
        super();
    }

    public SavingsAccount(String id, Customer owner, Money balance, double interestRate ){
        super(id, owner, balance);

        this.interestRate = interestRate;
        
    }

    @Override  //anotacion sobre ejecutar un metodo
    public void applyInterest(){
        //se aplica el polimorfismo
        double newBalance = getBalance().getAmount() + (getBalance().getAmount() * interestRate);
        getBalance().setAmount(newBalance);
    }


    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
}
