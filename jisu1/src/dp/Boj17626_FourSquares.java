package dp;

import java.util.Scanner;

public class Boj17626_FourSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i-1]+1;

            /* 1부터 시작하면 무조건 이전의 상태에서 값 +1을 할 수 밖에 없음
            * j = 1 일 경우 dp[i-j*j] == dp[i-1]
            * 12번 라인과 동일한 값을 대입하는 거므로 j는 2부터 시작
            * i-j^2==0 은 i==j^2 인 경우이므로 제곱수가 하나.
            * */
            for (int j = 2; j*j<=i ; j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        System.out.println(dp[n]);

    }
}
