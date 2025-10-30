package com.bank.app_bank.service;

import java.util.List;

import com.bank.app_bank.model.Account;
import com.bank.app_bank.model.Customer;
import com.bank.app_bank.model.Transactions;

public interface BankService {

    //gestion de usuarios
    Customer createCustomer(String id, String name, String email);
    Customer findCustomerById(String customerId);
    List<Customer> getAllCustomers();

    //gestion de cuentas

    Account createSavingsAccount(String accountId, Customer customer, double interestRate);
    Account createCheckingAccount(String accountId, Customer customer, double overdraftLimit);
    Account findAccountById(String accountId);

    List<Account> getAllAccounts();

    //operaciones bancarias

    boolean deposit(String accountId, double amount);
    boolean withdraw(String accountId, double amount);
    boolean transfer(String fromAccountId, String toAccountId, double amount);

    //intereses
    void applyInterest(String accountId);

    //consultas

    List<Transactions> getAccountTransactions(String accountId);

}
