import java.util.Scanner;

public class Boj16953_AB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int answer = 0;
        while (true) {
            if (b > 0 && b % 2 == 0) {
                b = b / 2;
                answer++;
            } else if (b > 1 && b % 10 == 1) {
                b = b / 10;
                answer++;
            } else {
                answer = -2;
                break;
            }

            if (a == b) {
                break;
            }
        }

        System.out.println(answer+1);
    }
}
