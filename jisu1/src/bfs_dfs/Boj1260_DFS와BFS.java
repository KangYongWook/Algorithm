package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_DFS와BFS {
    static ArrayList<Integer>[] graph;
    static StringBuilder dfsAnswer;
    static StringBuilder bfsAnswer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        dfsAnswer = new StringBuilder();
        visited = new boolean[n+1];
        dfs(v);
        System.out.println(dfsAnswer);

        bfsAnswer = new StringBuilder();
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(bfsAnswer);


    }

    private static void bfs(int vertex) {
        Queue<Integer> que = new LinkedList<>();
        que.add(vertex);
        visited[vertex] = true;

        while(!que.isEmpty()){
            int v = que.poll();
            bfsAnswer.append(v).append(" ");
            ArrayList<Integer> list = graph[v];
            Collections.sort(list);

            for(int l : list){
                if (!visited[l]){
                    visited[l] = true;
                    que.add(l);
                }
            }
        }
    }

    private static void dfs(int vertex) {
        dfsAnswer.append(vertex).append(" ");
        visited[vertex] = true;
        ArrayList<Integer> list = graph[vertex];
        Collections.sort(list);

        for(int l : list){
            if (!visited[l]){
                dfs(l);
            }
        }

    }
}
