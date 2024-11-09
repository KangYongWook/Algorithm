package class3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj21736_헌내기는친구가필요해 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    static char[][] arr;
    static boolean[][] isVisit;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        isVisit = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < arr.length; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < arr[i].length; j++) {
                if (input[j] == 'I') {
                	startX = i;
                	startY = j;
                }
                // 탐색 배열 저장
                arr[i][j] = input[j];
            }
        }

        _searchFriends(startX, startY);
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    private static void _searchFriends(int x, int y) {
    	isVisit[x][y] = true;
        if (arr[x][y] == 'P') {
        	result++;
        }
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if ( nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisit[nx][ny] && arr[nx][ny] != 'X') {
            	_searchFriends(nx, ny);
            }
        }
    }

}
