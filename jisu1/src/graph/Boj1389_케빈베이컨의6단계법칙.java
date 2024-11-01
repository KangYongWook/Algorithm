package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1389_케빈베이컨의6단계법칙 {
    static LinkedList<Integer>[] graph;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            graph[f1].add(f2);
            graph[f2].add(f1);
        }

        int answer = Integer.MAX_VALUE;
        int answerFriend = 0;
        for (int i = 1; i <= n; i++) {
            int result = bfs(i);
            if (result == 0) continue;

            if (answer > result){
                answer = result;
                answerFriend = i;
            }
        }

        System.out.println(answerFriend);

    }

    static int bfs(int start){
        int[] countArr = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Queue<Rel> que = new LinkedList<>();
        que.add(new Rel(start, 0));
        visited[start] = true;

        while (!que.isEmpty()) {
            Rel r = que.poll();
            countArr[r.friend] = r.count;

            for (int node : graph[r.friend]){
                if (!visited[node]) {
                    que.add(new Rel(node, r.count+1));
                    visited[node] = true;
                }
            }
        }

        int answer = 0;
        for (int c : countArr){
            answer += c;
        }
        return answer;
    }

    static class Rel {
        int friend;
        int count;

        public Rel(int friend, int count) {
            this.friend = friend;
            this.count = count;
        }
    }
}
