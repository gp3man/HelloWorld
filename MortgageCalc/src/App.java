import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    final static byte MONTHS_IN_YEAR =12;
        final static byte PERCENT = 100;
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        int principal = (int) readNumber("Principle: ", 1000, 1_000_000);
        float annualRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);
        double mortgage = calculateMortgage(principal, annualRate, years);
        final String result = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + result);
        
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max) break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
    public static double calculateBalance(int principal, float annualRate, byte years, short numberOfPaymentsMade){
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        double balance = principal * (Math.pow(1 + monthlyRate, numberOfPayments)- Math.pow(1 + monthlyRate, numberOfPaymentsMade)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        return balance;
    }
    public static double calculateMortgage(int principal, float annualRate, byte years) {
        double result;
        float monthlyRate;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        result = principal
                * (monthlyRate * Math.pow(monthlyRate + 1, numberOfPayments)) / (Math.pow(monthlyRate + 1, numberOfPayments) - 1);
        return result;
    }
}
