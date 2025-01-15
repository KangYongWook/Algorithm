package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // index 0 을 사용하기 때문에 n+1을 한다
        int[][] prefixSum = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 1; j <= n ; j++) {
                int num = Integer.parseInt(st.nextToken());
                prefixSum[i][j] = num;
                
                // 누적합
                if (j>1) {
                    prefixSum[i][j] += prefixSum[i][j-1];
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        // 연산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = x1; j <= x2 ; j++) {
                sum += prefixSum[j][y2] - prefixSum[j][y1-1];
            }
            answer.append(sum).append("\n");
        }

        System.out.println(answer);

    }
}
/*
4 1
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
1 1 4 4
 */