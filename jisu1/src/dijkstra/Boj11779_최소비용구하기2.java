package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11779_최소비용구하기2 {

    static final int INF = 1000000000;
    static int n;
    static ArrayList<Bus>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        int start, end;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            graph[start].add(new Bus(end, Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Bus goBus = daijstra(start, end);

        System.out.println(goBus.cost);
        System.out.println(goBus.cityCnt);
        System.out.println(goBus.routeStr);

    }

    static Bus daijstra(int start, int end) {
        int[] costArr = new int[n + 1];
        Arrays.fill(costArr, INF);

        PriorityQueue<Bus> que = new PriorityQueue<>();
        que.add(new Bus(start, 0, 1, String.valueOf(start)));
        costArr[start] = 0;

        while (!que.isEmpty()) {
            Bus curr = que.poll();
            if (curr.arrive == end) {
                // 도착지!
                return curr;
            }

            for (Bus next : graph[curr.arrive]) {
                if (curr.cost + next.cost < costArr[next.arrive]) {
                    costArr[next.arrive] = curr.cost + next.cost;
                    String r = curr.routeStr + " " + String.valueOf(next.arrive);
                    que.add(new Bus(next.arrive, costArr[next.arrive], curr.cityCnt+1, r));
                }
            }
        }

        return null;
    }

    static class Bus implements Comparable<Bus> {
        int arrive;
        int cost;
        int cityCnt;
        String routeStr;

        public Bus(int arrive, int cost) {
            this.arrive = arrive;
            this.cost = cost;
        }

        public Bus(int arrive, int cost, int cityCnt, String routeStr) {
            this.arrive = arrive;
            this.cost = cost;
            this.cityCnt = cityCnt;
            this.routeStr = routeStr;
        }

        public int compareTo(Bus b) {
            return this.cost - b.cost;
        }
    }
}
