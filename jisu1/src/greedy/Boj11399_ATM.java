package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pArr = new int[N];
        for (int i = 0; i < N; i++) {
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pArr);
        int[] withdrawArr = new int[N];
        withdrawArr[0] = pArr[0];
        for (int i = 1; i < N; i++) {
            withdrawArr[i] = withdrawArr[i-1]+pArr[i];
        }

        int answer = 0;
        for (int w : withdrawArr) {
            answer+=w;
        }

        System.out.println(answer);
    }
}
