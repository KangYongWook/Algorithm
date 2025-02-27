package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17070_파이프옮기기2 {
    static int[][] wall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wall = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3차원 dp
        // 0 -> 가로 , 1->세로 , 2 -> 대각선
        int[][][] dp = new int[3][n + 1][n + 1];

        // 초기값 (1,2) 위치에 (0->가로) 형태로 = 1개 있음
        dp[0][1][2] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (wall[i][j] == 0) {
                    // 가로인경우 (1,2)에는 값을 세팅해줘서 가로인경우만 Math.max 넣어줌
                    dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i][j - 1] + dp[2][i][j - 1]);
                    // 세로인경우
                    dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];
                }

                // 대각선인경우
                if (wall[i][j] == 0 && wall[i-1][j] == 0 && wall[i][j-1] == 0) {
                    dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
                }
            }
        }


        System.out.println(dp[0][n][n] + dp[1][n][n] + dp[2][n][n]);

    }
}
