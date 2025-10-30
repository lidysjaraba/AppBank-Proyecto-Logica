package com.bank.app_bank.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.app_bank.model.Account;
import com.bank.app_bank.model.CheckingAccount;
import com.bank.app_bank.model.Customer;
import com.bank.app_bank.model.Money;
import com.bank.app_bank.model.SavingsAccount;
import com.bank.app_bank.model.Transactions;


@Service
public class BankServiceImpl implements BankService {

    private List<Customer> customers;
    private List<Account> accounts;
    private InterestStrategy interestStrategy;  //pendiente de crear

    public BankServiceImpl(InterestStrategy interestStrategy) {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.interestStrategy = interestStrategy;
    }

    //gestion de clientes
    @Override
    public Customer createCustomer(String id, String name, String email) {
        Customer customer = new Customer(id, name, email);
        customers.add(customer);
        return customer;
    }

    // implementacion del metodo buscar cliente por el id

    @Override
    public Customer findCustomerById(String customerId) {
        return customers.stream()
        .filter(cliente -> cliente.getId().equals(customerId))
        .findFirst().orElse(null);
    }

    //implementacion del metodo obtener todos los clientes

    @Override
    public List<Customer> getAllCustomers(){
        return customers;
    }
    
    //gestion cuentas 

    @Override
    public Account createSavingsAccount(String accountId, Customer customer, double interestRate) {
        SavingsAccount account = new SavingsAccount(accountId, customer, new Money(0.0, "COP"), interestRate);
        accounts.add(account);

        return account;
    }

    @Override
    public Account createCheckingAccount(String accountId, Customer customer, double overdraftLimit) {
        CheckingAccount account = new CheckingAccount(accountId, customer, new Money(0.0, "USD"), overdraftLimit);
        accounts.add(account);
        return account;
    }

    @Override
    public Account findAccountById(String accountId) {
        return accounts.stream()
                .filter(a -> a.getId().equals(accountId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    // operaciones bancarias

    @Override
    public boolean deposit(String accountId, double amount) {

        Account account = findAccountById(accountId);

        if (account != null) {
            account.deposit(new Money(amount, "USD"));
            return true;
        }
        return false;
    }

    @Override
    public boolean withdraw(String accountId, double amount) {

        Account account = findAccountById(accountId);
        if (account != null) {
            return account.withdraw(new Money(amount, "USD"));
        }
        return false;
    }


    @Override
    public boolean transfer(String fromAccountId, String toAccountId, double amount) {
        
        Account fromAccount = findAccountById(fromAccountId);
        Account toAccount = findAccountById(toAccountId);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(new Money(amount, "USD"))) {
                toAccount.deposit(new Money(amount, "USD"));
                return true;
            }
        }
        return false;
    }

    //intereses

    @Override
    public void applyInterest(String accountId) {

        Account account = findAccountById(accountId);
        if (account != null) {
            double interest = interestStrategy.calculateInterest(account.getBalance().getAmount());
            account.deposit(new Money(interest, "COP"));
        }
    }

    // consultas

    @Override
    public List<Transactions> getAccountTransactions(String accountId) {
        Account account = findAccountById(accountId);
        return account != null ? account.getTransactions() : new ArrayList<>();
    }



}
