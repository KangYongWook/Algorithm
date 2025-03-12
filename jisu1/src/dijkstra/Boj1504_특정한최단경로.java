package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1504_특정한최단경로 {
    static LinkedList<Node>[] graph;
    static int n;
    static int INF = 400000000; // 200000 * 2 * 1000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n +1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<Node>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1->v1->v2->n
        int res1 = dijkstra(1,v1);
        res1 += dijkstra(v1,v2);
        res1 += dijkstra(v2,n);

        // 1->v2->v1->n
        int res2 = dijkstra(1,v2);
        res2 += dijkstra(v2,v1);
        res2 += dijkstra(v1,n);

        int answer = 0;
        if ((res1>=INF) && (res2>=INF)) {
            answer = -1;

        } else {
            answer += Math.min(res1, res2);
        }

        System.out.println(answer);
    }

    static int dijkstra(int start, int end) {
        int[] cost = new int[n +1];
        for (int i = 1; i <= n ; i++) {
            cost[i] = INF;
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        cost[start] = 0;
        que.add(new Node(start,0));

        while (!que.isEmpty()) {
            Node curr = que.poll();

            if (curr.end == end) {
                return cost[end];
            }

            for (Node next : graph[curr.end]) {
                if (cost[next.end] > curr.cost + next.cost) {
                    cost[next.end] = curr.cost + next.cost;
                    que.add(new Node(next.end, cost[next.end]));
                }
            }
        }

        return cost[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}

/*
4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
결과 : 10
정답 : 8

5 4
1 4 1
1 3 1
3 2 1
2 5 1
3 4
결과 : 7
정답 : 5
 */