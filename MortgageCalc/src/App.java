import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        int principal = 0;
        float annualRate = 0;
        int years = 0;
        int months =0;
        float monthlyRate=0;
        double mortgage = 0;

        while (true){
            System.out.print("Principal ($1K-$1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
        while (true){
            System.out.print("Annual Interest Rate: ");
            annualRate = scanner.nextFloat();
            if (annualRate > 0 && annualRate <= 30){
                monthlyRate = annualRate / 100 / 12;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        while (true){
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years > 0 && years <= 30){
                months = years * 12;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
        mortgage = (principal * ((monthlyRate * Math.pow(monthlyRate + 1, months)) / (Math.pow(monthlyRate + 1, months) - 1)));
        final String result = currency.format(mortgage);
        System.out.println("\nYour Mortgage: " + result);
    }
}
