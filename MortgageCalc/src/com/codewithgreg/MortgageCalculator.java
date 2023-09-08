package com.codewithgreg;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR =12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();
        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }
    public double calculateMortgage() {
        double result;
        float monthlyInterest;
        float numberOfPayments = getNumberOfPayments();
        monthlyInterest = getMonthlyInterest();
        result = principal
                * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) / (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
        return result;
    }
    public double[] getRemainingBalances(){
        double [] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length ; month++)
            balances[month-1] = calculateBalance(month);
        return balances;
    }
    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
