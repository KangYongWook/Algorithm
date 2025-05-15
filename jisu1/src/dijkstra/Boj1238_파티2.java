package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1238_파티2 {

    static int n,x;
    static final int INF = 1000000;
    public static void main(String[] args) throws IOException {
        // 다익스트라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken())-1;

        ArrayList<Node>[] graphToHome = new ArrayList[n];
        ArrayList<Node>[] graphToParty = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphToHome[i] = new ArrayList<>();
            graphToParty[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken());

            // 간선 정방향
            graphToHome[start].add(new Node(end, t));

            // 간선 역방향
            graphToParty[end].add(new Node(start, t));
        }

        // x -> 각자 집으로 가는 다익스트라
        int[] goHome = dijkstra(graphToHome);

        // x -> 각자집 가는걸 구하는건데 .. 간선이 역방향이라 로 가는 다익스트라 [][][][][]
        // 결국 구해지는게 각자 집 -> x 로 가는 최단 경로를 구할 수 있다
        int[] goParty = dijkstra(graphToParty);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, goParty[i] + goHome[i]);
        }
        System.out.println(answer);

    }
    static int[] dijkstra(ArrayList<Node>[] graph) {
        int[] go = new int[n];
        Arrays.fill(go, INF);
        go[x] = 0; // 자기 자신으로 가는 경로

        // x로 가는 다익스트라
        PriorityQueue<Node> que = new PriorityQueue<>();

        // start = x -> home
        que.add(new Node(x, 0));

        while(!que.isEmpty()) {
            Node curr = que.poll();

            for (Node next : graph[curr.end]) {
                if (go[next.end]>next.cost+curr.cost) {
                    go[next.end] = next.cost + curr.cost;
                    que.add(new Node(next.end, go[next.end]));
                }
            }
        }

        return go;
    }

    static class Node implements Comparable<Node>{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
