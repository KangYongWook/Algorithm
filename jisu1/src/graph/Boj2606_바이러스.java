package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj2606_바이러스 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeSize = Integer.parseInt(br.readLine());
        graph = new LinkedList[nodeSize+1];
        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new LinkedList<>();
        }

        int pair = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (pair -- > 0) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        visited = new boolean[nodeSize+1];
        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int n : graph[node]){
            if (!visited[n]){
                answer++;
                dfs(n);
            }
        }
    }
}
