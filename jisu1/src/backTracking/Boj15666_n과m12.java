package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj15666_n과m12 {
    static int n, m;
    static HashMap<String, Integer> permHashMap;
    static int[] permArr;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numArr = new int[n];
        permArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        permHashMap = new HashMap<>();

        backTracking(0, 0);

        String[] convert = new String[permHashMap.size()];
        for (String p : permHashMap.keySet()) {
            convert[permHashMap.get(p)] = p;
        }

        StringBuilder answer = new StringBuilder();
        for (String c : convert) {
            answer.append(c).append("\n");
        }
        System.out.println(answer);
    }

    static void backTracking(int start, int cnt) {
        if (cnt == m) {
            StringBuilder permSb = new StringBuilder();
            for (int pi : permArr) {
                permSb.append(pi).append(" ");
            }
            Integer value = permHashMap.get(permSb.toString());
            if (value == null) {
                permHashMap.put(permSb.toString(), permHashMap.size());
            }
            return;
        }

        for (int i = start; i < n; i++) {
            permArr[cnt] = numArr[i];
            backTracking(i, cnt + 1);
        }

    }
}