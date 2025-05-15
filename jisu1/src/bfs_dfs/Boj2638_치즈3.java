package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2638_치즈3 {

    static int[][] cheese;
    static int n, m;
    static Queue<Pos> deleteList = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new int[n][m];
        int cheeseCnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }
        // 입력 받기 끝

        int time = 0;
        Queue<Pos> que = new LinkedList<>();
        boolean[][] visited;
        int[][] attachCnt;

        while (cheeseCnt > 0) {
            visited = new boolean[n][m];
            attachCnt = new int[n][m];

            que.add(new Pos(0, 0));
            visited[0][0] = true;

            while (!que.isEmpty()) {
                Pos curr = que.poll();
                // 외부공기 탐색
                if (cheese[curr.x][curr.y] == 0) {
                    for (int i = 0; i < 4; i++) {
                        int xi = curr.x + dx[i];
                        int yi = curr.y + dy[i];

                        if (xi < 0 || xi >= n || yi < 0 || yi >= m || visited[xi][yi]) continue;

                        // 4방탐색
                        if (cheese[xi][yi] == 1) {
                            attachCnt[xi][yi]++;
                            if (attachCnt[xi][yi] == 2) {
                                deleteList.add(new Pos(xi, yi));
                                visited[xi][yi] = true;
                            }

                        } else {
                            que.add(new Pos(xi, yi));
                            visited[xi][yi] = true;
                        }
                    }
                }
            }

            // 외부공기 접촉 치즈 삭제
            cheeseCnt -= deleteList.size();
            deleteCheese();

            // 시간 증가
            time++;
        }

        System.out.println(time);

    }

    private static void isExternalCheese(int x, int y) {
        int lineCnt = 0;
        for (int i = 0; i < 4; i++) {
            int xi = x + dx[i];
            int yi = y + dy[i];

            if (xi < 0 || xi >= n || yi < 0 || yi >= m) continue;
            if (cheese[xi][yi] == 0) lineCnt++;
        }

        if (lineCnt >= 2) {
            deleteList.add(new Pos(x, y));
        }
    }

    private static void deleteCheese() {
        while (!deleteList.isEmpty()) {
            Pos del = deleteList.poll();
            cheese[del.x][del.y] = 0;
        }
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
11 15
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 1 0 0 0 1 0 0
0 0 1 0 1 1 1 1 0 1 1 1 0 1 0
0 0 1 1 0 1 0 0 1 1 1 0 1 1 0
0 0 1 0 1 0 1 1 1 1 1 1 0 1 0
0 0 1 0 0 0 1 1 0 0 1 0 1 0 0
0 1 1 0 1 0 0 0 0 1 1 1 0 0 0
0 1 1 0 1 1 1 0 1 1 1 1 1 1 0
0 0 0 1 1 0 1 0 1 0 0 0 0 1 0
0 0 0 0 0 1 0 1 0 1 0 0 0 1 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */