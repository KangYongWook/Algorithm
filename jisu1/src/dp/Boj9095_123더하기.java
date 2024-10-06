package dp;

import java.util.Scanner;

public class Boj9095_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[11];
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1 / 2
        dp[3] = 4; // 1+1+1 / 1+2 / 2+1 / 3
        for (int i = 4 ; i < 11; i++) {
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
            //      +1      +2      +3       한 개수를 더하면 되므로
        }
        StringBuilder answer = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            answer.append(dp[n]).append("\n");
        }
        System.out.println(answer);

    }
}
