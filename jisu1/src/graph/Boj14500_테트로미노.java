package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500_테트로미노 {
    static boolean[][] visited;
    static int[][] paper;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static int answer;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i,j,paper[i][j],1);
                visited[i][j]=false;

                // ㅓ ㅏ ㅗ ㅜ
                center(i,j);
            }
        }

        System.out.println(answer);


    }

    private static void dfs(int x, int y, int sum, int cnt) {
        if (cnt==4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];
            if (xi >= 0 && xi <n && yi>=0 && yi <m && !visited[xi][yi]) {
                visited[xi][yi] = true;
                dfs(xi,yi,sum+paper[xi][yi],cnt+1);
                visited[xi][yi] = false;
            }
        }
    }

    private static void center(int i, int j) {
        int sum = 0;
        if (i >= 1 && i < n && j >= 1 && j < m - 1) {
            // ㅓ
            //     가운데 + 상 + 하 + 좌
            sum = paper[i][j] + paper[i][j - 1] + paper[i][j + 1] + paper[i - 1][j];
            answer = Math.max(answer, sum);
        }

        if (i >= 0 && i < n - 1 && j >= 1 && j < m - 1) {
            // ㅏ
            //     가운데 + 상 + 하 + 우
            sum = paper[i][j] + paper[i][j - 1] + paper[i][j + 1] + paper[i + 1][j];
            answer = Math.max(answer, sum);
        }

        if (i >= 1 && i < n - 1 && j >= 1 && j < m) {
            // ㅗ
            //     가운데 + 상 + 좌 + 우
            sum = paper[i][j] + paper[i][j - 1] + paper[i-1][j] + paper[i + 1][j];
            answer = Math.max(answer, sum);
        }

        if (i >= 1 && i < n - 1 && j >= 0 && j < m - 1) {
            // ㅜ
            //     가운데 + 하 + 좌 + 우
            sum = paper[i][j] + paper[i][j + 1] + paper[i-1][j] + paper[i + 1][j];
            answer = Math.max(answer, sum);
        }
    }

}
