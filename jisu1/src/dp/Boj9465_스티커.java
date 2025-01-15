package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            n++; // dp용 범위를 위해

            // idx 1부터 시작 (혼선방지)
            int[][] stickerArr = new int[3][n];
            StringTokenizer st;
            for (int i = 1; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n; j++) {
                    stickerArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n];
            dp[1][1] = stickerArr[1][1];
            dp[2][1] = stickerArr[2][1];

            for (int i = 2; i < n; i++) {
                dp[1][i] = stickerArr[1][i]+ Math.max(dp[2][i-1], Math.max(dp[1][i-2], dp[2][i-2]));
                dp[2][i] = stickerArr[2][i]+ Math.max(dp[1][i-1], Math.max(dp[1][i-2], dp[2][i-2]));
            }

            answer.append(Math.max(dp[1][n-1],dp[2][n-1])).append("\n");
        }
        System.out.println(answer);
    }
}
