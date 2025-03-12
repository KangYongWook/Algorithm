package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1987_알파벳 {
    static int answer;
    static int r,c;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] charVisited;
//    static HashSet<Character> visitedSet;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];
//        visitedSet = new HashSet<>();
        charVisited = new boolean[27];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[0][0] = true;
//        visitedSet.add(board[0][0]);
        charVisited[(int)(board[0][0]-'A')] = true;
        dfs(0,0, 1);

        System.out.println(answer);

    }

    static void dfs(int x, int y, int move) {
        answer = Math.max(answer, move);

        for (int i = 0; i < 4; i++) {
            int xi = dx[i] + x;
            int yi = dy[i] + y;

            if (xi>=0 && xi< r && yi>=0 && yi < c
//                    && !visitedSet.contains(board[xi][yi])
                    && !charVisited[(int)(board[xi][yi]-'A')] && !visited[xi][yi] ) {
                visited[xi][yi] = true;
//                visitedSet.add(board[xi][yi]);
                charVisited[(int)(board[xi][yi]-'A')] = true;
                dfs(xi,yi,move+1);
//                visitedSet.remove(board[xi][yi]);
                charVisited[(int)(board[xi][yi]-'A')] = false;
                visited[xi][yi] = false;
            }
        }
    }
}
