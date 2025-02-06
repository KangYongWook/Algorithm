package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] downGame = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            downGame[i][0] = Integer.parseInt(st.nextToken());
            downGame[i][1] = Integer.parseInt(st.nextToken());
            downGame[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dpMin = new int[n][3];
        int[][] dpMax = new int[n][3];
        dpMin[0] = downGame[0].clone();
        dpMax[0] = downGame[0].clone();
        for (int i = 1; i < n ; i++) {
            dpMin[i][0] = downGame[i][0] + Math.min(dpMin[i-1][0],dpMin[i-1][1]);
            dpMin[i][1] = downGame[i][1] + Math.min(Math.min(dpMin[i-1][0],dpMin[i-1][1]),dpMin[i-1][2]);
            dpMin[i][2] = downGame[i][2] + Math.min(dpMin[i-1][1],dpMin[i-1][2]);

            dpMax[i][0] = downGame[i][0] + Math.max(dpMax[i-1][0],dpMax[i-1][1]);
            dpMax[i][1] = downGame[i][1] + Math.max(Math.max(dpMax[i-1][0],dpMax[i-1][1]),dpMax[i-1][2]);
            dpMax[i][2] = downGame[i][2] + Math.max(dpMax[i-1][1],dpMax[i-1][2]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<3;i++){
            min = Math.min(min, dpMin[n-1][i]);
            max = Math.max(max, dpMax[n-1][i]);
        }

        System.out.println(max+" "+min);

    }
}

/*
3
1 0 0
0 1 0
0 0 1
답 : 3 0
 */