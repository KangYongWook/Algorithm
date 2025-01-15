package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1916_최소비용구하기 {
    static LinkedList<Route>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        StringTokenizer st;
        int a, b, cost;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Route(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, arrive));
    }

    static int dijkstra(int start, int arrive) {
        int[] shortest = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Route> que = new PriorityQueue<>(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                return o1.cost - o2.cost;
            }
        });

        que.add(new Route(start, 0));
        while (!que.isEmpty()) {
            Route current = que.poll();
            if (current.arrive == arrive) {
                return shortest[arrive];
            }
            for (Route next : graph[current.arrive]) {
                if (shortest[next.arrive] > next.cost + current.cost) {
                    shortest[next.arrive] = next.cost + current.cost;
                    que.add(new Route(next.arrive, shortest[next.arrive]));
                }
            }

        }
        return shortest[arrive];
    }
}

class Route {
    int arrive;
    int cost;

    public Route(int arrive, int cost) {
        this.arrive = arrive;
        this.cost = cost;
    }
}
/*
5
4
1 2 1
2 3 1
1 4 1
4 5 1
1 5
 */