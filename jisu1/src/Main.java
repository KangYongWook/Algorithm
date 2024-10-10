import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n==0) break;
            double sqrt = Math.sqrt(n);
            System.out.println(sqrt);
            System.out.println(sqrt%1>0);
            System.out.println("--------");

        }
    }
}