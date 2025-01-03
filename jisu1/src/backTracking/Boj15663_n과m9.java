package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj15663_n과m9 {
    static int n,m;
    static HashMap<String,Integer> permHashMap;
    static int[] permArr;
    static int[] numArr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numArr =  new int[n];
        visited = new boolean[n];
        permArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        permHashMap = new HashMap<>();
        backTracking(0);

        // LinkedHashSet
        String[] convert = new String[permHashMap.size()];
        for (String p : permHashMap.keySet()){
            convert[permHashMap.get(p)] = p;
        }

        StringBuilder answer = new StringBuilder();
        for (String c : convert) {
            answer.append(c).append("\n");
        }
        System.out.println(answer);
    }

    static void backTracking(int cnt) {
        if (cnt == m) {
            StringBuilder permSb = new StringBuilder();
            for (int pi : permArr){
                permSb.append(pi).append(" ");
            }
            //Arrays.stream(permArr).forEach(p->permSb.append(p).append(" "));

            // StringBuilder로 값을 넣으면 "4 " "4 " 다른값
            // -> 주소비교
            Integer value = permHashMap.get(permSb.toString());
            if (value == null) {
                permHashMap.put(permSb.toString(), permHashMap.size());
            }
            /*LinkedList. stream . distinct */

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                permArr[cnt] = numArr[i];
                backTracking(cnt+1);
                visited[i] = false;
            }
        }

    }
}
/*
11 2 3
11 2
11 3
2 11
2 3
3 11

9 1
9 7
9 9
9 1
9 7
9 9
 */