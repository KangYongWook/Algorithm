package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1238_파티 {
    public static void main(String[] args) throws IOException {
        // 플로이드워셜 n=1000 이상부터는 불가.. n^3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());

            graph[start][end] = graph[start][end]==0? t : Math.min(graph[start][end],t);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (i==j || j==k || i==k) continue;
                    if (graph[j][i] != 0 && graph[i][k] != 0) {
                        int sum =  graph[j][i] + graph[i][k];
                        graph[j][k] = graph[j][k] ==0? sum : Math.min(sum, graph[j][k]);
                    }
                }
            }
        }

        //오고 가고
        // 0-> graph[0][2]+graph[2][0]
        int time = 0;
        for (int i = 0; i < n; i++) {
            time = Math.max(time, graph[i][x] + graph[x][i]);
        }
        System.out.println(time);
    }
}
