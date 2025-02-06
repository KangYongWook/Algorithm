package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Backpack[] backpackArr = new Backpack[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            backpackArr[i] = new Backpack(w,v);
        }

        // row = 가방의 무게
        // col = 물건
        int[][] dp = new int[k+1][n+1];

        for (int bagWeight = 1; bagWeight <= k; bagWeight++) {
            for (int j = 1; j <= n; j++) {
                if (bagWeight >= backpackArr[j].weight) {
                    int remain = bagWeight - backpackArr[j].weight;
//                    bagWeight 가 2인경우 remain도 1이고 동일한 짐을 가방에 2번 넣는 꼴이 됨
//                    dp[bagWeight][j] = dp[remain][j] + backpackArr[j].value;
//                    j-1을 하는 경우는 현재 물건 (j) 을 또 다시 넣지 않기 위해
                    dp[bagWeight][j] = dp[remain][j-1] + backpackArr[j].value;
                }
                dp[bagWeight][j] = Math.max(dp[bagWeight][j], dp[bagWeight][j-1]);
            }
        }

        System.out.println(dp[k][n]);
    }

    static class Backpack {
        int weight;
        int value;

        public Backpack(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}

/*
4 7
1 7
2 2
3 3
4 4
출력 12
정답 13
 */