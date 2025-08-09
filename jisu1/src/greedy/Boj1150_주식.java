package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1150_주식 {
    static int[] stock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            stock = new int[n];
            for (int j = 0; j < n; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int maxStockIdx = findMaxIdx(0);

            int[] benefit = new int[n];
            for (int j = 0; j < n-1; j++) {
                if (j < maxStockIdx) {
                    benefit[j] = stock[maxStockIdx] - stock[j];
                } else {
                    maxStockIdx = findMaxIdx(j);
                    benefit[j] = (stock[maxStockIdx] - stock[j]) < 0 ? 0 : stock[maxStockIdx] - stock[j];
                }
            }

            long sum = 0;
            for (int b : benefit) {
                sum += b;
            }
            answer.append(sum).append("\n");
        }

        System.out.println(answer);

    }

    static int findMaxIdx(int startidx) {
        int maxStockIdx = startidx;
        for (int i = startidx; i < stock.length; i++) {
            if (stock[maxStockIdx] <= stock[i]) {
                maxStockIdx = i;
            }
        }
        return maxStockIdx;
    }
}

/*
1
11
8 6 7 10 5 6 9 1 2 3 4
 */