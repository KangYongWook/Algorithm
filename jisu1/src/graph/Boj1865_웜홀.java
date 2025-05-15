package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1865_웜홀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            ArrayList<Node> dist = new ArrayList<>();

            //도로
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                //도로는 방향이 없음
                dist.add(new Node(s, e, t));
                dist.add(new Node(e, s, t));
            }

            //웜홀
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                dist.add(new Node(s, e, -t));
            }

            // 음의 사이클을 확인해야한다
            int[] cost = new int[n + 1];
            Arrays.fill(cost, 10001);
            cost[1] = 0;

//            for (int j = 0; j < n-1; j++) {
//                for (int i = 1; i <= n; i++) {
//                    for (Node node : graph[i]) {
//                        if (cost[node.end] > cost[i] + node.time) {
//                            cost[node.end] = cost[i] + node.time;
//                        }
//                    }
//                }
//            }
            Boolean change = false;
            for (int i = 0; i <= n; i++) {
                for (Node d : dist) {
                    if (cost[d.end] > cost[d.start] + d.time) {
                        cost[d.end] = cost[d.start] + d.time;

                        //N번 반복하는데도 시간이 줄어드는 부분이 있다면 음의 사이클이 존재
                        if (i == n) {
                            change = true;
                        }
                    }
                }
            }


            String possible = change ? "YES" : "NO";
            answer.append(possible).append("\n");
        }

        System.out.println(answer);
    }

    static class Node {
        int start;
        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
