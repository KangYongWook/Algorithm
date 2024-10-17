import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630_색종이만들기 {
    static int[][]map;
    static int white, blue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(0,0,n);
        System.out.println(white+" "+blue);
    }


    /**
     * 1,2,3,4분면...
     * 시작위치, N 사이즈
     *
     */

    private static void paper(int x,int y,int n) {
        int color = map[x][y];
        boolean divideFlag = false;
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (color != map[i][j]){
                    divideFlag = true;
                    paper(x,y,n/2);
                    paper(x,y+(n/2),n/2);
                    paper(x+(n/2),y,n/2);
                    paper(x+n/2,y+n/2,n/2);
                }
            }
        }

        // 분할이 되지 않고 정사각형 색종이로 카운팅됨
        if (!divideFlag){
            if (color == 0) {
                white++;
            } else {
                blue++;
            }
        }
    }
}
