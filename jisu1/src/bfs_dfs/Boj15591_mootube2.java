package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Boj15591_mootube2 {
    static final int MAX = 1000000000;
    static ArrayList<Node>[] graph;
    static int n;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        IntStream.range(1, n + 1).forEach(i -> graph[i] = new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int pi = Integer.parseInt(st.nextToken());
            int qi = Integer.parseInt(st.nextToken());
            int ri = Integer.parseInt(st.nextToken());
            graph[pi].add(new Node(qi, ri));
            graph[qi].add(new Node(pi, ri));
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int ki = Integer.parseInt(st.nextToken());
            int vi = Integer.parseInt(st.nextToken());
            count = 0;
            Arrays.fill(visited, false);
            visited[vi] = true;
            dfs(ki, vi, MAX);
            answer.append(count-1).append("\n");
        }

        System.out.println(answer);
    }

    static void dfs(int ki, int vi, int weight) {
        visited[vi] = true;
        for (Node next : graph[vi]) {
            if (visited[next.vertex]) continue;
            int minCost = Math.min(weight, next.cost);
            dfs(ki, next.vertex, minCost);
        }
        if (weight >= ki) count++;
    }

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
