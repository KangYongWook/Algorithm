import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1753_최단경로 {
    static LinkedList<Direction>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new LinkedList[v+1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new LinkedList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Direction(y,w));
        }

        int[] cost = new int[v+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<Direction> prio = new PriorityQueue<>();
        prio.add(new Direction(start,0));

        while (!prio.isEmpty()) {
            Direction curr = prio.poll();

            // 2% 틀림 이유
            if (cost[curr.vertex] > curr.weight) {
                cost[curr.vertex] = curr.weight;
            }

            for (Direction next : graph[curr.vertex]) {
                if (cost[next.vertex] > curr.weight + next.weight) {
                    cost[next.vertex] = curr.weight + next.weight;

                    prio.add(new Direction(next.vertex, cost[next.vertex]));
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= v ; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                answer.append("INF").append("\n");
            } else {
                answer.append(cost[i]).append("\n");
            }
        }

        System.out.println(answer);

    }

    static class Direction implements Comparable<Direction> {
        int vertex;
        int weight;

        public Direction(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Direction o) {
            return weight-o.weight;
        }
    }
}
