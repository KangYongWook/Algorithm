package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj12018_연세토토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] lecutres = new ArrayList[n];
        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            lecutres[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int pi = Integer.parseInt(st.nextToken());
            limit[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pi; j++) {
                lecutres[i].add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(lecutres[i], Collections.reverseOrder());
        }

        int[] minPoint = new int[n];
        for (int i = 0; i < n; i++) {
            if (limit[i]>lecutres[i].size()) {
                minPoint[i] = 1;
            } else {
                minPoint[i] = lecutres[i].get(limit[i]-1);
            }
        }

        int count = 0;
        int sum = 0;
        Arrays.sort(minPoint);
        for (int i = 0; i < n; i++) {
            if (sum+minPoint[i] <= m) {
                sum += minPoint[i];
                count++;
            }
        }

        System.out.println(count);

    }
}

/*
3 2
2 4
36 36
2 4
36 36
2 4
36 36
 */
