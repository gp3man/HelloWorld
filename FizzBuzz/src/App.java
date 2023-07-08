import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int cookie = scanner.nextInt();

            if ((cookie % 3 == 0) && (cookie % 5 == 0))
            System.out.println("FIZZBUZZ");
            else if (cookie%3==0)
            System.out.println("BUZZ");
            else if (cookie%5==0)
            System.out.println("FIZZ");
            else
            System.out.println(cookie);
    }
}
