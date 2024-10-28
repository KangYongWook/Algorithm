package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj21736_헌내기는친구가필요해 {

    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        Pos start = new Pos(0,0);
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    start.x = i;
                    start.y = j;
                }
            }
        }

        int answer = bfs(start);
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }

    }

    private static int bfs(Pos p) {
        int answer = 0;

        Queue<Pos> que = new LinkedList<>();
        que.add(p);
        visited[p.x][p.y] = true;

        while(!que.isEmpty()) {
            Pos curr = que.poll();
            for (int i = 0; i < 4; i++) {
                int xi = curr.x + dx[i];
                int yi = curr.y + dy[i];

                if (xi >= 0 && xi < n && yi >=0 && yi < m && !visited[xi][yi]){
                    if (map[xi][yi] == 'O') {
                        que.add(new Pos(xi, yi));
                        visited[xi][yi] = true;

                    } else if (map[xi][yi] == 'P') {
                        answer++;
                        que.add(new Pos(xi, yi));
                        visited[xi][yi] = true;
                    }
                }
            }
        }

        return answer;
    }
}
