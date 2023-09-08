package com.codewithgreg;
import java.text.NumberFormat;


public class App {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        int principal = (int) Console.readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
        var calculator = new MortgageCalculator(principal, annualInterest,years);
        new MortgageReport(calculator).printMortgage(currency);
        new MortgageReport(calculator).printPaymentSchedule();
    }
}
