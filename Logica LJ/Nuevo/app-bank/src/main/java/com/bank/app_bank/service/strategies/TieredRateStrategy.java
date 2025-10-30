package com.bank.app_bank.service.strategies;

import com.bank.app_bank.service.InterestStrategy;

public class TieredRateStrategy implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        if (balance <= 100000) {
            return balance * 0.01;  // 1% para saldos hasta 100000
        } else if (balance <= 500000) {
            return balance * 0.02;  // 2% para saldos de 1001 a 500000
        } else {
            return balance * 0.03;  // 3% para saldos mayores a 500000
        }
    }
}