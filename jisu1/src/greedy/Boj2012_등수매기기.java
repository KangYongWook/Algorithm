package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2012_등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] chart = new int[n];
        for (int i = 0; i < n; i++) {
            chart[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(chart);

        int unsatisfied = 0;
        for (int i = 0; i < n; i++) {
            unsatisfied += Math.abs(chart[i] - (i + 1));
        }

        System.out.println(unsatisfied);
    }
}
