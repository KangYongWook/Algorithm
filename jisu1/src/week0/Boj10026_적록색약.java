package week0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10026_적록색약 {

    static int n;
    static char[][] pic;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pic = new char[n][n];
        for (int i = 0; i < n; i++) {
            pic[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][n];
        int rgb = rgbDfs(true);

        visited = new boolean[n][n];
        int rg = rgbDfs(false);
        System.out.println(rgb+" "+rg);

    }

    private static int rgbDfs(boolean rgbFlag) {
        int section = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    section++;
                    char ch = pic[i][j];

                    if (rgbFlag) {
                        dfs(new Pos(i,j,ch));
                    } else {
                        rbDfs(new Pos(i,j,ch));
                    }
                }
            }
        }
        return section;
    }

    private static void rbDfs(Pos p) {
        visited[p.x][p.y] = true;
        for (int i = 0; i < 4; i++) {
            int xi = p.x+dx[i];
            int yi = p.y+dy[i];
            if (0 <= xi && xi < n && 0 <= yi && yi < n && !visited[xi][yi] ) {
                if (pic[xi][yi] == p.ch || (p.ch=='R' && pic[xi][yi]=='G') || (p.ch=='G' && pic[xi][yi]=='R')) {
                    rbDfs(new Pos(xi,yi,p.ch));
                }
            }
        }
    }

    private static void dfs(Pos p) {
        visited[p.x][p.y] = true;
        for (int i = 0; i < 4; i++) {
            int xi = p.x+dx[i];
            int yi = p.y+dy[i];
            if (0 <= xi && xi < n && 0 <= yi && yi < n
                    && !visited[xi][yi] && pic[xi][yi] == p.ch) {
                dfs(new Pos(xi,yi,p.ch));
            }
        }
    }

    static class Pos{
        int x;
        int y;
        char ch;

        public Pos(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }
}
