package bruteforcing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj18428_감시피하기 {
    static int[] blockArr = new int[3];
    static ArrayList<Pos> teacherList = new ArrayList<>();
    static ArrayList<Pos> emptyList = new ArrayList<>();
    static char[][] hallway;
    static int n;
    static boolean answer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        hallway = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                hallway[i][j] = st.nextToken().charAt(0);
                // 학생 S 선생님 T 없음 X
                switch (hallway[i][j]) {
                    case 'T':
                        teacherList.add(new Pos(i, j));
                        break;
                    case 'X':
                        emptyList.add(new Pos(i, j));
                }
            }
        }

        putBlock(0, 0);
        if (answer) System.out.println("YES");
        else System.out.println("NO");

    }

    static void putBlock(int idx, int start) {
        if (idx == 3) {
            change('O');
            // 학생찾기
            boolean result = findStudent();
            change('X');
            // 불가 "NO" 가능하면 "YES"
            if (result) {
                answer = true;
            }
            return;
        }

        for (int i = start; i < emptyList.size(); i++) {
            blockArr[idx] = i;
            putBlock(idx + 1, i + 1);
            if (answer) return;
        }

    }

    static void change(char sign) {
        for (int i = 0; i < 3; i++) {
            Pos position = emptyList.get(blockArr[i]);
            hallway[position.x][position.y] = sign;
        }
    }

    static boolean findStudent() {
        boolean result = true;
        for (Pos teacher : teacherList) {
            // 상
            int temX = teacher.x;
            while (--temX >= 0) {
                if (hallway[temX][teacher.y] == 'O') break;
                if (hallway[temX][teacher.y] == 'S') return false;
            }
            // 하
            temX = teacher.x;
            while (++temX < n) {
                if (hallway[temX][teacher.y] == 'O') break;
                if (hallway[temX][teacher.y] == 'S') return false;
            }
            // 좌
            int temY = teacher.y;
            while (--temY >= 0) {
                if (hallway[teacher.x][temY] == 'O') break;
                if (hallway[teacher.x][temY] == 'S') return false;
            }
            // 우
            temY = teacher.y;
            while (++temY < n) {
                if (hallway[teacher.x][temY] == 'O') break;
                if (hallway[teacher.x][temY] == 'S') return false;
            }
        }
        return result;
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
