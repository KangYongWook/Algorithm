import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14938_서강그라운드 {
    static final int INF = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역 개수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길이 개수

        // 지역대로 아이템 개수
        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int edge = Integer.parseInt(st.nextToken());
            graph[v1][v2] = Math.min(graph[v1][v2], edge);
            graph[v2][v1] = Math.min(graph[v2][v1], edge);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (k == i || i == j || k == j) continue;
                    if (graph[i][k] == INF || graph[k][j] == INF) continue; // 연결되어있어야함
                    int sum = graph[i][k] + graph[k][j];
                    graph[i][j] = Math.min(graph[i][j], sum);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = items[i];
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= m) {
                    sum += items[j];
                }
            }

            answer = Math.max(answer, sum);
        }

//        answer = IntStream.range(0, n)
//                .map(i -> IntStream.range(0, n)
//                        .filter(j -> graph[i][j] <= m)
//                        .map(j -> items[j])
//                        .sum()
//                )
//                .max()
//                .orElse(0);

        System.out.println(answer);
    }
}

/*
5 5 5
1 2 3 4 5
1 2 2
1 3 4
1 4 2
2 3 4
4 5 2
정답 15

5 15 5
2 4 5 20 3
1 2 6
2 3 7
3 4 9
1 3 2
1 5 14
정답 34

7 15 6
1 1 1 1 1 1 1
1 2 15
1 3 15
1 4 15
2 5 1
3 6 1
4 7 1
 */
