package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1167_트리의지름 {
    static ArrayList<Edge>[] graph;
    static boolean[] visited;
    static int findFarVer;
    static int findSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());

            while(true){
                int endV = Integer.parseInt(st.nextToken());
                if (endV==-1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph[startV].add(new Edge(endV, cost));
            }
        }

        visited = new boolean[v+1];
        dfs(1,0);

        Arrays.fill(visited, false);
        findSum = 0;
        dfs(findFarVer, 0);
        System.out.println(findSum);

    }

    static void dfs(int curr, int sum) {
        if (findSum<sum) {
            findFarVer = curr;
            findSum = sum;
        }

        visited[curr] = true;
        for (Edge next:graph[curr]){
            if (!visited[next.vertex]) {
                dfs(next.vertex, sum+ next.cost);
            }
        }
    }

    static class Edge {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
