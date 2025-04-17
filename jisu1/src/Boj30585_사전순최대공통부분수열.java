import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj30585_사전순최대공통부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        List<String> list = new ArrayList<>();
        list.add("");

        List<String>[] graph = new List[m];
        for (int i = 0; i < m; i++) {
            graph[i] = new ArrayList<>();
        }


        // 2차원배열의 0,0이 중요하다
        // 현재 자신의 인덱스까지 오기 전 단계에서 +1을 해줘야하기 때문이다
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

                if (arrN[i] == arrM[j]) {
//                    int size = list.size();
//                    for (int k = 0; k < size; k++) {
//                        StringBuilder sb = new StringBuilder(list.get(k));
//                        if (sb.length() > 0) {
//                            sb.append(" ");
//                        }
//                        sb.append(arrM[j]);
//                        list.add(sb.toString());
//                    }
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        String max = list.get(0);
        String[] s = max.split(" ");
        System.out.println(s.length + "\n" + max);
    }
}

/*
2
100 100
2
100 100
정답===========
2
100 100

6
5 4 3 1 5 3
7
5 2 1 3 5 4 3
정답===========
3
5 5 3
 */