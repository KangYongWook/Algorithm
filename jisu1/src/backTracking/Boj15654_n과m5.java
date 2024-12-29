package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654_n과m5 {
    static int n, m;
    static StringBuilder answer;
    static int[] box;
    static int[] numberArr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numberArr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numberArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberArr);

        answer = new StringBuilder();
        box = new int[m];

        dfs(0);

        System.out.println(answer);

    }

    // n과 m 2
    // 1 2 3 4

    // n과 m 5
    // 1 7 8 9

    // 수열 담을 박스, 박스에 담을 인덱스 및 리턴하기 위한 횟수 체크용
    private static void dfs(int cnt) {
        if (cnt == m) {
            for (int b : box) {
                answer.append(b).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                box[cnt] = numberArr[i];
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }

}
