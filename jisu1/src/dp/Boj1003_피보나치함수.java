package dp;

import java.util.Scanner;

public class Boj1003_피보나치함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[][] fiboDp = new int[41][2];
        fiboDp[0] = new int[]{1,0};
        fiboDp[1] = new int[]{0,1};

        for (int i = 2; i < 41; i++) {
            fiboDp[i][0] = fiboDp[i-1][0] + fiboDp[i-2][0];
            fiboDp[i][1] = fiboDp[i-1][1] + fiboDp[i-2][1];
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            answer.append(fiboDp[n][0]).append(" ").append(fiboDp[n][1]).append("\n");
        }
        System.out.println(answer);
    }
}
