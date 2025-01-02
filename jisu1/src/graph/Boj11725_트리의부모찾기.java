package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11725_트리의부모찾기 {
    static LinkedList<Integer>[] tree;
    static boolean[] visited;
    static int[] parentArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new LinkedList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n ; i++) {
            tree[i] = new LinkedList<>();
        }

        parentArr = new int[n+1];

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        dfs(0,1);

        StringBuilder answer = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            answer.append(parentArr[i]).append("\n");
        }
        System.out.println(answer);
    }

    static void dfs(int parent, int child) {
        visited[child] = true;
        parentArr[child] = parent;
        for (int ch : tree[child]){
            if (!visited[ch]){
                dfs(child,ch);
            }
        }
    }
}
