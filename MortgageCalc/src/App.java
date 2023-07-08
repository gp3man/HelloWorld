import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Principal: ");
        Scanner scanner = new Scanner(System.in);
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();
        int months = years * 12;
        float monthlyRate = annualRate / 100 / 12;
        System.out.println("Years of payments: " + years + "\nMonths: " + months + "\nMonthly Rate of: " + monthlyRate);

        NumberFormat currency = NumberFormat.getCurrencyInstance();

        double mortgage = (principal * ((monthlyRate * Math.pow(monthlyRate + 1, months)) / (Math.pow(monthlyRate + 1, months) - 1)));

        final String result = currency.format(mortgage);
        System.out.println("Your Mortgage: " + result);
    }
}
