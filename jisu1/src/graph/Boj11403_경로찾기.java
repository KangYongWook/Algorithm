package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11403_경로찾기 {
    static LinkedList<Integer>[] linkedGraph;
    static int[][] answerMap;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine())+1;
        linkedGraph = new LinkedList[n];
        for (int i = 1; i < n; i++) {
            linkedGraph[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n; j++) {
                int connect = Integer.parseInt(st.nextToken(" "));
                if (connect == 1) {
                    linkedGraph[i].add(j);
                }
            }
        }

        answerMap = new int[n][n];
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n; i++) {
            start = i;
            dfs(i);
            for (int j = 1 ; j < n ; j++) {
                answer.append(answerMap[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);

    }

    private static void dfs(int vertex) {
        for (int i : linkedGraph[vertex]){
            if (answerMap[start][i] == 0) {
                answerMap[start][i] = 1;
                dfs(i);
            }
        }
    }
}
