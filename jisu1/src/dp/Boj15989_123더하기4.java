package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15989_123더하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][3];
        dp[1][0] = 1;
        dp[2][0] = dp[2][1] = 1;
        dp[3][0] = dp[3][1] = dp[3][2] = 1;
        for (int i = 4; i < 10001; i++) {
            dp[i][0] = 1;
            dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
            dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
        }

        StringBuilder answer  = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            answer.append(Arrays.stream(dp[n]).sum()).append("\n");

        }
        System.out.println(answer);
    }
}
