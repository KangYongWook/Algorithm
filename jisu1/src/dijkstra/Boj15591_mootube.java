package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Boj15591_mootube {
    static final int MAX = 1000000000;
    static ArrayList<Node>[] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
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
            int result = dijkstra(ki, vi);
            answer.append(result).append("\n");
        }

        System.out.println(answer);
    }

    static int dijkstra(int ki, int vi) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, MAX);
        boolean[] visited = new boolean[n + 1];
        cost[vi] = 0;

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(vi, 0));

        while (!que.isEmpty()) {
            Node curr = que.poll();
            for (Node next : graph[curr.vertex]) {
                if (next.cost < cost[next.vertex]
                        && !visited[next.vertex]) {
                    if (curr.cost != 0) {
                        cost[next.vertex] = Math.min(curr.cost, next.cost);
                    } else {
                        cost[next.vertex] = next.cost;
                    }
                    visited[next.vertex] = true;
                    que.add(new Node(next.vertex, cost[next.vertex]));
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (cost[i] >= ki) {
                cnt++;
            }
        }
        return cnt;
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
